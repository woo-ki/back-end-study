package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {

		// 문제. 가위바위보
		// 실행
		// 가위바위보 >>> 가위
		// 당신은 가위, 컴퓨터는 보, 이겼습니다.
		// Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.
		Scanner input = new Scanner(System.in);
		
		System.out.print("가위바위보 >>> ");
		String strYour = input.nextLine();
		int your = 0;
		switch(strYour) {
		case "가위": your = 0; break;
		case "바위": your = 1; break;
		case "보": your = 2; break;
		}
		
		String strComputer = null;
		int computer = (int)(Math.random() * 3);
		switch(computer) {
		case 0: strComputer = "가위"; break;
		case 1: strComputer = "바위"; break;
		case 2: strComputer = "보"; break;
		}
		
		String result = null;
		switch (your - computer) {
		case 0: result = "비겼습니다."; break;
		case -1:
		case 2: result = "졌습니다."; break;
		case -2:
		case 1: result = "이겼습니다."; break;
		}
		
		System.out.println("당신은 " + strYour + ", 컴퓨터는 " + strComputer + ", " + result);
		input.close();
		
		
	}

}
