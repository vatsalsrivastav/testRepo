package com.selenium.tests; //Do not change the package name

import static org.testng.Assert.assertEquals;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.annotations.Listeners;
import com.selenium.pages.SetFormValues;
import com.selenium.pages.GetFormValues;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

@Listeners(FeatureTest.class)
// Do not change or remove this line.
public class TestValidFormValues { // Do not change the class name

	public static WebDriver driver;
	SetFormValues SetFormValues;
	GetFormValues GetFormValues;

	public static String uname;
	public static String umail;
	public static String uphone;
	public static String uage;
	public static String upass;
	public static String uhobbies1;
	public static String uhobbies2;
	public static String uradiobtn;
	public static String ucity;
	public static String uaddr;

	@BeforeClass
	// Apply the required annotation
	public void setUp() {
		// create the driver using method 'getDriver' in class DriverSetup.
		// Assign it to the variable 'driver'
		DriverSetup obj = new DriverSetup();
		driver = obj.getDriver();

		// DO NO CHANGE THE BELOW 2 OBJECT CREATIONS
		SetFormValues = new SetFormValues(driver);
		GetFormValues = new GetFormValues(driver);
	}

	public static String[] getExcelData() throws Exception {
		// Call the method 'readExcelData' in class 'ExcelUtils' using sheet
		// name 'user_valid'
		// Return the value
		ExcelUtils ex = new ExcelUtils();
		return ex.readExcelData("user_valid");
	}

	@Test
	// Apply the required annotation
	public void testvalidUserDetails() throws Exception {

		// Call the method 'getExcelData()' to read the excel file.
		// Using 'SetFormValues' object set the form values read from excel data
		/**
		 * Example: array of '0' has user name, invoke the 'setUserName' method
		 * using 'SetFormValues' and pass the user name
		 **/
		TestValidFormValues ti = new TestValidFormValues();
		String st[] = ti.getExcelData();
		SetFormValues.setUserName(st[0]);
		SetFormValues.setUserEmail(st[1]);
		SetFormValues.setUserPhone(st[2]);
		SetFormValues.setUserAge(st[3]);
		SetFormValues.setUserPassword(st[4]);
		SetFormValues.setUserHobbies(st[5]);
		SetFormValues.setUserGender(st[6]);
		SetFormValues.setUserCity(st[7]);
		SetFormValues.setUserAddress(st[8]);

		/**
		 * Using 'GetFormValues' object invoke the 'get' methods to get
		 * respective values Example : method 'getUserName' will return the
		 * value which is passed
		 *
		 * Locate the user name using getUserName() method and store it in a
		 * static variable ‘uname’ Locate the user email using getUserEmail()
		 * method and store it in a static variable ‘umail’ Locate the user
		 * phone using getUserPhone() method and store it in a static variable
		 * ‘uphone’ Locate the user age using getUserAge() method and store it
		 * in a static variable ‘uage’ Locate the user password using
		 * getUserPwd() method and store it in a static variable ‘upass’ Locate
		 * the user hobbies (Football) using getUserCheckBox2() method and store
		 * it in a static variable ‘uhobbies2’ (If hobbies chosen is ‘Cricket’
		 * then use the method getUserCheckBox1() and store it in a static
		 * variable ‘uhobbies1’) Locate the user gender using getUserRadiobtn()
		 * method and store it in a static variable ‘uradiobtn’ Locate the user
		 * city using getUserCity() method and store it in a static variable
		 * ‘ucity’ Locate the user address using getUserAddress() method and
		 * store it in a static variable ‘uaddr’
		 **/
		uname = GetFormValues.getUserName();
		umail = GetFormValues.getUserEmail();
		uphone = GetFormValues.getUserPhone();
		uage = GetFormValues.getUserAge();
		upass = GetFormValues.getUserPwd();
		// if(st[5].equalsIgnoreCase("Football")){
		uhobbies2 = GetFormValues.getUserCheckBox2();
		// }else if(st[5].equalsIgnoreCase("Cricket")){
		uhobbies1 = GetFormValues.getUserCheckBox1();
		// }
		uradiobtn = GetFormValues.getUserRadiobtn();
		ucity = GetFormValues.getUserCity();
		uaddr = GetFormValues.getUserAddress();

		// Submit the form
		SetFormValues.RegisterForm();

		// Assert whether the array value in '0' is equal to 'uname'
		// Assert whether the array value in '1' is equal to 'umail'
		// Assert whether the array value in '2' is equal to 'uphone'
		// Assert whether the array value in '3' is equal to 'uage'
		// Assert whether the array value in '4' is equal to 'upass'
		// Assert whether the array value in '5' is equal to 'uhobbies2' or
		// ‘uhobbies1’
		// Assert whether the array value in '6' is equal to 'uradiobtn'
		// Assert whether the array value in '7' is equal to 'ucity'
		// Assert whether the array value in '8' is equal to 'uaddr'
		Assert.assertEquals(st[0], uname);
		Assert.assertEquals(st[1], umail);
		Assert.assertEquals(st[2], uphone);
		Assert.assertEquals(st[3], uage);
		Assert.assertEquals(st[4], upass);
		if (st[5].equalsIgnoreCase("Football")) {
			Assert.assertEquals(st[5].toLowerCase(), uhobbies2);
		} else if (st[5].equalsIgnoreCase("Cricket")) {
			Assert.assertEquals(st[5].toLowerCase(), uhobbies1);
		}
		Assert.assertEquals(st[6].toLowerCase(), uradiobtn);
		Assert.assertEquals(st[7], ucity);
		Assert.assertEquals(st[8], uaddr);

	}

	@AfterClass
	// Apply the required annotation
	public void closeBrowser() {
		// close the driver
		driver.close();
	}

}