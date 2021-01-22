package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

		// 문제. 평점 입력 받아서 해당 평점만큼 ★울 출력하시오.
		// 평점은 1 ~ 5 사이 정수로 입력 받는데, 벗어난 범위는 다시 입력 받는다.
		
		Scanner input = new Scanner(System.in);
		int grade = 0;
		String stars = ""; // 문자열 + 연산자로 연결되는 경우 "" 로 초기화를 한다.
		
		do {
			System.out.print("평점을 입력해주세요(1 ~ 5) >>> ");
			grade = input.nextInt();
		} while(grade < 1 || grade > 5);
		
		while(grade > 0) {
			stars += "★";
			grade--;
		}

		System.out.print(stars);
		
//		switch(grade) {
//		case 1: stars = "★"; break;
//		case 2: stars = "★★"; break;
//		case 3: stars = "★★★"; break;
//		case 4: stars = "★★★★"; break;
//		case 5: stars = "★★★★★";
//		}
//		
//		System.out.println("평점 : " + stars);
		
	}

}
