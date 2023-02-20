package com.lec.customer;

import java.sql.Date;

public class CustomerDto {
	private String cid;
	private String cpw;
	private String cname;
	private String ctel;
	private String cemail;
	private String caddress;
	private Date   cbirth;
	private String cgender;
	private Date   crdate;
	public CustomerDto() {}
	public CustomerDto(String cid, String cpw, String cname, String ctel, String cemail, String caddress, Date cbirth,
			String cgender, Date rdate) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.ctel = ctel;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cbirth = cbirth;
		this.cgender = cgender;
		this.crdate = rdate;
	}
	public String getCid() {
		return cid;
	}
	public String getCpw() {
		return cpw;
	}
	public String getCname() {
		return cname;
	}
	public String getCtel() {
		return ctel;
	}
	public String getCemail() {
		return cemail;
	}
	public String getCaddress() {
		return caddress;
	}
	public Date getCbirth() {
		return cbirth;
	}
	public String getCgender() {
		return cgender;
	}
	public Date getRdate() {
		return crdate;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public void setCbirth(Date cbirth) {
		this.cbirth = cbirth;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public void setRdate(Date rdate) {
		this.crdate = rdate;
	}
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", ctel=" + ctel + ", cemail=" + cemail
				+ ", caddress=" + caddress + ", cbirth=" + cbirth + ", cgender=" + cgender + ", rdate=" + crdate + "]";
	}
}
