package homework;

import java.util.Scanner;

public class Hw01 {

	public static void main(String[] args) {

		/*
		이름(문자열), 나이(정수), 키(실수), 성별(문자)을 입력받아 출력하는 프로그램을 구현하시오.
		예시)
		이름을 입력하세요 >> mccain
		나이를 입력하세요 >> 25
		키를 입력하세요 >> 167.5
		성별을 입력하세요 >> 남
		mccain, 25, 167.5, 남
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 >> ");
		String name = sc.nextLine();
		System.out.print("나이 입력하세요 >> ");
		int age = sc.nextInt();
		System.out.print("키 입력하세요 >> ");
		double height = sc.nextDouble();
		sc.nextLine();
		System.out.print("성을 입력하세요 >> ");
		char gender = sc.nextLine().charAt(0);

		System.out.println(name + ", " + age + ", " + height + ", " + gender);
		sc.close();
	}

}
