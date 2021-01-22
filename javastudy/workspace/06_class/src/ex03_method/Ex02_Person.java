package ex03_method;

import java.util.Date;

class Person {
	
	// field
	String name;
	Date date;
	double height;
	double weight;
	
	// method
	
	// 1. 필드 정보 저장 메소드
	// 1) 결과타입 : void
	// 2) 메소드명 : setInfo
	// 3) 매개변수 : String n, double h, double w
	void setInfo(String n, double h, double w) {
		name = n;
		date = new Date();
		height = h;
		weight = w;
	}
	
	// 2. bmi 정보를 반환(리턴, 결과)하는 메소드
	// 1) 결과타입 : double
	// 2) 메소드명 : getBMI
	// 3) 매개변수 : 없음
	double getBMI() {
		// 결과가 있는 메소드는
		// return문으로 결과를 반환한다.
		double resultBMI = 0;
		double h = height / 100; // height단위 : cm, h단위 : m
		resultBMI = weight / Math.pow(h, 2);
		// 결과반환
		return resultBMI;
	}
	
	// 3. 건강정보를 반환하는 메소드
	// 1) 결과타입 : String
	// 2) 메소드명 : getHealthInfo
	// 3) 매개변수 : 없음
	
	// 건강정보
	// 체질량지수 25이상이면 "과체중", 24~20 "정상", 20미만이면 "저체중"
	String getHealthInfo() {
		double BMI = getBMI();
		if(BMI >= 25) {
			return "과체중";
		} else if(BMI >= 20) {
			return "정상";
		} else {
			return "저체중";
		}
	}
	
}

public class Ex02_Person {

	public static void main(String[] args) {

		Person person = new Person();
		person.setInfo("앨리스", 165.5, 55.5);
		System.out.println("체질량지수 : " + person.getBMI());
		System.out.println("건강정보 : " + person.getHealthInfo());
		
	}

}
