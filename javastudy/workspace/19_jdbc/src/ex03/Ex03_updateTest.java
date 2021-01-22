package ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnect;
import vo.JobVO;

public class Ex03_updateTest {

	public static void main(String[] args) {

		// job_id 가 DR인 데이터의 min_salary 를 4000 max_salary 를 5500으로 수정하시오.
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		// jobVO 객체 생성
		// update 문의 실행에 필요한 정보만 담는다.
		// 디폴트 타입으로 생성해서 필요한 정보만 setter로 저장한다.
		JobVO j = new JobVO();
		j.setJob_id("DR");
		j.setMin_salary(4000);
		j.setMax_salary(5500);
		
		try {
			conn = DBConnect.getConnection();
			sql = "update job set min_salary = ?, max_salary = ? where job_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, j.getMin_salary());
			ps.setInt(2, j.getMax_salary());
			ps.setString(3, j.getJob_id());
			result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(j.getJob_id() + "이(가) 수정되었습니다.");
			} else {
				System.out.println(j.getJob_id() + "이(가) 수정되지 않았습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
