package ex02_inheritance_quiz;

class Song {
	// field
	String title;
	String genre;
	double playTime;
	// constructor
	Song(String title, String genre, double playTime) {
		this.title = title;
		this.genre = genre;
		this.playTime = playTime;
	}
	//method
	void info() {
		System.out.println("제목: " + title + ", 장르: " + genre + ", 재생시간: " + playTime);
	}	
}

class Singer extends Song {
	// field
	String name;
	// constructor
	Singer(String name, String title, String genre, double playTime) {
		super(title, genre, playTime);
		this.name = name;
	}
	// method
	void info() {
		System.out.print("이름: " + name + ", ");
		super.info();
	}
}

public class Quiz04 {

	public static void main(String[] args) {

		Singer singer = new Singer("싹쓰리", "다시 여기 바닷가", "dance", 4.0);
		
		singer.info();

	}

}
