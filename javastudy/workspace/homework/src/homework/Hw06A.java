package homework;

import java.util.Scanner;

class RockScissorPaperGame {

	Scanner sc;
	String[] rsp = { "", "가위", "바위", "보" };  // 인덱스가 1이면 "가위", 2이면 "바위", 3이면 "보"
	int com;  // 컴퓨터의 랜덤 숫자(1~3)
	int user; // 사용자의 입력 숫자(1~3)
	int win;  // 이긴 횟수
	int draw; // 비긴 횟수
	int lose; // 진 횟수

	RockScissorPaperGame() {
		sc = new Scanner(System.in);
	}

	boolean toBeContinueGame() {
		com = (int) (Math.random() * 3) + 1;  // 컴퓨터가 1~3 사이 랜덤 생성

		System.out.print("가위 바위 보! >> ");  // 사용자가 "가위", "바위", "보" 입력
		String a = sc.next();
		
		if (a.equals("그만")) {  // "그만" 입력하면 false 리턴 (그만 한다는 뜻)
			return false;
		}
		
		for (int i = 1; i < rsp.length; i++) {  // 사용자가 입력한 "가위", "바위", "보"의 인덱스를 찾아
			if (a.equals(rsp[i])) {  // 사용자가 선택한 숫자로 변경(1~3)
				user = i;
			}
		}
		
		int diff = user - com;  // 사용자가 선택한 숫자 - 컴퓨터의 랜덤 숫자
		System.out.print("사용자는 " + rsp[user] + ", 컴퓨터는 " + rsp[com]);
		if (diff == -2 || diff == 1) {
			win++;
			System.out.println(", 이겼습니다!");
		} else if (diff == 0) {
			draw++;
			System.out.println(", 비겼습니다!");
		} else {
			lose++;
			System.out.println(", 졌습니다!");
		}
		return true;  // 이기고 비기고 진 결과에 상관 없이 true 리턴 (게임을 계속한다는 뜻)
	}

	void run() {
		while (true) {
			if (!toBeContinueGame()) {
				System.out.println("최종 전적: " + win + "승 " + draw + "무 " + lose + "패");
				sc.close();
				break;
			}
		}
	}

}

public class Hw06A {

	public static void main(String[] args) {

		RockScissorPaperGame game = new RockScissorPaperGame();
		game.run();

	}

}
