package entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/*
���Ե���һ�Զ�
*/
public class Test {
	public static void main(String[] args) {
		//add();
		//find();
		//update();
		delete();
	}
	//���ѧ����Ϣ
	public static void add(){
		Grade gd=new Grade("���2��","�����ϵ");
		Student stu1=new Student("����",true);
		Student stu2=new Student("����",false);
	    gd.getStudent().add(stu1);
	    gd.getStudent().add(stu2);
	    Session session=HibernateUtil.getSession();//��ȡsession
	    Transaction tr=session.beginTransaction();//��������
	    session.save(gd);
	    session.save(stu1);
	    session.save(stu2);
	    tr.commit();
	    HibernateUtil.closeSession(session);
	}
	//��ѯѧ����Ϣ
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
		Grade g=new Grade("���1��","�����ϵ");
		
		Session session=HibernateUtil.getSession();//��ȡsession
		Transaction tr=session.beginTransaction();//��������
		Student st=session.get(Student.class, 1);
		g.getStudent().add(st);
		session.save(g);
		tr.commit();
		HibernateUtil.closeSession(session);
		
	}
	public static void delete(){
		Session session=HibernateUtil.getSession();//��ȡsession
		Transaction tr=session.beginTransaction();//��������
		Grade g=session.get(Grade.class, 3);
		session.delete(g);
		tr.commit();
		HibernateUtil.closeSession(session);
	}
	
}
