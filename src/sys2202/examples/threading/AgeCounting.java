package sys2202.examples.threading;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class AgeCounting {

	public static void main(String[] args)
	{		
		// create a list of 100 million random ages from 1-100
		System.out.println("Creating ages list...");
		ArrayList<Integer> ages = new ArrayList<Integer>(100000000);
		Random r = new Random();
		for(int i = 1; i <= 100000000; ++i)
		{
		    int age = r.nextInt(100) + 1;
			ages.add(age);
		}
		
		// time how long it takes to count the number of people with each age
		System.out.println("Getting age counts...");
		
		long startTime = System.currentTimeMillis();
		
		Hashtable<Integer, Integer> ageCount = new Hashtable<Integer, Integer>(); 
		for(int age = 1; age <= 100; ++age)
		{
			int count = HowManyPeopleHaveAge(ages, age);
			ageCount.put(age, count);	
		}
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Age counting took " + elapsedTime + "ms.");
	}
	
	private static int HowManyPeopleHaveAge(ArrayList<Integer> ages, int age)
	{
		int count = 0;
		
		for(int i = 0; i < ages.size(); ++i)
		{
		    if(ages.get(i) == age)
		    	count = count + 1;
		}
		
		return count;
	}
}