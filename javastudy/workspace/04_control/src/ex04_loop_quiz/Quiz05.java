package ex04_loop_quiz;

public class Quiz05 {

	public static void main(String[] args) {

		// 1. 세로로 출력하는 전체 구구단
		// 2x1=2
		// 2x2=4
		// ...
		// 9x9=81
		
		for(int num = 2; num < 10; num++) {
			for(int a = 1; a < 10; a++) {
				System.out.println(num + "x" + a + "=" + (num * a));
			}
		}
		
		// 2. 가로로 출력하는 전체 구구단
		// 2x1=2	3x1=3	...		9x1=9
		// 2x2=4	3x2=6	...		9x2=18 
		// ...
		// 2x9=18	3x9=27	...		9x9-81
		for(int a = 1; a < 10; a++) {
			for(int num = 2; num < 10; num++) {
				System.out.print(num + "x" + a + "=" + (num * a) + "\t");
			}
			System.out.println();
		}
		
	}

}
