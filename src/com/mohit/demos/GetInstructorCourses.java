package com.mohit.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;

public class GetInstructorCourses {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//entity and their relationship 
			Instructor instructor = session.get(Instructor.class, 1);
			for(Course c : instructor.getCourses())
				System.out.println(c);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
