package com.lec.loopQuiz;
//1~10���� ¦�� �Ǵ� Ȧ���� ���� ���ϱ�
public class Quiz02 {
	public static void main(String[] args) {
		int tot_e = 0;
		int tot_o = 0;
		for(int i=1 ; i<=10 ; i++) {
			if(i%2 == 0) {
				tot_e += i;
			}else
				tot_o += i;
		}
		System.out.println("¦���� ���� " + tot_e);
		System.out.println("Ȧ���� ���� " + tot_o);
	}//main
}//class
