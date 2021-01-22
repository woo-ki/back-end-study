package com.koreait.quiz1;

public class Gugudan {
	private int startDan;
	private int endDan;
	private int startNum;
	private int endNum;
	private Calculator calculator;
	
	public int getStartDan() {
		return startDan;
	}
	public void setStartDan(int startDan) {
		this.startDan = startDan;
	}
	public int getEndDan() {
		return endDan;
	}
	public void setEndDan(int endDan) {
		this.endDan = endDan;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void gugudan() {
		for(int i = getStartDan(); i <= getEndDan(); i++) {
			for(int j = getStartNum(); j <= getEndNum(); j++) {
				calculator.mul(i, j);
			}
		}
	}
}
