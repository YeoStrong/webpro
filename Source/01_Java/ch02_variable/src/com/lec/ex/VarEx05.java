package com.lec.ex;
// 기본데이터타입(기초데이터타입; 소문자로 시작) VS. 참조데이터타입(객체데이터타입; 대문자로 시작)
public class VarEx05 {
	public static void main(String[] args) {
		// 기본데이터타입
		int i; //무조건 4바이트 잡음
		i = 10;
		// 참조데이터타입(객체데이터타입)
		String name;
		name = "홍길동";
		name = "김수한무거북이";
		System.out.println(i);
		System.out.println(name);
	}
}
