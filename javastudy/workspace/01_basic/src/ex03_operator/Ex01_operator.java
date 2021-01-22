package ex03_operator;

public class Ex01_operator {

	public static void main(String[] args) {

		/*
		 * 1. 산술 연산자
		 * 		1) +
		 * 		2) -
		 * 		3) *
		 * 		4) / : 정수(몫), 실수(나누기)
		 * 		5) % : 정수(나머지)
		 * 
		 * 2. 증감 연산자
		 * 		1) a++ : a를 사용하고 1 증가
		 * 		2) ++a : a를 1 증가시키고 사용
		 * 		3) a-- : a를 사용하고 1 감소
		 * 		4) --a : a를 1 감소시키고 사용
		 * 
		 * 3. 대입연산자
		 * 		1) = : 오른쪽 값을 왼쪽 변수에 대입
		 * 		2) += : 왼쪽 변수가 오른쪽의 값 만큼 증가한다.
		 * 		3) -= : 왼쪽 변수가 오른쪽의 값 만큼 감소한다.
		 * 		4) *= : 왼쪽 변수에 오른쪽의 값을 곱한 뒤 저장한다.
		 * 		5) /= : 왼쪽 변수를 오른쪽의 값으로 나눈 뒤 저장한다.
		 * 		6) %= : 왼쪽 변수를 오른쪽의 값으로 나눈 뒤 나머지를 저장한다.
		 * 
		 * 		주의
		 * 		=+, =-, =*, =/, =% 모두 불가능하다. =이 뒤에 나온다.
		 * */
		
		int a = 7;
		int b = 2;
		
		// 라인 복사 : 커서를 두고 Ctrl + Alt + 아래,위 방향키
		
		System.out.println(a + " + " + b + " = " + (a + b));
		System.out.println(a + " - " + b + " = " + (a - b));
		System.out.println(a + " * " + b + " = " + (a * b));
		System.out.println(a + " / " + b + " = " + (a / b));
		System.out.println(a + " % " + b + " = " + (a % b));
		
		int c = 10;
		int d = c++; // c를 d에 저장하고 c를 1증가시킨다.
		System.out.println(c);
		System.out.println(d);
		
		int e = 10;
		int f = ++e; // e를 1증가시키고 e를 f에 저장한다.
		System.out.println(e);
		System.out.println(f);
		
		int piggy_bank = 0;
		piggy_bank += 1000;
		piggy_bank -= 500;
		System.out.println(piggy_bank);
		
		// 문제1. 45를 일의자리와 십의자리로 분리해서 출력 하시오.
		int n = 45;
		int units; // 일의자리
		int tens;  // 십의자리
		units = n % 10;
		tens = n / 10;
		System.out.println(units);
		System.out.println(tens);
		
		// 문제2. 1분 = 60초, 1시간 = 60분 = 3600초
		// 3690초를 1시간 1분 30초로 변환해서 출력하시오
		int totalSecond = 3690;
		int hour = totalSecond / 3600;          // 시간
		int minute = (totalSecond % 3600) / 60; // 분
		int second = totalSecond % 60;          // 초
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
		
		// 문제3. 두 변수 x와 y에 저장된 값을 서로 교환하시오.
		int x = 10;
		int y = 20;
		int temp;
		
		System.out.println(x + ", " + y);

		temp = x;
		x = y;
		y = temp;
		
		// 라인 이동 : 커서를 두고 Alt + 방향키
		
		System.out.println(x + ", " + y);
		
	}

}
