//package com.lec.quiz;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Test {
//	public static void main(String[] args) {
//		ArrayList<Friend> Friends = new ArrayList<>();
//		Friend friend = new Friend();
//		while (true) {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("ģ���� �̸��� �Է����ּ���(�Է� �Ϸ� �� ģ�� �˻�: xŰ �Է�): ");
//			String name = sc.next();
//			if (!name.equalsIgnoreCase("x")) {
//				Scanner sc1 = new Scanner(System.in);
//				System.out.println("��ȭ��ȣ�� �Է����ּ���: ");
//				String tel = sc1.next();
//				Scanner sc2 = new Scanner(System.in);
//				System.out.println("�ּҸ� �Է����ּ���: ");
//				String address = sc2.next();
//				Scanner sc3 = new Scanner(System.in);
//				System.out.println("�¾ �⵵�� �Է����ּ���: ");
//				int y = sc3.nextInt();
//				Scanner sc4 = new Scanner(System.in);
//				System.out.println("�¾ ���� �Է����ּ���: ");
//				int m = sc4.nextInt();
//				Scanner sc5 = new Scanner(System.in);
//				System.out.println("�¾ ��¥(��)�� �Է����ּ���: ");
//				int d = sc5.nextInt();
//				friend.setName(name);
//				friend.setPhone(tel);
//				friend.setAddress(address);
//				Friends.add(new Friend(name, tel, address, y,m,d));
//			} else {
//				if (Friends.size() == 0) {
//					System.out.println("ģ�� ����� ������ϴ�.");
//					
//				} else {
//					for (int i = 0; i < Friends.size(); i++) {
//						System.out.println(Friends.get(i));
//					}
//					while (true) {
//						boolean searchOk = false; // �˻��� ����� ������ true
//						System.out.println("(����: x�Է�)�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ��� �Է��ϼ���: "); // 8888, 9999, 4238...
//						String searchTel = sc.next(); // 8888
//						if(searchTel.equalsIgnoreCase("x")) {
//							System.out.println("����Ǿ����ϴ�.");
//							break;
//						}
//						for (int i = 0; i < friend.getAddress().length(); i++) {
//							String postAdd = friend.getAddress().substring(friend.getAddress().lastIndexOf("-") + 1);
//							if (postAdd.equals(searchTel)) {
////								System.out.println("�˻��Ͻ� ��ȭ��ȣ�� " + tels[i]);
//								searchOk = true; // ��ȭ��ȣ ��� ����
//							}
//						}
//				}
//				break;
//			}
//		}
//	}
//}
