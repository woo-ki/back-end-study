package ex02_quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {
		
		// 문제. 체질량지수(bmi)를 구하고 건강 상태 출력하기
		// 체질량지수 = 몸무게(kg) / 키(m)의 제곱
		// 건강상태 = 체질량지수 25이상이면 "과체중", 24~20 "정상", 20미만이면 "저체중"
		// 몸무게는 kg 단위로 입력받고, 키는 cm단위로 입력받는다.
		Scanner input = new Scanner(System.in);
		System.out.print("몸무게를 입력하세요 >>> ");
		double weight = input.nextDouble();
		System.out.print("키를 입력하세요 >>> ");
		double height = input.nextDouble();
		
		double bmi = weight / height * 100 / height * 100;
		String health = bmi >= 25 ? "과체중" : bmi >= 20 && bmi < 25 ? "정상" : "저체중";
		System.out.println("건강상태는 " + health + "입니다");

	}

}
