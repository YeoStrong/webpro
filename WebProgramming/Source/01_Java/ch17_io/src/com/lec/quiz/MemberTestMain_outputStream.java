package com.lec.quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args){
		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now); // "12-20"
		Scanner scanner = new Scanner(System.in);
		String name, address, phone, birthStr;
		int y, m, d;
		Date birthday = null;
		OutputStream 	 fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("ȸ������ �Ͻðڽ��ϱ�?(����:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.println("�̸�: ");
				name = scanner.next();
				dos.writeUTF(name);
				System.out.print("�޴��� ��ȣ: ");
				phone = scanner.next();
				dos.writeUTF(phone);
				System.out.print("�ּ�: ");
				address = scanner.next();
				dos.writeUTF(address);
				System.out.print("�������(yyyy-mm-dd): ");
				birthStr = scanner.next();
				dos.writeUTF(birthStr);
				StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
				if(tokenizer.countTokens()==3) {
					y = Integer.parseInt(tokenizer.nextToken());
					m = Integer.parseInt(tokenizer.nextToken());
					d = Integer.parseInt(tokenizer.nextToken());
					birthday = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
					System.out.println("���� �Ϸ�");
					birthStr = birthStr.substring(birthStr.indexOf("-")+1);
					if(birthStr.equals(today))
						System.out.println("���� �����մϴ�.");
				}else {
					System.out.println("�߸��� ������ �Է��ϼ̽��ϴ�.");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null)dos.close();
				if(fos!=null)fos.close();
			} catch (IOException e) {
				
			}// close
		}// try-catch-finally

		InputStream 	fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/quiz/member.txt");
			dis = new DataInputStream(fis);
			while(true) {
				name = dis.readUTF();
				address = dis.readUTF();
				phone = dis.readUTF();
				birthStr = dis.readUTF();
				members.add(new Member(name, address, phone, birthday));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ȸ�� ��� ����մϴ�.");
		} finally {
			try {
				if(dis!=null)dis.close();
				if(fis!=null)fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} // try-catch
		if(members.isEmpty()) {
			System.out.println("��ϵ� ȸ���� �����ϴ�.");   
		}else {
			System.out.println("�̸� \t��ȭ��ȣ\t����\t�ּ�");
			for(Member mem : members) {
				System.out.println(mem);
			}
			System.out.println("\t\t\t....�̻� " + members.size() + "�� ����.");
		}
	}
}