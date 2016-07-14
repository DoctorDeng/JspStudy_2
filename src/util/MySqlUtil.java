package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MySqlUtil {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME = "test";
	private static final String USER = "root";
	private static final String PWD = "denghuajie123";
	private static final String URL = "jdbc:mysql://119.29.223.16:3306/"+ DATABASE_NAME + 
			"?user=" + USER +
			"&password=" + PWD +
			"&useUnicode=true" + 
			"&useSSL=false" +
			"&characterEncoding=UTF-8";
	private static final String URL1 = "jdbc:mysql://119.29.223.16:3306/" + DATABASE_NAME;
	private static Connection conn = null;
	//定义sql语句的执行对象
	private PreparedStatement pstmt;
	//定义查询返回的结果集合
	private ResultSet resultSet;
	
	public MySqlUtil(){}
	
	/**
	 * 建立JDBC-ORACLE的桥接器
	 */
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库的链接
	 * @return 返回数据库的连接对象
	 */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean updateByPreparedStatement(String sql, List<?> params)
	  throws SQLException {
		//flag标识
		boolean flag = false;
		int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
		pstmt = conn.prepareStatement(sql);
		int index = 1;
		//填充sql语句中的占位符
		if (params!=null && !params.isEmpty()) {
			for (int i=0; i<params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		result = pstmt.executeUpdate();
		flag = result > 0 ?true:false;
		return flag;
	}
	
	public List<Map<String,Object>> findResult(String sql, List<?> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if (params!=null && !params.isEmpty()) {
			for (int i=0; i<params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData =  resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while(resultSet.next()) {
			Map<String, Object> map = new HashMap<String,Object>();
			for (int i=0;i<cols_len;i++) {
				String cols_name = metaData.getColumnName(i +1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 释放资源
	 */
	public void releaseConn() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
