package ex02_api;

import java.util.Arrays;

public class Ex01_System {

	public static void main(String[] args) {
		// 1. 시스템 현재 시간 밀리초 단위로 반환
		//    1970년 1월 1일 이후로 측정
		System.out.println("현재 시간: " + System.currentTimeMillis() + "밀리초(1/1000초)");
		
		// 2. 시스템 현재 시간 나노초 단위로 반환
		//	  자바가 결정한 어느 시점 이후로 측정
		//	  측정용으로 사용
		System.out.println("현재 시간: " + System.nanoTime() + "나노초(1/10억초)");
		
		// 3. 배열 복사
		int[] src = {1, 2, 3, 4, 5};
		int[] des = new int[10];
		System.out.println(Arrays.toString(des));
		
//		for(int i = 0; i < src.length; i++) {
//			des[i + 2] = src[i];
//		}
		System.arraycopy(src, 0, des, 2, src.length);
		System.out.println(Arrays.toString(des));
		
		// 4. 시스템 종료
		// System.exit(0);
		
		// 문제. i++를 20억번 실행하는데 걸리는 시간 초 단위로 출력
		long sec1 = System.nanoTime();
		for(int i = 0; i < 2000000000;) {
			i++;
		}
		long sec2 = System.nanoTime();
		double sec3 = (sec2 - sec1) / 1000000000.0;
		System.out.println(sec3);
		
	}

}
