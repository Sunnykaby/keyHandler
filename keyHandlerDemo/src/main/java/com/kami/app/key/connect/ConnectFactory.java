package com.kami.app.key.connect;

import java.sql.*;

public class ConnectFactory {
	private Connection connection = null;
	public ConnectFactory() {
		// TODO Auto-generated constructor stub
		if (connection == null) {
			connection = getConnection();
		}
	}
	/**
	 * 获取数据库链接
	 * 每一次连接都会重新创建一个数据库连接
	 * @return
	 */
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//寻找这个类，看是否有这个驱动
			//本地调试
			String url = "jdbc:mysql://localhost:3306/km?characterEncoding=UTF-8&amp;autoReconnect=true&amp;autoReconnectForPools=true&amp;zeroDateTimeBehavior=convertToNull";
			String user = "root";
			String pass = "dxDBTest";
			//服务器链接
			//			String url = "jdbc:mysql://10.251.5.188:3306/dx_data?characterEncoding=UTF-8&amp;autoReconnect=true&amp;autoReconnectForPools=true&amp;zeroDateTimeBehavior=convertToNull";
			//			String user = "dxDBManager";
			//			String pass = "dxSERdb150306";

			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			try {
//				if (conn == null) {
//					System.out.println("获取连接失败");
//				}
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (Exception e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("数据库连接异常！" + e.toString());
		}
		return conn;
	}

	/**
	 * jdbc插入纪录
	 * @param sqlString
	 * @param args
	 * @return false/true
	 * @throws SQLException
	 */
	public boolean insert(String sql, Object... args)
			throws SQLException
	{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		if (pstmt.executeUpdate() != 1) {
			return false;
		}
		return true;
	}

	/**
	 * jdbc查询纪录
	 * @param sql
	 * @param args
	 * @return the resultset
	 * @throws SQLException
	 */
	public ResultSet query(String sql, Object... args)
			throws SQLException
	{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		return pstmt.executeQuery();
	}
	/**
	 * JDBC更新纪录
	 * @param sql
	 * @param args
	 * @return the number of row effected 
	 * @throws SQLException
	 */
	public int update(String sql, Object... args)
			throws SQLException{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		return pstmt.executeUpdate();
	}

	/**
	 * JDBC删除纪录
	 * @param sql
	 * @param args
	 * @return the number of row effected
	 * @throws SQLException
	 */
	public int delete(String sql, Object... args)
			throws SQLException
	{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		return pstmt.executeUpdate();
	}

	/**
	 * 关闭数据库链接
	 * @param conn <br>数据库链接
	 */
	public static void closeConnection(Connection conn) {
		try {
			//关闭数据库链接
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean closeConnection(){
		try {
			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
