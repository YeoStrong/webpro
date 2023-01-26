package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("=== 1. ȸ������ ===");
		String ctel = "010-3512-3467", cname= "�̼���";
//		result = dao.insertCustomer(ctel, cname);
//		System.out.println(result==CustomerDao.SUCCESS ? cname+"�� ȸ������ �����մϴ�. ����Ʈ 1000���� �����Ǿ����ϴ�." : cname+"�� ȸ�������� �����߽��ϴ�.");
		ctel="010-3479-1290"; cname="������";
//		result= dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0 , null, 0));
//		System.out.println(result==CustomerDao.SUCCESS ? cname+"�� ȸ������ �����մϴ�. ����Ʈ 1000���� �����Ǿ����ϴ�." : cname+"�� ȸ�������� �����߽��ϴ�.");
		System.out.println("=== 2. ��ȭ��ȣ �˻� ===");
		ctel = "9999";
		customers = dao.ctelGetCustomers(ctel);
		if(customers.isEmpty()) {
			System.out.println(ctel+" ��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������� �ϼ���.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 3. ��ǰ���� ===");
		result = dao.buy(1, 200000); // 1�� ���� 20���� ����
		if(result==CustomerDao.SUCCESS) { // ��ǰ ���Ű� �����Ǹ� �����޼����� �Բ� �� ���� ���
			CustomerDto customer = dao.getCustomer(1);
			System.out.println("��ǰ ���� �����մϴ�. ���� ������ �Ʒ��� ���� ������Ʈ �Ǿ����ϴ�.");
			System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
			System.out.println(customer);
		} else {
			System.out.println("cid�� ��ȿ���� �ʽ��ϴ�.");
		}
		System.out.println("=== 4. ������ ��� ===");
		System.out.println("��������: " + dao.getLevelNames());
		customers = dao.levelNameGetCustomer("vip");
		if(customers.size()==0) {
			System.out.println("VIP ���� ���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 5. ��ü��� ===");
		customers = dao.getCustomers();
		if(customers.isEmpty()) {
			System.out.println("���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 6. ȸ�� Ż�� ===");
		result = dao.deleteCustomer("010-9999-9999");
		System.out.println(result==CustomerDao.SUCCESS ? "��������" : "��ȿ�� ��ȭ��ȣ�� �ƴմϴ�.");
		customers = dao.getCustomers();
		if(customers.isEmpty()) {
			System.out.println("���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t��ȭ\t\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������ʿ�ݾ�");
			for (CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
	}
}
