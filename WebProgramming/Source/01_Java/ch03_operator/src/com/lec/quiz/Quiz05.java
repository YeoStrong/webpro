package com.lec.quiz;

import java.util.Scanner;

// ����, ����, ���� ������ ����ڿ��� �Է� �޾�, �� ������ ����ϰ� ����, ���(�Ҽ��� 2�ڸ�����) ����ϴ� ���α׷��� �����Ͻÿ�.
public class Quiz05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���: ");
		int kr = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ���: ");
		int en = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ���: ");
		int math = sc.nextInt();
		System.out.printf("����: %d \n����: %d \n����: %d\n\n", kr, en, math);
		int sum = kr + en + math;
		System.out.printf("����: %d\n", sum);
		double average = sum / 3.0;
		System.out.printf("���: %.2f\n", average);
		sc.close();
	}
}
