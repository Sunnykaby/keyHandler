package com.kami.app.key.service;

import com.kami.app.key.dataAccess.UserDao;
import com.kami.app.key.model.User;

public class UserService {
	public boolean checkUserAuth(String userName, String userPw){
		try {
			User user = UserDao.getUserInfoByName(userName);
			if (user == null || !user.getUserPw().equals(userPw)) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
