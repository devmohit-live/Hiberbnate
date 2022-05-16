package com.mohit.bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.bidirectional.entity.Instructor;
import com.mohit.hibernate.bidirectional.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//begin
			session.beginTransaction();
			InstructorDetail instructorDetail =  session.get(InstructorDetail.class, 1);
			
			//remove the association
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			//operation
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}
}
