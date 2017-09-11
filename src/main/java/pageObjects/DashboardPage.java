/**
* Copyright (c) 2017, Archsystems Inc and/or its affiliates. All rights reserved.
*/
package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import base.TestBase;
/**
 * This Class consists of all elements that are used in the test cases of testSuites package. It also consists of all user actions performed using these elements.
 * @author SanathKumar
 * @version 1.1
 */
public class DashboardPage extends BasePage {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	// Elements
	String viewXpath = "html/body/table/tbody/tr/td[2]/div/div/table/tbody/tr[0]/td[2]/a/button";

	public By view;
	public By optionYear = By.xpath(".//*[@id='yearLookUpId']");
	public By reportingOption = By.xpath(".//*[@id='reportingOptionLookupId']");
	public By parameterName = By.xpath(".//*[@id='parameterLookupId']");
	public By reportType = By.xpath(".//*[@id='reportTypeId']");
	public By submit = By.xpath(".//*[@id='displayreport']");
	public By graph = By.xpath(".//*[@id='chart-canvas']");
	public By yesOrNo = By.xpath("html/body/table/tbody/tr/td[2]/div[1]/table/tbody/tr[4]/td[2]/select/option[3]");
	public By execFireOption = By.xpath("html/body/table/tbody/tr/td[2]/div[1]/table/tbody/tr[1]/td[2]/select");
	public By searchMeasureNameforExpected = By.xpath("//*[@id='automplete-1']");
	public By searchMeasureNameforNotExpected = By.xpath("html/body/table/tbody/tr/td[2]/div[1]/table/tbody/tr[3]/td[2]/div/label/input");
	public By searchMeasureNameforFrequencies = By.cssSelector("#automplete-1");
/**
 * Measure box upon selecting measure ids
 */
	public By measureName = By.xpath("html/body/table/tbody/tr/td[2]/div[1]/table/tbody/tr[4]/td[2]/label/select");
/**
 * element location of hint box appears upon entering measure id or measure name	
 */
	public By hint = By.xpath("html/body/ul/li/div");
	public By exposrtAsPdf = By.xpath(".//*[@id='downloadPDF']");
	public By uploadTab = By.xpath(".//*[@id='header']/nav/div/table/tbody/tr[3]/td/div/ul/li[2]/a");
	public By selectUploadFileDrpDwn = By.xpath("html/body/table/tbody/tr/td[2]/div/div/div[2]/form/table/tbody/tr[1]/td/select[1]");
	public By browse = By.xpath("html/body/table/tbody/tr/td[2]/div/div/div[2]/form/table/tbody/tr[2]/td[2]/p/input");
	public By uploadButton = By.xpath("html/body/table/tbody/tr/td[2]/div/div/div[2]/form/table/tbody/tr[2]/td[3]/div/input[1]"); 
	public By homeButton = By.xpath(".//*[@id='header']/nav/div/table/tbody/tr[3]/td/div/ul/li[1]/a");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// Methods for User Actions
/**
 * Method for redirecting any page to home page by clicking on homebutton.
 */
	public void goBackPage() {
		DOMConfigurator.configure("../TestAutomationFrameworkMaster/src/test/resources/properties/log4j.xml");
		if (!driver.getTitle().equals("Hypothesis")) {
			driver.findElement(homeButton).click();
			log.info("Clicked on Home Button to navigate to Dashboard Page");
		}

	}
/**
 * common method for clicking on view buttons 
 * @param n
 */
	public void stringReplaceForViewXpath(int n) {
		viewXpath = viewXpath.replace("0", Integer.toString(n));
		view = By.xpath(viewXpath);
		System.out.println(viewXpath);
	}

	
/**
 * method for replacing n value and clicking on respective view button of the hypothesis
 * @param n
 */
	public void clickOnView(int n) {
		stringReplaceForViewXpath(n);

		driver.findElement(view).click();
		log.info("Clicked on View button and waiting for page to load to select the parameters");
	}
/**
 * Method for selecting option year
 * @param option
 * @throws InterruptedException
 */
	public void selectOptionYear(String option) throws InterruptedException {
		Thread.sleep(10000);
		Select select = new Select(driver.findElement(optionYear));
		select.selectByVisibleText(option);
		log.info("Selected Option Year");
	}
/**
 * Method for Selecting reporting option
 * @param option
 */
	public void selectreportingOption(String option) {
		Select select = new Select(driver.findElement(reportingOption));
		select.selectByVisibleText(option);
		log.info("Selected Reporting Option");
	}
/**
 * Method for selecting parameter name
 * @param option
 */
	public void selectparameterName(String option) {
		Select select = new Select(driver.findElement(parameterName));
		select.selectByVisibleText(option);
		log.info("Selected Parameter Name");
	}
/**
 * Method for selecting reporting option
 * @param option
 */
	public void selectreportType(String option) {
		Select select = new Select(driver.findElement(reportType));
		select.selectByVisibleText(option);
		log.info("Selected the Report Type");
	}
/**
 * Method for Selecting Exclusive or Frequency option in Hypothesis 4,5,6
 * @param option
 * @throws InterruptedException
 */
	public void selectExeFreOption(String option) throws InterruptedException {
		Thread.sleep(10000);
		Select select = new Select(driver.findElement(execFireOption));
		select.selectByVisibleText(option);
		log.info("Selected Option Year");
	}
/**
 * Method for selecting measure name by entering measure id for Hypothesis 5 Expected
 * @throws InterruptedException
 */
	public void selectMeasureName() throws InterruptedException {
		Thread.sleep(5000);
		WebElement measureBox = driver.findElement(By.xpath("//*[@id='automplete-1']"));
		measureBox.sendKeys("100");
		log.info("Measure id entered to select Measure name");
		driver.findElement(hint).click();
		log.info("hint in the dropdown selected");
	}
/**
 * Method for selecting measure name by entering measure id for Hypothesis 5 Not Expected
 * @param option
 * @throws InterruptedException
 */
	public void selectMeasureNameforNotExpected(String option) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(searchMeasureNameforNotExpected).sendKeys(option);
		log.info("Measure id entered to select Measure name");
		
