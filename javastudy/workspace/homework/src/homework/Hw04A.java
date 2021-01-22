package homework;

import java.util.Scanner;

public class Hw04A {
	
	public static void main(String args[]) {
		
		int[] unit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 }; // 권종
		int[] count = new int[10];
		
		Scanner sc = new Scanner(System.in);

		System.out.print("금액을 입력하시오 >> ");
		int money = sc.nextInt();

		for (int i = 0; i < unit.length; i++) {
			
			count[i] = money / unit[i];  // unit[i]에 저장된 각 권종의 개수를 계산한다.

			// count[i]는 권종의 개수
			if (count[i] > 0) {  // 권종이 존재하는 경우
				System.out.println(unit[i] + "원 짜리 : " + count[i] + "개");
				money = money % unit[i];  // money 갱신
			}
			
		}

		sc.close();
		
	}
	
}