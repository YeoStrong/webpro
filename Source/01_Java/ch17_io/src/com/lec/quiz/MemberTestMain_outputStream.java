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

// x를 입력할 때까지 재고 등록(물건명, 가격, 재고수량):file 출력 -> x를 입력하면 이때까지 등록된 모든 재고 목록을 출력
public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		// x를 입력할 때까지 재고등록(물건명, 가격, 재고수량):file 출력
		OutputStream 	 fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("이름을 입력하세요(종료:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.print("휴대폰 번호: ");
				dos.writeUTF(scanner.next());
				System.out.print("주소: ");
				dos.writeUTF(scanner.next());
				System.out.print("생년월일(0000-00-00): ");
				dos.writeUTF(scanner.next());
			}
			System.out.println("가입 완료");
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
		}// 재고 등록 try-catch-finally
		// x를 입력하면 등록된 모든 재고 목록을 출력
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
			System.out.println("재고 목록 출력합니다.");
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
			System.out.println("등록된 재고가 없습니다.");   
		}else {
			System.out.println("물품명 \t가격\t재고수량");
			for(Member m : members) {
				System.out.println(m);
			}
			System.out.println("이상 " + members.size() + "가지 재고 물품 입력됨.");
		}
	}
}
