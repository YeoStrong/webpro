package com.lec.quiz;

import java.util.Scanner;

// ���̸� �Է� �޾� �Է� ���� ���̰� 65�� �̻��� ��, "��ο��" ���, �ƴϸ� "�Ϲ�" ���
public class Quiz04 {
	public static void main(String[] args) {
		System.out.print("���̸� �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		String result = (age >= 65) ? "��ο��" : "�Ϲ�";
		System.out.println(result);
		sc.close();
	}

}
