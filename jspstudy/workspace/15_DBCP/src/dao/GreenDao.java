package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.GreenDto;

public class GreenDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private GreenDao() {}
	private static GreenDao greenDao = new GreenDao();
	public static GreenDao getInstance() {
		return greenDao;
	}
	
	/***** 1. 접속해제 *****/
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***** 2. 전체목록 가져오기 *****/
	public ArrayList<GreenDto> list() {
		ArrayList<GreenDto> list = new ArrayList<GreenDto>();
		try {
			con = dataSource.getConnection();
			sql = "select * from green order by hit desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				GreenDto greenDto = new GreenDto();
				greenDto.setNo(rs.getInt("no"));
				greenDto.setWriter(rs.getString("writer"));
				greenDto.setTitle(rs.getString("title"));
				greenDto.setContent(rs.getString("content"));
				greenDto.setHit(rs.getInt("hit"));
				greenDto.setPostDate(rs.getDate("postdate"));
				list.add(greenDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	/***** 3. 삽입하기 *****/
	public int insert(GreenDto greenDto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "insert into green values (green_seq.nextval, ?, ?, ?, 0, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, greenDto.getWriter());
			ps.setString(2, greenDto.getTitle());
			ps.setString(3, greenDto.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/***** 4. 게시글 가져오기 *****/
	public GreenDto view(int no) {
		GreenDto greenDto = null;
		try {
			con = dataSource.getConnection();
			sql = "select * from green where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while(rs.next()) {
				greenDto = new GreenDto();
				greenDto.setNo(rs.getInt(1));
				greenDto.setWriter(rs.getString("writer"));
				greenDto.setTitle(rs.getString(3));
				greenDto.setContent(rs.getString("content"));
				greenDto.setHit(rs.getInt(5));
				greenDto.setPostDate(rs.getDate("postdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return greenDto;
	}
	
	/***** 5. 조회수 증가하기 *****/
	public int updateHit(int no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "update green set hit = hit + 1 where no = ?";
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
	
	/***** 6. 게시글 삭제하기 *****/
	public int delete(int no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "delete from green where no = ?";
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

	/***** 7. 게시글 수정하기 *****/
	public int update(GreenDto greenDto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "update green set title = ?, content = ? where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, greenDto.getTitle());
			ps.setString(2, greenDto.getContent());
			ps.setInt(3, greenDto.getNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
}
