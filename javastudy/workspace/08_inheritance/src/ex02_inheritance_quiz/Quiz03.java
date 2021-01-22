package ex02_inheritance_quiz;

class Elec {
	int watt;
	
	Elec(int watt) {
		this.watt = watt;
	}
	
	void info() {
		System.out.println("소비전력: " + watt + "w");
	}
}

class Computer extends Elec {
	String name;
	int price;
	
	Computer(String name, int price, int watt) {
		super(watt);
		this.name = name;
		this.price = price;
	}
	
	@Override
	void info() {
		System.out.print("모델: " + name + ", 가격: " + price + "만원, ");
		super.info();
	}
}

class Notebook extends Computer {
	int battery;
	
	Notebook(String name, int price, int battery, int watt) {
		super(name, price, watt);
		this.battery = battery;
	}
	
	@Override
	void info() {
		System.out.print("배터리용량: " + battery + "w, ");
		super.info();
	}
}

public class Quiz03 {

	public static void main(String[] args) {

		Computer com = new Computer("알라딘", 200, 500);
		com.info();		// 모델: 알라딘, 가격: 200만원, 소비전력: 500w
		
		Notebook note = new Notebook("gram", 150, 80, 400);
		note.info();	//모델: gram, 가격: 150만원, 배터리용량: 80w, 소비전력: 400w
		
	}

}
