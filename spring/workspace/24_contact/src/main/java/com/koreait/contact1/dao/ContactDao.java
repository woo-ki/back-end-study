package com.koreait.contact1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.contact1.common.SpringJdbc;
import com.koreait.contact1.dto.ContactDto;

public class ContactDao {
	// DBCP을 직접 사용할 때는
	// 연결, PreparedStatement 생성, 쿼리문 생성, 변수처리, 실행, 반복, 연결 종료 등 모든 작업을
	// 반복적으로 개발자가 수행합니다.
	
	// 이 중 몇몇 작업(연결, ps생성등)을 JdbcTemplate template이 처리합니다.
	
	// 톰캣의 context.xml을 사용하지 않기 때문에
	// context.lookup("java:comp/env/jdbc/oracle")를 호출할 필요가 없습니다.
	
	// common 패키지의 SpringJdbc.template을 불러와서 사용하면 됩니다.
	
	private JdbcTemplate template;
	
	public ContactDao() {
		this.template = SpringJdbc.template;
	}
	
	private String sql;
	
	public List<ContactDto> contactList() {
		sql = "select * from contact";
		List<ContactDto> list = template.query(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
		return list;
	}
	
	public ContactDto contactView(int no) {
		sql = "select * from contact where no = " + no;
		ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
		return contactDto;
	}
	public ContactDto contactView2(int no) {
		sql = "select * from contact where no = ?";
		ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class), no);
		return contactDto;
	}
	
	public void contactInsert1(ContactDto contactDto) {
		// insert, update, delete문은 모두 template.update()를 사용합니다.
		sql = "insert into contact values (contact_seq.nextval, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, contactDto.getName());
				ps.setString(2, contactDto.getPhone());
				ps.setString(3, contactDto.getAddress());
				ps.setString(4, contactDto.getEmail());
				ps.setString(5, contactDto.getNote());
			}
		});
	}
	public void contactInsert2(String name, String phone, String address, String email, String note) {
		sql = "insert into contact values (contact_seq.nextval, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, phone);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, note);
			}
		});
	}
	public void contactInsert3(String name, String phone, String address, String email, String note) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "insert into contact values (contact_seq.nextval, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, phone);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, note);
				return ps;
			}
		});
	}
	
	public void contactUpdate(ContactDto contactDto) {
		sql = "update contact set name=?, phone=?, address=?, email=?, note=? where no=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, contactDto.getName());
				ps.setString(2, contactDto.getPhone());
				ps.setString(3, contactDto.getAddress());
				ps.setString(4, contactDto.getEmail());
				ps.setString(5, contactDto.getNote());
				ps.setInt(6, contactDto.getNo());
			}
		});
	}
	
	public void contactDelete(int no) {
		sql = "delete from contact where no=" + no;
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {}
		});
	}
}
