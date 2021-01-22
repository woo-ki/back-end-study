package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.BlueDto;

public class BlueDao {
	
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// DBCP 방식은 Connection을 DataSource 클래스가 관리한다.
	// 그 동안 사용하던 DriverManager 클래스를 사용하지 않기 때문에
	
	// getConnection() 메소드를 만들어서 사용하지 않는다.
	// 앞으로는 DataSource객체가 제공하는 getConnection() 메소드를 사용한다.
	
	// DataSource 객체 만들기 (새로운 작업)
	private static DataSource dataSource;
	// static { }  // static 블록에서 static 필드의 초기화를 할 수 있다.
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// Tomcat의 경우 java:comp/env/ 를 prefix로 사용한다.
			// context.xml의 <Resource>태그의 name속성이 jdbc/oracle이다.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// Singleton pattern
	private BlueDao() {}
	private static BlueDao blueDao = new BlueDao();
	public static BlueDao getInstance() {
		return blueDao;
	}
	
	// 메소드
	/****** 1. 접속종료 ******/
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/****** 2. 목록 가져오기 ******/
	public ArrayList<BlueDto> list() {
		ArrayList<BlueDto> list = new ArrayList<BlueDto>();
		try {
			con = dataSource.getConnection();
			sql = "select no, writer, title, content, filename, postdate from blue";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// rs.next() -> BlueDto -> list.add
			while(rs.next()) {
				BlueDto blueDto = new BlueDto();
				blueDto.setNo(rs.getInt("no"));
				blueDto.setWriter(rs.getString("writer"));
				blueDto.setTitle(rs.getString("title"));
				blueDto.setContent(rs.getString("content"));
				blueDto.setFilename(rs.getString("filename"));
				blueDto.setPostDate(rs.getDate("postdate"));
				list.add(blueDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	/****** 3. 게시글 삽입하기 ******/
	public int insert(BlueDto blueDto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "insert into blue values (blue_seq.nextval, ?, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, blueDto.getWriter());
			ps.setString(2, blueDto.getTitle());
			ps.setString(3, blueDto.getContent());
			ps.setString(4, blueDto.getFilename());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/****** 4. 게시글 가져오기 ******/
	public BlueDto view(int no) {
		BlueDto blueDto = null;
		try {
			con = dataSource.getConnection();
			sql = "select no, writer, title, content, filename, postdate from blue where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				blueDto = new BlueDto();
				blueDto.setNo(no);	// blueDto.setNo(rs.getInt("no"))
				blueDto.setWriter(rs.getString("writer"));
				blueDto.setTitle(rs.getString("title"));
				blueDto.setContent(rs.getString("content"));
				blueDto.setFilename(rs.getString("filename"));
				blueDto.setPostDate(rs.getDate("postdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return blueDto;
	}

	/****** 5. 게시글 삭제하기 ******/
	public int delete(int no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "delete from blue where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/****** 6. 게시글 수정하기 ******/
	public int Update(BlueDto blueDto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "update blue set title = ?, content = ? where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, blueDto.getTitle());
			ps.setString(2, blueDto.getContent());
			ps.setInt(3, blueDto.getNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
}
