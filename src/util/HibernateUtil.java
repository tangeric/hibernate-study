package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();//创建会话工厂
		session=sessionFactory.getCurrentSession();//会话对象	
		
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session){
		if(session!=null)
			session.close();
	}
}
