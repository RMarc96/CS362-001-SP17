package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
	
	public static String RandomSelectMethod(Random random){
      String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
    }
	
	
	
	
	
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		 		 
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing on TimeTable class...");
		 TimeUnit.SECONDS.sleep(1);
				 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {				
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);
				
				
				GregorianCalendar cal = new GregorianCalendar();
				CalDay cal_day = new CalDay(cal);
	
	
				int randHour = random.nextInt(24);
				int randHour2 = random.nextInt(24);
				int randHour3 = random.nextInt(24);
				int randMinute = random.nextInt(60);
				int randMinute2 = random.nextInt(60);
				int randMinute3 = random.nextInt(60);
				int randDay = random.nextInt(32);
				int randDay2 = random.nextInt(32);
				int randDay3 = random.nextInt(32);
				int randMonth = random.nextInt(13);
				int randMonth2 = random.nextInt(13);
				int randMonth3 = random.nextInt(13);
				int randYear = random.nextInt();
				int randYear2 = random.nextInt();
				int randYear3 = random.nextInt();
				String randTitle = (String) ValuesGenerator.getString(random);
				String randTitle2 = (String) ValuesGenerator.getString(random);
				String randTitle3 = (String) ValuesGenerator.getString(random);
				String randDescription = (String) ValuesGenerator.getString(random);
				String randDescription2 = (String) ValuesGenerator.getString(random);
				String randDescription3 = (String) ValuesGenerator.getString(random);
				
				
				Appt appt = new Appt(randHour, 
									 randMinute,
									 randDay,
									 randMonth,
									 randYear,
									 randTitle,
									 randDescription);
				
				Appt appt2 = new Appt(randHour2, 
									 randMinute2,
									 randDay2,
									 randMonth2,
									 randYear2,
									 randTitle2,
									 randDescription2);					 
				
				Appt appt3 = new Appt(randHour3,
									  randMinute3,
									  randDay3,
									  randMonth3,
									  randYear3,
									  randTitle3,
									  randDescription3);
				
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
						if (methodName.equals("setDescription")){
						   String newDescription=(String) ValuesGenerator.getString(random);
						   appt.setDescription(newDescription);						   
						}
					
				}
				
				
				
				// Add appointments randomly
				int randomAdd = random.nextInt(6);
				
				if(randomAdd == 0) {
					cal_day.addAppt(appt);
				} else if(randomAdd == 1) {
					cal_day.addAppt(appt2);
				} else if(randomAdd == 2) {
					cal_day.addAppt(appt3);
				} else if(randomAdd == 3) {
					cal_day.addAppt(appt);
					cal_day.addAppt(appt2);
				} else if(randomAdd == 4) {
					cal_day.addAppt(appt2);
					cal_day.addAppt(appt3);
				} else if(randomAdd == 5) {
					cal_day.addAppt(appt);
					cal_day.addAppt(appt2);
					cal_day.addAppt(appt3);
				} else {
					// Do nothing
				}
				
				
				
				
				// Delete one appointment from appointment list
				TimeTable t_table = new TimeTable();
				
				int randomDeleteTest = random.nextInt(8);
				
				if(randomDeleteTest == 0) {
					t_table.deleteAppt(cal_day.appts, appt);
				} else if(randomDeleteTest == 1) {
					t_table.deleteAppt(cal_day.appts, appt2);
				} else if(randomDeleteTest == 2) {
					t_table.deleteAppt(cal_day.appts, appt3);
				} else if(randomDeleteTest == 3) {
					t_table.deleteAppt(cal_day.appts, null);
				} else if(randomDeleteTest == 4) {
					t_table.deleteAppt(null, appt);
				} else if(randomDeleteTest == 5) {
					t_table.deleteAppt(null, appt2);
				} else if(randomDeleteTest == 6) {
					t_table.deleteAppt(null, appt3);
				} else {
					t_table.deleteAppt(null, null);
				}
				
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			       if((iteration%10000)==0 && iteration!=0 )
			             System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing TimeTable class...");
		 
		 
	 }


	
}
