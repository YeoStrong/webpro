package com.lec.ex;
// Quiz : ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�. 
// (��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. ����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int gugu;
		do {
			System.out.print("������ �� ���� �ҷ��ñ��?: ");
			gugu = scan.nextInt();
		}while(gugu<=1 || gugu>9);
		System.out.println(gugu + "��\n");
		multiTable(gugu);
		scan.close();
	}

	private static void multiTable(int gugu) {
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(gugu + "*" + i + "=" + (gugu*i));
		}
	}
}
