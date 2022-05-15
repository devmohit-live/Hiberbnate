package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//get the student you want to update 
			//getting by pmkey
			Student s = session.get(Student.class, 1);
			s.setFirstName("Light Yagami"); //student class setter
			//get that studetn again to confirm 
			System.out.println(session.get(Student.class, 1));
			session.getTransaction().commit();
			
			//remember after you commit you hae to again begin a new transaction to perform any operation
			
			
		}finally {
			factory.close();
		}

	}

}
