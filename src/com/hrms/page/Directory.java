package com.hrms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hrms.common.Common;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;

public class Directory  extends AbstractHRMSTest{
	
	WebDriver driver;
	
	private By empName_L = By.id(uilocation.get("ui.employee_name"));
	private By empId_L = By.id(uilocation.get("ui.employee_id"));
	private By empProject_L = By.id(uilocation.get("ui.employee_project"));
	private By empJobTitle_L = By.id(uilocation.get("ui.employee_job_title"));
	private By searchBtn_L = By.id(uilocation.get("ui.searchBtn"));
	
	private String expected_value;
	private String actual_value;
	
			
			
	public Directory(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void searchByValidEmployeeName(TestSuite testSuite){
		
		Common cmn = new Common(driver);
		cmn.enterText(empName_L,  testSuite.getDirectoryTestData().getEmployeeName());
		cmn.clickButton(searchBtn_L);
		
		expected_value = testSuite.getDirectoryTestData().getEmployeeId() +", "+ testSuite.getDirectoryTestData().getEmployeeName();
		actual_value = cmn.getUiText(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/span[1]"));
		cmn.assertionCheck(testSuite, actual_value, expected_value);
	} 
}
