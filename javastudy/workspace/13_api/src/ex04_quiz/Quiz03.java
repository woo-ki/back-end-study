package ex04_quiz;

import java.util.Calendar;
import java.util.Scanner;

// 문제. 10초 맞히기
// 시작할 떄 Enter
// 종료할 때 Enter
// 그 사이의 시간을 초로 계산
// 예시)
// player1의 게임을 시작합니다.
// 준비되면 Enter를 누르세요.	sc.nextLine();
// (Enter를 누르면) 현재 50초
// 10초가 된 것 같으면 Enter를 누르세요.
// (Enter를 누르면) 현재 58초
// player2의 게임을 시작합니다.
// 준비되면 Enter를 누르세요.
// (Enter를 누르면) 현재 10초
// 10초가 된 것 같으면 Enter를 누르세요.
// (Enter를 누르면) 현재 19초
// player1의 결과: 8초, player2의 결과: 9초, player2가 이겼습니다.

class GamePlayer {
	private Scanner sc = new Scanner(System.in);
	private String name;
	
	public GamePlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int play() {
		System.out.println(name + "의 게임을 시작합니다.");
		System.out.println("준비되면 Enter를 누르세요.");
		sc.nextLine();
		int start = Calendar.getInstance().get(Calendar.SECOND);
		System.out.println("현재 " + start + "초");
		System.out.println("10초가 된 것 같으면 Enter를 누르세요.");
		sc.nextLine();
		int end = Calendar.getInstance().get(Calendar.SECOND);
		System.out.println("현재 " + end + "초");
		// end < start 경우는 end에 60을 더해서 처리한다
		if(end < start) {
			end += 60;
		}
		return end - start;
	}
}

class Game {
	private GamePlayer[] players;
	private Scanner sc = new Scanner(System.in);
	
	public Game(int playerCount) {
		players = new GamePlayer[playerCount];
	}
	
	public void setPlayers() {
		for(int i = 0; i < players.length; i++) {
			System.out.print("플레이어" + (i + 1) + "이름 입력 >>> ");
			players[i] = new GamePlayer(sc.next());
		}
	}
	public void play() {
		int[] elapseTimes = new int[players.length];
		for(int i = 0; i < players.length; i++) {
			elapseTimes[i] = players[i].play();
		}
		// 10 - elapseTimes의 절대값의 최소값 구하기
		// 절대값 Math.abs(-5) == 5
		
		// 최소값 알고리즘
		// 1. 초기화: 배열의 첫 번째 요소
		// 2. 알고리즘: 최소값(min) 보다 더 작은 배열 요소가 나타나면 최소값 변경
		int min = Math.abs(10 - elapseTimes[0]);
		int winnerNo = 0;	// min이 저장된 요소의 인덱스
		for(int i = 1; i < elapseTimes.length; i++) {
			if(min > Math.abs(10 - elapseTimes[i])) {
				min = Math.abs(10 - elapseTimes[i]);
				winnerNo = i;
			}
		}
		// player1의 결과: 8초, player2의 결과: 9초, player2가 이겼습니다.
		for(int i = 0; i < players.length; i++) {
			System.out.print(players[i].getName() + "의 결과: " + elapseTimes[i] + "초, ");
		}
		System.out.println(players[winnerNo].getName() + "가 이겼습니다.");
	}
}

public class Quiz03 {

	public static void main(String[] args) {
		Game game = new Game(3);
		game.setPlayers();
		game.play();
//		Scanner sc = new Scanner(System.in);
//		long[] player = new long[2];
//		for(int i = 0; i < 2; i++) {
//			System.out.println("player" + (i + 1) + "의 게임을 시작합니다.\n준비되면 Enter를 누르세요.");
//			sc.nextLine();
//			long time1 = System.nanoTime();
//			Calendar cal = Calendar.getInstance();
//			System.out.println("현재 " + cal.get(Calendar.SECOND) + "초");
//			System.out.println("10초가 된 것 같으면 Enter를 누르세요.");
//			sc.nextLine();
//			long time2 = System.nanoTime();
//			Calendar cal1 = Calendar.getInstance();
//			System.out.println("현재 " + cal1.get(Calendar.SECOND) + "초");
//			player[i] = (time2 - time1) / 1000000000;
//		}
//		
//		long[] pl = new long[2];
//		
//		for(int i = 0; i < player.length; i++) {
//			if(player[i] < 10) {
//				pl[i] = 10 - player[i];
//			} else {
//				pl[i] = player[i] - 10;
//			}
//		}
//		
//		if(pl[1] - pl[0] < 0) {
//			System.out.println("player1의 결과: " + player[0] + "초, player2의 결과: " + player[1] + "초, player2가 이겼습니다.");
//		} else if(pl[1] - pl[0] > 0) {
//			System.out.println("player1의 결과: " + player[0] + "초, player2의 결과: " + player[1] + "초, player1이 이겼습니다.");
//		} else {
//			System.out.println("player1의 결과: " + player[0] + "초, player2의 결과: " + player[1] + "초, 비겼습니다.");
//		}
		
	}

}
