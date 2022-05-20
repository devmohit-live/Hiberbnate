package com.mohit.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;

public class LazyLoadingDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//HQL //solution2
			
			Query<Instructor> query = session.createQuery("SELECT i from Instructor i JOIN FETCH i.courses where i.id=:instructorId",
					Instructor.class);
			
			query.setParameter("instructorId", 1);
			
			Instructor instructor = query.getSingleResult();
			
			
			
			
			//entity and their relationship 
//			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("instructor : " + instructor);
//			System.out.println("Courses "+instructor.getCourses() );// solution 1 : fetching already before closing
			session.getTransaction().commit();
			System.out.println("\nClosing the sesion \n");
			session.close();
			
			System.out.println("Courses "+instructor.getCourses() );
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
