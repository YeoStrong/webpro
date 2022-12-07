package com.lec.ex08_super;
//this.~ : 내 객체의 ~
//this() : 현 class의 생성자 함수 (함수 내 첫 번째 명령이어야 함)
//super.~ : 부모클래스의 ~
//super() : 부모클래스의 생성자 함수 (함수 내 첫 번째 명령이어야 함)
public class Person {
	private String name;
	private String character;
	public Person() {
		System.out.println("매개변수 없는 Person 생성자");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개 짜리 Person 생성자");
	}
	public void intro() {
		System.out.println("★" + name + "은 " + character);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
