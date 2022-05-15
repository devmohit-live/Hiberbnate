package com.mohit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//First way of deleting an object : using refrence
			Student s = session.get(Student.class, 3);
			System.out.println("Deleting Student 3");
			session.delete(s);
			System.out.println("Done!");
			//Second way of deleting : using query 
			System.out.println("Deleting Student 2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			System.out.println("Done!");
			session.getTransaction().commit();
			
		}finally {
			session.close();
		}

	}

}
