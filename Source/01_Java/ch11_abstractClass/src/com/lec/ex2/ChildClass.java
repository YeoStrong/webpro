package com.lec.ex2;
// method1(추상), method2, method3(일반)
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상메소드라서 override함");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 그냥 override함");
	}
}
