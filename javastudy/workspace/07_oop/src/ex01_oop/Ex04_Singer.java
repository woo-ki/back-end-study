package ex01_oop;

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

class Singer {
	// field
	String name;
	Song song;
	// constructor
	Singer(String name, Song song) {
		this.song = song;
		this.name = name;
	}
	Singer(String name, String title, String genre, double playTime) {
		this.name = name;
		this.song = new Song(title, genre, playTime);
	}
	// method
	void info() {
		System.out.print("이름: " + name + ", ");
		song.info();
	}
}

public class Ex04_Singer {

	public static void main(String[] args) {

		Singer singer1 = new Singer("아델", new Song("hello", "balad", 4.5));
		
		Song song = new Song("nynamite", "dance", 3.5);
		Singer singer2 = new Singer("BTS", song);
		
		Singer singer3 = new Singer("싹쓰리", "다시 여기 바닷가", "dance", 4.0);
		
		singer1.info();	// 이름, 제목, 장르, 재생시간
		singer2.info();
		singer3.info();
		
	}

}
