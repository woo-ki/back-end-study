package ex04;

import java.sql.Connection;

import connection.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex03_selectOneTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int count = 0;
		ResultSet rs = null;
		
		try {
			conn = DBConnect.getConnection();
			sql = "select count(*) as row_count from job";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt("row_count");
			System.out.println(count);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
