package com.lec.ex06_toy;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("비행기입니다.");
		canLight();
		canMissile();
	}
	@Override
	public void canLight() {
		// TODO Auto-generated method stub
		System.out.println("불빛반사 할 수 있습니다.");
	}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("미사일 쏠 수 있습니다.");
	}

}
