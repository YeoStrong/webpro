package com.lec.ex8_decimal;

import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� �Է¹޾� �˻��� FULL ��ȭ��ȣ(�ߺ��� ���ڸ� ����) ���
public class Ex07_searchPostTel_review {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-8888", "010-6666-8888" };
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean searchOk = false; // �˻��� ����� ������ true
			System.out.println("(����: x�Է�)�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ��� �Է��ϼ���: "); // 8888, 9999, 4238...
			String searchTel = sc.next(); // 8888
			if(searchTel.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			for (int i = 0; i < tels.length; i++) {
				// int idx = tels[i].lastIndexOf("-"); //8, 6, ...
				// String postTel = tels[i].substring(idx+1);
				// System.out.println(i + "��° ���ڸ�: " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-") + 1);
				if (postTel.equals(searchTel)) {
					System.out.println("�˻��Ͻ� ��ȭ��ȣ�� " + tels[i]);
					searchOk = true; // ��ȭ��ȣ ��� ����
				}
			}
			if (!searchOk) {
				System.out.println("�˻��Ͻ� ���ڸ��� ��ȭ��ȣ�� �����ϴ�.");
			} else {
				System.out.println("�˻��Ͻ� ���ڸ��� ��ȭ��ȣ�� ��� ����Ͽ����ϴ�.");
			}
		}
	}
}
