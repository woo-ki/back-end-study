package homework;

import java.util.Scanner;

class Ggb {
	String[] kGgb = {"가위", "바위", "보"};
	int[] iGgb = {0, 1, 2};
	String pKGgb;
	int pIGgb;
	String cKGgb;
	int cIGgb;
	int win;
	int draw;
	int lose;
	Scanner sc = new Scanner(System.in);
	
	Ggb() {}
	
	// 1. 플레이어 가위바위보 생성
	void player() {
		for(int i = 0; i < kGgb.length; i++) {
			if(pKGgb.equals(kGgb[i])) {
				pIGgb = iGgb[i];
			}
		}
		System.out.print("사용자는 " + pKGgb + ", ");
	}
	// 2. 컴퓨터 가위바위보 생성
	void computer() {
		cIGgb = (int)(Math.random() * 3);
		for(int i = 0; i < kGgb.length; i++) {
			if(cIGgb == iGgb[i]) {
				cKGgb = kGgb[i];
			}
		}
		System.out.print("컴퓨터는 " + cKGgb + ", ");
	}
	// 3. 결과 생성
	void result() {
		player();
		computer();
		switch(pIGgb - cIGgb) {
		case 2 : case -1 :
			System.out.println("졌습니다!");
			lose += 1;
			break;
		case 0 :
			System.out.println("비겼습니다!");
			draw += 1;
			break;
		default :
			System.out.println("이겼습니다!");
			win += 1;
			break;
		}
	}
	// 4. 게임 종료
	void exit() {
		System.out.println("최종 전적: " + win + "승 " + draw +"무 " + lose + "패");
		sc.close();
	}
	// 5. 게임 머신
	void game() {
		while(true) {
			System.out.print("가위 바위 보! >> ");
			pKGgb = sc.next();
			sc.nextLine();
			switch(pKGgb) {
			case "가위" : case "바위" : case "보" :
				result(); break;
			case "그만" :
				exit(); return;
			default :
				System.out.println("없는 명령어 입니다.");
			}
		}
	}
}

public class Hw06 {

	public static void main(String[] args) {
		
		/*
		가위바위보 게임
		사용자가 가위, 바위, 보 중 하나를 입력하고 Enter를 입력하면
		컴퓨터는 가위, 바위, 보 중 하나를 랜덤하게 선택해서 누가 이겼는지 판단한다.
		사용자가 가위, 바위, 보 대신 “그만”을 입력하면 그 동안 사용자의 전적이 출력되고(예: 3승 3무 3패) 게임이 종료된다.
		예시)
		가위 바위 보! >> 가위
		사용자는 가위, 컴퓨터는 보, 이겼습니다!
		가위 바위 보! >> 바위
		사용자는 바위, 컴퓨터는 바위, 비겼습니다!
		가위 바위 보! >> 그만
		최종 전적: 1승 1무 0패
		*/
		
		Ggb ggb = new Ggb();
		ggb.game();
		
	}

}
