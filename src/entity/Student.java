package entity;

import java.io.Serializable;

public class Student implements Serializable {

	private int sid;
	private String sname;
	private boolean sex;
	private Grade grade;
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Student(String sname, boolean sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}
	public Student() {
		super();
	}

}
