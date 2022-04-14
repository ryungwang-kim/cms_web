package com.cms.app.board.model;

public class BoardVO {

	private int bid;
	private String b_title;
	private String b_content;
	private String b_write;
	private String reg_date;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_write() {
		return b_write;
	}
	public void setB_write(String b_write) {
		this.b_write = b_write;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ContentVO [bid=" + bid + ", b_title=" + b_title + ", b_content=" + b_content + ", b_write=" + b_write
				+ ", reg_date=" + reg_date + "]";
	}
	
	
	
}
