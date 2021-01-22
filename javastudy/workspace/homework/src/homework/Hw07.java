package homework;

import java.util.Scanner;

class Phone {
	String name;
	String tel;
	
	Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	String name() {
		return name;
	}
	
	String tel() {
		return tel;
	}
}

class PhoneBook {
	Phone[] phoneList;
	Scanner sc = new Scanner(System.in);
	
	// 1. 그만 입력시 나갈 exit
	void exit() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	// 2. 배열의 길이 및 객체 지정하는 set
	void set() {
		System.out.print("몇 명의 정보를 저장하시겠습니까? >> ");
		phoneList = new Phone[sc.nextInt()];
		for(int i = 0; i < phoneList.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> ");
			String name = sc.next();
			String tel = sc.next();
			sc.nextLine();
			phoneList[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다.");
	}
	
	// 3. 일치하는 이름이 있는지 체크하고 반환하는 name
	void name(String name) {
		for(int i = 0; i < phoneList.length; i++) {
			if(phoneList[i].name().equals(name)) {
				System.out.println(name + " 번호는 " + phoneList[i].tel() + " 입니다.");
				return;
			}
		}
		System.out.println(name + " 없습니다.");
	}
	// 4. 실행부 run
	void run() {
		set();
		while(true) {
			System.out.print("검색할 이름 >> ");
			String name = sc.nextLine();
			switch(name) {
			case "그만" :
				exit(); return;
			default :
				name(name);
			}
		}
	}
}

public class Hw07 {

	public static void main(String[] args) {
		
		/*
		이름(name), 전화번호(tel) 필드를 가지는 Phone 클래스를 작성하고,
		Phone[] phoneList 배열을 필드로 가지는 PhoneBook 클래스를 작성하시오.
		이름과 전화번호의 저장 후에는 이름을 입력 받아 해당 전화번호를 출력하도록 작성하시오.
		이름을 "그만"이라고 입력하면 프로그램을 종료하시오.
		예시)
		몇 명의 정보를 저장하시겠습니까? >> 3
		이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> 제임스 010-1111-1111
		이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> 나탈리 010-2222-2222
		이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> 데이빗 010-3333-3333
		저장되었습니다.
		검색할 이름 >> 제시카
		제시카 없습니다.
		검색할 이름 >> 나탈리
		나탈리 번호는 010-2222-2222 입니다.
		검색할 이름 >> 그만
		프로그램을 종료합니다.
		 */

		PhoneBook phone = new PhoneBook();
		phone.run();
		
	}

}
