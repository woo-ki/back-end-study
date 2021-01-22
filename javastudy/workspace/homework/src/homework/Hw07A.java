package homework;

import java.util.Scanner;

class Phone0 {
	
	String name;
	String tel;
	
	Phone0(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	String getName() {
		return name;
	}
	String getTel() {
		return tel;
	}
	
}

class Phone0Book {
	
	Scanner sc;
	Phone0[] phoneList;
	
	Phone0Book() {
		sc = new Scanner(System.in);
	}
	
	void input() {
		System.out.print("몇 명의 정보를 저장하시겠습니까? >> ");
		int n = sc.nextInt();
		phoneList = new Phone0[n];  
		
		for (int i = 0; i < phoneList.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> ");
			String name = sc.next();
			String tel = sc.next();
			phoneList[i] = new Phone0(name, tel);  // 입력 받은 이름과 전화번호를 하나의 Phone 객체로 만들어 phoneList 배열에 저장한다.
		}
		System.out.println("저장되었습니다.");
	}
	
	String search(String name) {  // 이름을 입력 받아서
		for (int i = 0; i < phoneList.length; i++) {
			if (phoneList[i].getName().equals(name)) {  // 같은 이름이 있으면
				return phoneList[i].getTel();  // 전화번호를 알려 준다.
			}
		}
		return null;  // 같은 이름이 없다는 의미
	}
	
	void run() {
		input();
		while (true) {
			System.out.print("검색할 이름 >> ");
			String name = sc.next();
			if (name.equals("그만")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			String tel = search(name);
			if (tel == null) {
				System.out.println(name + " 없습니다.");
			} else {
				System.out.println(name + " 번호는 " + tel + " 입니다.");
			}
		}
		sc.close();
	}
	
}

public class Hw07A {
	
	public static void main(String[] args) {
		
		new Phone0Book().run();
		
	}
	
}