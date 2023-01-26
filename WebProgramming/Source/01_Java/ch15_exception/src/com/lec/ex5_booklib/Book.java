package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890ㅁ-01-11", "java", "홍길동")
public class Book implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate; // 대출일
	private byte state;			 // 대출가능(0), 대출중(1)
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	@Override
	public void checkOut(String borrower) {
		// TODO Auto-generated method stub
		if(state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "도서는 현재 대출 중입니다.");
			return;
		}
		// state가 0(STATE_NORMAL)이라서 대출 진행
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED; // "대출중" 상태로 전환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		System.out.println(bookTitle + " 도서가 ★대출★ 되었습니다.");
		System.out.println("[대출인] " + borrower + "\n[대출일] " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		// TODO Auto-generated method stub
		if(state == STATE_NORMAL) {
			throw new Exception("★" +bookTitle + "이미 반납이 완료된 책입니다. 사서가 자고 있나 확인하세요.");
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff/ (24*60*60*1000); // 빌린 날
		if(day>14){
			System.out.println("연체료 일일 100원 부가합니다.");
			System.out.println("내셔야 할 연체료는 " + (day-14)*100 + "원 입니다.");
			System.out.println("연체료를 납입하고 y버튼을 눌러주세요.");
			Scanner sc = new Scanner(System.in);
			if(!sc.next().trim().equalsIgnoreCase("y")) {
				System.out.println(bookTitle + " 도서 연체료를 납입해야 반납이 완료됩니다.");
				return;
			}
		}
		// 연체료 출력 -> 연체료 냈는지 여부에 따라
		// state가 대출중(1:STATE_BORROWED)이라 반납 처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " 도서가 반납 완료되었습니다.");
	}

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "著) - ";
		msg += state == STATE_NORMAL ? "대출 가능" : "대출 중";
		if (state == STATE_NORMAL) {
			// msg = msg + "대출 중";
			return msg;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("(yy-MM-dd E요일)");
			return msg + sdf.format(checkOutDate);
		}
	}
	//getters
	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}
}
