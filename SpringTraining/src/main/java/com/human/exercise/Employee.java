package com.human.exercise;

public class Employee {
	private int dep_id; /* private으로 만들어야댐 */
	private String dep_name;
	private String dname;
	private String mname;
	public Employee() {
	}
	public Employee(int dep_id, String dep_name, String dname, String mname) {
		this.dep_id = dep_id;
		this.dep_name = dep_name;
		this.dname = dname;
		this.mname = mname;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
			
}
