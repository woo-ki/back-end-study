package ex01_array;

public class Ex03_araay_copy {

	public static void main(String[] args) {

		int[] a = {10, 20, 30, 40, 50};
		
		// 배열 a의 길이는 5이다. (a.length)
		// 나중에 배열 a의 길이를 늘리는 것은 불가능하다.
		
		// 새 배열을 만들어 기존 배열의 모든 요소를 복사한다.
		// 새 배열의 정보를 기존 배열에 전달한다. (기존 배열이 새 배열로 바뀌게 된다.)
		
		int[] t = new int[a.length * 2]; // 배열 a의 2배 길이를 가진 새로운 배열 t를 생성함.
		
		// 배열 a의 모든 요소를 배열 t로 복사한다. (1번째 코드)
		for(int i = 0; i < a.length; i++) {
			t[i] = a[i];
		}
		
		// 배열 a의 모든 요소를 배열 t로 복사한다. (2번째 코드)
		// System.arraycopy(a, 0, t, 0, a.length);
		
		// 새 배열 t를 기존 배열 a로 바꾸기
		// 배열 t의 주소 : t
		// 배열 a의 주소 : a
		a = t;
		
		// 배열 a의 길이가 2배가 되었는지 확인
		for(int i = 0; i < a.length; i++) {
			System.out.println("배열 요소 : " + a[i]);
		}
		
	}

}
