/**
 * Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
 */
package testSuites;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.DashboardPage;
/**
 * This class consists of a method to verify graph in Hypothesis 5 Frequencies
 * @author SanathKumar
 * @version 1.1
 */
public class Frequencies extends TestBase {
	
	DashboardPage dashboardPage;

	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
/**
 * This method consists of all actions necessary to verify line chart 	
 * @throws InterruptedException
 */
	@Test
	public void dashboardTest() throws InterruptedException{
		log.info("dashboard test for Frequency in Hypothesis 5 has started");
		/**
		 * helps in redirecting page to home page 
		 */
		dashboardPage.goBackPage();
		/**
		 * to click on required view button
		 */
		dashboardPage.clickOnView(9);
		Thread.sleep(10000);
		/**
		 * entering measure id to select measure name
		 */
		dashboardPage.searchMeasureNameforFrequencies("100");		

		dashboardPage.clickOnSubmit();
		Thread.sleep(50000);
		/**
		 * asserting the display of graph
		 */
		Assert.assertTrue(dashboardPage.verifyGraph());
		log.info("dashboard test for Frequency in Hypothesis 5 has ended");
		
	}
	
	
	
}
