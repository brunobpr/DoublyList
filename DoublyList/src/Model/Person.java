package Model;

import java.util.Date;

/**
 * @author Bruno Ribeiro - 2017138
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private Date date;
	private String passport;
	private Priority priority;
	private String id;
	//Default constructor
	public Person() {};
	
	public Person(String name, Priority priority) {
		//
		this.firstName = name;
		this.priority = priority;
		this.id = name.substring(0, 1).toUpperCase() + this.toString().substring(13).toUpperCase();
		System.out.println(id);
	}
	
	//New instance of a person 
	/** Information regarding new person being registered onto the queue
	 * @param firstName First Name	
	 * @param lastName	Last Name	
	 * @param date		Date of arrival 
	 * @param passport	Passport Number	
	 * @param priority	Priority level
	 */
	public Person(String firstName, String lastName, Date date, String passport, Priority priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.passport = passport;
		this.priority = priority;
		this.id = firstName.substring(0, 1).toUpperCase() + this.toString().substring(13).toUpperCase();
	}

	
	
	// Getters and Setters 
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDate() {
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

	public void setDate(Date date) {
		this.date = date;
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
	
	
	
}
