package com.team.hotel;

import java.util.ArrayList;

public interface iHotel {
	void addType(int type_code,String name);
	void addRoom(String name, int type, int howmany, int howmuch);
	
	ArrayList<roomtypeDTO> getTypeList();
	ArrayList<roomDTO> getRoomList();
	
}
