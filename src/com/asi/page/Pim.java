package com.asi.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.asi.common.Common;
import com.asi.populateTestSuite.TestSuite;
import com.asi.testSuite.*;
import com.asi.util.AbstractHRMSTest;

public class Pim extends AbstractHRMSTest{

	WebDriver driver;
	
	private By welcome_L = By.id(uilocation.get("ui.pim.welcome"));
	private By leaveMenu_L = By.id(uilocation.get("ui.menu.leave"));
	private By employeeName_L = By.id(uilocation.get("ui.pim.configuration.employeeName"));
	private By searchButton_L = By.id(uilocation.get("searchBtn"));
	private By resultTableSingleResult_L = By.xpath(uilocation.get("ui.pim.configuration.resultTable.xpath"));
	
	
	private String expected_value;
	private String actual_value;
	
			
			
	public Pim(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void checkLoginUser(TestSuite testSuite){
		Common cmn = new Common(driver);
		expected_value = expected.get("home.welcome");
		actual_value = cmn.getUiText(welcome_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	}
	
	public Leave navigateToLeave(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.clickButton(leaveMenu_L);
		return PageFactory.initElements(driver, Leave.class);
	}
	
	public void searchEmployee(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.enterText(employeeName_L, "Raghav");
		cmn.clickButton(searchButton_L);
		actual_value = cmn.getUiText(resultTableSingleResult_L);
		expected_value = "Raghav";
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	}
	
}
