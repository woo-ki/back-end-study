package ex01_oop;

class Driver {
	// field
	String name;
	// constructor
	Driver(String name) {
		this.name = name;
	}
}

class Bus {
	// field
	Driver driver;
	int speed;
	final int FULL_SPEED = 80;
	// constructor
	Bus(Driver driver) {
		this.driver = driver;
		this.speed = 0;
	}
	// method
	void speedUp(int speed) {
		if(speed <= 0) {
			return;
		}
		this.speed += speed;
		int nSpeed = this.speed >= FULL_SPEED ? FULL_SPEED : this.speed;
		System.out.println("현재 속도 " + nSpeed + "km/h");
	}
	void speedDown(int speed) {
		if(speed <= 0) {
			return;
		}
		this.speed -= speed;
		int nSpeed = this.speed <= 0 ? 0 : this.speed;
		System.out.println("현재 속도 " + nSpeed + "km/h");
	}
	
}

public class Ex07_Bus {

	public static void main(String[] args) {

		Driver driver = new Driver("김기사");
		Bus bus = new Bus(driver);	// speed는 0
		
		bus.speedUp(50);	// 현재 속도 50km/h
		bus.speedUp(50);	// 현재 속도 80km/h
		
		bus.speedDown(50);	// 현재 속도 30km/h
		bus.speedDown(50);	// 현재 속도 0km/h
		
	}

}
