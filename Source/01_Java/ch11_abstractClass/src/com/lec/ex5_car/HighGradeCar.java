package com.lec.ex5_car;
// HighGradeCar high = new HighGradeCar("빨강", "일반타이어", 1000, "파워핸들");
// high.getSpec();
public class HighGradeCar extends Car {
	private int tax;
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
		tax = 70000;
	}

	@Override
	public void getSpec() { // tax를 포함한 Spec들 출력
		// TODO Auto-generated method stub
		if(getDisplacement() > 1500) {
			tax += (getDisplacement() - 1500) * 500;
		}
		System.out.println("색 상: " + getColor());
		System.out.println("타이어: "+ getTire());
		System.out.println("배기량: " + getDisplacement());
		System.out.println("핸 들: " + getHandle());
		System.out.println("세 금: " + tax);
		System.out.println("===============================");
	}

}
