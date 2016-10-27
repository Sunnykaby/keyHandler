package com.kami.app.key.persistence;

import com.kami.app.key.model.KeyInfo;

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

    public UserRecord(String persistenceInfo) {
        this.persistenceInfo = persistenceInfo + "\n";
        StringTokenizer stringTokenizer =  new StringTokenizer(persistenceInfo," ");
        while (stringTokenizer.hasMoreTokens()){

        }
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
            keyInfo.setKeyName(stringTokenizer.nextToken());
            keyInfo.setKeyValue(stringTokenizer.nextToken());
        }
        return keyInfo;
    }
}
