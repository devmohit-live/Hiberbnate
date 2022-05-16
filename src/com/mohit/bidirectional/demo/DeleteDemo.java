package com.mohit.bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.unidirectional.entity.Instructor;
import com.mohit.hibernate.unidirectional.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//begin
			session.beginTransaction();
			Instructor instructor =  session.get(Instructor.class, 2);
			session.delete(instructor);
			//operation
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
