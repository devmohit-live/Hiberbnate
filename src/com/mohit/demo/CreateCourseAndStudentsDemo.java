package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.entity.Course;
import com.mohit.entity.Instructor;
import com.mohit.entity.InstructorDetail;
import com.mohit.entity.Review;
import com.mohit.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//create a courses
			Course c1 = new Course("Packman");
			Course c2 = new Course("Chess");
			Course c3 = new Course("Rummy");
			
			//create students
			
			Student s1 = new Student("Jhon", "Doe", "jhone@doe.com");
			Student s2 = new Student("Jane", "Doe", "jane@doe.com");
			
			//adding mapping
			//we can do it both ways but it will be preferred to save all courses first and add students to courses*think it of an university or institute
			
			c1.addStudent(s1);
			c1.addStudent(s2);
			c2.addStudent(s2);
			c3.addStudent(s2);
		
			System.out.println("Saving course and students..");
			session.persist(c1);
			session.persist(c2); 
			session.persist(c3); 
//			session.save(s1);
//			session.save(s2);
			
			session.getTransaction().commit();
			
			System.out.println("Saved!");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
