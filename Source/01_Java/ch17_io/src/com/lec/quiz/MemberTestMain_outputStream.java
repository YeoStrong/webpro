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
				System.out.println("회원가입 하시겠습니까?(종료:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.println("이름: ");
				name = scanner.next();
				dos.writeUTF(name);
				System.out.print("휴대폰 번호: ");
				phone = scanner.next();
				dos.writeUTF(phone);
				System.out.print("주소: ");
				address = scanner.next();
				dos.writeUTF(address);
				System.out.print("생년월일(yyyy-mm-dd): ");
				birthStr = scanner.next();
				dos.writeUTF(birthStr);
				StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
				if(tokenizer.countTokens()==3) {
					y = Integer.parseInt(tokenizer.nextToken());
					m = Integer.parseInt(tokenizer.nextToken());
					d = Integer.parseInt(tokenizer.nextToken());
					birthday = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
					System.out.println("가입 완료");
					birthStr = birthStr.substring(birthStr.indexOf("-")+1);
					if(birthStr.equals(today))
						System.out.println("생일 축하합니다.");
				}else {
					System.out.println("잘못된 정보를 입력하셨습니다.");
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
			System.out.println("회원 목록 출력합니다.");
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
			System.out.println("등록된 회원이 없습니다.");   
		}else {
			System.out.println("이름 \t전화번호\t생일\t주소");
			for(Member mem : members) {
				System.out.println(mem);
			}
			System.out.println("\t\t\t....이상 " + members.size() + "명 가입.");
		}
	}
}