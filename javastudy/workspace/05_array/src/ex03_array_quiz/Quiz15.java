package ex03_array_quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz15 {

	public static void main(String[] args) {

		// 로또
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("얼마? >>> ");
//		int money = sc.nextInt();
//		
//		int[][] lotto = new int[money / 1000][6];
//		
//		for(int i = 0; i < lotto.length; i++) {
//			// 45개 숫자에서 랜덤하게 빼서 lotto[i][j]에 저장
//			int ballCount = 45;
//			int[] ball = new int[ballCount];
//			
//			// 1~45 순차적으로 생성
//			for(int j = 0; j < ball.length; j++) {
//				ball[j] = j + 1;
//			}
//			
//			// ball 배열에서 6개를 lotto[i][j]로 보내기
//			for(int j = 0; j < lotto[i].length; j++) {
//				int rnd = (int)(Math.random() * ballCount); // ball 배열의 인덱스 (0~ballCount - 1)
//				lotto[i][j] = ball[rnd];
//				int lastIdx = 44 - j;
//				ball[rnd] = ball[lastIdx];
//				ballCount--;
//			}
//		}
//		
//		// 출력
//		for (int[] line : lotto) {
//			// line 오름차순 정렬
//			Arrays.sort(line);
//			for(int n : line) {
//				System.out.print(n + "\t");
//			}
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("얼마? >>> ");
		int money = sc.nextInt();
		
		int[][] lotto = new int[money / 1000][6];
		
		for(int i = 0; i < lotto.length; i++) {
			int ballCnt = 45;
			int[] ball = new int[ballCnt];
			
			for(int j = 0; j < ball.length; j++) {
				ball[j] = j + 1;
			}
			
			for(int j = 0; j <lotto[i].length; j++) {
				int r = (int)(Math.random() * ballCnt);
				lotto[i][j] = ball[r];
				int lastIdx = 44 - j;
				ball[r] = ball[lastIdx];
				ballCnt--;
			}
		}
		
		for(int[] line : lotto) {
			Arrays.sort(line);
			for(int n : line) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}
		
	}

}
