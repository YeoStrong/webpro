package com.lec.ex03_speakertv;
// �������̽� - static final ����(���)�� �߻�޼ҵ�, (����: default method, static method)
// �۾�����/ ������ / ��ü ��ǰȭ �۾� ����
public interface IVolume {
	public void volumeUp(); // ���� ������ 1�� up
	public void volumeUp(int level); // ���� ������ level�� up
	public void volumeDown(); // ���� ������ 1�� down
	public void volumeDown(int level); // ���� ������ level�� down
	public default void setMute(boolean mute) { // default method(�ǹ� �����ڴ� �� ��)
		if(mute) {
			System.out.println("����");
		}else {
			System.out.println("��������");
		}
	}
	public static void changeBattery() { // static method(�ǹ� �����ڴ� �� ��)
		System.out.println("�������� ��ȯ�մϴ�.");
	}
}
