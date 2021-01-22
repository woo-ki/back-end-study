package quiz;

class Elec {
	// field
	private String model;
	private int price;
	
	public Elec(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

class TV extends Elec {
	public TV(String model, int price) {
		super(model, price);
	}
}

class Radio extends Elec {
	public Radio(String model, int price) {
		super(model, price);
	}
}

class Customer {
	private Elec[] cart;
	private int money;
	private final double BOUNUSPOINT = 0.05;
	private int idx;
	
	public Customer(int money) {
		this.money = money;
		idx = 0;
		cart = new Elec[10];
	}
	
	public void buy(Elec cart) {
		this.cart[idx] = cart;
		if(this.cart[idx].getPrice() > money) {
			System.out.println(this.cart[idx].getModel() + "구매할 수 없습니다.");
		} else {
			money -= this.cart[idx++].getPrice();
		}
	}
	public void buyList() {
		int total = 0;
		for(Elec e : cart) {
			if(e != null) {
				System.out.println(e.getModel() + "\t\t\t" + e.getPrice() + "만원");
				total += e.getPrice();
			}
		}
		System.out.println("-------------------------------");
		System.out.println("총구매금액\t\t" + total + "만원");
		System.out.println("보너스포인트\t\t" + (total * BOUNUSPOINT) + "만원");
		System.out.println("남은돈\t\t\t" + money + "만원");
	}
}

public class Quiz01 {

	public static void main(String[] args) {

		Customer customer = new Customer(1000);
		customer.buy(new TV("LGTV", 200));
		customer.buy(new Radio("삼성Radio", 10));
		customer.buyList();
		
	}

}
