package com.lec.quiz;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890ㅁ-01-11", "java", "홍길동"),
						new BookLib("890ㅁ-01-12", "oracle", "오길동"),
						new BookLib("890ㅁ-02-01", "mysql", "마길동"),
						new BookLib("890ㅁ-01-01", "jdbc", "제이디"),
						new BookLib("890ㅁ-01-04", "html", "이에이")};
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호 (1:대출 / 2:반납 / 3:책list / 0:종료)
		int idx; // 대출하거나 반납할 때, 조회된 책의 index
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책 이름, 대출인, 대출일
		do {
			System.out.print("1:대출 / 2:반납 / 3:책list / 0:종료\t===>");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // 대출 : 1.책이름 입력	2.책조회	3.책상태확인	4.대출인입력	5.대출일입력	6.대출메소드 호출
				// 1.책이름 입력
				System.out.print("대출하고자 하는 책 이름을 입력해주세요: ");
				bTitle = scanner.next(); // white-space 앞까지의 String만 받음
				// 2.책조회
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle()) ) {
						break;
					}
				}//for
				if(idx == books.length) {
					System.out.println("현재 보유하지 않은 책입니다.");
				}else { // books[idx] 도서를 대출
					// 3.책상태확인
					if(books[idx].getState() == BookLib.STATE_BORROWED) { //대출 중
						System.out.println("현재 대출 중인 책입니다.");
					}else {
						// 4.대출인입력	
						System.out.print("대출인은?: ");
						borrower = scanner.next();
						// 5.대출일입력
						System.out.println("대출일은?: ");
						checkOutDate = scanner.next(); // 2022-12-01(o), 2002 12 01(x) (next를 쓰고 있기 때문에 space 사용 불가)
						// 6.대출메소드 호출
						books[idx].checkOut(borrower, checkOutDate);
					}//if - 상태확인
				}//if - 도서 조회
				break;
			case 2: // 반납
				// 1.책이름 입력
				System.out.print("반납하고자 하는 책 이름을 입력해주세요: ");
				bTitle = scanner.next(); // white-space 앞까지의 String만 받음
				// 2.책조회
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle()) ) {
						break;
					}
				}//for
				if(idx == books.length) {
					System.out.println("해당 책은 본 도서관의 책이 아닙니다.");
				}else {
					// 3.반납메소드 호출
					books[idx].checkIn();
				}
				break;
			case 3: // 책list 출력 : for문을 이용하여 printState()메소드 호출	//for(Book book : books){} 
				for(BookLib book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("프로그램 종료");
		scanner.close();
	}
}
