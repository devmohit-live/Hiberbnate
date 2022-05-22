package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;
import com.mohit.entity.Review;

public class GetCourseAndReviewaDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 10);
			System.out.println(course);
			
			System.out.println(course.getReviews());
			session.getTransaction().commit();
			
			System.out.println("Saved!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
