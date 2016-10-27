package com.kami.app.key.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含key的list，主要用于session中的key保存。
 * Created by shidian on 2016/10/24.
 */
@Deprecated
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
        long id = Long.parseLong(keyId);
        for (KeyInfo currentKey :
                lists) {
            if (currentKey.getKeyId() == id){
                return  lists.remove(currentKey);
            }
        }
        return true;
    }

    public List getList(){
        return  lists;
    }
}
