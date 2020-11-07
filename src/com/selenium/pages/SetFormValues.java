package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SetFormValues {

	public WebDriver driver;

	// Constructors are already given. If required, you can add more code into
	// it but do NOT remove the existing code.
	public SetFormValues() {
	}

	public SetFormValues(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String name) {
		// locate and fill the input box of the 'user name' with 'name'
		// Example: driver.findElement(By.name("Username")).sendKeys(name)
		driver.findElement(By.id("uname")).sendKeys(name);
	}

	public void setUserEmail(String emailid) {

		// locate and fill the input box of the 'user email' with 'emailid'
		driver.findElement(By.id("uemail")).sendKeys(emailid);

	}

	public void setUserPhone(String phonenum) {

		// locate and fill the input box of the 'user phone numer' with
		// 'phonenum'
		driver.findElement(By.id("phone")).sendKeys(phonenum);

	}

	public void setUserAge(String age) {

		// locate and fill the input box of the 'user age' with 'age'
		driver.findElement(By.id("age")).sendKeys(age);
	}

	public void setUserPassword(String pwd) {

		// locate and fill the input box of the 'user password' with 'pwd'
		driver.findElement(By.id("pass")).sendKeys(pwd);

	}

	public void setUserHobbies(String value) {
		// locate and fill the input box of the 'user hobbies' with 'value'
		// if value is "Cricket" then select chkbox1 else if value is "Football"
		// then select chkbox2
		if (value.equalsIgnoreCase("Cricket")) {
			driver.findElement(By.id("option1")).click();
		} else if (value.equalsIgnoreCase("Football")) {
			driver.findElement(By.id("option2")).click();
		}
	}

	public void setUserGender(String radiobtn) {

		// locate and fill the input box of the 'user gender' with 'radiobtn'
		// if radiobtn is "Female" select radio option1 else if radiobtn is
		// "Male" select radio option2
		if (radiobtn.equalsIgnoreCase("Female")) {
			driver.findElement(By.id("female")).click();
		} else if (radiobtn.equalsIgnoreCase("Male")) {
			driver.findElement(By.id("male")).click();
		}

	}

	public void setUserCity(String city) {

		// locate and fill the input box of the 'user city' with 'city'
		WebElement dropBox = driver.findElement(By.id("city"));
		dropBox.click();
		Select option = new Select(dropBox);
		option.selectByValue(city);

	}

	public void setUserAddress(String addr) {

		// locate and fill the input box of the 'user address' with 'addr'
		driver.findElement(By.id("uaddr")).sendKeys(addr);

	}

	public void RegisterForm() {

		// locate the Register button and submit the form
		driver.findElement(By.id("reg")).click();

	}

	public String getErrorMessage() {
		// locate the error message displayed after submit and return the text
		// Example: driver.findElement(ErrorMsg).getText(); //.replace("<br>",
		// "").trim();
		String err = driver.findElement(By.id("errfn")).getText();
		err.replace("<br>", "").trim();
		return err;

	}

	public void reset() {

		// locate the cancel button and click for reset
		driver.findElement(By.id("cancel")).click();

	}
}