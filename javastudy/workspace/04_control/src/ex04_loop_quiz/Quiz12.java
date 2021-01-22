package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz12 {

	public static void main(String[] args) {

		// 문제. 10000원 모두 쓰기
		// 사용할 금액을 입력 받아서 10000원에서 공제하기
		// 현재 10000원 있습니다.
		// 결제금액 >>> 5000
		// 현재 5000원 있습니다.
		// 결제금액 >>> 10000
		// 5000원이 부족합니다.
		// 현재 5000원 있습니다.
		// 결제금액 >>> 5000
		// 현재 0원 있습니다.
		
		Scanner input = new Scanner(System.in);
		int money = 10000;
		
		while(true) {
			System.out.println("현재 " + money + "원 있습니다.");
			if(money == 0) {
				break;
			}
			System.out.print("결제금액 >>> ");
			int pay = input.nextInt();
			
			if(pay <= 0) {
				System.out.println("정확한 금액을 입력하세요.");
				continue;
			} else if(pay <= money) {
				money -= pay;
			} else {
				System.out.println((pay - money) + "원이 부족합니다.");
				continue;
			}
			
		}

	}

}
