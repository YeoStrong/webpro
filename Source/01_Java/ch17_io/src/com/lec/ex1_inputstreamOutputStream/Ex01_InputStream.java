package com.lec.ex1_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1) stream 객체 생성(파일 열기) (2) read method 사용(데이터 읽기) (3) close 메소드 사용(파일 닫기)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			// 2. 데이터를 읽는다(파일 끝까지 1byte씩 반복적으로 읽는다)
			while(true) {
				int i = is.read(); // 1byte씩 읽기
				if(i == -1) break; // 파일의 끝이면 break;
				System.out.print((char)i +"("+ i + ")");
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("예외메세지: 파일을 찾을 수 없습니다. "+ e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("예외메세지: 파일을 읽는 중 오류가 발생했습니다. "+ e.getMessage());
		} finally {
			// 3. 파일을 닫는다
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
	}
}
