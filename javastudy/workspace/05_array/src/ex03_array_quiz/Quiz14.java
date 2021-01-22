package ex03_array_quiz;

public class Quiz14 {

	public static void main(String[] args) {

		// 문제. 빙고
		// 5 x 5
		// 1. 1~25 사이의 정수를 2차원 배열 bingo에 순차적으로 넣는다.
		// 2. 섞는다.
		//		1) 총 25번의 교환이 발생된다.
		//		2) bingo[0][0] <-> 랜덤
		//		   bingo[0][1] <-> 랜덤
		//		   ...
		//		   bingo[4][4] <-> 랜덤
		
		// 1~25 사이의 정수를 가진 bingo 배열
		final int SIZE = 5; // 상수(변치 않는 수) SIZE
		int[][] bingo = new int[SIZE][SIZE];
		
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = (i * SIZE) + (j + 1);
			}
		}
		

		
		// 섞는다
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				int ri = (int)(Math.random() * SIZE);
				int rj = (int)(Math.random() * SIZE);
				int temp;
				
				temp = bingo[i][j];
				bingo[i][j] = bingo[ri][rj];
				bingo[ri][rj] = temp;
			}
		}
		
		// 출력
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
