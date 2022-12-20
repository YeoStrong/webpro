package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù ��° ������?");
		i = scanner.nextInt();
		System.out.print("�� ��° ������?");
		j = scanner.nextInt();
		System.out.println("i = " + i + ", j= " + j);
		System.out.println("i * j = " + (i*j));
		try {			
			System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		}catch(ArithmeticException div0) { // ���� �߻� �� ���� �κ�
			System.out.println(div0.getMessage()); // ���� �޼��� ���
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}