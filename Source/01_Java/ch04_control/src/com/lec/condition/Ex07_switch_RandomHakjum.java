package com.lec.condition;
// 실행할 때마다 컴퓨터가 난수 점수(Random score)를 발생하여 학점 출력
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
		// 0 <= Math.random() <1 : 실수
		// 0 <= Math.random()*101 <101 : 실수
		// 0 <= (int)(Math.random()*101) <101 : 정수
		// 0 <= score <101 의 정수 난수
		// System.out.println((int)(Math.random()*101));
		int score = (int)(Math.random()*101);
		int temp = (score == 100) ? score-1 : score; //이러면 100점도 99점으로 출력
		switch(temp/10) {
		case 9:
			System.out.println(score + "점, A학점");break;
		case 8:
			System.out.println(score + "점, B학점");break;
		case 7:
			System.out.println(score + "점, C학점");break;
		case 6:
			System.out.println(score + "점, D학점");break;
		case 5:
			System.out.println(score + "점, F학점");break;
		case 4:
			System.out.println(score + "점, F학점");break;
		case 3:
			System.out.println(score + "점, F학점");break;
		case 2:
			System.out.println(score + "점, F학점");break;
		case 1:
			System.out.println(score + "점, F학점");break;
		case 0:
			System.out.println(score + "점, F학점");break;
		default:
			System.out.println("유효하지 않은 점수입니다");
		}
	}
}
