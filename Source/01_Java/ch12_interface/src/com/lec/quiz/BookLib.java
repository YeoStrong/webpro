package com.lec.quiz;
// Book book = new Book("890��-01-11", "java", "ȫ�浿")
public class BookLib extends BookInfo implements ILendable {
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state;			 // ���Ⱑ��(0), ������(1)

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		// TODO Auto-generated method stub
		if(state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + "������ ���� ���� ���Դϴ�.");
			return; // void�� return �ڿ� ���� ���� �� ���� �� return ��ü�� ����
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "������" ���·� ��ȯ
		System.out.println(getBookTitle() + " ������ ���� ó�� �Ǿ����ϴ�.");
		System.out.println("������: " + borrower + "\t������: " + checkOutDate);
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ�� å�Դϴ�. Ȯ���ϼ���.");
			return;
		}
		// state�� ������(1:STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
//		if(state == STATE_NORMAL) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "��) - ���� ����");
//		}else if(state == STATE_BORROWED) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "��) - ���� ��");
//		}
		String msg = getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "��) - ";
		// msg = msg + "���� ��";
		msg += state == STATE_NORMAL ? "���� ����" : "���� ��";
		System.out.println(msg);
	}
	//getters

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}
