package com.lec.dto;

import java.sql.Date;

public class FileboardDto { // join 추가
	private int    fnum;
	private String cid;
	private String fsubject;
	private String fcontent;
	private String ffilename;
	private String fpw;
	private int    fhit;
	private int    fref;
	private int    fre_step;
	private int    fre_level;
	private String fip;
	private Date   frdate;
	private String cname;
	private String cemail;
	public FileboardDto() {}
	// 글쓰기 용
	public FileboardDto(String cid, String fsubject, String fcontent, String ffilename, String fpw, int fref,
			int fre_step, int fre_level, String fip) {
		this.cid = cid;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fpw = fpw;
		this.fref = fref;
		this.fre_step = fre_step;
		this.fre_level = fre_level;
		this.fip = fip;
	}
	// 글 목록이나 글 상세보기 용
	public FileboardDto(int fnum, String cid, String fsubject, String fcontent, String ffilename, String fpw, int fhit,
			int fref, int fre_step, int fre_level, String fip, Date frdate, String cname, String cemail) {
		this.fnum = fnum;
		this.cid = cid;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fpw = fpw;
		this.fhit = fhit;
		this.fref = fref;
		this.fre_step = fre_step;
		this.fre_level = fre_level;
		this.fip = fip;
		this.frdate = frdate;
		this.cname = cname;
		this.cemail = cemail;
	}
	public int getFnum() {
		return fnum;
	}
	public String getCid() {
		return cid;
	}
	public String getFsubject() {
		return fsubject;
	}
	public String getFcontent() {
		return fcontent;
	}
	public String getFfilename() {
		return ffilename;
	}
	public String getFpw() {
		return fpw;
	}
	public int getFhit() {
		return fhit;
	}
	public int getFref() {
		return fref;
	}
	public int getFre_step() {
		return fre_step;
	}
	public int getFre_level() {
		return fre_level;
	}
	public String getFip() {
		return fip;
	}
	public Date getFrdate() {
		return frdate;
	}
	public String getCname() {
		return cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}
	public void setFpw(String fpw) {
		this.fpw = fpw;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public void setFref(int fref) {
		this.fref = fref;
	}
	public void setFre_step(int fre_step) {
		this.fre_step = fre_step;
	}
	public void setFre_level(int fre_level) {
		this.fre_level = fre_level;
	}
	public void setFip(String fip) {
		this.fip = fip;
	}
	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	@Override
	public String toString() {
		return "FileboardDto [fnum=" + fnum + ", cid=" + cid + ", fsubject=" + fsubject + ", fcontent=" + fcontent
				+ ", ffilename=" + ffilename + ", fpw=" + fpw + ", fhit=" + fhit + ", fref=" + fref + ", fre_step="
				+ fre_step + ", fre_level=" + fre_level + ", fip=" + fip + ", frdate=" + frdate + ", cname=" + cname
				+ ", cemail=" + cemail + "]";
	}
}


















