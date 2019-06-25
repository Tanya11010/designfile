package cn.lut.hotelvip.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author 孙子超
 * 版权所属：四川华迪信息技术有限公司
 * 2017年11月1日
 * 数据库连接工具类
 */
public class JdbcUtils {

	//配置信息
	static String url = null;
	static String username = null;
	static String password = null;
	//数据库连接池
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	//获取连接
	public static Connection getConnection() {

		try {
			Connection con = dataSource.getConnection(); // DriverManager.getConnection(url, usrname, password);
			return con;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 2. 释放资源（ResultSet,Statement,Connection)
	public static void ReleaseDB(Connection con, Statement sate, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {

			}
		if (sate != null)
			try {
				sate.close();
			} catch (SQLException e) {

			}

		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {

			}

	}

	// 3. 释放资源（ResultSet,Statement)
	public static void ReleaseDB(Statement sate, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {

			}
		if (sate != null)
			try {
				sate.close();
			} catch (SQLException e) {

			}
	}

}


