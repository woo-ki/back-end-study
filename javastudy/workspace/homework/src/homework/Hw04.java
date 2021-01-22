package homework;

import java.util.Scanner;

public class Hw04 {

	public static void main(String[] args) {

		/*
		사용자로부터 돈을 입력받아서 
		오만원권, 만원권, 오천원권, 천원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 오원 동전, 일원 동전이
		각각 몇 개로 변환되는지 출력하시오.
		이 때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};  // 권종
		예시)
		금액을 입력하시오 >> 77777
		50000원 짜리 : 1개
		10000원 짜리 : 2개
		5000원 짜리 : 1개
		1000원 짜리 : 2개
		500원 짜리 : 1개
		100원 짜리 : 2개
		50원 짜리 : 1개
		10원 짜리 : 2개
		5원 짜리 : 1개
		1원 짜리 : 2개
		 */
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하시오 >> ");
		int money = sc.nextInt();
		for(int i = 0; i < unit.length; i++) {
			int result = money / unit[i];
			money %= unit[i];
			System.out.println(unit[i] + "원 짜리 : " + result + "개");
		}
		sc.close();
		
	}

}
