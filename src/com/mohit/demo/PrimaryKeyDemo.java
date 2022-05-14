package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create student objects
			Student student1 =  new Student("S1","abc","abc@xyz.com");
			Student student2 =  new Student("S2","xyz","vvv@xyz.com");
			Student student3 =  new Student("S3","def","ccc@xyz.com");
			
			// start transaction
			session.beginTransaction();
			// save
			session.save(student1); 
			session.save(student2); 
			session.save(student3); 
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			factory.close();
		}
		

	}

}
