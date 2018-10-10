package com.ixanq.servlet3.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	//properties配置文件
	static{
		Properties properties = new Properties();
		InputStream inStream = JDBCUtils.class.getResourceAsStream("db.properties");
		try {
			properties.load(inStream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("jdbcUrl");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接
	 * @return 返回null 代表 连接失败
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 释放数据库资源
	 */
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//增删改
	public static int update(String sql,Object...params){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, rs);
		}
		return res;
	}
	
	
	
}










