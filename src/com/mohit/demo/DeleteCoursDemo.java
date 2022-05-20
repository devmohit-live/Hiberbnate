package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;

public class DeleteCoursDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int cid = 11;			
			session.beginTransaction();
			//entity and their relationship
			Course c1 = session.get(Course.class, 11);
			System.out.println("Deleting Course "+c1);
			session.delete(c1);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
