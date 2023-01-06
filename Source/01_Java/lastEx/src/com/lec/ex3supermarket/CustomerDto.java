package com.lec.ex3supermarket;

public class CustomerDto {
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelname;
	private int needamount;
	public CustomerDto() {}
	public CustomerDto(String ctel, String cname, int cpoint, int camount, String levelname, int needamount) {
		super();
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.needamount = needamount;
	}
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int camount, String levelname, int needamount) {
		super();
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.needamount = needamount;
	}
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", ctel=" + ctel + ", cname=" + cname + ", cpoint=" + cpoint + ", camount="
				+ camount + ", levelname=" + levelname + ", needamount=" + needamount + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	public int getCamount() {
		return camount;
	}
	public void setCamount(int camount) {
		this.camount = camount;
	}
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	public int getNeedamount() {
		return needamount;
	}
	public void setNeedamount(int needamount) {
		this.needamount = needamount;
	}
	
}
