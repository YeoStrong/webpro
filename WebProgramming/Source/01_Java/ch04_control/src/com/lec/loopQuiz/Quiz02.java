package com.lec.loopQuiz;
//1~10에서 짝수 또는 홀수의 합을 구하기
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
		System.out.println("짝수의 합은 " + tot_e);
		System.out.println("홀수의 합은 " + tot_o);
	}//main
}//class
