package com.lec.ex09_customer;

import cons.Constant;

// name, tel, infoString
public class Customer extends Person {
	private String address;
	private int	   sum; // 구매 금액 누적
	private int	   point; // 포인트(구매 시 0.5%, static final로 지정할 것)
	private String date; // String을 다음주부터는 Date형
	private boolean vip;
	// Customer c = new Customer("홍길동", "010-9999-9999", "서울", "12-12")
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		// TODO Auto-generated constructor stub
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name + "님 가입 감사합니다. 가입 기념으로 포인트 1000점을 드립니다.");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price;
		//int tempPoint = (int)(price * 0.05);
		int tempPoint = (int)(price * Constant.RATE);
		point += tempPoint; // 포인트 누적
		System.out.println("구매금액: " + price);
		System.out.println(getName() + "님 감사합니다. 금번 포인트: " + tempPoint );
		System.out.println("누적 포인트: " + point);
		if(vip == false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName() + "님 VIP고객으로 업그레이드 되셨습니다. 더욱 좋은 물건과 서비스를 제공하도록 노력하겠습니다.");
		}//if
	}//buy
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "  [주소]" + address + "  [포인트]" + point + "  [누적구매금액]" + sum + "  [VIP여부]" + vip;
	}
}
