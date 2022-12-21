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
				System.out.println("회원가입 하시겠습니까?(종료:n): ");
				if(scanner.next().trim().equalsIgnoreCase("n")) break;
				System.out.println("이름: ");
				String name = scanner.next();
				dos.writeUTF(name);
				System.out.print("휴대폰 번호: ");
				String phone = scanner.next();
				dos.writeUTF(phone);
				System.out.print("주소: ");
				String address = scanner.next();
				dos.writeUTF(address);
				System.out.print("생년월일(yyyy-mm-dd): ");
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
					System.out.println("가입 완료");
					Date nowDate = new Date();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
					String today = sdf1.format(nowDate);
					if(today.equals(sdf1.format(birthStr)))
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
			for(Member m : members) {
				System.out.println(m);
			}
			System.out.println("....이상 " + members.size() + "명 가입.");
		}
	}
}
