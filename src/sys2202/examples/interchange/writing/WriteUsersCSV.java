package sys2202.examples.interchange.writing;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import sys2202.examples.interchange.User;

public class WriteUsersCSV {

	public static void main(String[] args) throws Exception {

		// create a user
		LocalDate dateOfBirth = LocalDate.parse("1982-09-21");

		ArrayList<String> addresses = new ArrayList<String>();
		addresses.add("36 Roth Rd., Waynesboro, VA 22980");
		addresses.add("2010 Timbers Hill Rd., Apt C4, Richmond, VA 23235");

		User user = new User(1, "Matthew", "Gerber", dateOfBirth, addresses);

		// write the user object to a csv file
		PrintWriter usersCsvFile = new PrintWriter("/Users/matthewgerber/Desktop/users.csv");
		
		// write the header row
		usersCsvFile.write("id,first_name,last_name,date_of_birth,addresses\n");
		
		// write the first user record
		usersCsvFile.write(user.getId() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getDateOfBirth() + ",");
		
		// wrap addresses in double quotes and combine multiple addresses into a single value with the vertical pipe "|" 
		boolean firstAddress = true;
		usersCsvFile.write("\"");
		for(String address : addresses) {
			
			if(!firstAddress) {
				usersCsvFile.write("|");
			}
			
			usersCsvFile.write(address);
			
			firstAddress = false;
		}
		
		usersCsvFile.write("\"\n");
		
		// close the file!
		usersCsvFile.close();
	}
}