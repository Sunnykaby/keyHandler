package com.kami.app.key.model;

import java.util.Date;

public class KeyInfo {
    private Long keyId;
    private String keyName;
    private String keyValue;
    private Date updateTime;
    private String keyVersion;

    public KeyInfo(String keyName, String keyValue) {
        // TODO Auto-generated constructor stub
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public KeyInfo() {
        // TODO Auto-generated constructor stub
        //this method should be improved next time
        this.keyId =  new Date().getTime();
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getKeyVersion() {return keyVersion;}

    public void setKeyVersion(String keyVersion) { this.keyVersion = keyVersion;}

}
