package com.kami.app.key.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存内存中user信息和其对应的keyList
 * 其不仅仅是model的概念（内包含，而不是使用关联表）
 * Created by shidian on 2016/10/26.
 */

public class UserKeys {

    private String userName;
    private String password;
    private List keys;


    public UserKeys() {
        this.userName = "";
        this.password = "";
        this.keys = new ArrayList<KeyInfo>();
    }

    public UserKeys(String userName, String password, List keys) {
        this.userName = userName;
        this.password = password;
        if (this.keys != null)
            this.keys.addAll(keys);
        else {
            if (keys!=null)
                this.keys = new ArrayList<KeyInfo>(keys);
            else this.keys = new ArrayList<KeyInfo>();
        }
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) { this.userName = userName;}

    public String getPassword() {return password;}

    public void setPassword(String password) { this.password = password;}

    public List getKeys() {return keys;}

    public void setKeys(List keys) { this.keys = keys;}

    public void addKey(KeyInfo key){
        keys.add(key);
    }

    public void removeKey(KeyInfo key){
        keys.remove(key);
    }

    public void removeKey(Long id){
        KeyInfo temp = findKey(id);
        if (temp!=null) keys.remove(temp);
    }

    public KeyInfo findKey(Long id){
        //tips:可以在最开始声明变量，然后为null，有问题直接返回
        KeyInfo keyInfo = null;
        for (Object key : keys) {
            KeyInfo temp = (KeyInfo)key;
            if(temp.getKeyId().equals(id)){
                keyInfo = temp;
            }
        }
        return  keyInfo;
    }
}
