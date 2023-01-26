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
		long start = System.currentTimeMillis(); // 1970.1.1���� ���۽��������� �и�����
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Downloads\\bts.mp4"); // 1. ��Ʈ�� ��ü ����
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Downloads\\btscopy.mp4");
			byte[] bs = new byte[1024]; // 1KB
			int cnt = 0;
			while(true) { // 7,887 �� ����
				cnt++;
				int readbyteCount = is.read(bs); //2. read&write : bs�� �д´�
				if(readbyteCount == -1) break;
				os.write(bs, 0, readbyteCount); // bs�迭�� 0�� index���� count ����Ʈ ��ŭ write
			}
			System.out.println(cnt + "�� while�� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read&write ����" + e.getMessage());
		} finally {
			try {
				if(os!=null)os.close(); // 3.���� �ݱ�(��Ʈ�� ����)
				if(is!=null)is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}//try-catch-finally
		long end = System.currentTimeMillis(); // 1970.1.1~ ������ ���������� �и�����
		System.out.println(end-start);
	}//main
}
