package com.lec.ex;
// 논리연산자 : &&(AND), ||(OR)
public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		System.out.println("&& : (i<j) && (++j>h) 는 " + ((i<j) && (++j>h)) );
		System.out.println("j = " + j); // j = 11
		
		System.out.println("&& : (i>j) && (++j>h) 는 " + ((i>j) && (++j>h)) );	// &&(AND)연산의 경우 좌항이 false면 무조건 false기 때문에 우항은 쳐다도 안 봄.
		System.out.println("j = " + j); // 따라서 여기서 j값은 증감연산자가 작동하지 않은 11이 됨.
		
		System.out.println("|| : (i<j) || (++j>h) 는 " + ((i<j) || (++j>h)) );	// ||(OR)연산의 경우 좌항이 true면 무조건 true기 때문에 우항은 쳐다도 안 봄.
		System.out.println("j = " + j); // 따라서 여기서 j값은 증감연산자가 작동하지 않은 11이 됨.
		
		System.out.println("|| : (i>j) || (++j>h) 는 " + ((i>j) || (++j>h)) );
		System.out.println("j = " + j); 
	}
}
