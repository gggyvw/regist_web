package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static BasicDataSource ds;

	static {
		//加载参数
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader()
			 .getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//创建连接池
			ds = new BasicDataSource();
			//设置参数
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(
				Integer.parseInt(initsize));
			ds.setMaxActive(
				Integer.parseInt(maxsize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载db.properties失败!",e);
		}
	}
	
	public static Connection getConnection() 
		throws SQLException {
		return ds.getConnection();
	}
	
	public static BasicDataSource getDataSource(){
		return ds;
	}
	
	/**
	 * 目前连接是由连接池创建的,
	 * 连接的实现类是由连接池提供的,
	 * 连接池将连接对象的close方法
	 * 改为归还连接的逻辑.
	 */
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"关闭连接失败!",e);
		}
	}
	
}







