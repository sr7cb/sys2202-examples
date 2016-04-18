package sys2202.examples.interchange.xml;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import sys2202.examples.interchange.Transaction;

public class ParseTransactions {
	
	public static void main(String[] args) throws Exception {
		
		String xml = "<transactions>" + 
					 "  <transaction id=\"1\">" + 
					 "    <date>2016-01-31</date>" + 
					 "    <amount>500</amount>" + 
				     "  </transaction>" + 
					 "  <transaction id=\"2\">" + 
				     "    <date>2016-02-23</date>" + 
					 "    <amount>750</amount>" + 
				     "  </transaction>" +
					 "</transactions>";
		
		// parse XML
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
        
        // read each transaction node into a Transaction object.
        NodeList transactionNodes = doc.getElementsByTagName("transaction");
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for(int i = 0; i < transactionNodes.getLength(); ++i) {

        	Element transactionNode = (Element) transactionNodes.item(i);
        	
        	// get id
        	String idString = transactionNode.getAttribute("id");
        	int id = Integer.parseInt(idString);
        	
        	// get date
        	Element dateElement = (Element) transactionNode.getElementsByTagName("date").item(0);
        	String dateString = dateElement.getTextContent();
        	LocalDate date = LocalDate.parse(dateString);
        	
        	// get amount
        	Element amountElement = (Element) transactionNode.getElementsByTagName("amount").item(0);
        	String amountString = amountElement.getTextContent();
        	float amount = Float.parseFloat(amountString);
        	
        	// instantiate transaction
        	Transaction transaction = new Transaction(id, date, amount); 
        	transactions.add(transaction);
        	
        	System.err.println("Read transaction:  " + transaction);
        }
        
        System.err.println("Read " + transactions.size() + " transactions.");
	}
}