package com.mohit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		final String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false";
		final String user = "hbstudent";
		final String pass = "mohit";
				
		try {
			System.out.println("Connecting yo db "+jdbcURL);
			Connection myconn = DriverManager.getConnection(jdbcURL,user,pass);
			System.out.println("Connection Succesfull!");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
