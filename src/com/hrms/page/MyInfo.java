package com.hrms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.hrms.common.Common;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;

public class MyInfo extends AbstractHRMSTest{

	WebDriver driver;
	
	private By welcome_L = By.id(uilocation.get("ui.pim.welcome"));
	private By directoryMenu_L = By.id(uilocation.get("ui.menu.directory"));

	private String expected_value;
	private String actual_value;
	
			
			
	public MyInfo(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void checkLoginUser(TestSuite testSuite){
		Common cmn = new Common(driver);
		expected_value = expected.get("home.welcome");
		actual_value = cmn.getUiText(welcome_L);
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	}
	
	public Directory navigateToDirectory(TestSuite testSuite){
		Common cmn = new Common(driver);
		cmn.clickOnLink(directoryMenu_L);
		return PageFactory.initElements(driver, Directory.class);
	}

}
