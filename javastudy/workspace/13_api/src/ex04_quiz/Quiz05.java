package ex04_quiz;

class User {
	private String userId;
	private String userPw;
	
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		String id = "";
		String pw = "";
		for(int i = 0; i < userId.length() - 2; i++) {
			id += "*";
		}
		for(int i = 0; i < userPw.length(); i++) {
			pw += "*";
		}
		
		return "아이디: " + userId.substring(0, 2) + id + ", 비밀번호: " + pw;
	}
}

public class Quiz05 {

	public static void main(String[] args) {

		User user = new User("admin", "123456");
		
		System.out.println(user);	// 아이디: ad***, 비밀번호: ****** (글자 수 맞춤)
		
	}

}
