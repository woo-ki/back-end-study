package ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DBConnect;

public class Ex01_inserTest {

	public static void main(String[] args) {

		Connection conn = null;		 // 접속 담당
		PreparedStatement ps = null; // 쿼리 담당
		String sql = null;			 // 쿼리문 작성
		int result = 0;				 // 쿼리문 실행 결과 (insert, update, delete문은 int 타입의 결과를 반환한다.)
		
		try {
			// 1. 접속을 한다.
			conn = DBConnect.getConnection();
			
			// 2. 쿼리문을 미리 준비한다. (PreparedStatment을 사용하므로)
			sql = "insert into job (job_id, job_title, min_salary, max_salary) values ('DR', '대리', 3500, 4500)";	// 세미콜론(;) 붙여서 넘기면 오류발생
			
			// 3. 준비된 쿼리문을 이용해서 쿼리 담당 ps를 생성한다.
			ps = conn.prepareStatement(sql);
			
			// 4. 쿼리 담당 ps가 쿼리를 실행한다.
			// 실행 메소드
			// 1) executeUpdate() : insert, update, delete  실행용
			// 2) executeQuery()  : select 실행용
			// 쿼리 실행 결과는 쿼리문(sql)에 따라 다르다.
			result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("job이 추가되었습니다.");
			} else {
				System.out.println("job이 추가되지 않았습니다.");
			}
			// 실행결과
			// 0 : insert 된 데이터가 0개이다. (실패)
			// 1 : insert 된 데이터가 1개이다. (성공)
			
			// 기본적으로 setAutoCommint(true) 상태이기 때문에
			// COMMIT이 필요하지 않다.
			
			// 자동커밋을 끄고 수동으로 커밋을 할 수 있다.
			
			/*
				conn = DBConnect.getConnection();
				conn.setAutoCommit(false);
				...
				if(result > 0) {
					conn.commit();	// 수동 커밋
				}
			*/
					
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
