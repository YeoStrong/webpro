package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ�� �Է¹޾� �̰� ���� �� ���.
public class Ex06_telPrint {
	public static void main(String[] args) {
		String tel;
		while (true) {
			System.out.println("��ȭ��ȣ�� �Է��ϼ���: ");
			Scanner scan = new Scanner(System.in);
			tel = scan.next();
			if (tel.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			System.out.println("�Է��Ͻ� ��ȭ��ȣ: " + tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i) + " ");
				}
			} // for1
			System.out.println();
			System.out.print("���ڸ� �Ųٷ�: ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			} // for2
			System.out.println();
			System.out.print("��ȭ��ȣ ���ڸ�: ");
			for (int i = 0; i < tel.indexOf('-'); i++) {
				System.out.print(tel.charAt(i));
			} // for3
			System.out.println();
			System.out.print("��ȭ��ȣ ���ڸ�: ");
			for (int i = tel.lastIndexOf('-')+1 ; i < tel.length() ; i++) {
				System.out.print(tel.charAt(i));
			} // for4
			System.out.println();
		}
	}
}
