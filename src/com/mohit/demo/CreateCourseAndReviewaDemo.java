package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;
import com.mohit.entity.Review;

public class CreateCourseAndReviewaDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//create a course
			Course course = new Course("How to code in Java like a PRO");
			
			//create reviews
			Review r1 = new Review("4.5 out of 5 stars");
			Review r2 = new Review("Amazing Course");
			Review r3 = new Review("From Beginner to Pro");
			Review r4 = new Review("Covers all the basics and some amazing pro techniques");
			// add reviews
			course.addReview(r4);
			course.addReview(r3);
			course.addReview(r2);
			course.addReview(r1);
			
//			save  the cours : cascase will also save the reviews
			
			System.out.println("Saving course and reviews..");
			session.save(course);
			
			session.getTransaction().commit();
			
			System.out.println("Saved!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
