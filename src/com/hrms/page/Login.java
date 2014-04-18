package com.hrms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hrms.common.Common;
import com.hrms.dao.TestDataDao;
import com.hrms.populateTestSuite.*;
import com.hrms.util.AbstractHRMSTest;



public class Login extends AbstractHRMSTest{
    
	WebDriver driver;
		
	private By username_L = By.id(uilocation.get("ui.login.userid"));
	private By password_L = By.id(uilocation.get("ui.login.password"));
	private By login_L = By.id(uilocation.get("ui.login.btn"));
	private By login_L1 = By.id(uilocation.get("ui.login.btn1"));
	private By loginPanel_L = By.id("logInPanelHeading");
	private By blankUsername_L = By.id("spanMessage");
	private By blankPassword_L = By.id("spanMessage");
		
	private String adminUsername = applications.get("admin.userid");
	private String adminPassWord = applications.get("admin.password");
	
	
	private String expected_value; 
	private String actual_value;
	
	public Login(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void loginToHRMS(TestSuite testSuite){
		
		Common cmn = new Common(driver);
		cmn.enterText(username_L, testSuite.getLoginTestData().getUsername());
		cmn.enterText(password_L, testSuite.getLoginTestData().getPassword());
		cmn.clickButton(login_L);
	}
	
	
	public Pim validLoginToHRMS(TestSuite testSuite){
		Common cmn = new Common(driver);
		
		cmn.enterText(username_L, testSuite.getLoginTestData().getUsername());
		cmn.enterText(password_L, testSuite.getLoginTestData().getPassword());
		cmn.clickButton(login_L);
		return PageFactory.initElements(driver, Pim.class);
		
	}
	
	
	public void checkLoginPageAvailability(TestSuite testSuite){
		Common cmn = new Common(driver);
		expected_value = expected.get("login.loginPanel");
		actual_value = cmn.getUiText(loginPanel_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	
	}

	public void loginWithBlankUsername(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.enterText(password_L, adminPassWord);
		cmn.clickButton(login_L);
	    expected_value = expected.get("login.blankUsername");
		actual_value = cmn.getUiText(blankUsername_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	
	}
	
	public void loginWithBlankPassword(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.enterText(username_L, adminUsername);
		cmn.clickButton(login_L);
	    expected_value = expected.get("login.blankPassword");
		actual_value = cmn.getUiText(blankPassword_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	
	}
	
	public void loginWithBlankCredentials(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.clickButton(login_L1);
		expected_value = expected.get("login.blankUsername");
		actual_value = cmn.getUiText(blankUsername_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	
	}
	
	
	
}
