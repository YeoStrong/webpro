package com.lec.ex4_object;

public class QuizPoint3Dmain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(3);    
		p1.setY(2);
		p1.setZ(4);
		Point3D p2 = (Point3D) p1.clone();
		Point3D p3 = new Point3D();
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p3 : " + p3);
		if(p1.equals(p2)) {
			System.out.println("���� ������ �簢�� ��ü(������ �Ѱ��� ���縦 �Ѱ����� ��)");
		}else {
			System.out.println("�ٸ� ������ �簢�� ��ü");
		}
		if(p1==p2) {
			System.out.println("������ �� �ƴϰ� ����");
		}else {
			System.out.println("�ٸ� �ּ�");
		}
		if(p1!=p2 && p1.equals(p2)) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
}
