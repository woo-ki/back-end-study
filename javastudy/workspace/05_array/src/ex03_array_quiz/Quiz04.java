package ex03_array_quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

		// 문제. 성적 관리 프로그램
		// 학생 3명의 이름은 "타요", "띠띠뽀", "뽀로로" 이다.
		// 각 학생의 성적은 0~100 사이 정수 1개이다.
		// 학생의 점수를 입력 받아서, 평균, 최고, 최저 점수를 출력하시오.
		// 실행 예)
		// 타요의 점수 입력 >>> 50
		// 띠띠뽀의 점수 입력 >>> 55
		// 뽀로로의 점수 입력 >>> 60
		// 평균 : 55점, 최고 : 60점, 최저: 50점
		
		String[] students = {"타요", "띠띠뽀", "뽀로로"};
		int[] scores = new int[students.length];
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i] + "의 점수 입력 >>> ");
			scores[i] = input.nextInt();
		}
		
		double avg = 0;
		int total = 0; // zero
		int max = 0;   // 가장 작은 값
		int	min = 100; // 가장 큰 값
		
		// 합계 구하기
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		avg = total / (double)scores.length;
		
		// 최고, 최저 구하기
		for(int i = 0; i < scores.length; i++) {
			//최고
			if(max < scores[i]) {
				max = scores[i];
			}
			//최저
			if(min > scores[i]) {
				min = scores[i];
			}
		}
		
		System.out.println("평균 : " + avg + "점, 최고 : " + max + "점, 최저 : " + min + "점");
		
		
		
		
	}

}
