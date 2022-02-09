package com.human.exercise;

public class emplist1 {
	private int eid;
	private String ename;
	private String mobile;
	private int salary;
	public emplist1() {
	}
	public emplist1(int eid, String ename, String mobile, int salary) {
		this.eid = eid;
		this.ename = ename;
		this.mobile = mobile;
		this.salary = salary;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
