package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

		// 문제. 나이가 20살 이상이면 "성인", 아니면 "미성년자"를 출력하시오.
		Scanner input = new Scanner(System.in);
		System.out.print("나이를 입력하세요 >>> ");
		int age = input.nextInt();
		String result = "성인";
		
		switch (age / 10) {
		case 0:
		case 1: result = "미성년자";
		}
		
		System.out.println(result);
		
	}

}
