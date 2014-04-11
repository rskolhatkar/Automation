package com.asi.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.asi.populateTestSuite.TestSuite;


public class Common {

	WebDriver driver;
	public WebElement webElement;
	
	public Common(WebDriver driver){
		this.driver = driver;
	}
	
	
	
	public void clickButton (By locator){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}


	
	public void enterText (By locator, String text){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	
	public void selectDropDownValue (By locator, String text){
	
		WebDriverWait wait = new WebDriverWait(driver, 120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		new Select(webElement).selectByVisibleText(text);
	}
	
	
	public void selectUnselectCheckbox(By locator){
		WebDriverWait wait = new WebDriverWait(driver,120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public void selectUnselectRadioButton(By locator){
		WebDriverWait wait = new WebDriverWait(driver,120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public void clickOnLink(By locator){
		WebDriverWait wait = new WebDriverWait(driver,120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	public String getUiText(By locator){
		WebDriverWait wait = new WebDriverWait(driver,120);
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return webElement.getText();
	}
	
	public void assertionCheck(TestSuite testSuite, String actual_value, String expected_value){
	
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
	
	public String assertionMultipleCheck(TestSuite testSuite, String actual_value, String expected_value){
		
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
	
	
}
