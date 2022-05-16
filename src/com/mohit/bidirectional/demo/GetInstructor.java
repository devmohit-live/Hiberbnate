package com.mohit.bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.bidirectional.entity.*;


public class GetInstructor {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			//start transaction
			session.beginTransaction();
			//Now Since we have now BI directional Mapping
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
			System.out.println(instructorDetail.getInstructor()); //getting instructor using instructor details
			
//		
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
