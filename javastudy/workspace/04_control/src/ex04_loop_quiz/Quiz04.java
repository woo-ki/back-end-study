package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

		// 문제. 입력 받은 구구단만 출력하시오
		// 2~9 사이 정수를 입력 받아 해당 구구단만 출력하시오.
		Scanner input = new Scanner(System.in);
		
		System.out.print("몇단이 궁금하세요? ");
		int num = input.nextInt();
		
		for(int a = 1; a < 10; a++) {
			System.out.println(num + "x" + a + "=" + (num * a));
		}
		
		input.close();
		
	}

}
