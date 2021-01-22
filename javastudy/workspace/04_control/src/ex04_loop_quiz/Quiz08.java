package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {

		// 문제. 비밀번호를 "1234"로 가정한다.
		// 비밀번호를 입력 받아서 "1234"와 같으면 "성공"
		// "1234'가 아니면 다시 비밀번호를 입력
		// 최대 5번 가능하고 최종적으로 "실패"
		
		Scanner input = new Scanner(System.in);
		boolean success = false; // 어떤 상태를 의미하는 변수(flag)
		
		for(int i = 0; i < 5; i++) {
			System.out.print("비밀번호를 입력하세요 >>> ");
			String password = input.next();
			if(password.equals("1234")) {
				success = true;
				break;
			}
		}
		if(success) { // 성공했다면
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		input.close();
		
	}

}
