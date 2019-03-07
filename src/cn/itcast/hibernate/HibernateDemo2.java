package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.entity.User;
import cn.itcast.uitls.HibernateUtils;

public class HibernateDemo2 {
	@Test
	public void testGet() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//根据id查询
		//第一个参数：实体类class
		//第二参数：id值
		User user = session.get(User.class, "1");
		System.out.println(user);
		
		//修改
		user.setUsername("hahaha");
		session.update(user);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//根据id查询
		//第一个参数：实体类class
		//第二参数：id值
		//第一种
		User user = session.get(User.class, "1");
		
		//这个user叫持久态，是通过session查出来的，更session有关联
		System.out.println(user);
		session.delete(user);
		
		//第二种
//		User user = new User();
//		user.setUid("4");
//		session.delete(user);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Test
	public void testSaveOrUpUpdate() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	
		//第二种
//		User user = new User();
//		user.setUid("4");//此user是托管态，有id，但是和session没有任何关系。
		
		
//		User user = new User();
//		user.setUsername("zhangsan");
//		user.setPassword("343434");
//		user.setAddress("fdfdsfasd");
		
		//没有id，更session也没有任何关系称瞬时态
//		session.save(user);//所有值都会更新uid
		
//		session.update(user);//这个也很更新所以值，不建议，一般先查再改。
		
		
		//（1）user是瞬时态，saveOrUpdate做的是添加操作
//		User user = new User();
//		user.setUsername("dddd");
//		user.setPassword("dddggg");
//		user.setAddress("china");
//		session.saveOrUpdate(user);
		
		
		//（2）user是托管态，saveOrUpdate做的是修改操作
//		User user = new User();
//		user.setUid("1");
//		user.setUsername("dddd");
//		user.setPassword("dddggg");
//		user.setAddress("china");
//		session.saveOrUpdate(user);
		
		//（3）user是持久态，saveOrUpdate做的是修改操作
		User user = session.get(User.class, "6");
		user.setUsername("dddd");
		session.saveOrUpdate(user);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
