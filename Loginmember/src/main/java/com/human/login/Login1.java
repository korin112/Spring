package com.human.login;

public class Login1 {
 String name;
 String gender;
 String userid;
 String passcode;
 String interest;
public Login1() {
}
public Login1(String name, String gender, String userid, String passcode, String interest) {
	this.name = name;
	this.gender = gender;
	this.userid = userid;
	this.passcode = passcode;
	this.interest = interest;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPasscode() {
	return passcode;
}
public void setPasscode(String passcode) {
	this.passcode = passcode;
}
public String getInterest() {
	return interest;
}
public void setInterest(String interest) {
	this.interest = interest;
} 
 
}
