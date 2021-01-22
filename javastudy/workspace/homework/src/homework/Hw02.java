package homework;

import java.util.Scanner;

public class Hw02 {

	public static void main(String[] args) {

		/*
		1개의 점수와 학년을 입력받아 60점 이상이면 합격, 미만이면 불합격을 출력하시오.
		4학년인 경우 70점 이상이어야 합격이다.
		예시)
		점수를 입력하세요(0~100) >> 65
		학년을 입력하세요(1~4) >> 3
		합격!
		-----------------------------
		점수를 입력하세요(0~100) >> 65
		학년을 입력하세요(1~4) >> 4
		불합격!
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0~100) >> ");
		int score = sc.nextInt();
		System.out.print("학년을 입력하세요(1~4) >> ");
		int grade = sc.nextInt();
		boolean result = false;
		if(grade >= 4 && score >= 70) {
			result = true;
		} else if(grade <= 3 && score >= 60) {
			result = true;
		}
		System.out.println(result ? "합격" : "불합격");
		sc.close();
	}

}
