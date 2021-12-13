package org.com;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Junit extends BaseClass {
	
	static Pom p;
	static String ordernum;
	@BeforeClass
	public static void launch() {
		launch("https://adactinhotelapp.com/index.php");
	}
	
	@Before
	public void startTime() {
	  Date d = new Date();
	  System.out.println("Test Start Time: " +d);

	}
	
	@Before
	public void endTime() {
	  Date d = new Date();
	  System.out.println("Test End Time: " +d);

	}
	
	@Test
	public void a() throws IOException {
		 p = new Pom();
		insertvalues(p.getUsername(), excelRead("E:\\Excel\\JunitTest.xlsx", "login", 0, 0));
		insertvalues(p.getPassword(), excelRead("E:\\Excel\\JunitTest.xlsx", "login", 0, 1));
		Assert.assertTrue(driver.getTitle().contains("Hotel"));
		btnClick(p.getLogin());
		
	}
	
	@Test
	public void b() throws NumberFormatException, IOException {
		Assert.assertTrue(driver.getTitle().contains("Search Hotel"));
		System.out.println("Search Hotel");
		selectByIndex(p.getLocation(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 0, 1)));
		selectByIndex(p.getHotels(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 1, 1)));
		selectByIndex(p.getRoom_type(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 2, 1)));
		selectByIndex(p.getRoom_nos(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 3, 1)));
		insertvalues(p.getDatepick_in(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 4, 1));
		insertvalues(p.getDatepick_out(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 5, 1));
		selectByIndex(p.getAdult_room(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 6, 1)));
		selectByIndex(p.getChild_room(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "search", 7, 1)));
		btnClick(p.getSearch());
	}
	
	@Test
	public void c() {
		Assert.assertTrue(driver.getTitle().contains("Select Hotel"));
		System.out.println("Select Hotel");
		btnClick(p.getRadiobutton());
		btnClick(p.getContinueBtn());

	}
	
	@Test
	public void d() throws IOException, InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Book A Hotel"));
		System.out.println("Book A Hotel");
		insertvalues(p.getFirstName(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 0, 1));
		insertvalues(p.getLastName(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 1, 1));
		insertvalues(p.getAddress(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 2, 1));
		insertvalues(p.getCreditCardNo(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 3, 1));
		selectByIndex(p.getCreditCardType(), Integer.parseInt(excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 4, 1)));
		selectByValue(p.getExpMonth(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 5, 1));
		selectByValue(p.getExpYear(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 6, 1));
		insertvalues(p.getCvvNo(), excelRead("E:\\\\Excel\\\\JunitTest.xlsx", "bookhotel", 7, 1));
		btnClick(p.getBookNow());
		wait(8000);
		

	}
	@AfterClass
	public static void orderConfirmation() throws IOException {
		Assert.assertTrue(driver.getTitle().contains("Hotel Booking"));
		System.out.println("Booking Confirmed");
		 ordernum = ordernum("order_no");
		 excelWrite("E:\\\\\\\\Excel\\\\\\\\JunitTest.xlsx", "test", 0, 0, ordernum);
		 
		
		
		
		
		

	}
	
	
}
