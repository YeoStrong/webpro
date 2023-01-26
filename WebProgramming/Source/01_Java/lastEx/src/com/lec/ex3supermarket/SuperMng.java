package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner sc = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.println("1: ȸ������, 2: ����4�ڸ�(FULL)�˻�, 3:��ǰ����, 4:������ ���, 5: ��ü���, 6:Ż��, �׿�: ����  ��");
			fn = sc.next();
			switch(fn) {
			case "1":
				System.out.println("������ ȸ���� ��ȭ��ȣ: ");
				String ctel = sc.next();
				System.out.println("������ ȸ���� �̸�: ");
				String cname = sc.next();
				int result = dao.insertCustomer(ctel, cname);
				//int result = dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0, null, 0));
				System.out.println(result==CustomerDao.SUCCESS ? cname+"�� �����մϴ�, ����Ʈ 1000�� ���޵Ǿ����ϴ�." : cname+"�� ȸ������ �����߽��ϴ�.");
				break;
			case "2":
				System.out.println("�˻��� ��ȭ��ȣ �� 4�ڸ��� ��ȭ��ȣ ��ü: ");
				String searchTel = sc.next();
				customers = dao.ctelGetCustomers(searchTel);
				if(customers.isEmpty()) {
					System.out.println(searchTel+"��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������� �ϼ���.");
				} else {
					System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.println("�����̵�(�� ���, �˻�): ");
				int cid = sc.nextInt();
				System.out.println("��ǰ����: ");
				int price = sc.nextInt();
				result = dao.buy(cid, price);
				if(result==CustomerDao.SUCCESS) {
					System.out.println("��ǰ���� �����մϴ�." + price + "�� �����Ͽ� ���� �����Ͱ� �Ʒ��� ���� ���׷��̵� �Ǿ����ϴ�.");
					CustomerDto customer = dao.getCustomer(cid);
					System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
					System.out.println(customer);
				} else {
					System.out.println(cid+"�� ��ȿ�� �����̵� �ƴմϴ�.");
				}
				break;
			case "4":
				System.out.println("�˻��ϰ��� �ϴ� ����" + dao.getLevelNames() + " : ");
				String levelName = sc.next();
				customers = dao.levelNameGetCustomer(levelName);
				if(customers.size()==0) {
					System.out.println("�ش� ����" + levelName + "�� ���� �˻����� �ʽ��ϴ�.");
				} else {
					System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				System.out.println("��ü ���");
				customers = dao.getCustomers();
				if(customers.isEmpty()) {
					System.out.println("���� �˻����� �ʽ��ϴ�.");
				} else {
					System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.println("Ż���� �� ��ȭ��ȣ: ");
				ctel = sc.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result==CustomerDao.SUCCESS ? "ȸ��Ż�� �Ϸ�Ǿ����ϴ�." : "��ȿ�� ��ȭ��ȣ�� �ƴմϴ�.");
				break;
			}
				
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6"));
		System.out.println("BYE");
	}
}
