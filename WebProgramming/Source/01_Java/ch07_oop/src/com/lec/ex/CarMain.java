package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("빨강");//myPorsche.color = "빨강";
		System.out.println(myPorsche.getColor() + "색 차량 배기량: " + myPorsche.getCc());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car yourPorsche = new Car();
		yourPorsche.setColor("진회");//yourPorsche.color = "진회";
		System.out.println(yourPorsche.getColor() + "색 차량 배기량: " + yourPorsche.getCc());
		yourPorsche.drive();
		System.out.println("내 차 속도: " + myPorsche.getSpeed());
	}
}
