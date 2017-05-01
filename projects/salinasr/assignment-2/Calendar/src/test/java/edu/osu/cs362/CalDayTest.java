package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);

		assertEquals(2017, cal_day.getYear());

 
	  }

	@Test
	  public void test02()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);

		assertEquals(3, cal_day.getMonth());

 			
	  }
	
	@Test
	  public void test03()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);

		assertTrue(cal_day.isValid());

 
	  }
	
	@Test
	  public void test04()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay();

		assertFalse(cal_day.isValid());

 
	  }
	
	@Test
	  public void test05()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);
	 	Appt new_appt = new Appt(13, 30, 10, 4, 2017,
					"Birthday Party",
					"This is my birthday party.");

		
		cal_day.addAppt(new_appt);

		assertTrue(new_appt.getValid());
		assertEquals(1, cal_day.getSizeAppts());				
 
	  }

	@Test
	  public void test06()  throws Throwable  {
	//	GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay();
		/*Appt new_appt = new Appt(13, 30, 10, 4, 2017,
					"Birthday Party",
					"This is my birthday party.");
*/

		/*assertEquals("\t --- 1/1/1970 --- \n"
			     " --- -------- Appointments ------------ --- \n"
			     " cal_day.toString());
		
		assertNull(cal_day.toString()); */
	  }
	@Test
	  public void test07()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);
		Appt new_appt = new Appt(13, 30, 10, 4, 2017,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);
		String return_string = cal_day.toString();
	
		assertTrue(new_appt.getValid());	
		assertNotNull(return_string);
		assertNotEquals(0, cal_day.getSizeAppts());

	  }

	@Test
	  public void test08()  throws Throwable  {
		//GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay();
		Appt new_appt = new Appt(999, 999, 999, 999, 999,
					"Birthday Party",
					"This is my birthday party.");

		cal_day.addAppt(new_appt);

		assertFalse(new_appt.getValid()); 
	  }

	@Test
	  public void test09()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay();

		assertNull(cal_day.iterator());
 
	  }

	@Test
	  public void test10()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);

		
		assertNotNull(cal_day.iterator());
 
	  }


	// This is testing the for loop in addAppt to see
	// if it properly arranges inserted appointments

	@Test
	  public void test11()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay cal_day = new CalDay(cal);
		Appt new_appt = new Appt(13, 30, 10, 4, 2017,
					"Birthday Party",
					"This is my birthday party.");

		Appt new_appt2 = new Appt(16, 30, 10, 4, 2017,
					"Birthday Afterparty",
					"This is more birthday party time!");
		cal_day.addAppt(new_appt2);
		cal_day.addAppt(new_appt);
		

		assertTrue(new_appt.getValid()); 
		assertTrue(new_appt2.getValid()); 
		assertEquals(2, cal_day.getSizeAppts());
	  }


}
