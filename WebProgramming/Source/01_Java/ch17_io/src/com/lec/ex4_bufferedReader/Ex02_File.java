package com.lec.ex4_bufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex02_File {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�о�� ���ϸ�: ");
		String filename = scanner.next();
		File file = new File("txtFile/"+filename);
		try {
			if (file.exists()) {
				reader = new FileReader("txtFile/" + filename);
				br = new BufferedReader(reader); // ������Ʈ���� �⺻��Ʈ���� ����
				while (true) {
					String linedata = br.readLine(); // ���پ� �д´�
					if (linedata == null)
						break;
					System.out.println(linedata);
				}
			}else {
				System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null)br.close();
				if(reader!=null)reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
