package com.hrms.testSuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.hrms.page.Login;
import com.hrms.page.Pim;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;




public class LoginTestSuite extends AbstractHRMSTest {
	
	
	
	public TestSuite TC_login_01(TestSuite testSuite) throws Exception{
		
		getController();
		Login login = PageFactory.initElements(driver, Login.class);
		login.checkLoginPageAvailability(testSuite);
		driver.close();
		return testSuite;
	}
	
	
     public TestSuite TC_login_02(TestSuite testSuite) throws Exception{
		
    	getController();
    	Login login = PageFactory.initElements(driver, Login.class);
    	login.loginWithBlankUsername(testSuite);
    	driver.close();
		return testSuite;
	}

     public TestSuite TC_login_03(TestSuite testSuite) throws Exception{
 
    	getController();
     	Login login = PageFactory.initElements(driver, Login.class);
     	login.loginWithBlankPassword(testSuite);
     	driver.close();
 	  	return testSuite;
 	}
     
     
     public TestSuite TC_login_04(TestSuite testSuite) throws Exception{
    	 try{
    	 getController();
         Login login = PageFactory.initElements(driver, Login.class);
         login.loginWithBlankCredentials(testSuite);
    	 }catch(Exception e) {
     		testSuite.setTestExecutionStatus("Failed");
 			testSuite.setTestExecutionErrorMessage("Exception in TC_login_04 : " + e.getMessage());
     	}
         
         driver.close();
         System.out.println("      Execution Completed for : TC_login_04");
		return testSuite;
	}
     
     public TestSuite TC_login_05(TestSuite testSuite) {
  		try{
		 getController();
		 Login login = PageFactory.initElements(driver, Login.class);
		 Pim pim = login.validLoginToHRMS(testSuite);
	     pim.checkLoginUser(testSuite);
	     
  		}catch(Exception e) {
    		testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_login_05 : " + e.getMessage());
    	}
  		driver.close();
  		System.out.println("      Execution Completed for : TC_login_05");
		return testSuite;
	}
     
}
