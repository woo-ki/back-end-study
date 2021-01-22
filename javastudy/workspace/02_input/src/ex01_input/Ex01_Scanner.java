package ex01_input;

// import
import java.util.Scanner;

public class Ex01_Scanner {

	public static void main(String[] args) {

		/*
		 * 그 동안 사용했던 클래스
		 * 모두 동일한 패키지에 저장되어 있다.
		 * 패키지명 : java.lang
		 * 1. String
		 * 2. System
		 * 3. Integer
		 * 4. Boolean
		 * 5. Double
		 * 
		 * java.lang 패키지에 저장된 클래스들은 import가 필요 없다.
		 * */
		
		/*
		 * Scanner 클래스
		 * 
		 * 1. 콘솔 입력(키보드 입력)
		 * 2. 패키지 : java.util
		 * 		import가 필요하다. (자동 완성으로 클래스를 입력한다)
		 * 3. 생성방법
		 * 		Scanner 객체 = new Scanner(입력스트림);
		 * 4. 소멸 방법
		 * 		객체.close();
		 * 5. 입력 받을 때 사용하는 메소드
		 * 		1) 정수 입력
		 * 			- nextInt(), nextLong(), sextShort(), NextByte()
		 * 		2) 실수 입력
		 * 			- nextDouble(), nextFloat()
		 * 		3) 논리 입력
		 * 			- nextBoolean()
		 * 		4) 문자열 입력
		 * 			- next() : 공백 문자 전까지 입력 (공백의 입력이 불가능)
		 * 			- nextLine() : 엔터 전까지 입력 (공백의 입력이 가능)
		 * 		5) 문자 입력
		 * 			- 메소드가 없다.
		 * 			- 문자열 입력 후 첫 번째 글자만 빼서 사용한다.
		 * 			- 첫 번째 글자를 빼는 메소드 : charAt(0)
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		
		// System.out.println(); // 출력 후 줄을 바꿔준다
		// System.out.print();   // 출력 후 줄이 바뀌지 않는다.
		
		// 1. 이름 입력 받기
		System.out.print("이름을 입력하세요 >>> ");
		String name = sc.nextLine(); // 이름에 공백이 포함될 수 있다.
		
		// 2. 나이 입력 받기
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt();
		
		// 3. 키 입력 받기
		System.out.print("키를 입력하세요 >>> ");
		double height = sc.nextDouble();
		
		// 4. 성별 입력 받기
		System.out.print("성별을 입력하세요(남/여) >>> ");
		char gender = sc.next().charAt(0);
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age + "살");
		System.out.println("키 : " + height + "cm");
		System.out.println("성별 : " + gender);
		
		sc.close(); // 생략이 가능하다.
	}

}
