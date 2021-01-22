package ex02_interface;

/*
 * 인터페이스
 * 1. interface
 * 2. 모든 메소드가 추상 메소드인 추상 클래스
 * 3. final 상수와 추상 메소드만 가질 수 있다.(구 버전 기준)
 * 4. jdk 1.8 이후로 default 메소드와 static 메소드를 갖리 수 있다.
 * 5. 특징
 * 	1) 상속(extends)받지 않고, 구현(implements)한다.
 * 	2) 2개 이상의 인터페이스를 구현할 수 있다.
 * 	3) abstract를 생략할 수 있다.
 */

// 인터페이스 = 작업지시서
interface Shape {
	// public abstract String getName();
	// public abstract double getArea();
	// public abstract 는 자동으로 삽입된다.
	
	String getName();
	double getArea();
	
	// 알고만 있자.
	public default void whoAmI() {
		System.out.println("나는 도형이다.");
	}
}

// 인터페이스를 보고 구현하자.
// 구현 클래스
class Rect implements Shape {
	private int width, height;
	
	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String getName() {
		return "사각형";
	}
	@Override
	public double getArea() {
		return width * height;
	}
}

public class Ex01_Shape {

	public static void main(String[] args) {

		Shape[] list = new Shape[2];
		
		list[0] = new Rect(3, 5);
		System.out.println(list[0].getName() + "의 넓이: " + list[0].getArea());
		
	}

}
