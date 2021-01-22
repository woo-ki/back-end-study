package ex01_list;

import java.util.ArrayList;

public class Ex02_ArrayList {

	public static void main(String[] args) {

		// 1~10000 모든 정수를 저장한 ArrayList 2개 생성
		ArrayList<Integer> iList1 = new ArrayList<Integer>();
		ArrayList<Integer> iList2 = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			iList1.add(i + 1);
			iList2.add(i + 1);
		}
		// 2. 마지막 요소부터 하나씩 전체 삭제(나노초 단위로 수행 시간)
		long time1 = System.nanoTime();
		for(int i = iList1.size() - 1; i >= 0; i--) {
			iList1.remove(i);
		}
		long time2 = System.nanoTime();
		long time3 = time2 - time1;
		System.out.println(time3);
		// 3. 첫 번째 요소만 계속 지우는 방법으로 전체 삭제(나노초 단위로 수행 시간)
		long time4 = System.nanoTime();
		for(int i = 0, size = iList2.size(); i < size; i++) {
			iList2.remove(0);
		}
		long time5 = System.nanoTime();
		long time6 = time5 - time4;
		System.out.println(time6);
		
		
	}

}
