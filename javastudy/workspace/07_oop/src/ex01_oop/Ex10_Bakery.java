package ex01_oop;

class Bakery {
	// field
	int bake;
	int price;
	int balance;
	// constructor
	Bakery(int bake, int price, int balance) {
		this.bake = bake;
		this.price = price;
		this.balance = balance;
	}
	// method
	// 1. sell(판매)
	// 빵, 돈
	int[] sell(int money) {
		// 빵을 팔 수 있는가?
		// 돈 받기
		this.balance += money;
		// 제공하는 빵과 잔돈
		int sBake = money / price;
		int change = money % price;
		int[] array = {sBake, change};
		
		// 빵 제공
		this.bake -= sBake;
		// 잔돈제공
		this.balance -= change;
		
		return array;
	}
	// 2. info
	void info() {
		System.out.println("빵 재고: " + bake + "개, 자본금: " + balance +"원");
	}
}

class Customer {
	// field
	// 빵, 돈
	int bake;
	int balance;
	// constructor
	Customer(int balance) {
		this.bake = 0;
		this.balance = balance;
	}
	// method
	// buy
	void buy(Bakery bakery, int money) {
		// 가진돈보다 적게 사려고 하는가?
		if(money > this.balance) {
			System.out.println("가진돈이 부족합니다.");
			return;
		}
		// 잔돈과 빵 갯수 받아오기
		int[] array = new int[2];
		array = bakery.sell(money);
		// 빵 받기
		this.bake += array[0];
		// 잔돈 받기
		this.balance += array[1];
		// 돈 지불
		this.balance -= money;
		System.out.println("가진 빵: " + bake + "개, 남은 돈: " + balance + "원");
	}
}

public class Ex10_Bakery {

	public static void main(String[] args) {

		Bakery paris = new Bakery(100, 500, 10_000);	// 빵 100개, 빵 하나 500원, 자본금 10_000원
		Bakery tour = new Bakery(50, 1000, 10_000);		//빵 50개, 빵 하나 1_000원, 자본금 10_000원
		
		Customer customer = new Customer(20_000);		// 가진돈 20_000원
		
		// 첫 번째 빵집 방문
		customer.buy(paris, 10_000);	// 가진빵 20개, 남은 돈 10_000원
		
		// 두 번째 빵집 방문
		customer.buy(tour, 10_000);		// 가진빵 30개, 남은 돈 0원
		
		// 첫 번쨰 빵집 상황
		paris.info();	// 빵 80개, 자본금 20_000원
		tour.info();	// 빵 40개, 자본금 20_000원
		
	}

}
