package ex03_array_quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

		// 다섯명의 키를 입력받아 키가 가장큰 사람의 이름을 출력하시오
		// 실행 예)
		// james의 키 입력 >>> 155.5
		// alice의 키 입력 >>> 165.5
		// amanda의 키 입력 >>> 175.5
		// jessica의 키 입력 >>> 185.5
		// emily의 키 입력 >>> 195.5
		// 가장 키가 큰 사람은 emily 입니다.
		
		String[] person = {"james", "alice", "amanda", "jessica", "emily"};
		double[] height = new double[person.length];
		
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < height.length; i++) {
			System.out.print(person[i] + "의 키 입력 >>> ");
			height[i] = input.nextDouble();
		}
		double tallest = height[0];
		String tPerson = person[0];
		for(int i =  1; i < height.length; i++) {
			if(tallest < height[i]) {
				tallest = height[i];
				tPerson = person[i];
			}
		}
		
		System.out.println("가장 키가 큰 사람은 "+ tPerson + " 입니다.");
		
	}

}
