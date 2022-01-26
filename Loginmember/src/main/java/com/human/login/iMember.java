package com.human.login;

import java.util.ArrayList;


public interface iMember {
	void insertLogin(String name, String gender, String userid, String passcode, String interest);
	void signcheck(String userid,String passcode);
	ArrayList<Login1> getsigncheck();
	ArrayList<Login1> member();
	void updateLogin(String userid);
	void selectLogin(String userid,String passcode);
	void updateLogout(String userid);

}
