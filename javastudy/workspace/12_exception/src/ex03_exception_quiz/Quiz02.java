package ex03_exception_quiz;

class Game {
	public int challenge() throws Exception {
		return 0;
	}
	public void play() throws Exception {
		int a = challenge();
	}
}

public class Quiz02 {
	// 방법 1
	/*
	public static void main(String[] args) {
		Game game = new Game();
		try {
			game.play();
		} catch(Exception e) {
			
		}
	}
	*/
	
	// 방법 2
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		game.play();
	}
}
