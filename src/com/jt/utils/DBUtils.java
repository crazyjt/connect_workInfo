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
		//���ڼ���properties���ļ�����
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
	
	//��ȡ���ӵķ���
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}
	
	//�ر���Դ�ķ���
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
