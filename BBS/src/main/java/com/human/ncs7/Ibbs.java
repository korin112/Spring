package com.human.ncs7;

import java.util.ArrayList;

public interface Ibbs {
	ArrayList<Post> getList(); //메소드 이름이 되는것임
	Post getView(int id);	//resultType 마지막에있는거
	void writePost(String title, String name, String content);
	void deletePost(int id);
	void modifyPost(int id,String title, String name, String content);
	void plusHit(int id);
}
