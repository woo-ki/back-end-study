package homework;

import java.util.Scanner;

class Player0 {
	
	String name;
	Scanner sc;

	Player0(String name) {
		this.name = name;
		sc = new Scanner(System.in);
	}

	String getName() {
		return name;
	}

	void getEnterKey() {
		sc.nextLine(); // <Enter> 키를 입력 받아서 버린다.(Enter키를 누를 때까지 기다린다는 의미)
	}

	boolean turn() {
		System.out.print("[" + name + "]:<Enter>");
		getEnterKey(); // 참가자가 <Enter>키 입력할 때까지 기다림

		int num[] = new int[3]; // 3개의 난수를 저장하기 위한 배열

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 3) + 1; // 1~3까지의 임의의 수 발생(3개의 난수 생성)
		}

		// 3개의 난수 출력
		System.out.print("\t\t");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}

		// 3개의 난수가 같은지 비교
		boolean result = true;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != num[0]) {		// 하나라도 다르면 false
				result = false;			// 같지 않음
				break;
			}
		}

		return result; // result가 true 이면 승리
	}
	
}

class GamblingGame {
	
	Player0[] players;
	Scanner sc;

	GamblingGame() {
		sc = new Scanner(System.in);
		System.out.print("갬블링 게임에 참여할 선수 숫자를 입력하세요 >> ");
		int nPlayers = sc.nextInt();
		sc.nextLine();  // 입력스트림에 입력된 <Enter>키 제거

		players = new Player0[nPlayers];	// nPlayer명이 하는 게임이 된다.
		for (int i = 0; i < players.length; i++) {
			System.out.print((i + 1) + "번째 선수 이름 >> ");
			players[i] = new Player0(sc.nextLine());
		}
	}

	void run() {
		int i = 0;
		while (true) {
			if (players[i].turn()) {  // 선수 i의 세 난수가 모두 같은 경우
				System.out.println(players[i].getName() + " 승리!");
				break;
			} else {
				System.out.println("아쉽군요!");
				i++;  // 다음 사람
				i = i % players.length;	// players 배열에 저장된 Player가 번갈아 가면서 게임을 진행
			}
		}
	}

}

public class Hw08A {
	
	public static void main(String[] args) {
		
		GamblingGame game = new GamblingGame();
		game.run();
		
	}
	
}