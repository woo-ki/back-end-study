package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

		// 문제. 임의의 양수를 입력 받아서,
		// "짝수", "홀수", "3의배수"를 구분해서 출력하시오
		// 3의배수 : 3으로 나눈 나머지가 0인 수
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >>> ");
		int num = input.nextInt();
		if(num % 3 == 0) {
			System.out.println("3의 배수");
		}else if(num % 2 == 1) {
			System.out.println("홀수");			
		}else {
			System.out.println("짝수");			
		}
		
	}

}
