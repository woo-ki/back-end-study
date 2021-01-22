package ex01_branch;

import java.util.Random;

public class Ex03_if_elseif {

	public static void main(String[] args) {

		// if-elseif문
		// 1. 조건식이 다수 존재할 때 사용
		// 2. 형식
		//		if (조건식1) {
		//			실행문1;
		//		} else if (조건식2) {
		//			실행문2;
		//		} else if (조건식3) {
		//			실행문3;
		//		} ...
		
		int a = (new Random()).nextInt();
		
		if (a > 0) {
			System.out.println(a + "는 양수이다.");
		} else if (a == 0) {
			System.out.println("0이다.");
		} else if (a < 0) {
			System.out.println(a + "는 음수이다.");
		}
		
		// if - else if - else 문을 모두 활용하는 것이 좋다.
		
		if (a > 0) {
			System.out.println(a + "는 양수이다.");
		} else if (a == 0) {
			System.out.println("0이다.");
		} else {
			System.out.println(a + "는 음수이다.");
		}

	}

}
