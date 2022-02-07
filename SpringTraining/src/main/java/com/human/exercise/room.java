package com.human.exercise;

public class room {
	private int roomcode;
	private String name;
	private int howmany;
	private int howmuch;
	private String type;
	public room() {
	}
	public room(int roomcode, String name, int howmany, int howmuch, String type) {
		this.roomcode = roomcode;
		this.name = name;
		this.howmany = howmany;
		this.howmuch = howmuch;
		this.type = type;
	}
	public int getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(int roomcode) {
		this.roomcode = roomcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHowmany() {
		return howmany;
	}
	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}
	public int getHowmuch() {
		return howmuch;
	}
	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
}
