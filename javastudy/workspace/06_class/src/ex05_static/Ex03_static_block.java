package ex05_static;

import java.util.Arrays;

class StaticClass {
	static int a;
	static int[] b;
	
	// static 블록 : static 필드의 초기화 작업 진행
	static {
		a = 10;
		b = new int[10];
		for(int i = 0; i < b.length; i++) {
			b[i] = (int)(Math.random() * 101);
		}
	}
}

public class Ex03_static_block {

	public static void main(String[] args) {

		System.out.println(StaticClass.a);
		System.out.println(Arrays.toString(StaticClass.b));
		
	}

}
