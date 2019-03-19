package com.example.ffs;

public class User {

	public static Person person = new Person();
	
	public void setperson(Person n) {
		person = n;
	}
	
	public User(Person n) {
		System.out.println("Change happening");
		person = n;
		System.out.println(person.id);
	}
	public User() {
	}
	
}
