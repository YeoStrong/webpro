package com.lec.ex10_final;
// speed, running(), stop(final, override �Ұ���)
public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�������� �ٸ鼭 ������ �����. ���� �ӵ�: " + speed);
	}
}
