package ex05_static;

class MyMath {
	final static double PI = 3.141592;
	
	static double pow(double n, double times) {
		double result = 1;
		for(int i = 0; i < times; i++) {
			result *= n;
		}
		return result;
	}
}

public class Ex02_MyMath {

	public static void main(String[] args) {

		System.out.println(MyMath.PI);
		MyMath myMath = new MyMath();
		System.out.println(myMath.pow(2, 5));
		
		// pow에 스태틱이 붙은 경우
		// new 없이(인스턴스 없이) 호출
		System.out.println(MyMath.pow(2, 6));
	}

}
