package com.lec.ex;
// Ŭ���� : �Ӽ�, (������:���� �ð���), �޼ҵ�, setter&getter
public class Rect {
	private int width;
	private int height;
	// �����ڰ� ���� ��� JVM�� �ڵ� ��������.
	public Rect() {} //�ڵ����� �����Ǵ� ������, �ƹ� �͵� ����// default ������
	public Rect(int side) { //�Ű����� 1��¥�� ������ �Լ�
		width = side;
		height = side;
	}
	public Rect(int width, int height) { //�Ű����� 2�� ¥�� ������ �Լ�
		this.width = width;
		this.height = height; //�����ڴ� ���ø� �ʱ�ȭ ��.
	}
	public int area() {
		return width*height;
	}
	// getter & setter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}