package ex01_inheritance;

class Pizza {
	// field
	int cheese;
	String dough;
	// constructor
	Pizza(int cheese, String dough){
		this.cheese = cheese;
		this.dough = dough;
	}
	// method
	void info() {
		System.out.println(dough + "(" + cheese + ")");
	}
}

// 서브클래스
class BulgogiPizza extends Pizza {
	// field
	String bulgogiOrigin;
	// constructor
	BulgogiPizza(int cheese, String dough, String bulgogiOrigin) {
		super(cheese, dough);
		this.bulgogiOrigin = bulgogiOrigin;
	}
	// method
	// Pizza 클래스에 info 메소드가 있지만,
	// BulgogiPizza 클래스는 info 메소드를 다시 만들어야 한다. (오버라이드)
	
	@Override
	void info() {
		// 치즈, 도우, 불고기원산지 출력하기
		// 이 중에서 치즈, 도우 출력은 이미 Pizza 크래스의 info 메소드가 처리하고 있다.
		super.info();
		System.out.println(bulgogiOrigin);
	}
}

public class Ex07_method_override {

	public static void main(String[] args) {

		BulgogiPizza p = new BulgogiPizza(100, "씬", "한국");
		p.info();
		
	}

}
