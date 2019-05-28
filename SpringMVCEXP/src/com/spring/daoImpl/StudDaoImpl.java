package com.spring.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.spring.dao.Studdao;
import com.spring.model.StudPojo;

public class StudDaoImpl implements Studdao {

	@Override
	public boolean save(StudPojo s) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Object Saved Successfully");
		return true;
		
	}

	@Override
	public List<StudPojo> viewAll() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("from StudPojo p");
		List <StudPojo> l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			StudPojo p = (StudPojo) o;
			System.out.println(p.getId());
			System.out.println(p.getStudAdd());
			System.out.println(p.getStudMail());
			System.out.println(p.getStudName());

		}
		return l;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session =factory.openSession();
		
		Object o=session.load(StudPojo.class, new Integer (id));
		StudPojo p=(StudPojo) o;
		Transaction tx=session.beginTransaction();
		session.delete(p);
		System.out.println("Object Deleted Successfully");
		tx.commit();
		session.close();
		factory.close();
		
	}
	public List<StudPojo> viewbyid(StudPojo emp) {
		// TODO Auto-generated method stub
		
		System.out.println("I amin Viewbyid implementation");
		System.out.println(emp.getId());
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
	
		String hql = "select * from StudPojo where id =" +emp.getId();
		System.out.println(hql);
		Query qry = session.createQuery("from StudPojo where id="+emp.getId());
		List l =qry.list();
		System.out.println("Total Number Of Records : "+l.size());
		java.util.Iterator it = l.iterator();

		while(it.hasNext())
		{
		
			StudPojo reg = (StudPojo)it.next();
			System.out.println(reg.getId());
			System.out.println(reg.getStudAdd());
			System.out.println(reg.getStudMail());
		}
		session.close();
		factory.close();
		return l;
	}

}
