package entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 save();
	}
 
	public static void save(){
		Grade g=new Grade("���4��","�����ϵ");
		
		Student st1=new Student("�����",true);
		Student st2=new Student("������",true);
		g.getStudent().add(st1);
		g.getStudent().add(st2);
		st1.setGrade(g);
		st2.setGrade(g);
		Session session=HibernateUtil.getSession();//��ȡsession
		Transaction tr=session.beginTransaction();//��������
		session.save(g);
		//session.save(st1);
		//session.save(st2);
		tr.commit();
		HibernateUtil.closeSession(session);
	}
}
