package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_jumin {
	public static void main(String[] args) {
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���(******-*******): ");
		Scanner scan = new Scanner(System.in);
		String jumin = scan.next();
		char gender = jumin.charAt(7);
		if(gender=='1' || gender=='3') {
			System.out.println("�����̽ñ���.");
		}else if(gender=='2' || gender=='4') {
			System.out.println("�����̽ñ���.");
		}else {
			System.out.println("��ȿ���� ���� �ֹι�ȣ �Դϴ�.");
		}
		// ���2 String���� ����
		String genderStr = jumin.substring(7,8); // "2"
		if(genderStr.equals("1") || genderStr.equals("3")) {
			System.out.println("�����̽ñ���.");
		}
		// ���3 genderStr�� ������ ��ȯ
		int genderInt = Integer.parseInt(genderStr); //2
		if(genderInt==1 || genderInt==3) {
			System.out.println("�����̽ñ���.");
		}else if(genderInt==2 || genderInt==4) {
			System.out.println("�����̽ñ���.");
		}else {
			System.out.println("��ȿ���� ���� �ֹε�Ϲ�ȣ�Դϴ�.");
		}
	}
}
