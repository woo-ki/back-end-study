package ex03_array_quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {

		// 문제. 성적 관리 프로그램
		// 학생 3명의 이름은 "타요", "띠띠뽀", "뽀로로" 이다.
		// 각 학생의 성적은 임의의 정수 1개이다.
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
		
		double avg = 0; // 사실 의미 없는 초기화
		int total = scores[0]; // 첫 번쨰 점수로 초기화
		int max = scores[0];   // 첫 번쨰 점수로 초기화
		int	min = scores[0];   // 첫 번쨰 점수로 초기화
		
		// 합계 구하기 초기화로 인해서 [0]을 더해주면 안 됨 i = 1부터
		for(int i = 1; i < scores.length; i++) {
			total += scores[i];
		}
		avg = total / (double)scores.length;
		
		// 최고, 최저 구하기
		for(int i = 1; i < scores.length; i++) {
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
