package ex04_constructor;

class Circle {
	// field
	double r;
	int xPoint;
	int yPoint;
	
	// 생성자
	Circle(int xPoint, int yPoint, double r) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.r = r;
	}
	Circle(double r) {
		this(0, 0, r);
	}
	
	// method
	double getArea() {
		return Math.pow(r, 2) * Math.PI;
	}
	void info() {
		System.out.println("중심좌표: [" + xPoint + ", " + yPoint + "], 반지름: " + r);
	}
}

public class Ex04_Circle {

	public static void main(String[] args) {

		Circle circle1 = new Circle(1.5);
		Circle circle2 = new Circle(1, 2, 1.5);
		
		System.out.println("circle1의 크기: " + circle1.getArea());
		System.out.println("circle2의 크기: " + circle2.getArea());
		
		circle1.info();	// 중심좌표: [0, 0], 반지름: 1.5
		circle2.info(); // 중심좌표: [1, 2], 반지름: 1.5
		
	}

}
