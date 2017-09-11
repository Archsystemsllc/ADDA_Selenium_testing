/**
 * Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
 */
package testSuites;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import base.TestBase;
import pageObjects.LoginPage;
/**
 * This class consists of methods to login into application
 * @author SanathKumar
 * @version 1.1
 */
public class TestLogin extends TestBase {
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);

		log.debug("Navigated to Sign In Page");
	}
	
	@Test(dataProvider="getData")
	public void loginTest(String fullName, String password) throws InterruptedException {

		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clickSubmit();
		log.debug("Clicked submit button");
		Thread.sleep(15000);
	
	}	
	
}
