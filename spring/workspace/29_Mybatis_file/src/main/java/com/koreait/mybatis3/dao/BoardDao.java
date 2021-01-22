package com.koreait.mybatis3.dao;

import java.util.List;

import com.koreait.mybatis3.dto.BoardDto;

public interface BoardDao {

	public List<BoardDto> boardList();
	
	public int boardInsert(String writer, String title, String content, String filename);
	
	public BoardDto boardView(int no);
	
	public int boardDelete(int no);
	
}
