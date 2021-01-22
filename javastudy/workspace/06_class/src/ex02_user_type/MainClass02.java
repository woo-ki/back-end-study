package ex02_user_type;

public class MainClass02 {

	public static void main(String[] args) {

		
		Computer myCom = new Computer();	// Computer 생성
		myCom.save("GRAM", "LG", 180);		// save 메소드 호출
		myCom.info();						// info 메소드 호출
		
		Book myBook = new Book();
		myBook.setInfo("어린왕자", "생떽쥐베리", 15000, 10000);
		myBook.print();
		
		Person me = new Person();
		me.save("김영욱", 28, '남', 194.0, myCom, myBook);
		me.info();
		
	}

}
