package ex02_downcasting;

class Car {
	// field
	private String model;
	// constructor
	public Car(String model) {
		super();
		this.model = model;
	}
	// method
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void drive() {
		System.out.println(model + "타고 드라이브");
	}
}

class EV extends Car {
	// field
	private int battery;
	// constructor
	public EV(String model, int battery) {
		super(model);
		this.battery = battery;
	}
	// method
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public void charge(int battery) {
		this.battery += battery;
		System.out.println(getModel() + "의 배터리: " + this.battery);	// 모델명 확인: getModel()
	}
}

class Hybrid extends EV {
	// field
	private int oil;
	private final int FULL_OIL = 60;	// 가득찬 연료통 60
	// constructor
	public Hybrid(String model, int battery, int oil) {
		super(model, battery);
		this.oil = oil;
	}
	// method
	public int getOil() {
		return oil;
	}
	public void setOil(int oil) {
		this.oil = oil;
	}
	public void addOil(int oil) {
		this.oil += oil;
		if(this.oil > FULL_OIL) {
			this.oil = FULL_OIL;
		}
		System.out.println(getModel() + "의 현재 주유량: " + this.oil);
	}
}

public class Ex02_Car {

	public static void main(String[] args) {

		// Car 클래스 타입의 배열 선언
		Car[] motors = new Car[2];
		
		motors[0] = new EV("코나", 80);
		motors[1] = new Hybrid("그랜져", 40, 60);
		
//		// motors[0] 의 모든 메소드 호출하기
//		motors[0].drive();
//		((EV)motors[0]).charge(20);
//		
//		// motors[1] 의 모든 메소드 호출하기
//		motors[1].drive();
//		((EV)motors[1]).charge(20);
//		((Hybrid)motors[1]).addOil(20);
		for(int i = 0; i < motors.length; i++) {
			motors[i].drive();
			if(motors[i] instanceof Hybrid) {
				((Hybrid)motors[i]).charge(20);
				((Hybrid)motors[i]).addOil(20);
			} else if(motors[i] instanceof EV) {
				((EV)motors[i]).charge(20);
			}
		}
//		for(Car motor : motors) {
//			motor.drive();
//			// 가장 아래 후손부터 확인한다.
//			if(motor instanceof Hybrid) {
//				((Hybrid)motor).charge(20);
//				((Hybrid)motor).addOil(20);
//			} else if(motor instanceof EV) {
//				((EV)motor).charge(20);
//			}
//		}
		
		
	}

}
