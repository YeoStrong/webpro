package com.lec.ex4_shape;

public class Rectangle extends Shape {
	private int w; // 가로
	private int h; // 세로
	public Rectangle() {}
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return h * w;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print("직사각형 ");
		super.draw();
	}
}
