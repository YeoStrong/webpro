package com.lec.ex1_string;

public class Ex08_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		// str의 주소 출력 (X) => 해쉬코드로 ㄷ체
		System.out.println("str의 해쉬코드: " + str.hashCode());
		str = "Hello";
		System.out.println("str의 해쉬코드: " + str.hashCode());
	}
}
