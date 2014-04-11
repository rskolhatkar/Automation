package com.asi.testSuite;

import org.openqa.selenium.support.PageFactory;

import com.asi.page.Leave;
import com.asi.page.Login;
import com.asi.page.Pim;
import com.asi.populateTestSuite.TestSuite;
import com.asi.util.AbstractHRMSTest;

public class LeaveTestSuite extends AbstractHRMSTest{

	
	
public TestSuite TC_LEAVE_01(TestSuite testSuite) throws Exception{
		
		getController();
		Login login = PageFactory.initElements(driver, Login.class);
		Pim pim = login.validLoginToHRMS(testSuite);
		Leave leave = pim.navigateToLeave(testSuite);
		leave.loginLeaveModuleByAdmin(testSuite);
		driver.close();
		System.out.println("      Execution Completed for : TC_LEAVE_01");
		return testSuite;
	}
}
