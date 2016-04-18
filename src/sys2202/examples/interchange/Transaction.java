package sys2202.examples.interchange;

import java.time.LocalDate;

public class Transaction {

	private int id;
	private LocalDate date;
	private float amount;
	
	public int getId() {
		
		return id;
	}
	
	public LocalDate getDate() {
		
		return date; 
	}
	
	public float getAmount() {
		
		return amount;
	}
	
	public Transaction(int id, LocalDate date, float amount)
	{
		this.id = id;
		this.date = date;
		this.amount = amount;
	}
	
	public String toString() {
		return "Transaction " + id + " (" + date + "):  " + amount;
	}
}