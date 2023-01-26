package com.lec.ex09_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer1 = new Customer("ȫ�浿", "010-9999-9999", "����� ���빮��", "12-01");
		System.out.println(customer1.infoString());
		customer1.buy(500000);
		customer1.buy(510000);
		Staff staff1 = new Staff("�ڻ��", "010-8888-8888", "2022-12-06", "�Ǹź�");
		Person[] person = {customer1, staff1};
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		Person customer2 = new Customer("�ű浿", "010-7777-7777", "����� ��������", "12-07");
		//customer2.buy(20000);
		if(customer2 instanceof Customer) {
			((Customer)customer2).buy(20000);
		}else {
			System.out.println("buy�� �� ���� ��ü�Դϴ�.");
		}
	}
}
