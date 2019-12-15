package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Bruno Ribeiro - 2017138
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private String date;
	private String passport;
	private Priority priority;

	private String id;

	// Default constructor
	public Person() {
	};

	public Person(String name, Priority priority) {
		//
		this.firstName = name;
		this.priority = priority;
		this.id = this.toString().substring(13).toUpperCase();
	}

	// New instance of a person
	/**
	 * Information regarding new person being registered onto the queue
	 * 
	 * @param firstName
	 *            First Name
	 * @param lastName
	 *            Last Name
	 * @param string
	 *            Date of arrival
	 * @param passport
	 *            Passport Number
	 * @param priority
	 *            Priority level
	 */
	public Person(String firstName, String lastName, String passport, String date, Priority priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passport = passport;
		this.priority = priority;
		this.date = date;
		// For each person, the ID will be the String representantion of the object
		// itself
		// Not random, but UNIQUE.
		this.id = this.toString().substring(15).toUpperCase();
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDate() {
		return date;
	}

	public String getPassport() {
		return passport;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
