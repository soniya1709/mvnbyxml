package com.prowing;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

public class TestEmployee {
	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("soniya");
		emp.setSalary(80000);
		Employee emp1=new Employee();
		emp1.setName("Ashvini");
		emp1.setSalary(60000);
		Employee emp2=new Employee();
		emp2.setName("Saurabh");
		emp2.setSalary(50000);
		Configuration con=new Configuration();
		SessionFactory factory=con.configure().buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		System.out.println("************************");
		Criteria c=session.createCriteria(Employee.class);
	    c.setFirstResult(1);
//       c.setMaxResults(3);
	    java.util.List list=c.list();
		System.out.println(list);
		session.close();
		
//		Session session1=factory.openSession();
//		Query query=session1.createQuery("from Employee");
//		java.util.List list=query.getResultList();
//		System.out.println(list);
//		session1.close();
//		System.out.println("*****************");
		
		factory.close();
	}
}
