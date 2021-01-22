package ex02_quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

		// 문제. 두 개의 실수를 입력 받아서,
		// 두 실수의, 값을 교환하시오.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 실수를 입력하세요 >>> ");
		double num1 = sc.nextDouble();
		System.out.print("두 번째 실수를 입력하세요 >>> ");
		double num2 = sc.nextDouble();
		double temp;
		temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println("첫 번째 : " + num1);
		System.out.println("두 번째 : " + num2);
		sc.close();
		
	}

}
