package com.lec.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTestMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("ȸ�������� ���ϸ� ������ �Է����ּ���(ȸ������ �ź�=nŰ �Է�): ");
			String name = scanner.next();
			if (!name.equalsIgnoreCase("n")) {
				System.out.println("��ȭ��ȣ�� �Է����ּ���: ");
				String tel = scanner.next();
				System.out.println("�ּҸ� �Է����ּ���: ");
				String address = scanner.next();
				customers.add(new Customer(name, tel, address));
			} else {
				if (customers.size() == 0) {
					System.out.println("������ ȸ�� ����� �����ϴ�.");
					
				} else {
					for (int i = 0; i < customers.size(); i++) {
						System.out.println(customers.get(i));
					}
				}
				break;
			}
		}
	}
}
