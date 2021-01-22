package ex02_generic_quiz;

class Soldier {}
class Marine extends Soldier{}
class FireBet extends Soldier{}
class Tank {}

class Bunker<T> {
	private T[] units;
	private int count;	// 최대 배열(bunker)의 길이
	private int idx;	// 배열의 인덱스 (bunker에 입장한 실제 Marine 수)

	public Bunker(int count) {
		// units = new T[count];
		// 배열의 크기 결정은 컴파일 타임에 진행되어야 하는데,
		// generic 타입의 결정은 실행 타임에 결정되므로,
		// 컴파일 타임에 neneric 타입의 메모리 크기를 알 수 없다,
		// 해결책 : Object를 사용한다.
		units = (T[])new Object[count];	// Object 배열 생성 후 나중에 캐스팅해서 사용
		this.count = count;
		this.idx = 0;
	}
	
	public void add(T item) {
		if(idx == count) {
			return;
		}
		units[idx++] = item;
	}

	@Override
	public String toString() {
		return "현재 " + idx + "명의 Marine 입장.";
	}
}

public class Quiz01 {

	public static void main(String[] args) {

		// 스타크래프트
		Bunker<Soldier> bunker = new Bunker<>(10); // 최대 10명의 마린 입장 가능
		
		bunker.add(new Marine());
		bunker.add(new Marine());
		bunker.add(new Marine());
		bunker.add(new FireBet());
		// bunker.add(new Tank());	// 막아야 할 작업
		
		System.out.println(bunker); // 현재 3명의 Marine 입장.
		
	}

}
