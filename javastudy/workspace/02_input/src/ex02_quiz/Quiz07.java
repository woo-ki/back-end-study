package ex02_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {

		// 문제. 온도 변환기
		// 섭씨 온도를 입력하면 해당 화씨 온도를 출력하십시오.
		// 화씨 = 섭씨 * 1.8 + 32
		
		Scanner input = new Scanner(System.in);
		System.out.print("온도를 입력하세요 >>> ");
		double c = input.nextDouble();
		
		double f = c * 1.8 + 32;
		System.out.println("화씨는 " + f + "도");
		
	}

}
