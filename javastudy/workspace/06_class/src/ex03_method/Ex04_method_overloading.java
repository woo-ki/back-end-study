package ex03_method;

class Nemo {
	int width;
	int height;
	
	void setInfo(int w, int h) {
		width = w;
		height = h;
	}
	
	void setInfo(int n) {
		setInfo(n, n);
	}
	
	int getArea() {
		return width * height;
	}
	
	void info() {
		System.out.println("너비: " + width + ", 높이: " + height);
	}
	
}

public class Ex04_method_overloading {

	public static void main(String[] args) {

		// 사각형 만들기
		
		// 1. 직사각형
		Nemo nemo1 = new Nemo();
		nemo1.setInfo(3, 5);
		System.out.println("넓이: " + nemo1.getArea());	// 넓이: 15
		nemo1.info();	// 너비: 3, 높이: 5
		
		// 2. 정사각형
		Nemo nemo2 = new Nemo();
		nemo2.setInfo(3);
		System.out.println("넓이: " + nemo2.getArea());	// 넓이: 9
		nemo2.info();	// 너비: 3, 높이: 3
		
	}

}
