package ex02_exception_class;

import java.util.Scanner;

class NameException extends Exception {
	public NameException(String message) {
		super(message);
	}
}

class Human {
	
	// field
	private String name;

	// constructor
	public Human(String name) {
		super();
		this.name = name;
	}

	// method
	public String getName() {
		return name;
	}
	public void setName(String name) throws NameException{
		if(name.length() < 2 || name.length() > 6) {
			NameException e = new NameException("이름의 길이가 잘못되었습니다.(2~6)");
			throw e;
		}
		this.name = name;
	}
}

public class Ex02_NameException {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			Human p = new Human("호동이");
			
			System.out.print("이름을 입력하세요 >>> ");
			String name = sc.next();
			sc.nextLine();
			p.setName(name);
			System.out.println("변경된 이름: " + p.getName());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}

}