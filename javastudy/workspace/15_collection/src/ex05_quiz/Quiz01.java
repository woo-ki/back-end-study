package ex05_quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// 문제. 임의의 User를 3명 저장하는 ArrayList를 생성하시오.
// 회원번호를 입력 받아 검색하여 일치하는 회원을 삭제하시오.

class User {
	//field
	private int no;		// 회원번호
	private String id;	// 아이디
	private Date date;	// 가입일

	public User(int no, String id) {
		super();
		this.no = no;
		this.id = id;
		date = new Date();
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return id;
	}
}

public class Quiz01 {

	public static void main(String[] args) {
		List<User> user = new ArrayList<User>();
		user.add(new User(1, "a"));
		user.add(new User(2, "b"));
		user.add(new User(3, "c"));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원번호를 입력하세요 >>> ");
		int no = sc.nextInt();
		
		// 저장된 User의 no와 입력된 no 비교
		int idx = -1;
		for(int i = 0, size = user.size(); i < size; i++) {
			if(user.get(i).getNo() == no) {
				user.remove(i);
				idx = i;
				break;
			}
		}
		if(idx == -1) {
			System.out.println("일치하는 대상이 없습니다.");
		}
		
		// 출력
		System.out.println(user);	// [객체, 객체, 객체]
		// 개별 객체 정보를 문자열로 반환하는 toString 메소드를 함께 활용
		
		sc.close();
	}
	
}
