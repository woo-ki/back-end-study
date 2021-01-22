package com.koreait.quiz2;

public class BMICalculator {
	// bmi = 몸무게(kg) / 키(m) 제곱
	// Field
	// 저체중(bmi : ~19) 
	private double normal; // 정상(bmi : 20~25)
	private double over; // 과체중(bmi : 26~30)
	private double obesity; // 비만(bmi : 31~)
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	public void bmi(double weight, double height) {
		double bmi = weight / Math.pow((height/100), 2);
		String strBmi = "";
		if(bmi >= 31) {
			strBmi = "(비만)";
		} else if(bmi >= 26) {
			strBmi = "(과체중)";
		} else if(bmi >= 20) {
			strBmi = "(정상)";
		} else {
			strBmi = "(저체중)";
		}
		System.out.println("체질량(BMI) 지수: " + bmi + strBmi);
	}
}
