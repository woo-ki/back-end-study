package ex02_variable;

public class Ex05_parsing {

	public static void main(String[] args) {

		/*
		 * 문자열 타입 변환은 casting이 아니고, parsing이다.
		 * 
		 * 1. String -> int
		 * 		String s = "100";
		 * 		int a = Integer.parseInt(s);
		 * 
		 * 2. String -> double
		 * 		String s = "1.5";
		 * 		double a = Double.parseDouble(s);
		 * 
		 * 3. String -> boolean
		 * 		String s = "true";
		 * 		boolean a = Boolean.parseBoolean(s);
		 * 
		 * 4. int -> String
		 * 		int a = 100;
		 * 		String s = String.valueOf(a);
		 * 
		 * 5. double -> String
		 * 		double a = 1.5;
		 * 		String s = String.valueOf(a);
		 * 
		 * 6. boolean -> String
		 * 		boolean a = true;
		 * 		String s = String.valueOf(a);
		 * 
		 * 4~6. 어떤 타입 -> String
		 * 		1) String s = String.valueOf(a);
		 * 		2) String s = a + "";
		 * */
		
		String strAge = "25";
		String strHeight = "175.5";
		
		int age = Integer.parseInt(strAge);
		double height = Double.parseDouble(strHeight);
		
		System.out.println("나이는 " + age + "살 입니다.");
		System.out.println("키는 " + height + "cm입니다.");
		
	}

}
