package com.lec.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int    num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int	   readcount;
	private String pw;
	private int    ref;
	private int	   re_step;
	private int	   re_indent;
	private String ip;
	private Timestamp rdate;
	public BoardDto() {}
	public BoardDto(int num, String writer, String subject, String content, String email, int readcount, String pw,
			int ref, int re_step, int re_indent, String ip, Timestamp rdate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.readcount = readcount;
		this.pw = pw;
		this.ref = ref;
		this.re_step = re_step;
		this.re_indent = re_indent;
		this.ip = ip;
		this.rdate = rdate;
	}
	public int getNum() {
		return num;
	}
	public String getWriter() {
		return writer;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getEmail() {
		return email;
	}
	public int getReadcount() {
		return readcount;
	}
	public String getPw() {
		return pw;
	}
	public int getRef() {
		return ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public int getRe_indent() {
		return re_indent;
	}
	public String getIp() {
		return ip;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public void setRe_indent(int re_indent) {
		this.re_indent = re_indent;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", email=" + email + ", readcount=" + readcount + ", pw=" + pw + ", ref=" + ref + ", re_step="
				+ re_step + ", re_indent=" + re_indent + ", ip=" + ip + ", rdate=" + rdate + "]";
	}
}
