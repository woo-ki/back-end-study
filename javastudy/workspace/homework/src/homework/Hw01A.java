package homework;

import java.util.Scanner;

public class Hw01A {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 >> ");
		String name = sc.next();
		System.out.print("나이를 입력하세요 >> ");
		int age = sc.nextInt();
		System.out.print("키를 입력하세요 >> ");
		double height = sc.nextDouble();
		System.out.print("성별을 입력하세요 >> ");
		char gender = sc.next().charAt(0);
		// char타입 입력 메소드는 없다.
		// 일단 문자열로 입력받은 뒤(next 메소드) 첫 번째 글자만(인덱스 0 위치의 글자: charAt(0)) 추출한다.

		System.out.println(name + ", " + age + ", " + height + ", " + gender);

		sc.close();

	}

}
