package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;


public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", 
			      appt.getDescription());         		
	 }

	@Test
	 public void test02()	throws Throwable  {
		Appt appt = new Appt(0, 0, 0, 0, 0, null, null);
		
		appt.setStartHour(13);
		appt.setStartMinute(30);
		appt.setStartDay(10);
		appt.setStartMonth(4);
		appt.setStartYear(2017);
		appt.setTitle("Birthday Party");
		appt.setDescription("This is my birthday party.");

		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", 
			      appt.getDescription());         		
	

	 }

	@Test
	 public void test03()	throws Throwable  {
		Appt appt = new Appt(0, 0, 0, 0, 0, null, null);
		String return_string =  appt.toString();

		assertFalse(appt.getValid());
		assertNull(return_string);	

	 }


	@Test
	 public void test04()	throws Throwable  {
		Appt appt = new Appt(0, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
		String return_string =  appt.toString();

		assertTrue(appt.getValid());
		assertNotNull(return_string);	

	 }

}
