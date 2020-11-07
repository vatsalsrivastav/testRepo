/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

package com.selenium.setup;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String baseUrl = "http://webapps.tekstac.com/FormRegistration/FormRegistration.html";
    
	public static WebDriver getDriver() {
	    System.setProperty("webdriver.gecko.driver", "E:/Cognizant/JavaPractice/HotelAvailabilityAutomation/Drivers/geckodriver.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver(firefoxOptions);
		driver.navigate().to(DriverSetup.baseUrl);
		String baseUrl = "http://webapps.tekstac.com/FormRegistration/FormRegistration.html";
		driver.get(baseUrl);
		return driver;
	}
}
