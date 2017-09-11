package testSuites;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.DashboardPage;

public class HighExclusionNotExpected extends TestBase {
	
	DashboardPage dashboardPage;
	
	@BeforeMethod
	public void testSetUp() {
		dashboardPage = new DashboardPage(driver);		
	}
	
	@Test
	public void dashboardTest() throws InterruptedException{
		log.info("dashboard test for High Exclusion Not Expected in Hypothesis 5 has started");
		dashboardPage.goBackPage();
		dashboardPage.clickOnView(8);
		Thread.sleep(10000);
		
		
		dashboardPage.selectMeasureNameforNotExpected("100");		

		dashboardPage.clickOnSubmit();
		Thread.sleep(50000);
		Assert.assertTrue(dashboardPage.verifyGraph());
		log.info("dashboard test for High Exclusion Not Expected in Hypothesis 5 has ended");
		
	}
	
	
	
}
