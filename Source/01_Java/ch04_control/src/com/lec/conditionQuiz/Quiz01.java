package com.lec.conditionQuiz;
// ���� �Է� �޾� ���밪�� ���
import java.util.Scanner;
public class Quiz01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է��ϼ���: ");
		int num = scan.nextInt();
		if(num>0) {
			System.out.println("���밪�� " + num + "�Դϴ�.");
		}else if(num==0) {
			System.out.println(num + "�Դϴ�.");
		}else {
			System.out.println("���밪�� " + (-num) + "�Դϴ�.");
		} //if
		scan.close();
	} //main
} //class