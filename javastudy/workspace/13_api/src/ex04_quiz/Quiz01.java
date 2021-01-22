package ex04_quiz;

import java.util.Scanner;

public class Quiz01 {
	private static Scanner sc;
	// static 메소드 (클래스 메소드)는
	// static 메소드+static 필드만 호출할 수 있다.
	
	// inputFullName 메소드
	// 실행 예)
	// 성을 입력하세요 >>> james
	// 이름을 입력하세요 >>> dean
	// james dean 을 반환하는 메소드로 구현하시오
	// 반드시 StringBuffer 클래스를 사용하시오.
	public static String inputFullName() {
		sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.print("성을 입력하세요 >>> ");
		sb.append(sc.nextLine()).append(" ");
		System.out.print("이름을 입력하세요 >>> ");
		sb.append(sc.nextLine());
		sc.close();
		return sb.toString();
	}
	
	public static void main(String[] args) {

		String fullName1 = inputFullName(); // inputFullname(); 메소드는 같은 ㅡㅋㄹ래스에 있다
		String fullName2 = inputFullName();
		System.out.println("성명1: " + fullName1);
		System.out.println("성명2: " + fullName2);
		if(fullName1.equals(fullName2)) {
			System.out.println("같은 이름입니다.");
		} else {
			System.out.println("다른 이름입니다.");
		}
		
	}

}
