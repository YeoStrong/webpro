package com.lec.ex1_inputstreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// JSP나 SPRING에서 파일첨부게시판 작성시 copy할 로직
//C:\Users\EZEN 203\Downloads\bts.mp4 => C:\Users\EZEN 203\Downloads\btscopy.mp4 (8,075,033 byte)
public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("C:\\Users\\EZEN 203\\Downloads\\bts.mp4");
			is = new FileInputStream(file); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Downloads\\bts_copy.mp4");
			byte[] bs = new byte[(int) file.length()]; // 1KB
			while(true) { // 7,887 번 수행
				int readbyteCount = is.read(bs); //2. read&write : bs에 읽는다
				if(readbyteCount == -1) break;
				os.write(bs, 0, readbyteCount); // bs배열을 0번 index부터 count 바이트 만큼 write
			}
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
	}//main
}
