package com.lec.ex01;
// CONSTANT_NUM, CONSTANT_STRING, method1(), method2()
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public String method2() {
		// TODO Auto-generated method stub
		System.out.println("���� ������ implements�� Ŭ�������� �� - method2");
		return null;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("���� ������ implements�� Ŭ�������� �� - method1");
	}
}