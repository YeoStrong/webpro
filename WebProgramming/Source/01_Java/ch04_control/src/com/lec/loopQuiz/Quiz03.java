package com.lec.loopQuiz;
import java.util.Scanner;
//����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ����غ���.
public class Quiz03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���ϴ� �����ܼ��� �Է��ϼ���: ");
		int gugu = scan.nextInt();
		if(gugu<=0) {
			System.out.println("���� ������ �Է��ϼ���.");
		}else {
			for(int i=1 ; i<=9 ; i++) {
				System.out.println(gugu + "*" + i + "=" + (gugu*i));
			}
		}scan.close(); //if
	} //main
} //class