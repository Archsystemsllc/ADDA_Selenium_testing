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
 * This class consists of methods to verify functionality of Export as PDF button visible after displaying charts in the Hypothesis's 
 * @author SanathKumar
 * @version 1.1
 */
public class TestSaveAsScreen extends TestBase {
	
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
	
	@Test
	public void dashboardTest() throws InterruptedException, AWTException{
		log.info("dashboard test for TestSaveAsScreen has started");
		dashboardPage.goBackPage();
		dashboardPage.clickOnView(3);
		Thread.sleep(10000);
		
		Thread.sleep(15000);
		dashboardPage.selectOptionYear("ALL");
		dashboardPage.selectreportingOption("CLAIMS");
		dashboardPage.selectparameterName("Rural Area");
		dashboardPage.selectreportType("Line Chart");
		dashboardPage.clickOnSubmit();
		Thread.sleep(40000);
		dashboardPage.clickOnExportAsPdf();
		/**
		 * clicking on Ok button in the windows pop-up asking to save the file
		 */
		dashboardPage.verifySaveAsWindow();		
		log.info("dashboard test for TestSaveAsScreen has ended");
		
	}
	
	
	
}
