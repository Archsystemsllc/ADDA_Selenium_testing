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
 * This class consists of a method required to verify graph display of Hypothesis Four
 * @author SanathKumar
 * @version 1.1
 */
public class HypothesisFour extends TestBase {
	
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
	
	@Test
	public void dashboardTest() throws InterruptedException{
		log.info("dashboard test for Hypothesis 4 has started");
		dashboardPage.goBackPage();
		dashboardPage.clickOnView(10);
		Thread.sleep(10000);
		dashboardPage.selectExeFreOption("Frequency");
		dashboardPage.selectreportingOption("CLAIMS");
		dashboardPage.searchMeasureNameforHypothesisFour("100");	
		dashboardPage.clickOnSubmit();
		Thread.sleep(50000);
		Assert.assertTrue(dashboardPage.verifyGraph());
		log.info("dashboard test for Hypothesis 4 has ended");
		
	}
	
	
	
}
