package com.lec.ex1_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1) inputstream 객체 생성(파일 열기) 
//(2) read(byte[]) : byte 배열의 length만큼 읽기 (속도 빠름) 
//(3) close 메소드 사용(파일 닫기)
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Desktop\\YeosongYoon\\Source\\01_Java\\ch17_io\\txtFile\\inTest.txt");
			// 2. 데이터를 읽는다(10byte씩 반복적으로 읽는다)
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs);
				if(readByteCount == -1) break; // 파일의 끝인지 여부
				for(int i=0 ; i<readByteCount ; i++) {
					System.out.print((char)bs[i]);
				}
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null)is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
