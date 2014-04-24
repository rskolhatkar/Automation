package com.hrms.testSuite;

import org.openqa.selenium.support.PageFactory;
import com.hrms.dao.TestDataDao;
import com.hrms.page.Login;
import com.hrms.page.MyInfo;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;


public class LoginTestSuite extends AbstractHRMSTest {
	
	public TestSuite TC_LOGIN_01(TestSuite testSuite) throws Exception{
		try{
			getController();
			Login login = PageFactory.initElements(driver, Login.class);
			login.checkLoginPageAvailability(testSuite);
			}catch(Exception e) {
				testSuite.setTestExecutionStatus("Failed");
				testSuite.setTestExecutionErrorMessage("Exception in TC_login_01 : " + e.getMessage());
			}finally{
				takeScreenshots(testSuite);
				driver.close();
			}
		System.out.println("      Execution Completed for : TC_login_01");
	return testSuite;
	}
	
	
     public TestSuite TC_LOGIN_02(TestSuite testSuite) throws Exception{
		try{
			getController();
			Login login = PageFactory.initElements(driver, Login.class);
			login.loginWithBlankUsername(testSuite);
     	}catch(Exception e) {
	 		testSuite.setTestExecutionStatus("Failed");
	 		testSuite.setTestExecutionErrorMessage("Exception in TC_login_02 : " + e.getMessage());
	 	}finally{
	 		takeScreenshots(testSuite);
	 		driver.close();
	 	}
		System.out.println("      Execution Completed for : TC_login_02");
		return testSuite;
	}

     public TestSuite TC_LOGIN_03(TestSuite testSuite) throws Exception{
    	 try{
    		 getController();
    		 Login login = PageFactory.initElements(driver, Login.class);
    		 login.loginWithBlankPassword(testSuite);
    	 	}catch(Exception e) {
    	 		testSuite.setTestExecutionStatus("Failed");
    	 		testSuite.setTestExecutionErrorMessage("Exception in TC_login_03 : " + e.getMessage());
    	 	}finally{
    	 		takeScreenshots(testSuite);
    	 		driver.close();
    	 	}
         System.out.println("      Execution Completed for : TC_login_03");
 	  	return testSuite;
 	}
     
     
     public TestSuite TC_LOGIN_04(TestSuite testSuite) throws Exception{
    	 
    	 try{
    		 getController();
    		 Login login = PageFactory.initElements(driver, Login.class);
    		 login.loginWithBlankCredentials(testSuite);
    	 	}catch(Exception e) {
    	 		testSuite.setTestExecutionStatus("Failed");
    	 		testSuite.setTestExecutionErrorMessage("Exception in TC_login_04 : " + e.getMessage());
    	 	}finally{
    			takeScreenshots(testSuite);
                driver.close();
    	 	}
            System.out.println("      Execution Completed for : TC_login_04");
		return testSuite;
	}
     
     public TestSuite TC_LOGIN_05(TestSuite testSuite) {
    
    	 TestDataDao dao = new TestDataDao();
    	 
    	 try{
    		 getController();
    		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.ess")));
    		 Login login = PageFactory.initElements(driver, Login.class);
    		 MyInfo pim = login.validLoginToHRMS(testSuite);
    		 pim.checkLoginUser(testSuite);
	     
  			}catch(Exception e) {
  				testSuite.setTestExecutionStatus("Failed");
  				testSuite.setTestExecutionErrorMessage("Exception in TC_login_05 : " + e.getMessage());
  				e.printStackTrace();
  			}finally{
  				takeScreenshots(testSuite);
  				driver.close();
  				dao.deleteEmployee(testSuite.getEmp_number());
  			}
  			
    	 	System.out.println("      Execution Completed for : TC_login_05");
  			return testSuite;
	}
     
     public TestSuite TC_LOGIN_06(TestSuite testSuite) {
    	 
    	 TestDataDao dao = new TestDataDao();
    	 
    	 try{
    		 getController();
 			 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.consultant")));
 			 Login login = PageFactory.initElements(driver, Login.class);
 			 MyInfo pim = login.validLoginToHRMS(testSuite);
 			 pim.checkLoginUser(testSuite);
 	     	}catch(Exception e) {
 	     		testSuite.setTestExecutionStatus("Failed");
 	     		testSuite.setTestExecutionErrorMessage("Exception in TC_login_06 : " + e.getMessage());
 	     		e.printStackTrace();
 	     	}finally{
 				takeScreenshots(testSuite);
 	     		driver.close();
 	     		dao.deleteEmployee(testSuite.getEmp_number());
 	     	}
   			
    	 	System.out.println("      Execution Completed for : TC_login_06");
   			return testSuite;
 	}
     
     public TestSuite TC_LOGIN_07(TestSuite testSuite) {
    	
    	 TestDataDao dao = new TestDataDao();
    	 
    	 try{
    		 getController();
  		 	 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.recruitmentManager")));
  		 	 Login login = PageFactory.initElements(driver, Login.class);
  		 	 MyInfo pim = login.validLoginToHRMS(testSuite);
  		 	 pim.checkLoginUser(testSuite);
  	     
    		}catch(Exception e) {
    			testSuite.setTestExecutionStatus("Failed");
    			testSuite.setTestExecutionErrorMessage("Exception in TC_login_07 : " + e.getMessage());
    			e.printStackTrace();
    		}finally{
    			takeScreenshots(testSuite);
    			driver.close();
    			dao.deleteEmployee(testSuite.getEmp_number());
    		}
    		
    	 	System.out.println("      Execution Completed for : TC_login_07");
    	 	return testSuite;
  	}
     
     public TestSuite TC_LOGIN_08(TestSuite testSuite) {
    	 
    	TestDataDao dao = new TestDataDao();
    	 
 		try{
		 getController();
		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.admin")));
		 Login login = PageFactory.initElements(driver, Login.class);
		 MyInfo myInfo = login.validLoginToHRMS(testSuite);
		 myInfo.checkLoginUser(testSuite);
	     
 		}catch(Exception e) {
 			testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_login_08 : " + e.getMessage());
			e.printStackTrace();
 		}finally{
			takeScreenshots(testSuite);
 			driver.close();
 			dao.deleteEmployee(testSuite.getEmp_number());
 		}
 		
 		System.out.println("      Execution Completed for : TC_login_08");
		return testSuite;
	}
     
}
