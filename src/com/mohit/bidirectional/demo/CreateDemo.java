package com.mohit.bidirectional.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.unidirectional.entity.Instructor;
import com.mohit.hibernate.unidirectional.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			//start transaction
			session.beginTransaction();
			
			//create Instructor
//			Instructor instructor = new Instructor("Mike","Tyson","tyson@mike.com");
//			InstructorDetail details = new InstructorDetail("www.youtube.com/realmiketyson","Feeding to pet Pigeons");
			
			Instructor instructor = new Instructor("Mohit","Singh","singh@mohit.com");
			InstructorDetail details = new InstructorDetail("www.youtube.com/realmohit","Boxing");
			
			instructor.setInstructorDetail(details);
			session.save(instructor); //cascading all will save the details too
//			one to one unidirectional cascade => instructor->instructor_details
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
