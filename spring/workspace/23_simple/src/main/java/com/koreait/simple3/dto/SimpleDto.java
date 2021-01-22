package com.koreait.simple3.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SimpleDto {
	private int no;
	private String writer, title, content;
	private Date regDate;
}
