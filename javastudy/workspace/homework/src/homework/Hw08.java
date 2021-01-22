package homework;

import java.util.Scanner;

class Player {
	String name;
	Scanner sc = new Scanner(System.in);
	
	Player(String name) {
		this.name = name;
	}
	
	// 1. 한사람의 턴 진행되는 turn
	boolean turn() {
		System.out.print("[" + name + "]:<Enter>");
		sc.nextLine();
		int[] r = new int[3];
		// 랜덤상수 생성 및 출력
		for(int i = 0; i < r.length; i++) {
			r[i] = (int)(Math.random() * 3) + 1;
			System.out.print("\t\t" + r[i] + "\t");
		}
		// 랜덤상수 비교 및 결과 출력
		for(int i = 0; i < r.length; i++) {
			if(r[i] != r[0]) {
				return false;
			}
		}
		return true;
	}
	// 2. 이름 반환 함수 getName
	String getName() {
		return name;
	}
}

class Game {
	Player[] players;
	Scanner sc = new Scanner(System.in);
	
	Game() {
		System.out.print("겜블링 게임에 참여할 선수 숫자를 입력하세요 >> ");
		players = new Player[sc.nextInt()];
		sc.nextLine();
		for(int i = 0; i < players.length; i++) {
			System.out.print((i + 1) + "번째 선수 이름 >> ");
			players[i] = new Player(sc.nextLine());
		}
	}
	
	// 게임 실행
	void run() {
		int i = 0;
		while(true) {
			if(players[i].turn()) {
				System.out.println(players[i].getName() + " 승리!");
				return;
			} else {
				System.out.println("아쉽군요!");
			}
			i++;
			i %= players.length;
		}
	}
}

public class Hw08 {

	public static void main(String[] args) {
		

		/*
		갬블링 게임
		각 선수는 Player 클래스로 작성한다.
		게임에 참여하는 Player가 몇 명인지 인원수를 입력 받아서 Player[] 배열에 저장한다.
		각 Player는 이름을 입력 받아서 생성하시오.
		선수가 한 번씩 게임을 진행하며 각 사람이 자기 차례에서 Enter를 누르면 3개의 난수(1~3사이)가 발생하며
		 이 숫자가 모두 같으면 승자가 되고 게임이 끝난다.
		예시)
		갬블링 게임에 참여할 선수 숫자를 입력하세요 >> 3
		1번째 선수 이름 >> 마틴
		2번째 선수 이름 >> 잭슨
		3번째 선수 이름 >> 캐리
		[마틴]:<Enter>
				2	1	3	아쉽군요!
		[잭슨]:<Enter>
				3	3	3	잭슨 승리!
		 */
		Game g = new Game();
		g.run();
	}

}
