package ex03_array_quiz;

public class Quiz07 {

	public static void main(String[] args) {

		// 문제 윷 던지기
		// 실행 예)
		// "도", 1칸 이동한다.
		// "개", 2칸 이동한다.
		// "걸", 3칸 이동한다.
		// "윷", "도", 5칸 이동한다.
		// "모", "윷", "도", 10칸 이동한다.
		
		String[] yut = {"","도", "개", "걸", "윷", "모"};
		int totalMove = 0;
		
		while(true) {
			
			// 던지고, (1~5 중 하나를 랜덤 생성)
			int move = (int)(Math.random() * 5) + 1;
			System.out.print("\"" + yut[move] + "\""); // "도"~"모" 출력
			
			// 이동횟수 누적
			totalMove += move;
			
			// 도, 개, 걸이면 보여주고 끝
			if(move <= 3) {
				System.out.println(", " + totalMove + "칸 이동한다.");
				break;
			} 
			// 윷, 모이면 while 처음부터 다시 돌리기
			else {
				System.out.print(", ");
			}
		}
		
	}

}
