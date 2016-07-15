package util.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.SqlUtil;

public class DataSourceUtil implements SqlUtil {
	
	private Connection conn = null;
	
	@Override
	public Connection getConn() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/mysql/imooc");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("数据源不存在");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据源获取连接出错");
			e.printStackTrace();
		}
		return conn;
	}

}
