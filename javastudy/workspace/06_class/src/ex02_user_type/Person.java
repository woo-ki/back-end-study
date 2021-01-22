package ex02_user_type;

public class Person {

	// field
	String name;
	int age;
	char gender;
	double height;
	boolean isAdult;
	Computer computer;
	Book book;
	
	// method
	// 1. 필드 정보 출력하는 메소드
	// 1) 결과타입 : void
	// 2) 메소드명 : info
	// 3) 매개변수 : 없음
	void info() {
		System.out.println("내 이름은 : " + name);
		System.out.println("내 나이는 : " + age + "살 (" + (isAdult ? "성인" : "미성년자") + ")");
		System.out.println("내 성별은 : " + gender);
		System.out.println("내 키는 : " + height + "cm");
		computer.info();
		book.print();
	}
	
	// 2. 필드 정보 저장하는 메소드
	// 1) 결과타입 : void
	// 2) 메소드명 : save
	// 3) 매개변수 : isAdult 제외하고 모두 매개변수로 선언
	//	  String n, int a, char g, double h, Computer c, Book b
	void save(String n, int a, char g, double h, Computer c, Book b) {
		name = n;
		age = a;
		isAdult = age >= 20;
		gender = g;
		height = h;
		computer = c;
		book = b;
	}
	
}
