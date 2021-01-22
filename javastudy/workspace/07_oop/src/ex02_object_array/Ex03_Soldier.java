package ex02_object_array;

class Gun {
	// field
	String model;
	int bullet;
	
	// constructor
	Gun(String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	// method
	void shoot() {
		if(bullet > 0) {
			bullet--;
			System.out.println(model + "빵야! (" + bullet + "발 남음)");
		} else {
			System.out.println(model + "총알이 없습니다.");
		}
	}
	
	void info() {
		System.out.println(model + "(" + bullet + "발)"); 
	}
}

class Soldier {
	String name;
	Gun[] guns;
	int i;
	
	Soldier(String name, int gunN) {
		this.name = name;
		guns = new Gun[gunN];
	}
	
	void addGun(Gun gun) {
		guns[i++] = gun;
	}
	void shoot() {
		for(int i = 0; i < this.i; i++) {
			guns[i].shoot();
		}
	}
	void shoot(int gunN) {
		guns[gunN - 1].shoot();
	}
	void shoot(String model) {
		for(Gun gun : guns) {
			if(model.equals(gun.model)) {
				gun.shoot();
			}
		}
	}
	void info() {
		System.out.println("이름: " + name);
		for(Gun gun : guns) {
			gun.info();
		}
	}
}

public class Ex03_Soldier {

	public static void main(String[] args) {

		Soldier soldier = new Soldier("람보", 3); // Gun을 3개 가질 수 있는 람보
		
		soldier.addGun(new Gun("콜트", 10));
		soldier.addGun(new Gun("베레타", 10));
		soldier.addGun(new Gun("스미스웨슨", 10));
		
		// 총 쏘는 방법이 3가지
		soldier.shoot();	// 모든 총을 한 발씩 쏜다.
		soldier.shoot(1);	// 1번쨰 총만 한 발 쏜다.  // shoot(2),shoot(3)
		soldier.shoot("베레타");	// 베레타만 한 발 쏜다.
		
		soldier.info();
		// 이름: 람보
		// 콜트(8발)
		// 베레타(8발)
		// 스미스웨슨(9발)
		
	}

}
