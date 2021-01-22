package ex01_pakage;

public class Father {

	// 1. private : Father 클래스 내부에서만 볼 수 있다.
	// 2. default : ex01_pakage 내부에서만 볼 수 있다.
	// 3. protected : ex01_pakage 내부 + Father 클래스의 서브 클래스에서만 볼 수 있다.
	// 4. public : 어디서든 누구나 볼 수 있다.
	
	@SuppressWarnings("unused")
	private String secret = "비상금이 있다.";
	String tv = "LGTV";
	protected String perID = "851212-1234567";
	public String name = "김철수";
	
}
