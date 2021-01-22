package com.koreait.contact2.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.contact2.common.SpringJdbc;
import com.koreait.contact2.dto.ContactDto;

public class ContactDao {
	private JdbcTemplate template;
	public ContactDao() {
		this.template = SpringJdbc.template;
	}
	
	private String sql;
	
	public List<ContactDto> contactList() {
		sql = "select * from contact order by no";
		List<ContactDto> list = template.query(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class));
		return list;
	}
	
	public void contactInsert(ContactDto contactDto) {
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
	
	public ContactDto contactView(int no) {
		sql = "select * from contact where no = ?";
		ContactDto contactDto = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDto>(ContactDto.class), no);
		return contactDto;
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
