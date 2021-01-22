package homework;

import java.util.Scanner;

public class Hw05 {

	public static void main(String[] args) {

		/*
		난수를 발생시키는 RandomGenerator 클래스를 생성하시오.
		사용자로부터 배열의 길이를 입력 받아서(0 < 길이 < 100)
		해당 길이를 가진 int타입 배열을 생성하시오.
		이곳에 1에서 100까지 범위의 정수를 랜덤하게 삽입하시오.
		같은 값은 생성하지 못하도록 설정하고 생성된 배열을 출력하시오.
		중복 방지 대책은 생성된 랜덤 값이 기존에 생성된 적이 있는지 검사해서
		생성된 적이 있다면 다시 생성하는 방식으로 진행하시오.
		예시)
		배열의 길이를 입력하세요 >> 20
		61	5	30	85	41	74	90	54	13	12	
		25	2	96	58	89	17	60	72	65	86	
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 >> ");
		int[] array = new int[sc.nextInt()];
		
		for(int i = 0; i < array.length; i++) {
			int r;
			r = (int)(Math.random() * 100) + 1;
			for(int j = 0; j < array.length; j++) {
				if(array[j] == r) {
					r = (int)(Math.random() * 100) + 1;
					j--;
				}
			}
			array[i] = r;
			System.out.print(array[i] + "\t");
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		} // end for
		sc.close();
		
	}

}
