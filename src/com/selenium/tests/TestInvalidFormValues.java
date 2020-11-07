package com.selenium.tests; //Do not change the package name

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.annotations.Listeners;
import com.selenium.pages.SetFormValues;
import com.selenium.pages.GetFormValues;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

@Listeners(FeatureTest.class)
// Do not change or remove this line.
public class TestInvalidFormValues { // Do not change the class name

	public static WebDriver driver;

	SetFormValues SetFormValues;
	GetFormValues GetFormValues;

	public static String blankErrtxt;

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
		// name 'user_invalid'
		// Return the value
		ExcelUtils ex = new ExcelUtils();
		return ex.readExcelData("user_invalid");

	}

	@Test
	// Apply the required annotation
	public void testInvalidUserDetails() throws Exception {
		// Call the method 'getExcelData()' to read the excel file.
		// Using 'SetFormValues' object set the form values read from excel data
		/**
		 * Example: array of '0' has user name, invoke the 'setUserName' method
		 * using 'SetFormValues' and pass the user name
		 **/
		// Submit the form
		// Locate the error message and assign it to variable 'blankErrtxt'
		// Assert whether 'blankErrtxt' is 'Phone can't be blank'
		TestInvalidFormValues ti = new TestInvalidFormValues();
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
		SetFormValues.RegisterForm();
		blankErrtxt = SetFormValues.getErrorMessage();
		Assert.assertEquals(blankErrtxt, "Phone can't be blank");

	}

	@AfterClass
	// Apply the required annotation
	public void closeBrowser() {
		// close the driver
		driver.close();
	}

}