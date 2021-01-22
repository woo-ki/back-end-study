package homework;

import java.util.Scanner;

class RandomGenerator2 {
	private int r;
	private Scanner sc = new Scanner(System.in);
	private int[] n;
	
	public RandomGenerator2() {
		System.out.print("배열의 길이를 입력하시오(1~99) >> ");
		n = new int[sc.nextInt()];
	}
	
	public boolean isOverlab(int r) {
		for(int i = 0; i < n.length; i++) {
			if(r == n[i]) {
				return true;
			}
		}
		return false;
	}
	
	public void game() {
		for(int i = 0; i < n.length; i++) {
			int r = (int)(Math.random() * 100) + 1;
			if(isOverlab(r)) {
				i--;
			} else {
				n[i] = r;
				System.out.print(n[i] + "\t");
				if((i + 1) % 10 == 0) {
					System.out.println();
				}
			}
		}
		sc.close();
	}
}

public class Main2 {

	public static void main(String[] args) {

		RandomGenerator2 r = new RandomGenerator2();
		r.game();
		
	}

}
