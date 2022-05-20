package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;

public class CreateCoursDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Course c1 = new Course("Learn Golang");
			Course c2 = new Course("Learn Scala");
			
			session.beginTransaction();
			//entity and their relationship
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.addCourse(c1);
			instructor.addCourse(c2);
			//structure formation done
			session.save(c1);
			session.save(c2);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
