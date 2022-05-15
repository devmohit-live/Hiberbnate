package com.mohit.practise.demo;

import java.util.Scanner;

import com.mohit.practise.demo.crud.CRUD;
import com.mohit.practise.demo.crud.Employee;

public class Main {
	static final Scanner sc = new Scanner(System.in);
	private static int getId() {
		System.out.println("Enter the ID");
		int id = sc.nextInt();
		sc.nextLine();
		return  id;
	}

	public static void main(String[] args) {
		CRUD ob = new CRUD() ;
		while(true) {
			displayMessage();
			char ch = sc.nextLine().charAt(0);
			if(ch == '5') {
				ob.dispose();
				ob = null;
				break;
			}
			
			switch (ch) {
			case '1':
				System.out.println("Enter Employee firstname, lastname and email seperated by new line");
				ob.addEmployee( new Employee(sc.nextLine(), sc.nextLine(), sc.nextLine()));
				break;
			case '2':
				Employee e = ob.getEmployee(getId());
				System.out.println(e);
				break;
			case '3':
				ob.updateEmployeeEmail(getId(), getEmail());
				break;
				
			case '4':
				ob .deleteEmployee(getId());
				break;
				
			default:
				System.out.println("Andha hai kya Law*e");
			}
			
		}
	}

	private static String getEmail() {
		System.out.println("Enter new email : ");
		return sc.nextLine();
	}

	/**
	 * 
	 */
	private static void displayMessage() {
		System.out.println("Enter Your Choice");
		System.out.println("Enter 1 to add an entry in DB");
		System.out.println("Enter 2 to get an entry in DB");
		System.out.println("Enter 3 to update an entry in DB");
		System.out.println("Enter 4 to delete an entry in DB");
		System.out.println("Enter 5 to exit the program");
		System.out.println();
	}

}
