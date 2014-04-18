package com.hrms.testSuite;

import org.openqa.selenium.support.PageFactory;

import com.hrms.dao.TestDataDao;
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
    	 TestDataDao dao = new TestDataDao();
    	 try{
		 getController();
		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.ess")));
		 Login login = PageFactory.initElements(driver, Login.class);
		 Pim pim = login.validLoginToHRMS(testSuite);
	     pim.checkLoginUser(testSuite);
	     
  		}catch(Exception e) {
    		testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_login_05 : " + e.getMessage());
			e.printStackTrace();
    	}finally{
    		driver.close();
   		 dao.deleteEmployee(testSuite.getEmp_number());
    	}
  		System.out.println("      Execution Completed for : TC_login_05");
 		return testSuite;
	}
     
     public TestSuite TC_login_06(TestSuite testSuite) {
    	 TestDataDao dao = new TestDataDao();
    	 try{
 		 getController();
 		
 		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.consultant")));
 		 Login login = PageFactory.initElements(driver, Login.class);
 		 Pim pim = login.validLoginToHRMS(testSuite);
	     pim.checkLoginUser(testSuite);
 	     
   		}catch(Exception e) {
     		testSuite.setTestExecutionStatus("Failed");
 			testSuite.setTestExecutionErrorMessage("Exception in TC_login_06 : " + e.getMessage());
 			e.printStackTrace();
     	}finally{
     		driver.close();
    		 dao.deleteEmployee(testSuite.getEmp_number());
     	}
   		System.out.println("      Execution Completed for : TC_login_06");
 		return testSuite;
 	}
     
     public TestSuite TC_login_07(TestSuite testSuite) {
    	 TestDataDao dao = new TestDataDao();
    	 try{
  		 getController();
  		 
  		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.recruitmentManager")));
  		 Login login = PageFactory.initElements(driver, Login.class);
  		Pim pim = login.validLoginToHRMS(testSuite);
	     pim.checkLoginUser(testSuite);
  	     
    		}catch(Exception e) {
      		testSuite.setTestExecutionStatus("Failed");
  			testSuite.setTestExecutionErrorMessage("Exception in TC_login_07 : " + e.getMessage());
  			e.printStackTrace();
      	}finally{
      		driver.close();
      		dao.deleteEmployee(testSuite.getEmp_number());
      	}
    		System.out.println("      Execution Completed for : TC_login_07");
  		return testSuite;
  	}
     
     public TestSuite TC_login_08(TestSuite testSuite) {
    	 TestDataDao dao = new TestDataDao();
 		try{
		 getController();
		
		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.admin")));
		 Login login = PageFactory.initElements(driver, Login.class);
		 Pim pim = login.validLoginToHRMS(testSuite);
	     pim.checkLoginUser(testSuite);
	     
 		}catch(Exception e) {
   		testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_login_08 : " + e.getMessage());
			e.printStackTrace();
   	}finally{
   		driver.close();
     	dao.deleteEmployee(testSuite.getEmp_number());
   	}
 		System.out.println("      Execution Completed for : TC_login_08");
		return testSuite;
	}
     
}
