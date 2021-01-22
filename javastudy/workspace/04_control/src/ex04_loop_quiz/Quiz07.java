package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {

		// 문제. 퀴즈 맞추기
		// 대한민국의 수도 맞추기
		// 맞히면 "정답입니다" 틀리면 "오답입니다"
		// 몇 번만에 맞혔는지 출력하기
		
		Scanner input = new Scanner(System.in);
		int count = 0;
		
		while(true) {
			System.out.print("대한민국의 수도는? >>> ");
			String answer = input.next();
			count ++;
			if(answer.equals("서울") || answer.equalsIgnoreCase("seoul")) {
				System.out.println("정답입니다. " + count + "회 만에 맞혔습니다.");
				break;
			} else {
				System.out.println("오답입니다.");				
			}
		}
		
		
	}

}
