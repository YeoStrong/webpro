package com.lec.method;
// sum(int, int) - sum(10, 100) => 반드시 매개변수 갯수를 지켜줘야 함. but sum(10) - 함수의 오버로딩
// sum(10, 100), sum(10), evenOdd(55) / abs(-9)
public class Arithmetic {
	public int sum(int from, int to) { //from부터 to까지 정수 누적값 return
		int result = 0; // 누적변수
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) { //1~to까지 정수 누적 값 return
		int result = 0; // 누적변수
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		return value%2==0? "짝수입니다" : "홀수입니다";
	}
	public static int abs(int value) { //절대값 return. 접근제한자 생략할 경우? public을 안쓰면 다른 패키지에서는 쓸 수가 없다.
		int result = value>=0? value : -value;
		return result;
		
	}
}
