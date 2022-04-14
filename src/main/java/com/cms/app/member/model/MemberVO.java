package com.cms.app.member.model;

public class MemberVO {

	private String b_id;
	private String b_pw;
	private String b_name;
	private String b_phone;
	
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_pw() {
		return b_pw;
	}
	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_phone() {
		return b_phone;
	}
	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}
	
	@Override
	public String toString() {
		return "MemberVO [b_id=" + b_id + ", b_pw=" + b_pw + ", b_name=" + b_name + ", b_phone=" + b_phone + "]";
	}
}
