/**
 * Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
 */
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utilities.ExcelReader;
/**
 * This class consists of information from where test data needs to be taken, and invoking firefox browser
 * @author SanathKumar
 * @version 1.1
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/test_data.xlsx");
/**
 * Method for invoking firefox browser and navigating to application URL
 * @throws IOException
 */
	@BeforeSuite	
	public void setUp() throws IOException {
		DOMConfigurator.configure("../TestAutomationFrameworkMaster/src/test/resources/properties/log4j.xml");
		log.info("TestBase setup has started...");
		if (driver == null) {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			config = new Properties();
			config.load(fis);

			if (config.getProperty("browser").equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver.exe");
				driver = new FirefoxDriver();
			} 
			// Rendering Base URL
/*
 * navigate to application URL			
 */
			driver.get(config.getProperty("test_site_url"));
			/*
			 * Maximizing window
			 */
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("Navigated to site url: " + config.getProperty("test_site_url"));
			log.info("setup has ended");
		}
	}

@AfterSuite	
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
//		driver.close();
		driver.quit();
		log.debug("Close the driver");
	}
/**
 * Method to take test data from excel file located in src/test/resources/properties/excel/test_data
 * @param m
 * @return
 */
	@DataProvider
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}
