package com.human.edu;

public class Member {
	String realname;
	String gender;
	String idname;
	String passcode;
	String passcode1;
	String interest;
	public Member() {
	}
	public Member(String realname, String gender, String idname, String passcode, String passcode1, String interest) {
		this.realname = realname;
		this.gender = gender;
		this.idname = idname;
		this.passcode = passcode;
		this.passcode1 = passcode1;
		this.interest = interest;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getPasscode1() {
		return passcode1;
	}
	public void setPasscode1(String passcode1) {
		this.passcode1 = passcode1;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
}
