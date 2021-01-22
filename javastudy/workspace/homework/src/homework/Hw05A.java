package homework;

import java.util.Scanner;

class RandomGenerator {
	
	// 발생한 난수(r)가 기존 배열에 존재하는지 확인하는 메소드 
	boolean exists(int a[], int presentIndex, int r) {
		for (int i = 0; i < presentIndex; i++) {
			if (a[i] == r) {
				return true;  // 존재하면 true 리턴
			}
		}
		return false;  // 존재하지 않으면 false 리턴
	}
	
	// 실행 메소드
	void run() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 >> ");
		int n = sc.nextInt();

		if (n <= 0 || n > 100) {
			System.out.print("1~100사이로 입력하세요.");
			sc.close();
			return; // run 메소드의 종료 = 프로그램 종료
		}
		
		int array[] = new int[n]; // n개의 정수 배열 생성

		for (int i = 0; i < array.length; i++) {
			int r = (int) (Math.random() * 100 + 1); // 1~100 범위의 난수
			// 정수 r이 배열 array[0] ~ array[i-1] 에 있는지 검사
			if (exists(array, i, r)) {  // 중복이 있다면
				i--;					// 다시 랜덤을 발생시켜 입력해야 하므로 증가된 인덱스를 취소시킴
				continue;
			}
			array[i] = r;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
			if (i % 10 == 9) { // 한 줄에 10개씩 출력하기 위해서 인덱스가 9로 끝나는지 검사
				System.out.println();  // 다음 줄로 넘어가기
			}
		}

		sc.close();
		
	}
	
}

public class Hw05A {

	public static void main(String[] args) {
		RandomGenerator generator = new RandomGenerator();
		generator.run();
		
	}

		
}
