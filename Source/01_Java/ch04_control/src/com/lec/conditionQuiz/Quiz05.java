package com.lec.conditionQuiz;
// ���� �� �������� Ű����κ��� �Է¹޾� ������ ����ϴ� ���α׷�
import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �� �Դϱ�?: ");
		int month = scan.nextInt(); // 1 ~ 12
		switch(month) {
		case 1: case 2: case 11: case 12:
			System.out.println(month + "���� �ܿ��Դϴ�.");break;
		case 3: case 4: case 5:
			System.out.println(month + "���� ���Դϴ�.");break;
		case 6: case 7: case 8:
			System.out.println(month + "���� �����Դϴ�.");break;
		case 9: case 10:
			System.out.println(month + "���� �����Դϴ�.");break;
		default:
			System.out.println("��ȿ�� ���� �Է����ּ���(1~12).");
		} //switch
		scan.close();
	} //main

} //class
