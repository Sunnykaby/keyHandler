package com.kami.app.key.persistence;

import com.kami.app.key.model.UserKeys;
import com.kami.app.key.utils.EncodeHelper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * file management and transform the data to record object
 * Created by shidian on 2016/10/27.
 */

public class FileDBHelper {
    //here we make this class be a singleton class
    public static FileDBHelper fileDBHelper;
    File db;
    private Map userKeysMap;
    private EncodeHelper encodeHelper;
    private String dbBasePath;

    public FileDBHelper() {
        userKeysMap = new HashMap<String, UserKeys>();
        encodeHelper = new EncodeHelper();
        dbBasePath = "resource" + File.separator + "db" + File.separator + "key.txt";
    }

    public FileDBHelper(String rootPath){
        userKeysMap = new HashMap<String, UserKeys>();
        encodeHelper = new EncodeHelper();
        setDbBasePath(rootPath);
    }

    public void setDbBasePath(String root){
        if (dbBasePath == null)
        dbBasePath = root +File.separator +dbBasePath;
        else dbBasePath = root + File.separator + "resource" + File.separator + "db" + File.separator + "key.txt";
    }


    public static FileDBHelper getInstance() {
        if (fileDBHelper == null){
            synchronized (FileDBHelper.class){
                if (fileDBHelper == null){
                    fileDBHelper = new FileDBHelper();
                }
            }
        }
        return  fileDBHelper;
    }

    /**
     * get whole data form the target file with the file path in the object
     */
    public synchronized String retrieveData(){
        BufferedReader bufferedReader = null;
        char[] charBuffer;
        try {
            //bufferedReader is more effective
            bufferedReader = new BufferedReader(new FileReader(db.getAbsolutePath()));
            //need a long enough char array, here we get length from a file object
             charBuffer = new char[(int) new File(db.getAbsolutePath()).length()];
            bufferedReader.read(charBuffer);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new RuntimeException("Read DB File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Read DB file error", e);
        }
        finally {
            closeReader(bufferedReader);
        }
        return new String(charBuffer);
    }

    public void closeReader(BufferedReader bufferedReader){
        try {
            if (bufferedReader!=null) bufferedReader.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    /**
     * get the noralized info data from the file String
     */
    public void initializeInfo(){
        //init the file
        db = new File(dbBasePath);
        String whileData = retrieveData();
        StringTokenizer st = new StringTokenizer(whileData,"\n");
        while (st.hasMoreTokens()){
            UserRecord userRecord = new UserRecord(st.nextToken());
            putUserKey(new UserKeys(userRecord.getUserName(),
            userRecord.getPassword(),userRecord.getKeys()));
        }
    }

    public void putUserKey(UserKeys userKeys){
        //create a key for map, ! wouldn't appear in base64
        String mapKey = userKeys.getUserName()+"-" + userKeys.getPassword();
        userKeysMap.put(mapKey,userKeys);
    }

    /**
     * get the userKeys info from the map(app memory space)
     * @param userName
     * @param password
     * @return
     */
    public UserKeys getUserKey(String userName, String password){
        String keyMap = userName + "-" + password;
        return (UserKeys) userKeysMap.get(keyMap);
    }

    public void closeDB(){
        writeUserKeys();
    }

    /**
     * persistent the userKeys into the text
     */
    public void writeUserKeys(){
        StringBuffer stringBuffer = new StringBuffer();
        for (Object userKeys : userKeysMap.values()) {
            UserRecord ur = new UserRecord((UserKeys)userKeys);
            stringBuffer.append(ur.getPersistenceInfo());
        }
        writeText(stringBuffer.toString());
    }

    /**
     * write the text string into file
     */
    public synchronized void  writeText(String text){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(db.getAbsolutePath()));
            bufferedWriter.write(text);
        } catch (Exception e) {
            //e.printStackTrace();
             throw new RuntimeException("Write text into File Error", e);
        }
        finally {
            closeWriter(bufferedWriter);
        }
    }

    public void closeWriter(BufferedWriter bufferedWriter){
        try {
            if (bufferedWriter !=null) bufferedWriter.close();;
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
