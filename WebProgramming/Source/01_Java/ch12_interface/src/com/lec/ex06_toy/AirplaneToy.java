package com.lec.ex06_toy;

public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("������Դϴ�.");
		canLight();
		canMissile();
	}
	@Override
	public void canLight() {
		// TODO Auto-generated method stub
		System.out.println("�Һ��ݻ� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�̻��� �� �� �ֽ��ϴ�.");
	}

}
