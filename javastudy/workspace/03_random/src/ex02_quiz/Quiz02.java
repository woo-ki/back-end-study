package ex02_quiz;

import java.util.Random;

public class Quiz02 {
	
	public static void main(String[] args) {
		
		// 문제 아이템 획득하기
		// 10% 확률로 "전설 아이템", 나머지 확률로 "영웅 아이템"을 출력하시오.
		Random ran = new Random();
//		int chance = ran.nextInt(10);
//		String item = chance == 9 ? "전설 아이템" : "영웅 아이템";
		String item = ran.nextDouble() <= 0.1 ? "전설 아이템" : "영웅 아이템";
		System.out.println("당첨 아이템 : " + item);
		
	}

}
