package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable {

	private int gid;
	private String gname;
    private String gdesc;
    private Set<Student> student=new HashSet<Student>();
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public Grade(int gid, String gname, String gdesc, Set<Student> student) {
		
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.student = student;
	}
	public Grade(String gname, String gdesc) {
		
		this.gname = gname;
		this.gdesc = gdesc;
	}
	public Grade() {
		super();
	}
    
}
