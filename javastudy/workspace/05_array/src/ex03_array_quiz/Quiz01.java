package ex03_array_quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {

		// 문제. 길이가 5인 double 타입의 배열을 선언하고,
		// 5개의 키(실수)를 입력 받아서 배열에 저장하고 출력하시오.
		Scanner input = new Scanner(System.in);
		double[] height = new double[5];
		
		for(int i = 0; i < height.length; i++) {
			System.out.print((i + 1) + "번째 키를 입력하세요 >>> ");
			height[i] = input.nextDouble();
		}
		
		for(int i = 0; i < height.length; i++) {
			System.out.print(height[i] + "\t");
		}
		
	}

}
