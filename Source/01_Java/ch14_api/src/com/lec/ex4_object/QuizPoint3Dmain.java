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
			System.out.println("같은 내용의 사각형 객체(복제를 한건지 복사를 한건지는 모름)");
		}else {
			System.out.println("다른 내용의 사각형 객체");
		}
		if(p1==p2) {
			System.out.println("복제한 게 아니고 복사");
		}else {
			System.out.println("다른 주소");
		}
		if(p1!=p2 && p1.equals(p2)) {
			System.out.println("복제 성공");
		}else {
			System.out.println("복제 실패");
		}
	}
}
