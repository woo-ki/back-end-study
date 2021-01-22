package ex04_quiz;

class Score {
	private int kor;
	private int eng;
	private int math;
	
	public Score(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Score) {
			Score score = (Score)obj;
			if(kor == score.kor && eng == score.eng && math == score.math) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "국어: " + kor + ", 영어: " + eng + ", 수학: " + math;
	}
}

public class Quiz04 {

	public static void main(String[] args) {

		Score score1 = new Score(80, 90, 100);
		Score score2 = new Score(80, 90, 100);
		
		System.out.println(score1);	// 국어: 80, 영어: 90, 수학: 100
		System.out.println(score2);	// 국어: 80, 영어: 90, 수학: 100
		
		if(score1.equals(score2)) {
			System.out.println("같은 점수이다.");
		} else {
			System.out.println("다른 점수이다.");
		}
		
	}

}
