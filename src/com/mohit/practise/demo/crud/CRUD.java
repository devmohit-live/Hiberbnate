package com.mohit.practise.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUD {
	private SessionFactory factory;
	private Session session;
	
	public CRUD() {
		this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
	}

	private void print() {
		System.out.println("Operation Preformed Succesfully.");
	}

	public void addEmployee(Employee emp) {
		try {
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
			print();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Employee getEmployee(int input) {
		Employee e = null;
		try {
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			e = session.get(Employee.class, input);
			session.getTransaction().commit();
			print();
			return e;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;

	}


	public void deleteEmployee(int input) {
		try {
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			Employee e = session.get(Employee.class, input);
			session.delete(e);
			session.getTransaction().commit();
			print();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployeeEmail(int input,String newEmail) {
		try {
			System.out.println("Enter new email");
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.get(Employee.class, input).setEmail(newEmail);
			session.getTransaction().commit();
			print();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void dispose() {
		factory.close();		
	}

}
