package com.lec.loopQuiz;
//1~10������ ���� ����� ����غ���
public class Quiz01 {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1 ; i<=10 ; i++) {
			System.out.print(i);
			if(i!=10) {
				System.out.print('*');
			}
			tot *= i;
		}//for
		System.out.println("�� �������� " + tot + "�Դϴ�.");
	}//main
}//class