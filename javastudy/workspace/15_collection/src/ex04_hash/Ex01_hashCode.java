package ex04_hash;

class User {}

public class Ex01_hashCode {

	public static void main(String[] args) {

		Integer a = new Integer(10);
		System.out.println(a.hashCode());
		
		String b = new String("apple");
		System.out.println(b.hashCode());
		
		Double c = new Double(1.5);
		System.out.println(c.hashCode());
		
		// 사용자 정의 클래스의 hashCode() 값은
		// 객체가 저장된 주소값이다.
		User user = new User();
		System.out.println(user.hashCode());
		
	}

}
