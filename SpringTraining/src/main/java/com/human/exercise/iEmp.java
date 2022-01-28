package com.human.exercise;

import java.util.ArrayList;

public interface iEmp {
	ArrayList<Employee> getEmpList(); //덩어리를 받아오는거니까 arraylist<dto>로 처리 select할때 필요~
	void addMenu(String menu_name,int price);	// type과 갯수만 맞으면 됨 변수 이름은 상관없음
}

