package cn.itcast.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.entity.User;
import cn.itcast.uitls.HibernateUtils;
import net.bytebuddy.implementation.bytecode.Addition;

public class HibernateDemo {
	
	@Test
	public void testAdd() {
		//1、加载hibernate核心配置文件
		//到src下面找到名称是hibernate.cfg.xml
		//在hibernate里面封装对象
//		Configuration cfg = new Configuration();
//		cfg.configure();
		
		//2、创建SessionFactory对象
		//读取hibernate核心配置文件内容，创建SessionFactory
		//过程中根据映射关系，在配置数据库里面把表创建
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		//3、使用SessionFactory创建session对象
		//类似连接
		Session session = sessionFactory.openSession();
		
		//4、开启事务
		Transaction tx = session.beginTransaction();
		
		//5、写具体逻辑crud操作
		//添加
		
		User user = new User();
		user.setUsername("张三");
		user.setPassword("12343");
		user.setAddress("中国");
		
		//调用session的方法实现添加
		session.save(user);
		
		//6、提交事务
		tx.commit();
//		tx.rollback();//回滚
		
		//7、关闭资源
		session.close();
		sessionFactory.close();
	}

}


