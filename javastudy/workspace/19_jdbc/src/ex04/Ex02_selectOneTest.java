package ex04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;
import vo.JobVO;

public class Ex02_selectOneTest {

	public static void main(String[] args) {

		// where 절에서 pk 또는 uq 칼럼이 동등비교 조건인경우
		// 결과가 1개이다.
		Connection conn = null;			// 접속 담당
		PreparedStatement ps = null;	// 쿼리 담당
		ResultSet rs = null;			// select 결과 담당
		String sql = null;
		
		try {
			conn = DBConnect.getConnection();
			sql = "select job_id, job_title, min_salary, max_salary from job where job_id = 'GJ'";
			ps = conn.prepareStatement(sql);
			// select 문은 executeQuery() 메소드를 사용한다.
			rs = ps.executeQuery();
			
			// rs값은 next() 메소드로 추출한다.
			// rs값은 반드시 next()메소드로 호출해야 한다.
			// rs 값에 1개의 row가 있기 때문에 next() 메소드를 한 번만 호출하면 된다.
			if(rs.next()) {
				String job_id = rs.getString(1);
				String job_title = rs.getString(2);
				int min_salary = rs.getInt(3);
				int max_salary = rs.getInt(4);
				JobVO vo = new JobVO(job_id, job_title, min_salary, max_salary);
				System.out.println("job_id: " + vo.getJob_id());
				System.out.println("job_title: " + vo.getJob_title());
				System.out.println("min_salary: " + vo.getMin_salary());
				System.out.println("max_salary: " + vo.getMax_salary());
			}
			/*
			 * rs의 상태
			 * 
			 * job_id + job_title + min_salary + max_salary (순서대로 저장 되어있음)
			 * 
			 * 1) job_id : rs.getString(1), rs.getString("job_id")
			 * 2) job_title : rs.getString(2), rs.getString("job_title")
			 * 3) min_salary : rs.getInt(3), rs.getInt("min_salary")
			 * 4) max_salary : rs.getInt(4), rs.getInt("max_salary")
			 * */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(ps != null) { ps.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
