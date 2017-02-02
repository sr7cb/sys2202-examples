package sys2202.examples.interchange.csv;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import sys2202.examples.interchange.User;

public class ParseUsersCSV {

	public static void main(String[] args) {
		
        String csvPath = "data/users.csv";

        CSVReader reader = null;
        
        try {
        	
            reader = new CSVReader(new FileReader(csvPath), CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);
            
            ArrayList<User> users = new ArrayList<User>();
            
            String[] record;
            while ((record = reader.readNext()) != null) {
            	
            	// get fields
            	int id = Integer.parseInt(record[0]);
            	String firstName = record[1];
            	String lastName = record[2];
            	LocalDate dateOfBirth = LocalDate.parse(record[3]);
            	String addressString = record[4];
            	
            	// break apart addresses and add to list
            	ArrayList<String> addresses = new ArrayList<String>();
            	for(String address : addressString.split(Pattern.quote("|")))
            	{
            		addresses.add(address);
            	}
            	
            	// create user and add to list
            	User user = new User(id, firstName, lastName, dateOfBirth, addresses);
            	users.add(user);                
            }
            
            // print users
            for(User user : users)
            {
            	System.out.println(user.toString());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}