package ex01_user_type;

// 클래스 Book
// 제목, 저자, 가격, 판매량, 베스트셀러 유무(판매량이 1000 이상은 베스트셀러)

class Book {
	
	// 필드는 자동으로 초기화된다.
	
	String title;				// null
	String author;				// null
	int price;					// 0
	int amount;					// 0
	boolean isBestSeller;		// false
}

public class Ex02_Book {

	public static void main(String[] args) {

		// 객체 생성
		Book b1 = new Book();
		b1.title = "선녀와 나무꾼";
		b1.author = "미상";
		b1.price = 8000;
		b1.amount = 1000;
		b1.isBestSeller = b1.amount >= 1000;
		
		System.out.println(b1.title);
		System.out.println(b1.author);
		System.out.println(b1.price);
		System.out.println(b1.amount);
		System.out.println(b1.isBestSeller ? "베스트셀러" : "일반서적");
		
	}

}
