package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz01 {
	
	public static void main(String[] args) {
		
		// 문제. 국어와 영어 점수를 입력받아서,
		// "합격", "불합격"을 구분하여 출력하시오.
		// 국어와 영어 점수가 모두 80점 이상이고, 평균이 85점 이상이면 "합격"
		
		Scanner input = new Scanner(System.in);
		System.out.print("국어 점수를 입력하시오 >>> ");
		int kor = input.nextInt();
		System.out.print("영어 점수를 입력하시오 >>> ");
		int eng = input.nextInt();
		double avg = (kor + eng) / 2.0;
		String pass;
		if(kor >= 80 && eng >= 80 && avg >= 85) {
			pass = "합격";
		} else {
			pass = "불합격";
		}
		System.out.println("합격 여부는 : " + pass);
		
	}

}
