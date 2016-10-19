package com.kami.app.key.service;

import java.sql.SQLException;
import java.util.List;

import com.kami.app.key.dataAccess.KeyInfoDao;
import com.kami.app.key.model.KeyInfo;

public class KeyInfoService {
	
	public boolean addKey(String keyName, String keyValue){
		KeyInfo keyInfo = new KeyInfo(keyName,keyValue);
		try {
			return KeyInfoDao.addKeyInfo(keyInfo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public List<KeyInfo> getKeyInfosByName(String keyName) {
		try {
			return KeyInfoDao.getKeyInfoByKeyName(keyName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
