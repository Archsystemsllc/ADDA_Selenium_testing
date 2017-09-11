/**
* Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
*/
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * This class consists of element locations of fields required to login into application. Also, it contains methods to perform action against these elements.
 * @author SanathKumar
 * @version 1.1
 */
public class LoginPage extends BasePage {
	
	// Elements
	public By uName = By.xpath(".//*[@id='log_in']/div/div/form/div/input[1]");
	public By pWord = By.xpath(".//*[@id='log_in']/div/div/form/div/input[2]");
	public By login = By.xpath(".//*[@id='log_in']/div/div/form/button");

	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.url = super.url;
	}
	
	// User Actions
/**
 * Method for entering username on login page	
 * @param username
 */
	public void enterUsername(String username) {
		driver.findElement(uName).sendKeys(username);
	}
/**
 * Method for entering password on login page	
 * @param password
 */
	public void enterPassword(String password) {
		driver.findElement(pWord).sendKeys(password);
	}
/**
 * Method for clicking on Submit button after entering username and password on login page	
 */
	public void clickSubmit() {
		driver.findElement(login).click();
	}
	
}
