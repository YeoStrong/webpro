package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);
		System.out.println("pObj1�� pObj2�� ������? " + pObj1.equals(pObj2));
		pObj1.method1();
		pObj2.method1(); // �Ѵ� parent���� �������� method�� ����
		pObj2.method2();
		System.out.println("----------------------------------");
		Child cObj1 = new Child(); // Parent() -> Child()
		Child cObj2 = new Child(2); // Parent() -> Child(2)
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
		// pObj1.method3();
		System.out.println("cObj1�� pObj1�� ������? " + cObj1.equals(pObj1)); //equals�� Child���� override�ؼ� ������ true�� �������� �߱� ������ ������ true�� ����.
		System.out.println("--------------------------------------------");
		Parent obj = new Child();
		obj.method1();
		obj.method2();
		// obj.method3(); //obj������ Ÿ�� ������ �Ұ�
		// ((Child) obj).method3(); // ��ü�� ������ ����ȯ(very dangerous)
		if(obj instanceof Child) { // ��ü�� ������ ����ȯ, instanceof ���(safe)
			((Child)obj).method3();
		}else {
			System.out.println("����ȯ �Ұ�");
		}
	}
}