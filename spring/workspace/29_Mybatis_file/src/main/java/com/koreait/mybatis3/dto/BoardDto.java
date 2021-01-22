package com.koreait.mybatis3.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BoardDto {
	private int no;
	private String writer, title, content, filename;
	private Date regDate;
}
