package com.lec.ex1_square;
// 속성변수, 생성자, 메소드, (getter&setter=>안 쓸수도 있음, but 많이 쓴다.)
// Square s = new Square(); //s의 side는 무조건 0, String이라면 0 으로 초기화
// Square s1 = new Square(10); //s의 side를 10으로 초기화 하면서 객체 생성
public class Square {
	private int side;
	public Square() {  // 생성자 함수: return type이 없고 클래스명과 같은 함수
		System.out.println("매개변수 없는 생성자 함수 호출");
	} //안 쓸거면 안 써도 되지만 매개변수 있는 생성자 함수를 만들 때도, 매개변수 없는 생성자 함수도  만들어 줘야 함.
	public Square(int side) { // 매개변수가 있는 생성자 함수 용도: 데이터의 초기화
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출");
	}
	public int area() {
		return side*side;
	}
	// setter : s1.setSide(5);
	public void setSide(int side) {
		this.side = side;
	}
	// getter : sysout(s1.getSide())
	public int getSide() {
		return side;
	}
}
