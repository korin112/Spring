package com.human.exercise;

import java.util.ArrayList;

public interface iJob {
	ArrayList<Job> jobList();
	ArrayList<EmpInfo> getList(String jobid);
	ArrayList<deptlist> deptList();
	ArrayList<emplist1> getDept(String depid);
	ArrayList<manager> ManList();
	ArrayList<manager1> EmpList(String mid);

	
}
