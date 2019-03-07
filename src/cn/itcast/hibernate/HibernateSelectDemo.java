package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.entity.User;
import cn.itcast.uitls.HibernateUtils;

public class HibernateSelectDemo {
	
	@Test
	public void testCasch() {
		//验证hibernate的一级缓存
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		//执行第一个get方法是否查询数据库，是否发送sql语句
		User user = session.get(User.class, "6");
		System.out.println(user);
		
		//执行第一个get方法是否查询数据库，是否发送sql语句
		User user1 = session.get(User.class, "6");
		System.out.println(user1);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testDemo() {
		//验证hibernate的一级缓存特性
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		//执行第一个get方法是否查询数据库，是否发送sql语句
		User user = session.get(User.class, "6");
		user.setUsername("fffff");
		
		System.out.println(user);
		
//		session.update(user);  持久态不需要调用update也能更新数据
		
		//执行第一个get方法是否查询数据库，是否发送sql语句
		User user1 = session.get(User.class, "6");
		System.out.println(user1);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}	
