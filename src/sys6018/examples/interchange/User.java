package sys6018.examples.interchange;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private ArrayList<String> addresses;
	
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
