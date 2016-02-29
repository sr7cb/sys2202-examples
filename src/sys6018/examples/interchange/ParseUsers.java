package sys6018.examples.interchange;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParseUsers {

	public static void main(String[] args) throws Exception {

		// parse XML
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new File("data/users.xml"));
		
		// read each user element into a User object
		NodeList userNodes = doc.getElementsByTagName("user");
		ArrayList<User> users = new ArrayList<User>();
		for(int i = 0; i < userNodes.getLength(); ++i)
		{
			Element userNode = (Element) userNodes.item(i);
			
			// get id
			String idString = userNode.getAttribute("id");
			int id = Integer.parseInt(idString);
			
			// get first name
			Element nameNode = (Element) userNode.getElementsByTagName("name").item(0);
			String firstName = nameNode.getElementsByTagName("first").item(0).getTextContent();			
			
			// get last name
			String lastName = nameNode.getElementsByTagName("last").item(0).getTextContent();
			
			// get date of birth
			String dateOfBirthString = userNode.getElementsByTagName("date_of_birth").item(0).getTextContent();
			LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
			
			// get addresses
			Element addressesNode = (Element) userNode.getElementsByTagName("addresses").item(0);
			ArrayList<String> addresses = new ArrayList<String>();
			NodeList addressNodes = addressesNode.getElementsByTagName("address");
			for(int j = 0; j < addressNodes.getLength(); ++j)
			{
				Element addressNode = (Element) addressNodes.item(j);
				String addressString = addressNode.getTextContent();
				addresses.add(addressString);
			}
			
			// instantiate user
			User user = new User(id, firstName, lastName, dateOfBirth, addresses);
			users.add(user);
			
			System.err.println("Read user:  " + user);
		}
		
		System.err.println("Read " + users.size() + " users.");
	}
}