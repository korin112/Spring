package com.human.exercise;

public class Menu {
	private int code;
	private String menuname;
	private int price;
	public Menu() {
	}
	public Menu(int code, String menuname, int price) {
		this.code = code;
		this.menuname = menuname;
		this.price = price;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
