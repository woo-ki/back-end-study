package ex01_branch;

public class Ex04_switch {

	public static void main(String[] args) {

		/*
		 * switch문
		 * 1. 표현식의 결과에 따라 실행을 구분
		 * 2. 형식
		 * 		switch (표현식) {
		 * 		case 결과1 : 실행문1;
		 *	 				break;
		 *		case 결과2 : 실행문2;
		 * 					break;
		 * 		case 결과3 : 실행문3;
		 * 					break;
		 * 		default : 실행문4;
		 * 		}
		 * 3. 주의
		 * 		1) 표현식의 결과는 정수, 문자, 문자열이 가능하다.
		 * 		2) 표현식의 결과가 논리나 실수이면 switch문은 사용할 수 없다.
		 */
		
		int genderNum = 1;
		String gender = null;  // String 타입 초기화 방법1
		// String gender = ""; // String 타입 초기화 방법2
		
		switch(genderNum % 2) {
		case 0 : gender = "여자";
				break;
		case 1 : gender = "남자";
				break; // 필요하지 않은 break(마지막 case 또는 default 에서만)
		}
		
		
		
	}

}
