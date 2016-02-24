package sys6018.examples.interchange;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ParseUsers {

	public static void main(String[] args) throws Exception {

		// parse XML
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new File("data/users.xml"));
		
		// read each user element into a User object
		NodeList userNodes = ????;
		ArrayList<User> users = new ArrayList<User>();
		for(int i = 0; i < userNodes.getLength(); ++i)
		{
			// get id
			
			// get first name
			
			// get last name
			
			// get date of birth
			
			// get addresses
			
			// instantiate user
			User user = new User(????);
			
			System.err.println("Read user:  " + user);
		}
		
		System.err.println("Read " + users.size() + " users.");
	}
}