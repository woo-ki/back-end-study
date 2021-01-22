package ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnect;
import vo.JobVO;

public class Ex02_deleteTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		JobVO j = new JobVO();
		j.setJob_id("CJ");
		
		try {
			conn = DBConnect.getConnection();
			sql = "delete from job where job_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setNString(1,  j.getJob_id());
			result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(j.getJob_id() + "이(가) 삭제되었습니다.");
			} else {
				System.out.println(j.getJob_id() + "이(가) 삭제되지 않았습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
