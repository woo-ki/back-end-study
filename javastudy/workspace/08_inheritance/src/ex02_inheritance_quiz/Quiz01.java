package ex02_inheritance_quiz;

// 슈퍼클래스
class Owner {
	String oName;
	
	Owner() {
		this.oName = "없음";
	}
	
	Owner(String oName) {
		this.oName = oName;
	}
	
	void info() {
		System.out.print("주인: " + oName);
	}
}

// 서브클래스
class Cat extends Owner {
	String cName;
	
	Cat(String cName) {
		super();
		this.cName = cName;
	}
	
	Cat(String cName, String oName) {
		super(oName);
		this.cName = cName;
	}
	
	@Override
	void info() {
		System.out.print("이름: " + cName + " (");
		super.info();
		System.out.println(")");
	}
}

public class Quiz01 {

	public static void main(String[] args) {

		// 서브클래스
		Cat cat1 = new Cat("야옹이", "제임스");
		cat1.info();	// 이름: 야옹이 (주인: 제임스)
		
		Cat cat2 = new Cat("냥냥이");
		cat2.info();	// 이름: 냥냥이 (주인: 없음)
		
	}

}
