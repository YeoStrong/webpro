package com.lec.loop;

import java.util.Scanner;

// ¦���� �Է¹޾� ���, ¦���� �Է��Ҷ����� ���
public class Ex10doWhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		do {
			System.out.print("¦���� �Է��ϼ���: ");
			num = scan.nextInt();
		}while((num%2) != 0);
		System.out.println("�Է��� ¦����" + num);
		scan.close();
	}

}
