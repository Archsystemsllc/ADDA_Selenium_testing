/**
 * Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
 */
package testSuites;

import java.awt.AWTException;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.DashboardPage;
/**
 * This class consists of method to verify the upload button functionality in the home page
 * @author SanathKumar
 * @version 1.1
 */
public class TestUploadfile extends TestBase {
	
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
/**
 * 	Method for handling windows pop-up
 * @throws InterruptedException
 * @throws AWTException
 */
	@Test
	public void dashboardTest() throws InterruptedException, AWTException{
		log.info("dashboard test for TestUploadfile has started");
		dashboardPage.clickOnUploadMenu();
		dashboardPage.selectUploadOption();
		dashboardPage.clickOnBrowse();
		dashboardPage.setUploadFile();
		dashboardPage.clickOnUploadButton();
		Thread.sleep(10000);
		log.info("dashboard test for TestUploadfile has ended");
	}
	
	
	
}
