package com.lec.ex5_car;
// LowGradeCar low = new LowGradeCar("����", "�Ϲ�Ÿ�̾�", 1000, "�Ŀ��ڵ�");
// low.getSpec();
public class LowGradeCar extends Car {
	private int tax;
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
		tax = 0;
	}

	@Override
	public void getSpec() { // tax�� ������ Spec�� ���
		// TODO Auto-generated method stub
		if(getDisplacement() > 900) {
			tax += (getDisplacement() - 900) * 500;
		}
		System.out.println("�� ��: " + getColor());
		System.out.println("Ÿ�̾�: "+ getTire());
		System.out.println("��ⷮ: " + getDisplacement());
		System.out.println("�� ��: " + getHandle());
		System.out.println("�� ��: " + tax);
		System.out.println("===============================");
	}

}