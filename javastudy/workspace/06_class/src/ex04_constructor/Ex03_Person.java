package ex04_constructor;

class Person {
	// field
	String name;
	String sn;			// 주민등록번호 (하이픈 포함)
	int age;			// sn으로 자동 계산 (1, 2, 5, 6 : 1900년대 / 3, 4, 7, 8 : 2000년대)
	char gender;		// sn으로 자동 계산 (1, 3, 5, 7 : 남자 / 2, 4, 6, 8 : 여자_
	boolean isKorean;	// sn으로 자동 계산 (1, 2, 3, 4 : 한국인 / 5, 6, 7, 8 : 외국인)
	
	// 생성자
	Person(String name, String sn) {
		this.name = name;
		this.sn = sn;
		char key = sn.charAt(7);
		
		if(key == '1' || key == '2' || key == '5' || key == '6') {
			age = 121 - Integer.parseInt(sn.substring(0,2));
		} else {
			age = 21 - Integer.parseInt(sn.substring(0,2));
		}
		
		gender = key % 2 == 1 ? '남' : '여';
		
		isKorean = key >= '1' && key <= '4';
	}
	
	// method
	void print() {
		System.out.println("이름: " + name);
		System.out.println("주민등록번호: " + sn.substring(0, 8) + "******");
		System.out.println("나이: " + age + "살");
		System.out.println("성별: " + gender);
		System.out.println(isKorean ? "한국인" : "외국인");
	}
	
}

public class Ex03_Person {

	public static void main(String[] args) {

		Person man = new Person("철수", "951212-1234567");
		Person woman = new Person("영희", "051212-4567891");
		
		man.print();
		woman.print();
		
		// 이름: 철수
		// 주민등록번호: 951212-1******
		// 나이: 26살
		// 성별: 남
		// 한국인
		
	}

}
