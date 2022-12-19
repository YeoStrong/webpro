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
//			System.out.println("친구의 이름을 입력해주세요(입력 완료 및 친구 검색: x키 입력): ");
//			String name = sc.next();
//			if (!name.equalsIgnoreCase("x")) {
//				Scanner sc1 = new Scanner(System.in);
//				System.out.println("전화번호를 입력해주세요: ");
//				String tel = sc1.next();
//				Scanner sc2 = new Scanner(System.in);
//				System.out.println("주소를 입력해주세요: ");
//				String address = sc2.next();
//				Scanner sc3 = new Scanner(System.in);
//				System.out.println("태어난 년도를 입력해주세요: ");
//				int y = sc3.nextInt();
//				Scanner sc4 = new Scanner(System.in);
//				System.out.println("태어난 월을 입력해주세요: ");
//				int m = sc4.nextInt();
//				Scanner sc5 = new Scanner(System.in);
//				System.out.println("태어난 날짜(일)를 입력해주세요: ");
//				int d = sc5.nextInt();
//				friend.setName(name);
//				friend.setPhone(tel);
//				friend.setAddress(address);
//				Friends.add(new Friend(name, tel, address, y,m,d));
//			} else {
//				if (Friends.size() == 0) {
//					System.out.println("친구 목록이 비었습니다.");
//					
//				} else {
//					for (int i = 0; i < Friends.size(); i++) {
//						System.out.println(Friends.get(i));
//					}
//					while (true) {
//						boolean searchOk = false; // 검색한 결과가 있으면 true
//						System.out.println("(종료: x입력)검색하고자 하는 전화번호 뒷자리를 입력하세요: "); // 8888, 9999, 4238...
//						String searchTel = sc.next(); // 8888
//						if(searchTel.equalsIgnoreCase("x")) {
//							System.out.println("종료되었습니다.");
//							break;
//						}
//						for (int i = 0; i < friend.getAddress().length(); i++) {
//							String postAdd = friend.getAddress().substring(friend.getAddress().lastIndexOf("-") + 1);
//							if (postAdd.equals(searchTel)) {
////								System.out.println("검색하신 전화번호는 " + tels[i]);
//								searchOk = true; // 전화번호 출력 여부
//							}
//						}
//				}
//				break;
//			}
//		}
//	}
//}
