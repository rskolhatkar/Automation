package com.hrms.testSuite;

import org.openqa.selenium.support.PageFactory;

import com.hrms.page.Leave;
import com.hrms.page.Login;
import com.hrms.page.Pim;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;

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
