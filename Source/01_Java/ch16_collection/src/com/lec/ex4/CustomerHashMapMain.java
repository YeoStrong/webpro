package com.lec.ex4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		while (true) {
			Scanner scname = new Scanner(System.in);
			System.out.println("ȸ�������� ���ϸ� ������ �Է����ּ���(ȸ������ �ź�=nŰ �Է�): ");
			String name = scname.next();
			if (!name.equalsIgnoreCase("n")) {
				Scanner sctel = new Scanner(System.in);
				System.out.println("��ȭ��ȣ�� �Է����ּ���: ");
				String tel = sctel.next();
				//������ ������ ��ȭ��ȣ���� Ȯ���ϴ� ���
				if (customers.get(tel)!=null) {
					System.out.println("�̹� ���Ե� ��ȭ��ȣ�Դϴ�. ��ȭ��ȣ�� �ߺ��Ͽ� ������ �� �����ϴ�.");
				}
				Scanner scaddress = new Scanner(System.in);
				System.out.println("�ּҸ� �Է����ּ���: ");
				String address = scaddress.next();
				customers.put(tel, new Customer(name, tel, address));
			} else {
				if (!customers.isEmpty()) {
					Iterator<String> iterator = customers.keySet().iterator();
					while (iterator.hasNext()) {
						String key = iterator.next();
						System.out.println(customers.get(key));
					}
				}else {
					System.out.println("������ ȸ�� ����� �����ϴ�.");
					break;
				}
			}
		}
	}
}
