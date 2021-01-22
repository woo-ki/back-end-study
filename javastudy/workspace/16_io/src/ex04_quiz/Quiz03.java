package ex04_quiz;

import java.io.File;
import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 파일명을 입력하시오 >>> ");
		String name = sc.nextLine();
		sc.close();
		File file = new File("C:" + File.separator + "test" + File.separator + name);
		
		if(file.exists()) {
			file.delete();
			System.out.println(name + "파일이 삭제되었습니다.");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
	}

}
