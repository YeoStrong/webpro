package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890��-01-11", "java", "ȫ�浿")
public class Book implements ILendable {
	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	private String borrower; // ������
	private Date checkOutDate; // ������
	private byte state;			 // ���Ⱑ��(0), ������(1)
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	@Override
	public void checkOut(String borrower) {
		// TODO Auto-generated method stub
		if(state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "������ ���� ���� ���Դϴ�.");
			return;
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED; // "������" ���·� ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		System.out.println(bookTitle + " ������ �ڴ���� �Ǿ����ϴ�.");
		System.out.println("[������] " + borrower + "\n[������] " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		// TODO Auto-generated method stub
		if(state == STATE_NORMAL) {
			throw new Exception("��" +bookTitle + "�̹� �ݳ��� �Ϸ�� å�Դϴ�. �缭�� �ڰ� �ֳ� Ȯ���ϼ���.");
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff/ (24*60*60*1000); // ���� ��
		if(day>14){
			System.out.println("��ü�� ���� 100�� �ΰ��մϴ�.");
			System.out.println("���ž� �� ��ü��� " + (day-14)*100 + "�� �Դϴ�.");
			System.out.println("��ü�Ḧ �����ϰ� y��ư�� �����ּ���.");
			Scanner sc = new Scanner(System.in);
			if(!sc.next().trim().equalsIgnoreCase("y")) {
				System.out.println(bookTitle + " ���� ��ü�Ḧ �����ؾ� �ݳ��� �Ϸ�˴ϴ�.");
				return;
			}
		}
		// ��ü�� ��� -> ��ü�� �´��� ���ο� ����
		// state�� ������(1:STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "��) - ";
		msg += state == STATE_NORMAL ? "���� ����" : "���� ��";
		if (state == STATE_NORMAL) {
			// msg = msg + "���� ��";
			return msg;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("(yy-MM-dd E����)");
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
