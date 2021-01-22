package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

		// 문제. 권한을 정수(1~3) 입력 받아서
		// 권한1 : "실행, 쓰기, 읽기"
		// 권한2 : "쓰기, 읽기"
		// 권한3 : "읽기"
		
		Scanner input = new Scanner(System.in);
		System.out.print("권한을 입력하세요 >>> ");
		int level = input.nextInt();
		
		switch(level) {
		case 1: System.out.print("실행, ");
		case 2: System.out.print("쓰기, ");
		case 3: System.out.println("읽기");
		}
		
	}

}
