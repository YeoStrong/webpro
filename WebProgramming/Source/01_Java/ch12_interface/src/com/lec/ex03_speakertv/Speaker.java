package com.lec.ex03_speakertv;

public class Speaker implements IVolume{
	private int volumeLevel;
	private final int MAX_VOLUME = 50;
	private final int MIN_VOLUME = 0;
	public Speaker() {
		volumeLevel = 10;
	}

	@Override
	public void volumeUp() { //volume�� 1�� up
		// TODO Auto-generated method stub
		if(volumeLevel < MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ������ 1��ŭ �÷� ���� ������ " + volumeLevel);
		}else {
			System.out.println("���� ����Ŀ ������ �ִ�ġ(" + MAX_VOLUME + ")�̾ �ø��� ���߽��ϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub
		if(volumeLevel + level < MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("����Ŀ ������ "+ level + "��ŭ �÷� ���� ������ " + volumeLevel);
		}else {
			int tempLevel = MAX_VOLUME - volumeLevel; // 50 - 47
			volumeLevel = MAX_VOLUME;
			System.out.println("����Ŀ ������ " + tempLevel + "��ŭ �÷� �ִ�ġ("+ MAX_VOLUME + "�Դϴ�.");
		}
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		if(volumeLevel > MIN_VOLUME) {
			volumeLevel --;
			System.out.println("����Ŀ ������ 1��ŭ ���� ���� ���� " + volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ּ��Դϴ�.");
		}
	}

	@Override
	public void volumeDown(int level) { 
		// TODO Auto-generated method stub
		if(volumeLevel - level > MIN_VOLUME) { // ���� ������ 5, level 4
			volumeLevel -= level;
			System.out.println("����Ŀ ������ " + level + "��ŭ ���� ���� ���� " + volumeLevel);
		}else { //���� ���� 5, level 7
			int tempLevel = volumeLevel - MIN_VOLUME;
			volumeLevel = MIN_VOLUME;
			System.out.println("����Ŀ ������ " + tempLevel + "��ŭ ���� �ּ��Դϴ�.");
		}
	}
}
