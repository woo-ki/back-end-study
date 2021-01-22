package ex03_array_quiz;

import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {

		// 문제. 식당 대기표
		// 실행 예)
		// 5팀 예약
		// 1번 손님 좌석 예약 >>> 3
		// 2번 손님 좌석 예약 >>> 4
		// 3번 손님 좌석 예약 >>> 2
		// 4번 손님 좌석 예약 >>> 4
		// 5번 손님 좌석 예약 >>> 1
		// 예약 현황
		// 1번 : 0 0 0
		// 2번 : 0 0 0 0
		// 3번 : 0 0
		// 4번 : 0 0 0 0
		// 5번 : 0
		
		Scanner input = new Scanner(System.in);
		
		int[][] a = new int[5][];
		
		for(int i = 0; i < a.length; i++) {
			System.out.print((i + 1) + "번 손님 좌석 예약 >>> ");
			a[i] = new int[input.nextInt()];
		}
		
		System.out.println("예약 현황");
		for(int i = 0; i < a.length; i++) {
			System.out.print((i + 1) + "번 : ");
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		
		input.close();
		
	}

}
