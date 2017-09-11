/**
* Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
*/

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists methods to invoke the browser and URL
 * @author SanathKumar
 * @version 1.1
 */
public abstract class BasePage {

	public WebDriver driver;
	public String url = "http://ec2-34-208-54-139.us-west-2.compute.amazonaws.com/imapui";
	
	// Elements / Instance Variables
	public By msg = By.xpath("//*[@id='header']/nav/div/table/tbody/tr[1]/td[2]/div");
	
	// User Actions / Instance Methods
	public void waitForElementToBeVisible(By element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	/**
	 * Opening the URL
	 */
	public void open() {
		driver.get(this.url);
	}
	
}
