package com.kami.app.key.model;

import java.util.Date;

public class KeyInfo {
	private Integer keyId;
	private String keyName;
	private String keyValue;
	private Date updateTime;

	public KeyInfo(String keyName, String keyValue) {
		// TODO Auto-generated constructor stub
		this.keyName = keyName;
		this.keyValue = keyValue;
	}

	public KeyInfo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
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


}
