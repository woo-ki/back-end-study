package ex01_user_type;

// 클래스 Person
// 이름, 나이, 성별, 키, 성인 유무(나이가 20이상이면 성인)

class Person {
	String name;			// null
	int age;				// 0
	char gender;			// 코드값 0인 문자 : 널문자('\0')
	double height;			// 0.0
	boolean isAdult;		// false
}

public class Ex03_Person {

	public static void main(String[] args) {

		Person me = new Person();
		me.name = "김영욱";
		me.age = 28;
		me.gender = '남';
		me.height = 194.0;
		me.isAdult = me.age >= 20;
		
		System.out.println(me.name);
		System.out.println(me.age);
		System.out.println(me.gender);
		System.out.println(me.height);
		System.out.println(me.isAdult ? "성인" : "미성년자");
		
	}

}
