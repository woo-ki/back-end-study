package ex01_user_type;

/*
 * 객체지향언어
 * 1. 모든 사물을 객체로 만들어서 처리하는 언어이다.
 * 2. 객체를 만드는 설계도를 클래스라고 한다.
 * 		클래스			객체
 * 		붕어빵 기계		붕어빵
 * 3. 개발자가 만드는 '타입'을 클래스라고 볼 수 있다.
 */

/*
 * 클래스의 구성
 * 1. 필드(field)
 * 		객체가 가질 값
 * 2. 메소드(method)
 * 		객체가 가질 기능
 * 3. 예시
 * 		컴퓨터 클래스
 * 		- 필드 : 모델명, 제조사, 가격, 생산년도 등등
 * 		- 메소드 : 계산, 인터넷, 앱실행, 게임 등등
 */

/*
 * 객체
 * 1. 클래스가 있어야만 객체를 생성할 수 있다.
 * 2. 객체는 필드와 메소드를 가진다.
 * 3. 생성 방법
 * 		1) new를 이용한 동적 생성
 * 		2) 정적 생성
 * 4. 필드와 메소드 호출 방법
 * 		!) 객체.필드
 * 		2) 객체.메소드()
 */

// 하나의 자바 파일에 여러 클래스를 둘 수 있다. (비추천)
// 파일명과 같은 이름의 클래스만 public을 붙인다.

// 객체를 생성하기 위한 클래스
class Computer {
	
	// 클래스에서 선언한 변수 = 필드(field)
	String model;
	String manufacturer;
	int price;
	
}

// 메인 클래스 : main 메소드를 가지고 있는 클래스
// 실행을 위해서 존재하고,
// 객체를 만드는 목적의 클래스가 아니다.
public class Ex01_Computer {

	public static void main(String[] args) {

		// 객체 생성
		Computer myCom = new Computer();
		myCom.model = "Mac";
		myCom.manufacturer = "Apple";
		myCom.price = 370;
		
		// 객체 생성
		Computer yourCom = new Computer();
		yourCom.model = "Gram";
		yourCom.manufacturer = "LG";
		yourCom.price = 180;
		
		// 객체 자체 확인
		System.out.println(myCom); // myCom의 주소(참조) 확인
		
		// 객체의 필드 확인
		System.out.println(myCom.model);
		System.out.println(myCom.manufacturer);
		System.out.println(myCom.price);
		
	}

}
