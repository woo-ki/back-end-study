package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;
import dto.JobDTO;

// DAO : Database Access Object
// DB에 접근하는 객체
// CRUD를 처리하는 객체
// Create : insert
// Read   : select
// Update : update
// Delete : delete

public class JobDAO {

	// field
	private Connection con;	// 자동으로 null
	private PreparedStatement ps;
	private String sql;
	private int result;
	// select 용
	private ResultSet rs;
	private JobDTO dto;
	
	// constructor
	public JobDAO() {
		// 접속만 해 두자
		try {
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// method
	// 1. 삽입 메소드
	public int insert(JobDTO dto) {
		try {
			sql = "insert into job values (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getJob_id());
			ps.setString(2, dto.getJob_title());
			ps.setInt(3, dto.getMin_salary());
			ps.setInt(4, dto.getMax_salary());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 2. 갱신 메소드
	public int update(JobDTO dto) {
		try {
			sql = "update job set min_salary = ?, max_salary = ? where job_id = upper(?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getMin_salary());
			ps.setInt(2, dto.getMax_salary());
			ps.setString(3, dto.getJob_id());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 3. 삭제 메소드
	public int delete(String job_id) {
		try {
			sql = "delete from job where job_id = upper(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, job_id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 4. 검색 메소드
	public JobDTO select(String job_id) {
		try {
			sql = "select * from job where job_id = upper(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, job_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String job_id2 = rs.getString(1);
				String job_title = rs.getString(2);
				int min_salary = rs.getInt(3);
				int max_salary = rs.getInt(4);
				dto = new JobDTO(job_id2, job_title, min_salary, max_salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
}
