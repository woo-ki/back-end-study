package ex04_quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 문제. 파일복사
// sample.mp4파일을 sample2.mp4로 복사하시오.
// 1. sample.mp4파일에서 적당히 데이터를 읽는다.
// 2. 읽어둔 데이터를 sample2.mp4 파일로 보낸다.
// 3. 복사 시간을 잰다.

public class Quiz01 {

	public static void main(String[] args) {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("sample.mp4"));
			bos = new BufferedOutputStream(new FileOutputStream("sample2.mp4"));
			// int 단위로 읽고 쓰기
			// int data = bis.read();
			// bos.write(data);
			
			// byte[] 단위로 읽고 쓰기
			// byte[] bytes = new byte[1024];	// 1024바이트 = 1킬로바이트
			// bis.read(bytes);
			// bos.write(bytes);
			long start = System.currentTimeMillis();
			while(true) {
				byte[] bytes = new byte[1024];
				int state = bis.read(bytes);
				if(state == -1) {
					break;
				}
				bos.write(bytes);	// Sample2.mp4파일에 쓰기(생성)
			}
			long end = System.currentTimeMillis();
			double copyTime = (end - start) / 1000.0;
			System.out.println("파일이 복사되었습니다. 복사시간: " + copyTime);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {bos.close();}
				if(bis != null) {bis.close();}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
