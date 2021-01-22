package homework;

import java.util.Scanner;

public class Hw02A {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력하세요(0~100) >> ");
		int score = sc.nextInt();
		System.out.print("학년을 입력하세요(1~4) >> ");
		int grade = sc.nextInt();

		if (grade < 4) {
			if (score >= 60) {
				System.out.println("합격!");	 // 1~3학년, 60점 이상 합격
			} else {
				System.out.println("불합격!");  // 1~3학년, 60점 미만 불합격
			}
		} else {
			if (score >= 70) {
				System.out.println("합격!");  // 4학년, 70점 이상 합격
			} else {
				System.out.println("불합격!");  // 4학년, 70점 미만 불합격
			}
		}

		sc.close();

	}
	
}
