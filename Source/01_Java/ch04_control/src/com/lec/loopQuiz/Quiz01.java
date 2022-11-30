package com.lec.loopQuiz;
//1~10까지의 곱의 결과를 출력해보자
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
		System.out.println("의 누적곱은 " + tot + "입니다.");
	}//main
}//class