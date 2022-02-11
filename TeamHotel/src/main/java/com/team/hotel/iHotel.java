package com.team.hotel;

import java.util.ArrayList;

public interface iHotel {
	void addType(String type_name);
	void addRoom(String name, int type, int howmany, int howmuch);
	void delType(int type_code);
	void delRoom(int room_code);
	void updType(int type_code,String type_name);
	void updRoom(int room_code,String name,int type, int howmany, int howmuch);
	
	ArrayList<roomtypeDTO> selType();
	ArrayList<roomDTO> selRoom();
	
}
