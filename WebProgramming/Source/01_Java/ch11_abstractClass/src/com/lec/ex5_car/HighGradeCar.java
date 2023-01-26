package com.lec.ex5_car;
// HighGradeCar high = new HighGradeCar("����", "�Ϲ�Ÿ�̾�", 1000, "�Ŀ��ڵ�");
// high.getSpec();
public class HighGradeCar extends Car {
	private int tax;
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
		tax = 70000;
	}

	@Override
	public void getSpec() { // tax�� ������ Spec�� ���
		// TODO Auto-generated method stub
		if(getDisplacement() > 1500) {
			tax += (getDisplacement() - 1500) * 500;
		}
		System.out.println("�� ��: " + getColor());
		System.out.println("Ÿ�̾�: "+ getTire());
		System.out.println("��ⷮ: " + getDisplacement());
		System.out.println("�� ��: " + getHandle());
		System.out.println("�� ��: " + tax);
		System.out.println("===============================");
	}

}
