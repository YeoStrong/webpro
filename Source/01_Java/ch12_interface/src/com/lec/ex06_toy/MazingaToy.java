package com.lec.ex06_toy;

public class MazingaToy implements IMoveArmLeg, IMissile {
	public MazingaToy() {
		System.out.println("��¡���Դϴ�.");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
	}

	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

}
