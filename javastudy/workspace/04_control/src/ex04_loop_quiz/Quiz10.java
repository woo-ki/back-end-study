package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {

		// 문제. UpDown 게임
		// 1 ~ 10000 사이의 난수를 발생시키고,
		// 해당 난수를 맞히는 게임
		// 입력마다 "Up!", "Down!"
		//
		// 난수 : 4500
		// 입력 >>> 5000
		// Down!
		// 입력 >>> 2500
		// Up!
		// ...
		// 입력 >>> 4500
		// 정답. 총 5번만에 성공.
		
		Scanner input = new Scanner(System.in);
		int num = (int)(Math.random() * 10000) + 1;
		int count = 0;
		
		while(true) {
		System.out.print("입력 >>> ");
		int answer = input.nextInt();
		count++;
		if(answer < 1 || answer > 10000) {
			System.out.println("1~10000 사이만 유효합니다.");
			continue;
		}
		if(num > answer) {
			System.out.println("Up!");
		} else if(num < answer) {
			System.out.println("Down!");
		} else {
			System.out.println("정답. 총 " + count + "번만에 성공.");
			break;
		}
		}
		
	}

}
