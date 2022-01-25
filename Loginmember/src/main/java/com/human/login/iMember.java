package com.human.login;

import java.util.ArrayList;


public interface iMember {
	void insertLogin(String name, String gender, String userid, String passcode, String interest);
	ArrayList<Login1> getsignchk();
}
