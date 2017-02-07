package sys2202.examples.interchange.writing;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import sys2202.examples.interchange.User;

public class WriteUsersXML {

	public static void main(String[] args) throws Exception {
		
		// create a user
		LocalDate dateOfBirth = LocalDate.parse("1982-09-21");

		ArrayList<String> addresses = new ArrayList<String>();
		addresses.add("36 Roth Rd., Waynesboro, VA 22980");
		addresses.add("2010 Timbers Hill Rd., Apt C4, Richmond, VA 23235");
		
		User user = new User(1, "Matthew", "Gerber", dateOfBirth, addresses);
		
		// write the user object to an xml file
		PrintWriter usersXmlFile = new PrintWriter("/Users/matthewgerber/Desktop/users.xml");
		usersXmlFile.write("<users>\n");
		usersXmlFile.write("<user id=\"" + user.getId() + "\">\n" +
		                   "<name>\n" + 
		                   "<first>" + user.getFirstName() + "</first>\n" + 
				           "<last>" + user.getLastName() + "</last>\n" +
		                   "</name>\n" + 
		                   "<date_of_birth>" + user.getDateOfBirth() + "</date_of_birth>\n" + 
				           "<addresses>\n");
		
		for(String address : addresses) {
			usersXmlFile.write("<address>" + address + "</address>\n");
		}
		
		usersXmlFile.write("</addresses>\n" + 
		                   "</user>\n" + 
				           "</users>");
		
		// be sure to close the file! it won't be fully written to disk unless you do.
		usersXmlFile.close();
	}
}
