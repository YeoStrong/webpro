package com.lec.loopQuiz;
//구구단을 바둑판 형식으로 출력해보자.
public class Quiz04 {
	public static void main(String[] args) {
		for(int i=1 ; i<=9 ; i++) {
			for(int j=2 ; j<=9 ; j++) {
				System.out.print(j + "*" + i + "=" + (j*i) + "\t");
			}
			System.out.println();
		}//for
	}//main
}//class