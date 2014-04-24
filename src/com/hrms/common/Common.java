package com.hrms.common;
/**
 * COMMON FUNCTION FILE
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.populateTestSuite.TestSuite;


public class Common {

	WebDriver driver;
	public WebElement webElement;
	
	public Common(WebDriver driver){
		this.driver = driver;
	}
	
	
	
	public void clickButton (By locator){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}


	
	public void enterText (By locator, String text){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	
	public void selectDropDownValue (By locator, String text){
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		new Select(webElement).selectByVisibleText(text);
	}
	
	
	public void selectUnselectCheckbox(By locator){
		WebDriverWait wait = new WebDriverWait(driver,10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public void selectUnselectRadioButton(By locator){
		WebDriverWait wait = new WebDriverWait(driver,10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public void clickOnLink(By locator){
		WebDriverWait wait = new WebDriverWait(driver,10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public String getUiText(By locator){
		WebDriverWait wait = new WebDriverWait(driver,10);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return webElement.getText();
	}
	
	public void assertionCheck(TestSuite testSuite, String actual_value, String expected_value) {
	
		String error_message = "Actual and Expected value are not matching.";
		try{
			Assert.assertEquals(actual_value, expected_value);
			testSuite.setTestExecutionStatus("Passed");
			testSuite.setTestExecutionErrorMessage("");
		} catch(Throwable e){
			String message = "Expected is \"" +  expected_value +"\" and Actual value is \"" + actual_value + "\"."; 
			testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage(error_message.concat(message));
			
		}
	
	}
	
	public String assertionMultipleCheck(TestSuite testSuite, String actual_value, String expected_value) throws IOException{
		
		String error_message = "Actual and Expected value are not matching. ";
		try{
			Assert.assertEquals(actual_value, expected_value);
			testSuite.setTestExecutionStatus("Passed");
			testSuite.setTestExecutionErrorMessage("");
		} catch(Throwable e){
			String message = "Expected is \"" +  expected_value +"\" and Actual value is \"" + actual_value + "\"." + "\n";
//			message.concat(System.lineSeparator());
			testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage(error_message.concat(message));
			
		}
		
	return testSuite.getTestExecutionErrorMessage();
	}
	
	public void takeScreenShots(TestSuite testSuite){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("../AutomationProject/reports/screenshots/" + testSuite.getTestCaseId()+
					"_" +testSuite.getTestExecutionStatus() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
