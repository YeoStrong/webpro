package com.lec.ex2_parkingsystem;

import com.lec.constant.Constant;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000; // 상수(final 변수)
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
	}
	public Parking(String no, int inTime, int outTime, int fee) {
		this.no = no;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public String in() {
		return String.format("%s님 어서오세요.\n*입차시간: %d시", no, inTime);
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
		System.out.printf("%s님 안녕히 가세요.\n*입차시간: %d시\n*출차시간: %d시\n*주차요금: %d원\n", no, inTime, outTime, fee);
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
