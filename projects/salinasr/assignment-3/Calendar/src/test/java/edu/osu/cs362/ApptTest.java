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
		Appt appt = new Appt(11, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
		String return_string =  appt.toString();

		assertTrue(appt.getValid());
		assertNotNull(return_string);	

	 }
	 
	 @Test
	// Set start hour to 11, check edge case
	 public void toStringTest01()	throws Throwable  {
		Appt appt = new Appt(11, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
		String return_string =  appt.toString();

		assertTrue(appt.getValid());
		assertNotNull(return_string);	
		assertEquals("\t"+appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() +" at "
		+appt.getStartHour()+":"+appt.getStartMinute() +"am"+" ,"+appt.getTitle()+", "+appt.getDescription()+"\n", return_string);
	 }
	 
	 @Test
	// Set start hour to 13, check edge case
	 public void toStringTest02()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
		String return_string =  appt.toString();

		assertTrue(appt.getValid());
		assertNotNull(return_string);	
		assertEquals("\t"+appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() +" at "
		+"1"+":"+appt.getStartMinute() +"pm"+" ,"+appt.getTitle()+", "+appt.getDescription()+"\n", return_string);
	 }
	 
	 // Invalid start hour
	 public void isValidTest01()	throws Throwable {
		
		Appt appt = new Appt(0, 0, 0, 0, 0, 
						null, 
						null);
		 
		assertTrue(appt.getValid());
	 }

	@Test
	 public void isValidSetTests01()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				
		// Testing upper edge case of isValid()
		appt.setStartHour(23);
		appt.setStartMinute(59);
		appt.setStartDay(31);
		appt.setStartMonth(12);


		 assertTrue(appt.getValid());
		 assertEquals(23, appt.getStartHour());
		 assertEquals(59, appt.getStartMinute());
		 assertEquals(31, appt.getStartDay());
		 assertEquals(12, appt.getStartMonth());
	
	 }
	 
	 
	@Test
	 public void isValidSetTests02()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				
		// Testing lower edge case of isValid()
		appt.setStartHour(0);
		appt.setStartMinute(0);
		appt.setStartDay(1);
		appt.setStartMonth(1);


		 assertTrue(appt.getValid());
		 assertEquals(0, appt.getStartHour());
		 assertEquals(0, appt.getStartMinute());
		 assertEquals(1, appt.getStartDay());
		 assertEquals(1, appt.getStartMonth());
	 }

	 @Test
	 public void isValidSetTests03()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
			
		appt.setStartHour(-1);

		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartHour());
	 }
	 
	@Test
	 public void isValidSetTests04()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				
		appt.setStartMinute(-1);

		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartMinute());

	 }
	 
	@Test
	 public void isValidSetTests05()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				
		appt.setStartDay(-1);

		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartDay());

	 }
	 
	@Test
	 public void isValidSetTests06()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				
		appt.setStartMonth(-1);


		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartMonth());
	 }
	

	// This test won't change anything since the appointment will
	// always be valid no matter what year is set as
	@Test
	 public void isValidSetTests07()	throws Throwable  {
		Appt appt = new Appt(13, 30, 10, 04, 2017,
				     "Birthday Party",
				     "This is my birthday party.");
				

		 appt.setStartYear(-1);

		assertTrue(appt.getValid());
		assertEquals(-1, appt.getStartYear());
	 
	 }
}
