package sys2202.examples.interchange;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private ArrayList<String> addresses;
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public ArrayList<String> getAddresses() {
		return addresses;
	}
	
	public User(int id, String firstName, String lastName, LocalDate dateOfBirth, ArrayList<String> addresses)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.addresses = addresses;
	}
	
	public String toString() {
		
		return "User " + id + ":  " + firstName + " " + lastName + " (DOB:  " + dateOfBirth + ", " + addresses.size() + " addresses)"; 
	}
}
