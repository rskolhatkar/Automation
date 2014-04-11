package com.hrms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hrms.common.Common;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.testSuite.*;
import com.hrms.util.AbstractHRMSTest;

public class Leave extends AbstractHRMSTest {

	public WebDriver driver;
	private String expected_value;
	private String actual_value;
	
	private By menu_leave_L = By.id(uilocation.get("ui.menu.leave"));
	private By submenu_leave_apply_L = By.id(uilocation.get("ui.menu_leave_applyLeave"));
	private By submenu_leave_myLeave_L = By.id(uilocation.get("ui.menu_leave_viewMyLeaveList"));
	private By submenu_leave_entitlements_L = By.id(uilocation.get("ui.menu_leave_Entitlements"));
	private By submenu_leave_reports_L = By.id(uilocation.get("ui.menu_leave_Reports"));
	private By submenu_leave_configure_L = By.id(uilocation.get("ui.menu_leave_Configure"));
	private By submenu_leave_leaveList_L = By.id(uilocation.get("ui.menu_leave_viewLeaveList"));
	private By submenu_leave_assignLeave_L = By.id(uilocation.get("ui.menu_leave_assignLeave"));
	private By submenu_leave_compOff_L = By.id(uilocation.get("ui.menu_leave_CompOff"));
	
	
	
	
	
	public Leave(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void loginLeaveModuleByAdmin(TestSuite testSuite){
		Common cmn = new Common(driver);
		expected_value = expected.get("menu.leave.apply");
		actual_value = cmn.getUiText(submenu_leave_apply_L);
		
	    String error = 	cmn.assertionMultipleCheck(testSuite, actual_value, expected_value);
	  
	  
	    expected_value = expected.get("menu.leave.myLeave");
	    actual_value = cmn.getUiText(submenu_leave_myLeave_L);
	    error = error.concat(cmn.assertionMultipleCheck(testSuite, actual_value, expected_value));
	
	    testSuite.setTestExecutionErrorMessage(error);
	}	
}
