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
 * This class consists of a method required to verify bar chart display in Hypothesis 1&2
 * @author SanathKumar
 * @version 1.1
 */
public class TestSummaryByReportingOptionWithBarChart extends TestBase {
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
	
	
	@Test
	public void dashboardTest() throws InterruptedException{
		log.info("dashboard test for TestSummaryByReportingOptionWithBarChart in Hypothesis 1&2 has started");
		dashboardPage.goBackPage();
		dashboardPage.clickOnView(2);

		Thread.sleep(15000);
		dashboardPage.selectOptionYear("ALL");
		
		dashboardPage.selectreportingOption("CLAIMS");
		
		dashboardPage.selectparameterName("Rural Area");
		
		dashboardPage.selectreportType("Bar Chart");
		
		dashboardPage.clickOnSubmit();
		Thread.sleep(50000);
		Assert.assertTrue(dashboardPage.verifyGraph());
		log.info("dashboard test for TestSummaryByReportingOptionWithBarChart in Hypothesis 1&2 has ended");
	}
	
	
	
}
