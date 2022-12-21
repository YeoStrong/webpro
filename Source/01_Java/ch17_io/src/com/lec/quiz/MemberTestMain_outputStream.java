package com.lec.quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) throws ParseException {
		OutputStream 	 fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("ȸ������ �Ͻðڽ��ϱ�?(����:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.println("�̸�: ");
				String name = scanner.next();
				dos.writeUTF(name);
				System.out.print("�޴��� ��ȣ: ");
				String phone = scanner.next();
				dos.writeUTF(phone);
				System.out.print("�ּ�: ");
				String address = scanner.next();
				dos.writeUTF(address);
				System.out.print("�������(yyyy-mm-dd): ");
				String birthStr = scanner.next();
				dos.writeUTF(birthStr);
				StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
				String[] arr = new String[tokenizer.countTokens()];
				while(tokenizer.hasMoreTokens()) {
					int idx = 0;
					arr[idx++] = tokenizer.nextToken();
				}
				int y; int m; int d;
				y = Integer.parseInt(arr[0]);
				m = Integer.parseInt(arr[1]);
				d = Integer.parseInt(arr[2]);
				Date birthday = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
				if(tokenizer.countTokens()==3) {
					System.out.println("���� �Ϸ�");
					Date nowDate = new Date();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
					String today = sdf1.format(nowDate);
					if(today.equals(sdf1.format(birthStr)))
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
		
		ArrayList<Member> members = new ArrayList<Member>();
		InputStream 	fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/quiz/member.txt");
			dis = new DataInputStream(fis);
			while(true) {
				String name = dis.readUTF();
				String address = dis.readUTF();
				String phone = dis.readUTF();
				String birthStr = dis.readUTF();
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
			for(Member m : members) {
				System.out.println(m);
			}
			System.out.println("....�̻� " + members.size() + "�� ����.");
		}
	}
}
