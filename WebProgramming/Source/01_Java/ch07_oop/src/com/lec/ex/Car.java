package com.lec.ex;
// ��¥ class �����(�ؾ�� ��ü, �ؾƲ�� class), data���� ���� �״��� method
// Ŭ���� : �Ӽ�(������)�� �޼ҵ�(���)
// Car myCar = new Car();
// myCar.park()
public class Car {
	private String color;
	private int    cc; // ��ⷮ
	private int    speed;
	public void park() {
		speed = 0;
		System.out.println(color + "�� �� �����մϴ�. ���� �ӵ�: " + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "�� �� �����մϴ�. ���� �ӵ�: " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "�� �� ���̽��մϴ�. ���� �ӵ�: " + speed);
	}
	//getter & setter (color:getColor/setColor, cc: getCc/setCc, speed: getSpeed/setSpeed). myCar.setColor("����")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color; //this.color: �� ��ü ���� color
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
