package com.lec.ex1_inputstreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1) inputstream ��ü ����(���� ����) 
//(2) read(byte[]) : byte �迭�� length��ŭ �б� (�ӵ� ����) 
//(3) close �޼ҵ� ���(���� �ݱ�)
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Desktop\\YeosongYoon\\Source\\01_Java\\ch17_io\\txtFile\\inTest.txt");
			// 2. �����͸� �д´�(10byte�� �ݺ������� �д´�)
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs);
				if(readByteCount == -1) break; // ������ ������ ����
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
