package ex02_char_base;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ex05_BufferedWriter {

	public static void main(String[] args) {

		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("text2.txt"));
			bw.write("히융히융히융이융이융이융\n");
			bw.write("삐용삐용삐용삐용히용히용\n");
			System.out.println("text2.txt 파일이 생성되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
