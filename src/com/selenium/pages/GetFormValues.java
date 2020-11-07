package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetFormValues {

	// Constructors are already given. If required, you can add more code into
	// it but do NOT remove the existing code.
	public WebDriver driver;

	public GetFormValues() {
	}

	public GetFormValues(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserName() {

		// locate and return the value passed inside the textbox 'username'
		return driver.findElement(By.id("uname")).getAttribute("value")
				.toString();

	}

	public String getUserEmail() {

		// locate and return the value passed inside the textbox 'Useremail'
		return driver.findElement(By.id("uemail")).getAttribute("value")
				.toString();
	}

	public String getUserPhone() {

		// locate and return the value passed inside the textbox 'Userphone'
		return driver.findElement(By.id("phone")).getAttribute("value")
				.toString();
	}

	public String getUserAge() {

		// locate and return the value passed inside the textbox 'Userage'
		return driver.findElement(By.id("age")).getAttribute("value")
				.toString();
	}

	public String getUserPwd() {

		// locate and return the value passed inside the textbox 'Userpassword'
		return driver.findElement(By.id("ucountry")).getAttribute("value")
				.toString();
	}

	public String getUserCheckBox1() {

		// locate and return the value selected with checkbox text 'Cricket'
		return driver.findElement(By.id("option1")).getAttribute("value")
				.toString();
	}

	public String getUserCheckBox2() {

		// locate and return the value selected with checkbox text 'Football'
		return driver.findElement(By.id("option2")).getAttribute("value")
				.toString();
	}

	public String getUserRadiobtn() {

		// locate and return the value selected with radio button option text
		// 'Male' or 'Female'
		if (driver.findElement(By.id("female")).isSelected()) {

			String fm = driver.findElement(By.id("female")).getAttribute(
					"value");
			return fm;
		} else if (driver.findElement(By.id("male")).isSelected()) {
			String male = driver.findElement(By.id("male")).getAttribute(
					"value");
			return male;
		}
		return null;
	}

	public String getUserCity() {

		// locate and return the value passed inside the textbox 'Usercity'
		return driver.findElement(By.id("city")).getAttribute("value")
				.toString();
	}

	public String getUserAddress() {

		// locate and return the value passed inside the textbox 'Address'
		return driver.findElement(By.id("uaddr")).getAttribute("value")
				.toString();
	}

	public String getTitle() {

		// locate and return the title
		return driver.getTitle();
	}

}
