package ex02_quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

		// 문제. 주민등록번호를 하이픈(-) 없이 입력 받아서,
		// "남자", "여자" 구분하여 출력하시오.
		
		Scanner input = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요 >>> ");
		String strSn = input.next();
		char genderNum = strSn.charAt(6); // 7번째 글자를 의미한다.
		// genderNum   코드값(정수)
		//    '1'           49
		//    '2'           50
		//    '3'           51
		//    '4'           52
		// 대표 코드값
		// '0' -> 48
		// 'A' -> 65
		// 'a' -> 97
		// String gender = genderNum % 2 == 1 ? "남자" : "여자"; // genderNum 은 코드값으로 계산된다
		String gender = genderNum == '1' || genderNum == '3' ? "남자" : "여자";
		System.out.println("성별은 " + gender);
		
		input.close();
		
	}

}
