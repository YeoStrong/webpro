package com.lec.ex1_runnable;

public class Ex01_TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target();
		//Runnable target = new Target();
		// "��A"��� �̸��� Thread�� ���� - target.run()�� ���ÿ� ������ Thread
		Thread t1 = new Thread(target, "��A");
		// "~B"��� �̸��� Thread�� ���� - target.run()�� ���ÿ� ������ Thread
		Thread t2 = new Thread(target, "~B");
		t1.start();
		t2.start();
		System.out.println("main�Լ� �������: " + Thread.currentThread().getName());
		System.out.println("main�Լ� ��");
	}
}