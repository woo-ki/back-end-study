package ex01_oop;

// 좌표
class Coord {
	// field
	int x;
	int y;
	
	// constructor
	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Coord(Coord copy) {
		this(copy.x, copy.y);
	}
	
	// method
	void info() {
		System.out.println("좌표 [" + x + ", " + y + "]");
	}
	
}

// 원
class Circle {
	// field
	double r;
	Coord center;
	
	// constructor
	Circle(int x, int y, double r) {
		center = new Coord(x, y);
		this.r = r;
	}
	Circle(double r) {
		this(1, 1, r);
	}
	
	// method
	void info() {
		System.out.println("좌표 [" + center.x + ", " + center.y + "], 반지름 " + r + ", 크기 " + (Math.PI * Math.pow(r, 2)));
	}
	
}

public class Ex02_Circle {

	public static void main(String[] args) {

		Coord coord1 = new Coord(3, 5);
		Coord coord2 = new Coord(coord1);
		
		coord1.info();		// 좌표 [3,5]
		coord2.info();		// 좌표 [3,5]
		
		Circle circle1 = new Circle(1.5);
		Circle circle2 = new Circle(33, 55, 1.5);
		
		circle1.info();		// 좌표 [1, 1], 반지름 1.5, 크기 7.xxx
		circle2.info();		// 좌표 [33, 55], 반지름 1.5, 크기 7.xxx
		
	}

}
