package com.kami.app.key.dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kami.app.key.connect.ConnectFactory;
import com.kami.app.key.model.User;

public class UserDao {
	
	public static User getUserInfoById(Integer userId) throws SQLException{
		StringBuffer sql = new StringBuffer();
		User user = null;
		sql.append("select user_id,user_name,user_pw from user where user_id = ?");
		ConnectFactory connectFactory = new ConnectFactory();
		ResultSet resultSet = connectFactory.query(sql.toString(), userId);
		if (resultSet.next()) {
			user = new User();
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setUserPw(resultSet.getString(3));
		}
		return user;
	}
	
	public static User getUserInfoByName(String userName) throws SQLException{
		StringBuffer sql = new StringBuffer();
		User user = null;
		sql.append("select user_id,user_name,user_pw from user where user_name = ?");
		ConnectFactory connectFactory = new ConnectFactory();
		ResultSet resultSet = connectFactory.query(sql.toString(), userName);
		if (resultSet.next()) {
			user = new User();
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setUserPw(resultSet.getString(3));
		}
		return user;
	}
	
	/**
	 * 添加用户信息
	 * 没有考虑重复添加的问题
	 * @Description: TODO
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException   
	 * @return boolean  
	 * @throws
	 * @author 
	 * @date 2016年8月16日
	 */
	public static boolean addUser(User user) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into user(user_name,user_pw) value (?,?)");
		ConnectFactory connectFactory = new ConnectFactory();
		return connectFactory.insert(sql.toString(), user.getUserName(),user.getUserPw());
		
	}
	
	public static void main(String[] args){
		try {
//			User newuser = new User();
//			newuser.setUserName("sunny");
//			newuser.setUserPw("111");
//			System.out.println(UserDao.addUser(newuser));
			User user = UserDao.getUserInfoById(1);
			System.out.println(user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
