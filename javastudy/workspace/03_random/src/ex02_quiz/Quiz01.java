package ex02_quiz;

import java.util.Random;

public class Quiz01 {

	public static void main(String[] args) {

		// 문제. 주사우 ㅣ던지기
		// 1~6 사이의 임의의 숫자를 출력하시오.
		Random ran = new Random();
		int dice = ran.nextInt(6) + 1;
		System.out.println(dice);
		
	}

}
