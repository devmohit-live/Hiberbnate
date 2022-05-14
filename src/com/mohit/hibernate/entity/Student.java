package com.mohit.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //tells that this calss is a mapping db table class : also known as entity class
@Table(name="student") //optional when class and table have same name
public class Student {
		
	@Id //tells it is a key
	@Column(name = "id") // optional when table attribute name and class properies have exactly same name
	@GeneratedValue(strategy = GenerationType.IDENTITY) // telling to use ai feature in this filed acc to mysql
	private int id;
	
	@Column(name="first_name")
	private String fisrtName;
	
	@Column(name="last_name")
	private String lastName;
	
//	@Column(name="email")
	private String email;
	
	
	public Student() {
		
	}


	public Student(String fisrtName, String lastName, String email) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFisrtName() {
		return fisrtName;
	}


	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}
