package com.lec.quiz;

import java.util.Scanner;

//�� ���� �Է¹޾�
//�� ���� ������ ����� o�� x�� ���.
//ù��° ���� �� ū�� ����� o�� x�� ���.
public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ������ �Է��ϼ���: ");
		int su1 = sc.nextInt();
		System.out.print("�� ��° ������ �Է��ϼ���: ");
		int su2 = sc.nextInt();
		String result1 = (su1 == su2) ? "O�Դϴ�." : "X�Դϴ�.";
		String result2 = (su1 > su2) ? "O�Դϴ�." : "X�Դϴ�.";
		System.out.printf("\n" + result1 + "\n" + result2);
		sc.close();
	}

}
