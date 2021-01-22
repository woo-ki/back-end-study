package ex01_inheritance;

// 슈퍼클래스 (부모클래스)
class Parent {
	// field
	int parentNum;
	// constructor
	// 개발자가 만들지 않으면 "디폴트 생성자"가 호출된다.
	// Parent() {}
	
	// method
	void parentMethod() {
		parentNum = 1;
		System.out.println("parentNum : " + parentNum);
	}
}

class Child extends Parent {
	// field
	int childNum;
	
	// constructor
	
	// method
	void childMethod() {
		childNum = 2;
		System.out.println("childNum : " + childNum);
	}
}

public class Ex01_extends {

	public static void main(String[] args) {

		// 슈퍼클래스(Parent) 타입의 객체(p) 생성
		Parent p = new Parent();
		p.parentMethod();
		
		// 서브클래스(Child) 타입의 객체(c) 생성
		Child c = new Child();
		
		// 서브클래스는 슈퍼클래스의 멤버를 호출할 수 있다.
		c.parentMethod();
		c.childMethod();
		
	}

}