		driver.findElement(hint).click();
		log.info("hint in the dropdown selected");
		
	}
/**
 * Method for selecting measure name by entering measure id for Hypothesis 5 Frequencies
 * @throws InterruptedException
 */
	public void searchMeasureNameforFrequencies(String option) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(searchMeasureNameforFrequencies).sendKeys(option);
		log.info("Measure id entered to select Measure name");
		driver.findElement(hint).click();
		log.info("hint in the dropdown selected");
	}
/**
 * Method for selecting measure name by entering measure id for Hypothesis 4
 * @param option
 * @throws InterruptedException
 */
	public void searchMeasureNameforHypothesisFour(String option) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(searchMeasureNameforNotExpected).sendKeys(option);
		log.info("Measure id entered to select Measure name");

		driver.findElement(hint).click();
		log.info("hint in the dropdown selected");
	}
/**
 * Method for selecting measure name by entering measure id for Hypothesis 6
 * @param option
 * @throws InterruptedException
 */
	public void searchMeasureNameforHypothesisSix(String option) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(searchMeasureNameforNotExpected).sendKeys(option);
		log.info("Measure id entered to select Measure name");

		driver.findElement(hint).click();
		log.info("hint in the dropdown selected");
	}
/**
 * method for selecting required hypothesis from the dropdown after clicking on upload button on Home page
 * @throws InterruptedException
 */
	public void selectUploadOption() throws InterruptedException{
		Thread.sleep(15000);
		Select select = new Select(driver.findElement(selectUploadFileDrpDwn));
		log.info("CLicked on dropdown");
		select.selectByVisibleText("Hypothesis 1 & 2"); 
		log.info("Hypothesis 1&2 selected");
	}
	
/**
 * Method for clicking on submit button after selecting all parameters in every hypothesis	
 */
	public void clickOnSubmit() {
		driver.findElement(submit).click();
		log.info("Clicked on Submit button and waiting for graph to display");
	}
/**
 * Method for clicking on Export as PDF button after Line Chart is being displayed in Hypothesis 1&2
 */
	public void clickOnExportAsPdf() {
		driver.findElement(exposrtAsPdf).click();
		log.info("Clicked on Export as PDF button");
	}
/**
 * Method for handling windows pop-up to save the line chart in pdf format.
 * @throws AWTException
 * @throws InterruptedException
 */
	public void verifySaveAsWindow() throws AWTException, InterruptedException {
		Thread.sleep(10000);
		Robot robot = new Robot();		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("Clicked on Save button to save the file");
	}
/**
 * Method for clicking on browse button against provider data after clicking on upload button on home page and selecting hypothesis 1&2	
 */
	public void clickOnBrowse(){
		driver.findElement(browse).click();
		log.info("Clicked on browse button");
	}
/**
 * Method for clicking on upload tab on Home page	
 */
	public void clickOnUploadMenu(){
		//to click on Upload menu option
		driver.findElement(uploadTab).click();
		log.info("Clicked on Upload tab");
	}
/**
 * Method for selecting appropriate file from computer, that is handling windows pop-up upon clicking browse button.
 * @throws AWTException
 * @throws InterruptedException
 */
	public void setUploadFile() throws AWTException, InterruptedException{
		StringSelection file = new StringSelection("C:\\Users\\SanathKumar\\Desktop\\Arch\\AddA\\TestAutomationFrameworkMaster\\src\\test\\resources\\excel\\Dummy_Provider_Data.xlsx");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		log.info("Select the file to upload");
	}
/**
 * Method for clicking on upload button after selecting require file for upload functionality	
 */
	public void clickOnUploadButton(){
		driver.findElement(uploadButton).click();
		log.info("A file has been uploaded");
	}
/**
 * Method for verifying graph's presence	
 * @return
 */
	public Boolean verifyGraph() {
		log.info("Graph is successfully displayed");
		return driver.findElement(graph).isDisplayed();
		
		
	}
}
