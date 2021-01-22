package ex01_oop;

class Engine {
	// field
	String type;	// 가솔린, 디젤
	int cc;			// 배기량
	int hp;			// 마력
	// constructor
	Engine(String type, int cc, int hp) {
		this.type = type;
		this.cc = cc;
		this.hp = hp;
	}
	// method
	void info() {
		System.out.println("연료: " + type);
		System.out.println("배기량: " + cc);
		System.out.println("마력: " + hp);
	}
	
}

class Car {
	// field
	String model;
	double fuelEfficiency;	// 연비
	Engine engine;
	// constructor
	Car(String model, double fuelEfficiency, Engine engine) {
		this.model = model;
		this.fuelEfficiency = fuelEfficiency;
		this.engine = engine;
	}
	Car(String model, double fuelEfficiency, String type, int cc, int hp) {
		this.model = model;
		this.fuelEfficiency = fuelEfficiency;
		this.engine = new Engine(type, cc, hp);
	}
	// method
	void info() {
		System.out.println("차종: " + model);
		System.out.println("연비: " + fuelEfficiency + "km");
		System.out.println("엔진정보");
		engine.info();
	}
}
public class Ex05_Car {

	public static void main(String[] args) {

		// 2개의 자동차를 생성하시오.
		Engine engine = new Engine("가솔린", 1998, 150);
		Car car1 = new Car("Soul", 19.7, engine);
		Car car2 = new Car("Ray", 20.4, "디젤", 1500, 100);
		
		car1.info();
		System.out.println();
		car2.info();
		
	}

}
