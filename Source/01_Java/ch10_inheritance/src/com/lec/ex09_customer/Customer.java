package com.lec.ex09_customer;

import cons.Constant;

// name, tel, infoString
public class Customer extends Person {
	private String address;
	private int	   sum; // ���� �ݾ� ����
	private int	   point; // ����Ʈ(���� �� 0.5%, static final�� ������ ��)
	private String date; // String�� �����ֺ��ʹ� Date��
	private boolean vip;
	// Customer c = new Customer("ȫ�浿", "010-9999-9999", "����", "12-12")
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		// TODO Auto-generated constructor stub
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name + "�� ���� �����մϴ�. ���� ������� ����Ʈ 1000���� �帳�ϴ�.");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price;
		//int tempPoint = (int)(price * 0.05);
		int tempPoint = (int)(price * Constant.RATE);
		point += tempPoint; // ����Ʈ ����
		System.out.println("���űݾ�: " + price);
		System.out.println(getName() + "�� �����մϴ�. �ݹ� ����Ʈ: " + tempPoint );
		System.out.println("���� ����Ʈ: " + point);
		if(vip == false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName() + "�� VIP������ ���׷��̵� �Ǽ̽��ϴ�. ���� ���� ���ǰ� ���񽺸� �����ϵ��� ����ϰڽ��ϴ�.");
		}//if
	}//buy
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "  [�ּ�]" + address + "  [����Ʈ]" + point + "  [�������űݾ�]" + sum + "  [VIP����]" + vip;
	}
}
