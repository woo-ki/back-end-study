package ex04_quiz;

import java.util.Calendar;

public class Quiz02 {

	public static void main(String[] args) {

		// 기념일 계산하기
		// Calendar 클래스를 이용해 특정 기념일로부터
		// 며칠이 지났는지 출력하시오.
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(1993, 0, 13);
		Calendar cal = Calendar.getInstance();
		long day = (cal.getTimeInMillis() - anniversary.getTimeInMillis()) / 1000 / 86400;
		System.out.println(day);
		
	}

}
