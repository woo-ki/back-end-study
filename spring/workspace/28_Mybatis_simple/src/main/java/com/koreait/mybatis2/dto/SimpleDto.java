package com.koreait.mybatis2.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SimpleDto {

	// field
	private int no;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	
}