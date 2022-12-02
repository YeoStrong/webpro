package com.lec.ex;
// 진짜 class 만들기(붕어빵은 객체, 붕어빵틀은 class), data부터 적고 그다음 method
// 클래스 : 속성(데이터)과 메소드(기능)
// Car myCar = new Car();
// myCar.park()
public class Car {
	private String color;
	private int    cc; // 배기량
	private int    speed;
	public void park() {
		speed = 0;
		System.out.println(color + "색 차 주차합니다. 현재 속도: " + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "색 차 운전합니다. 현재 속도: " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "색 차 레이싱합니다. 현재 속도: " + speed);
	}
	//getter & setter (color:getColor/setColor, cc: getCc/setCc, speed: getSpeed/setSpeed). myCar.setColor("빨강")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color; //this.color: 내 객체 안의 color
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
