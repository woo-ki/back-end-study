package com.koreait.spring;

import java.util.List;

public class ListHandler {
	// field
	private List<String> list;

	public ListHandler() {
		super();
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	public void listInfo() {
		for(String item : list) {
			System.out.println(item);
		}
	}
}
