package ex01_inheritance;

/*
 * 메소드 오버라이드(method override)
 * 
 * 1. 슈퍼클래스의 메소드를 서브클래스는 사용할 수 있다.(재활용)
 * 2. 슈퍼클래스의 메소드를 서브클래스가 다시 만들어서 사용할 수 있다. (오버라이드)
 * 3. 슈퍼클래스의 메소드와 원형 (결과타입 + 메소드명 + 매개변수)이 모두 같아야 한다.
 * 4. 에너테이션(Annotation) @Override 를 추가하는 것이 좋다.
 */

// 슈퍼클래스
class Espresso {
	// field
	String beanOrigin;	// 커피 원산지
	int water;	// 물의 양
	// constructor
	Espresso(String beanOrigin, int water) {
		this.beanOrigin = beanOrigin;
		this.water = water;
	}
	//method
	void taste() {
		System.out.println("쓰다.");
	}
}

// 서브클래스
class Latte extends Espresso {
	// field
	int milk;
	// constructor
	Latte(String beanOrigin, int water, int milk) {
		super(beanOrigin, water);
		this.milk = milk;
	}
	// method
	// Espresso 클래스에 taste 메소드가 있지만.
	// Latte 가 사용하기엔 부적절하다.
	// 이런 경우에는 taste 메소드를 다시 만들어서 사용한다.
	// 1. 동일한 원형으로 만들어야 한다.
	// 2. 애너테이션 @Override를 추가해 준다.
	
	// @Override의 역할
	// 1. 자바에게 이 메소드가 오버라이드 한 메소드임을 알린다.
	//		오버라이드 규칙에 위배되면 에러가 발생한다.
	// 2. 다른 개발자들에게 오버라이드 한 메소드임을 알린다.
	
	@Override
	void taste() {
		System.out.println("Latte는 부드럽다.");
	}
}

public class Ex06_method_override {

	public static void main(String[] args) {

		// 서브클래스
		Latte cafeLatte = new Latte("콜롬비아", 10, 150);
		cafeLatte.taste();	// Latte 클래스의 taste 메소드가 호출된다.
		
	}

}
