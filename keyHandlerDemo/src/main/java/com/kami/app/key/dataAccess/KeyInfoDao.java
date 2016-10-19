package com.kami.app.key.dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kami.app.key.connect.ConnectFactory;
import com.kami.app.key.model.KeyInfo;

public class KeyInfoDao {
	public static List<KeyInfo> getKeyInfoByKeyName(String keyName) throws SQLException{
		StringBuffer sql = new StringBuffer();
		List<KeyInfo> keyInfos = new ArrayList<KeyInfo>();
		sql.append("select key_name,key_value from user where key_name = ?")
			.append("order by update_time desc");
		ConnectFactory connectFactory = new ConnectFactory();
		ResultSet resultSet = connectFactory.query(sql.toString(), keyName);
		if (resultSet.next()) {
			KeyInfo keyInfo= new KeyInfo();
			keyInfo.setKeyName(resultSet.getString(1));
			keyInfo.setKeyValue(resultSet.getString(2));
			keyInfos.add(keyInfo);
		}
		return keyInfos;
	}
	
	public static boolean addKeyInfo(KeyInfo keyInfo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into key_info(key_name,key_value,update_time) value (?,?,?)");
		ConnectFactory connectFactory = new ConnectFactory();
		return connectFactory.insert(sql.toString(), keyInfo.getKeyName(),
				keyInfo.getKeyValue(),keyInfo.getUpdateTime());
		
	}
	
}
