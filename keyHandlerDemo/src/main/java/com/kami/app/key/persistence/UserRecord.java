package com.kami.app.key.persistence;

import com.kami.app.key.model.KeyInfo;
import com.kami.app.key.model.UserKeys;
import com.kami.app.key.utils.EncodeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * transform the userKey to be a kind of Object for persistent
 * Created by shidian on 2016/10/26.
 * persistence format:
 * each user with a single line
 * -----------------------------------------
 *     userName password keyname,keyvalue|keyname,keyvalue|(\n)
 * -----------------------------------------
 */

public class UserRecord {
    private String userName;
    private String password;
    private List keys;
    private String persistenceInfo;//持久化String

    private EncodeHelper encodeHelper = new EncodeHelper();

    /**
     * accroding the persistence string data to recover the userKey object
     * @param persistenceInfo
     */
    public UserRecord(String persistenceInfo) {
        this.persistenceInfo = persistenceInfo + "\n";
        StringTokenizer stringTokenizer =  new StringTokenizer(persistenceInfo," ");
        while (stringTokenizer.hasMoreTokens()){
            this.userName = stringTokenizer.nextToken();
            this.password = encodeHelper.decode(stringTokenizer.nextToken());
            //must check is there any keys in dataSet
            if (stringTokenizer.hasMoreTokens())
                this.keys = createKeys(stringTokenizer.nextToken());
            else this.keys = new ArrayList<KeyInfo>();
        }
    }

    public UserRecord(UserKeys userKeys){
        this.userName = userKeys.getUserName();
        this.password = userKeys.getPassword();
        this.keys = userKeys.getKeys();
        // composite the persistence string
        StringBuffer sb = new StringBuffer();
        sb.append(userName).append(" ");
        sb.append(encodeHelper.encode(password)).append(" ");
        sb.append(createKeyString(keys));
        this.persistenceInfo = sb.append("\n").toString();
    }

    public String createKeyString(List keys){
        StringBuffer sb = new StringBuffer();
        for (Object key : keys) {
            KeyInfo keyInfo = (KeyInfo)key;
            sb.append(keyInfo.getKeyId()).append(",");
            sb.append(keyInfo.getKeyName()).append(",");
            sb.append(keyInfo.getKeyValue()).append("|");
        }
        return  sb.toString();
    }


    /**
     * create a list of keyInfo from a string, "keyname,kayvalue|keyname,keyvalue|"
     * @param keysString
     * @return
     */
    public List createKeys(String keysString){
        List keys = new ArrayList<KeyInfo>();
        StringTokenizer stringTokenizer = new StringTokenizer(keysString,"|");
        while (stringTokenizer.hasMoreTokens()){
            String keyString = stringTokenizer.nextToken();
            keys.add(createKey(keyString));
        }
        return keys;
    }

    /**
     * create a KeyInfo object from a keyString "keyname,keyvalue"
     * @param keyString
     * @return
     */
    public KeyInfo createKey(String keyString){
        KeyInfo keyInfo = new KeyInfo();
        StringTokenizer stringTokenizer = new StringTokenizer(keyString,",");
        while (stringTokenizer.hasMoreTokens()){
            keyInfo.setKeyId(Long.parseLong(stringTokenizer.nextToken()));
            keyInfo.setKeyName(stringTokenizer.nextToken());
            keyInfo.setKeyValue(stringTokenizer.nextToken());
        }
        return keyInfo;
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) { this.userName = userName;}

    public String getPassword() {return password;}

    public void setPassword(String password) { this.password = password;}

    public List getKeys() {return keys;}

    public void setKeys(List keys) { this.keys = keys;}

    public String getPersistenceInfo() {return persistenceInfo;}

    public void setPersistenceInfo(String persistenceInfo) { this.persistenceInfo = persistenceInfo;}
}
