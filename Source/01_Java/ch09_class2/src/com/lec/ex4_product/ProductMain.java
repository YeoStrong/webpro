package com.lec.ex4_product;

public class ProductMain {
	public static void main(String[] args) {
		System.out.println(Product.count);
		Product.staticMethod();
		Product p1 = new Product();
		p1.infoPrint();
		Product p2 = new Product();
		System.out.println("static ���� : " + Product.count);
//		System.out.println("static ���� : " + p1.count); //������ �ѵ� ����õ
//		System.out.println("static ���� : " + p2.count);
	}
}
