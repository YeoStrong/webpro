package com.lec.quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// x�� �Է��� ������ ��� ���(���Ǹ�, ����, ������):file ��� -> x�� �Է��ϸ� �̶����� ��ϵ� ��� ��� ����� ���
public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		// x�� �Է��� ������ �����(���Ǹ�, ����, ������):file ���
		OutputStream 	 fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("�̸��� �Է��ϼ���(����:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.print("�޴��� ��ȣ: ");
				dos.writeUTF(scanner.next());
				System.out.print("�ּ�: ");
				dos.writeUTF(scanner.next());
				System.out.print("�������(0000-00-00): ");
				dos.writeUTF(scanner.next());
			}
			System.out.println("���� �Ϸ�");
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
		}// ��� ��� try-catch-finally
		// x�� �Է��ϸ� ��ϵ� ��� ��� ����� ���
		ArrayList<Member> members = new ArrayList<Member>();
		InputStream 	fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec.ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				String name = dis.readUTF();
				String address = dis.readUTF();
				String phone = dis.readUTF();
				String birthday = dis.readUTF();
//				members.add(new Member(name, address, phone, birthday));
//				Product product= new Product();
//				product.setName(dis.readUTF());
//				product.setPrice(dis.readInt());
//				product.setStock(dis.readInt());
//				products.add(product);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��� ��� ����մϴ�.");
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
			System.out.println("��ϵ� ��� �����ϴ�.");   
		}else {
			System.out.println("��ǰ�� \t����\t������");
			for(Member m : members) {
				System.out.println(m);
			}
			System.out.println("�̻� " + members.size() + "���� ��� ��ǰ �Էµ�.");
		}
	}
}
