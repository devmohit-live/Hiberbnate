package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student obj
			System.out.println("Creating new Student");
			Student student = new Student("Mohit","Thakur","mohit@boxer-association.com");
			
			//start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			//save the student object
			session.save(student);
			System.out.println("Saving Student Object");
			//commit transaction
			System.out.println("Commiting this transactions");
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
