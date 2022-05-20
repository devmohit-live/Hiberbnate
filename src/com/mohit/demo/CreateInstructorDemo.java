package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session sesison = factory.getCurrentSession();
		
		try {
			sesison.beginTransaction();
			//entity and their relationship
			Instructor instructor = new Instructor("Mohit", "Thakur", "singh.mohit@gmail.com");
			InstructorDetail detail = new InstructorDetail("http://youtube.com/mr_developer", "Boxing");
			instructor.setInstructorDetail(detail);
			detail.setInstructor(instructor);
		
			//structure formation done
			
			sesison.save(instructor);
			sesison.getTransaction().commit();
		}finally {
			sesison.close();
			factory.close();
		}
	}

}
