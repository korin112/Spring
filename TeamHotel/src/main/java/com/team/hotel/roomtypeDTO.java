package com.team.hotel;

public class roomtypeDTO {
	private int type_code;
	private String name;
	public roomtypeDTO() {
	}
	public roomtypeDTO(int type_code, String name) {
		this.type_code = type_code;
		this.name = name;
	}
	public int getType_code() {
		return type_code;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
