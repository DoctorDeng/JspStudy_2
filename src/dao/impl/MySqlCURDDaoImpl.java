package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dao.CommanCURDDao;
import util.SqlUtil;
import util.impl.DataSourceUtil;

public class MySqlCURDDaoImpl implements CommanCURDDao {

	private Connection conn;
	private PreparedStatement ps;
	private SqlUtil sqlUtil;
	
	public MySqlCURDDaoImpl() {
		sqlUtil = new DataSourceUtil();
		conn = sqlUtil.getConn();
	}
	
	@Override
	public boolean insert(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public boolean delete(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public boolean update(String sql, List<String> str) {
		try {
			ps = conn.prepareStatement(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			int j = ps.executeUpdate();
			if (j==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

	@SuppressWarnings("finally")
	@Override
	public Vector<String[]> select(String sql, List<String> str) {
		Vector<String[]> vector = new Vector<>();
		try {
			ps = conn.prepareStatement(sql);
			if (str != null && !str.isEmpty()) {
				for (int i=0; i<str.size(); i++) {
					ps.setString(i + 1, str.get(i));
				}
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while(rs.next()) {
				String[] dataStr = new String[metaData.getColumnCount()];
				for (int i=0; i<dataStr.length; i++) {
					dataStr[i] = rs.getString(i+1);
				}
				vector.add(dataStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return vector;
		}
	}

}
