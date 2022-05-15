package com.mohit.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			//query  students table
			List<Student> list = session.createQuery("from Student").getResultList();
			
			// QUery students whose lastname is xyz or firstname is S1
			//remmeber s is the student object returned by hibernate cursor s.propertyname => from student class
			List<Student> l2 = session.createQuery("from Student s where s.lastName='xyz' OR s.firstName='S1'").getResultList();
			
			List<Student> l3 = session.createQuery("from Student s where s.email LIKE '%xyz.com'").getResultList();
			List<Student> l4 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			
			//display students
			displayResult(list);
			displayResult(l2);
			displayResult(l3);
			displayResult(l4);
			
			System.out.println("Commiting this transactions");
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

	private static void displayResult(List<Student> l2) {
		System.out.println(" Query Results");
		for(Student s: l2) System.out.println(s);
	}

}
