package com.lec.quiz;
// Book book = new Book("890��-01-11", "java", "ȫ�浿")
public class BookInfo {
	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	
	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	
	//getters
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}
}
