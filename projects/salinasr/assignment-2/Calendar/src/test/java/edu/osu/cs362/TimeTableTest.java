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
		

		assertNotNull(t_table);
		
		//assertNotNull(t_table.calDays);
	 }


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

		assertNotNull(t_table);
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
		
		assertFalse(new_appt.getValid());
		assertNotNull(t_table);
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
		
		assertFalse(new_appt.getValid());
		assertNotNull(t_table);
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
	
		assertFalse(new_appt.getValid());
		assertNotNull(t_table);
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
	
		assertNotNull(t_table);
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


		assertNotNull(t_table);
		//assertNotNull(t_table.calDays);
	 }
}
