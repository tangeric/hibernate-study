package entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/*
测试单向一对多
*/
public class Test {
	public static void main(String[] args) {
		//add();
		//find();
		//update();
		delete();
	}
	//添加学生信息
	public static void add(){
		Grade gd=new Grade("软件2班","计算机系");
		Student stu1=new Student("王杰",true);
		Student stu2=new Student("郭宁",false);
	    gd.getStudent().add(stu1);
	    gd.getStudent().add(stu2);
	    Session session=HibernateUtil.getSession();//获取session
	    Transaction tr=session.beginTransaction();//开启事务
	    session.save(gd);
	    session.save(stu1);
	    session.save(stu2);
	    tr.commit();
	    HibernateUtil.closeSession(session);
	}
	//查询学生信息
	public static void find(){
		Session session=HibernateUtil.getSession();
		Grade grade=session.get(Grade.class, 1);
		System.out.println(grade.getGname()+"|"+grade.getGdesc());
		Set<Student> student=grade.getStudent();
		for(Student stu:student){
			System.out.println(stu.getSid()+"|"+stu.getSname());
		}
	}
	public static void update(){
		Grade g=new Grade("软件1班","计算机系");
		
		Session session=HibernateUtil.getSession();//获取session
		Transaction tr=session.beginTransaction();//开启事务
		Student st=session.get(Student.class, 1);
		g.getStudent().add(st);
		session.save(g);
		tr.commit();
		HibernateUtil.closeSession(session);
		
	}
	public static void delete(){
		Session session=HibernateUtil.getSession();//获取session
		Transaction tr=session.beginTransaction();//开启事务
		Grade g=session.get(Grade.class, 3);
		session.delete(g);
		tr.commit();
		HibernateUtil.closeSession(session);
	}
	
}
