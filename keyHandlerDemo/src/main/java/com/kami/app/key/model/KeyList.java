package com.kami.app.key.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shidian on 2016/10/24.
 */

public class KeyList {
    private List<KeyInfo> lists;

    public KeyList(List<KeyInfo> lists) {
        this.lists = lists;
    }

    public KeyList() {
        lists = new ArrayList<KeyInfo>();
    }

    public void setList(List<KeyInfo> lists){
        this.lists = lists;
    }

    public void addKey(KeyInfo keyInfo){
        lists.add(keyInfo);
    }

    public boolean removeKey(String keyId){
        for (KeyInfo currentKey :
                lists) {
            if (currentKey.getKeyId().equals(keyId)){
                return  lists.remove(currentKey);
            }
        }
        return true;
    }
}
