package com.jt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class DBUtils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		//用于加载properties的文件数据
		ResourceBundle rBundle = ResourceBundle.getBundle("dbinfo");
		driverClass = rBundle.getString("driverClass");
		url = rBundle.getString("url");
		username = rBundle.getString("username");
		password = rBundle.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接的方法
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}
	
	//关闭资源的方法
	public static void closeAll(ResultSet rSet, Statement stmt, Connection conn) {
		if(rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rSet = null;
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
