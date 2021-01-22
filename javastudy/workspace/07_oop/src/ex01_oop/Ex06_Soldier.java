package ex01_oop;

class Gun {
	// field
	String model;
	int bullet;		// 0 ~ FULL_BULLET
	final int FULL_BULLET = 6;
	// constructor
	Gun(String model, int bullet) {
		this.model = model;
		if(bullet <= FULL_BULLET && bullet >= 0) {
			this.bullet = bullet;
		} else {
			System.out.println("최대 " + FULL_BULLET + "발 입니다.");
			this.bullet = FULL_BULLET;
		}
	}
	// method
	void reload(int bullet) {	// 장전
		int tump = this.bullet;
		this.bullet += bullet;
		if(bullet >= FULL_BULLET) {
			this.bullet = FULL_BULLET;
			System.out.println((this.bullet - tump) + "발이 장전되었다. 현재 " + this.bullet + "발.");
		} else {
			System.out.println((this.bullet - tump) + "발이 장전되었다. 현재 " + this.bullet + "발.");
		}
	}
	void shoot() {
		if(bullet > 0) {
			bullet--;
			System.out.println("빵야!" + bullet + "발 남았다.");
		} else {
			System.out.println("헛빵!");
		}
	}
	void info() {
		System.out.println(model + "(" + bullet + ")");
	}
}

class Soldier {
	// field
	String name;
	Gun pistol;
	// constructor
	Soldier(String name, Gun gun) {
		this.name = name;
		this.pistol = gun;
	}
	// method
	void reload(int bullet) {
		pistol.reload(bullet);
	}
	void shoot() {
		pistol.shoot();
	}
	void info() {
		System.out.print(name + ": ");
		pistol.info();
	}
}

public class Ex06_Soldier {

	public static void main(String[] args) {

		Gun gun = new Gun("K-2", 2);
		Soldier soldier = new Soldier("람보", gun);
		
		soldier.shoot();	// 빵야! 1발 남았다.
		soldier.shoot();	// 빵야! 0발 남았다.
		soldier.shoot();	// 헛빵!
		
		soldier.reload(3);	// 3발이 장전되었다. 현재 3발.
		soldier.reload(6);	// 3발이 장전되었다. 현재 6발.
		soldier.reload(6);	// 0발이 장전되었다. 현재 6발.
		
		soldier.info();
		
	}

}
