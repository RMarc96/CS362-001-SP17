package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		
		Appt new_appt = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		t_table.getApptRange(appts, firstDay, lastDay);
		

		assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }


	/*
	@Test
	  public void test02()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 1, 1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
			
		Appt new_appt = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		t_table.getApptRange(appts, lastDay, firstDay);
		

		//assertNotNull(t_table);
		
		//assertNotNull(t_table.calDays);
	 }
	*/

	@Test
	  public void test03()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 1, 1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	

		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }


	@Test
	  public void test04()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 1, 1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(9999, 9999, 9999, 9999, 9999,
					"Birthday Party",
					"This is my birthday party.");


		cal_day.addAppt(new_appt);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		
		//assertFalse(new_appt.getValid());
		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }

	@Test
	  public void test05()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, 1);
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(14, 30, 10, 04, 2017,
					"Birthday Continued",
					"This is the hour after my birthday party.");

		Appt new_appt2 = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");



		cal_day.addAppt(new_appt);
		cal_day.addAppt(new_appt2);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		
		//assertFalse(new_appt.getValid());
		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }

	@Test
	  public void test06()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, 1);
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(0, 0, 0, 0, 0,
					null,
					null);

		Appt new_appt2 = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");



		cal_day.addAppt(new_appt);
		cal_day.addAppt(new_appt2);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		t_table.deleteAppt(cal_day.appts, new_appt);	
	
		//assertFalse(new_appt.getValid());
		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }

	// Test first branch condition on deleteAppt
	@Test
	  public void test07()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, 1);
		CalDay cal_day = new CalDay(firstDay);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		t_table.deleteAppt(null, null);	
	
		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }

	// Test second branch condition on deleteAppt
	@Test
	  public void test08()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, 1);
		CalDay cal_day = new CalDay(firstDay);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		t_table.deleteAppt(null, null);	

		Appt new_appt = new Appt(13, 30, 10, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		
		t_table.deleteAppt(cal_day.appts, new_appt);


		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }
	 
	 
	 
	 // Check for invalid valid and invalid appointments
	 @Test
	  public void getApptRangeTest01()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2017, 4, 9);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 12);
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(13, 30, 10, 4, 2017,
					"Birthday Continued",
					"This is the hour after my birthday party.");

		//Appt new_appt2 = new Appt(14, 10, 11, 04, 2017,
			//		"Birthday Party",
				//	"This is my birthday party.");



		cal_day.addAppt(new_appt);
		//cal_day.addAppt(new_appt2);
		LinkedList<CalDay> return_appts = t_table.getApptRange(cal_day.appts, firstDay, lastDay);	
		
		
		assertEquals(3, return_appts.size());
		assertNotNull(return_appts.get(1));
	 }
	 
	 
		 // Check for invalid valid and invalid appointments
	 @Test
	  public void getApptRangeTest02()  throws Throwable  {
		// Line 73 test
		
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2017, 4, 9);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 11);
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(9, 30, 9, 4, 2017,
					"Birthday Continued",
					"This is the hour after my birthday party.");
		
		Appt new_appt2 = new Appt(10, 30, 10, 4, 2017,
					"Birthday Continued",
					"This is the hour after my birthday party.");
					
		
		cal_day.addAppt(new_appt);
		cal_day.addAppt(new_appt2);
		
		
		LinkedList<CalDay> return_val = t_table.getApptRange(cal_day.appts, firstDay, lastDay);
		assertNotNull(return_val);
					
	 }
	 
	@Test
	  public void getApptRangeTest03()  throws Throwable  {
		// Line 59 test
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2017, 4, 9);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 12);
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(9, 30, 9, 4, 2017,
					"Birthday Continued",
					"This is the hour after my birthday party.");
		
		//Appt new_appt2 = new Appt(10, 30, 10, 4, 2017,
		//			"Birthday Continued",
		//			"This is the hour after my birthday party.");
					
		
		cal_day.addAppt(new_appt);
	//	cal_day.addAppt(new_appt2);
		
		
		LinkedList<CalDay> return_val = t_table.getApptRange(cal_day.appts, firstDay, lastDay);
		
		System.out.println(return_val.get(0));
		
		assertTrue(return_val.get(0).toString().contains(new_appt.toString()));
		assertNotNull(return_val);
		assertEquals(3, return_val.size());
		
			
	 }
	 
	 ////////////////////////////
	@Test
	  public void getApptRangeTest04()  throws Throwable  {
	
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 1, 1);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		CalDay cal_day = new CalDay(firstDay);

		Appt new_appt = new Appt(13, 30, 10, 04, 2015,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		t_table.getApptRange(cal_day.appts, firstDay, lastDay);	

		//assertNotNull(t_table);
		//assertNotNull(t_table.calDays);

	 }
	 
	@Test
	  // Tests for deleting appointments
	  public void deleteApptTest01()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		CalDay cal_day = new CalDay(firstDay);
		LinkedList<Appt> return_value;
		
		
		Appt new_appt = new Appt(13, 30, 28, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		
		return_value = t_table.deleteAppt(cal_day.appts, new_appt);
		
		
		assertNotNull(return_value);
		assertEquals(0, cal_day.appts.size());
	 }
	 
	 
	 @Test
	  // Tests for deleting appointments
	  public void deleteApptTest02()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		CalDay cal_day = new CalDay(firstDay);
		LinkedList<Appt> return_value;
		

		Appt new_appt = new Appt(13, 30, 28, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");
					
		return_value = t_table.deleteAppt(null, null);
		
		assertNull(return_value);
	 }
	 
	 
	@Test
	  // Tests for deleting appointments
	  public void deleteApptTest03()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		CalDay cal_day = new CalDay(firstDay);
		LinkedList<Appt> return_value;
		
		
		Appt new_appt = new Appt(13, 30, 28, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		
		return_value = t_table.deleteAppt(cal_day.appts, null);
		
		
		assertNull(return_value);
		assertEquals(1, cal_day.appts.size());
	 }
	 
	 @Test
	  // Tests for deleting appointments
	  public void deleteApptTest04()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		CalDay cal_day = new CalDay(firstDay);
		LinkedList<Appt> return_value;
		
		
		Appt new_appt = new Appt(13, 30, 28, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		Appt new_appt2 = new Appt(15, 30, 28, 04, 2017,
					"Birthday Afterparty",
					"This is my birthday afterparty.");			
				
		cal_day.addAppt(new_appt);
		cal_day.addAppt(new_appt2);
		
		return_value = t_table.deleteAppt(cal_day.appts, new_appt2);
		
		
		//assertNull(return_value);
		assertEquals(1, cal_day.appts.size());
	 }
	 
	@Test
	  // Tests for deleting appointments
	  public void deleteApptTest05()  throws Throwable  {
		TimeTable t_table = new TimeTable();
		GregorianCalendar firstDay = new GregorianCalendar(2016, 4, 27);
		GregorianCalendar lastDay = new GregorianCalendar(2017, 4, 27);
		CalDay cal_day = new CalDay(firstDay);
		LinkedList<Appt> return_value;
		
		
		Appt new_appt = new Appt(13, 30, 28, 04, 2017,
					"Birthday Party",
					"This is my birthday party.");

		Appt new_appt2 = new Appt(15, 30, 28, 04, 2017,
					"Birthday Afterparty",
					"This is my birthday afterparty.");			
					
		Appt new_appt3 = new Appt(17, 30, 28, 04, 2017,
					"Birthday Afterafterparty",
					"This is my birthday afterafterparty.");	

				
		cal_day.addAppt(new_appt);
		cal_day.addAppt(new_appt2);
		
		// Search for something not in range
		return_value = t_table.deleteAppt(cal_day.appts, new_appt3);
		
		
		assertNull(return_value);
		assertEquals(2, cal_day.appts.size());
	 }
	 
	 
}
