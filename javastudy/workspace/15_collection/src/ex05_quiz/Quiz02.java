package ex05_quiz;

import java.util.HashSet;
import java.util.Set;

// 문제. 로또 발생기
// HashSet 클래스를 이용해서 당첨 번호 6개만 생성하시오.

public class Quiz02 {

	public static void main(String[] args) {
		
		Set<Integer> n = new HashSet<Integer>();
		while(n.size() <= 6) {
			n.add((int)(Math.random() * 45) + 1);
		}
		
		System.out.println(n);
		
	}

}
