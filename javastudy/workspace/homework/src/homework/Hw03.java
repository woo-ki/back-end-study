package homework;

import java.util.Scanner;

public class Hw03 {

	public static void main(String[] args) {

		/*
		커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오.
		switch 문을 이용하여 구현하시오.
		(에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)
		예시)
		무슨 커피 드릴까요? >> 카푸치노
		카푸치노는 3500원입니다.
		-----------------------------
		무슨 커피 드릴까요? >> 아메리카노
		아메리카노는 2000원입니다.
		-----------------------------
		무슨 커피 드릴까요? >> 믹스커피
		믹스커피는 메뉴에 없습니다.
		*/
		Scanner sc = new Scanner(System.in);
		int price;
		
		System.out.print("무슨 커피를 드릴까요? >> ");
		String menu = sc.nextLine();
		switch(menu) {
		case "아메리카노" :
			price = 2000;
			break;
		case "카푸치노" : case "에스프레소" : case "카페라떼" :
			price = 3500;
			break;
		default :
			price = 0;
		}
		
		if(price == 0) {
			System.out.println(menu + "는 메뉴에 없습니다.");
		} else {
			System.out.println(menu + "는 " + price + "원 입니다.");
		}
		sc.close();
	}

}
