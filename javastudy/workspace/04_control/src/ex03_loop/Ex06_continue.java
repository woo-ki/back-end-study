package ex03_loop;

import java.util.Scanner;

public class Ex06_continue {

	public static void main(String[] args) {

		// continue문
		// 실행 중인 loop문으로 되돌아 감
		
		// 1. 1 ~ 10 사이 정수 중에서 4 ~ 6만 제외하고 출력
		
		for(int a = 1; a < 11; a++) {
			if(a >= 4 && a <= 6) {
				continue;
			}
			System.out.println(a);
		}
		
		// 2. 애들 밥 먹이기
		// 김치 뺴고 5번 먹이기
		// 김치는 안 먹고, 나머지는 모두 먹는 상황
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			// 반찬 입력
			System.out.print("먹을 반찬 입력 >>> ");
			String food = input.next();
			
			// 김치인가 아닌가
			if(food.equals("김치")) {
				System.out.println("매운 거 안 먹어요");
				i--;
				continue;
			}
			
			System.out.println(food + " 잘 먹겠습니다.");
			
		}
		
	}

}
