package ex03_loop;

public class Ex07_label {

	public static void main(String[] args) {
		
		// label
		// 소스코드의 특정 위치를 지정해 주는 방법
		// 라벨명:
		
		// outer loop 에 outer 라벨을 달아 놓고 사용한다.
		
		outer: // outer 라벨
		for(int dan = 2; dan <= 9; dan++) {
			for(int num = 1; num <= 9; num++) {
				System.out.println(dan + "x" + num + "=" + (dan * num));
				if (dan == 4 && num == 4) {
					break outer; // outer 라벨을 종료한다.
				}
			}
		}
		
	}
	
}
