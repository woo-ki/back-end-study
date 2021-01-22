package com.koreait.simple3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.koreait.simple3.dto.SimpleDto;

/*
	이번 SimpleDao는 singleton으로 만들지 않습니다.
	대신 SimpleDao의 생성을 Spring에 맡기는 DI 방식을 사용하겠습니다.
*/
public class SimpleDao {
	private DataSource dataSource;
	
	public SimpleDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SimpleDto> allList() {
		List<SimpleDto> list = new ArrayList<SimpleDto>();
		try {
			con = dataSource.getConnection();
			sql = "select * from simple order by no";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SimpleDto simpleDto = new SimpleDto();
				simpleDto.setNo(rs.getInt("no"));
				simpleDto.setWriter(rs.getString("writer"));
				simpleDto.setTitle(rs.getString("title"));
				simpleDto.setContent(rs.getString("content"));
				simpleDto.setRegDate(rs.getDate("regdate"));
				list.add(simpleDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	public void simpleInsert(SimpleDto simpleDto) {
		try {
			con = dataSource.getConnection();
			sql = "insert into simple values (simple_seq.nextval, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, simpleDto.getWriter());
			ps.setString(2, simpleDto.getTitle());
			ps.setString(3, simpleDto.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	public SimpleDto simpleViewPage(int no) {
		SimpleDto simpleDto = new SimpleDto();
		try {
			con = dataSource.getConnection();
			sql = "select * from simple where no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while(rs.next()) {
				simpleDto.setNo(rs.getInt("no"));
				simpleDto.setWriter(rs.getString("writer"));
				simpleDto.setTitle(rs.getString("title"));
				simpleDto.setContent(rs.getString("content"));
				simpleDto.setRegDate(rs.getDate("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return simpleDto;
	}
	
	public void simpleUpdate(SimpleDto simpleDto) {
		try {
			con = dataSource.getConnection();
			sql = "update simple set writer = ?, title = ?, content = ? where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, simpleDto.getWriter());
			ps.setString(2, simpleDto.getTitle());
			ps.setString(3, simpleDto.getContent());
			ps.setInt(4, simpleDto.getNo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	public void simpleDelete(int no) {
		try {
			con = dataSource.getConnection();
			sql = "delete from simple where no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
}
