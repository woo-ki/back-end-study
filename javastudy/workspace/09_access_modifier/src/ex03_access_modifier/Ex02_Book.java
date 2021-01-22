package ex03_access_modifier;

class Book {

	private String title;				// null
	private String author;				// null
	private int price;					// 0
	private int amount;					// 0
	private boolean isBestSeller;		// false
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
		setBestSeller(this.amount >= 1000);	// setAmount 호출하면 setBestSeller 함께 호출된다.
	}
	private void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	public boolean isBestSeller() {
		return isBestSeller;
	}
	
}

public class Ex02_Book {

	public static void main(String[] args) {
	
		Book b1 = new Book();
		b1.setTitle("선녀와 나무꾼");
		b1.setAuthor("미상");
		b1.setPrice(8000);
		b1.setAmount(1000);
		
		System.out.println(b1.getTitle());
		System.out.println(b1.getAuthor());
		System.out.println(b1.getPrice());
		System.out.println(b1.getAmount());
		System.out.println(b1.isBestSeller() ? "베스트셀러" : "일반서적");
		
	}
	
}
