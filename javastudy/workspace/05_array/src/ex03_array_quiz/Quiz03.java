package ex03_array_quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

		// 문제. 친구 3명을 저장할 수 있는 배열을 생성하고,
		// 초기화를 통해 배열에 입력한다.
		// 새로 사귄 친구의 수를 입력 받아서,
		// 기존 친구들이 저장된 배열의 길이를 늘리시오.
		
		String[] friendList = {"타요", "띠띠뽀", "뽀로로"};
		Scanner input = new Scanner(System.in);
		System.out.print("새 친구 숫자를 입력하세요 >>> ");
		int plus = input.nextInt();
		String[] newFrienList = new String[friendList.length + plus];
		
		System.arraycopy(friendList, 0, newFrienList, 0, friendList.length);
		friendList = newFrienList;
		
		for(String f : friendList) {
			System.out.println(f);
		}
		
	}

}
