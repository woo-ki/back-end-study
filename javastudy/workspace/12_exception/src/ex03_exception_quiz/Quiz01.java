package ex03_exception_quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * UpDownGame
 * 
 * 1. 1~100 사이의 난수를 발생시키고, 사용자가 해당 난수를 맞히는 게임.
 * 2. 몇 번만에 맞혔는지 게임 종료 시 출력
 * 3. 1~100 사이를 벗어난 값을 입력하면 NumberOutOfBoundsException 예외 발생
 * 	  예외 메시지 : 1~100 사이의 정수만 입력할 수 있습니다.
 * 
 */

class UpDownGame {
	private int answer;	// 발생된 난수
	private int count;	// 시도 횟수
	private Scanner sc;	// 입력 받을 sc (모든 메소드에서 sc 객체를 사용할 수 있다.)
	
	public UpDownGame() {
		this.answer = (int)(Math.random() * 100) + 1;
		this.count = 0;
		this.sc = new Scanner(System.in);
	}
	
	// 사용자가 1 ~ 100 사이의 값 입력
	// 사용자가 입력한 값을 리턴
	public int challenge() throws InputMismatchException, NumberOutOfBoundsException {
		count++;
		System.out.print("1~100 사이의 숫자를 입력하세요 >> ");
		int i = sc.nextInt();
		if(i < 1 || i > 100) {
			NumberOutOfBoundsException e = new NumberOutOfBoundsException("1~100 사이의 정수만 입력할 수 있습니다.");
			throw e;
		}
		return i;
		
	}
	public void play() {
		while(true) {
			try {
				int i = challenge();
				if(i > answer) {
					System.out.println("다운");
				} else if(i < answer) {
					System.out.println("업");
				} else {
					System.out.println("정답입니다. " + count + "회 만에 맞히셨습니다.");
					sc.close();
					return;
				}
			} catch(NumberOutOfBoundsException e) {
				System.out.println(e.getMessage());
				// challenge 메소드의 정수가 아닌 입력은 int i 에 전달되지 못하고,
				// 계속 입력 스트림에 남아있어서 제거해 줘야 한다.
			} catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
				sc.next();
			}
		}
	}
}

class NumberOutOfBoundsException extends Exception {
	public NumberOutOfBoundsException(String message) {
		super(message);
	}
	
}

public class Quiz01 {

	public static void main(String[] args) {

		UpDownGame game = new UpDownGame();
		game.play();
		
	}

}
