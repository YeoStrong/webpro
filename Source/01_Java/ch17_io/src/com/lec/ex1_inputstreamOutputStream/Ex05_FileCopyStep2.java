package com.lec.ex1_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//C:\Users\EZEN 203\Downloads\bts.mp4 => C:\Users\EZEN 203\Downloads\btscopy.mp4 (8,075,033 byte)
public class Ex05_FileCopyStep2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1부터 시작시점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Downloads\\bts.mp4"); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Downloads\\btscopy.mp4");
			byte[] bs = new byte[1024]; // 1KB
			int cnt = 0;
			while(true) { // 7,887 번 수행
				cnt++;
				int readbyteCount = is.read(bs); //2. read&write : bs에 읽는다
				if(readbyteCount == -1) break;
				os.write(bs, 0, readbyteCount); // bs배열을 0번 index부터 count 바이트 만큼 write
			}
			System.out.println(cnt + "번 while문 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read&write 오류" + e.getMessage());
		} finally {
			try {
				if(os!=null)os.close(); // 3.파일 닫기(스트림 해제)
				if(is!=null)is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}//try-catch-finally
		long end = System.currentTimeMillis(); // 1970.1.1~ 끝나는 시점까지의 밀리세컨
		System.out.println(end-start);
	}//main
}
