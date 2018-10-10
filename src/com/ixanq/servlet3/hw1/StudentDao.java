package com.ixanq.servlet3.hw1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ixanq.servlet3.util.JDBCUtils;

public class StudentDao {

	public Student queryByNameAndPassword(String name, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from students where name=? and password = ?";
		Student stu = null;
		conn = JDBCUtils.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				stu = new Student(name,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

}
