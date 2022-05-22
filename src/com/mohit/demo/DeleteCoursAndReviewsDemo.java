package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;
import com.mohit.entity.Review;

public class DeleteCoursAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int cid = 11;			
			session.beginTransaction();
			//entity and their relationship
			Course c1 = session.get(Course.class, 11);
			System.out.println(c1);
			System.out.println("Deleting Course "+c1);
			System.out.println("This will also delete all the reviews related to that course.");
			session.delete(c1);
			System.out.println("Delete completed");
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
