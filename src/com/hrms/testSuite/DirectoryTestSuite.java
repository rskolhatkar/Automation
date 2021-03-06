package com.hrms.testSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.hrms.dao.TestDataDao;
import com.hrms.page.Directory;
import com.hrms.page.Login;
import com.hrms.page.MyInfo;
import com.hrms.populateTestSuite.TestSuite;
import com.hrms.util.AbstractHRMSTest;

public class DirectoryTestSuite extends AbstractHRMSTest{

public TestSuite TC_DIRECTORY_01(TestSuite testSuite) throws Exception{
		
  	TestDataDao dao = new TestDataDao();
  	List<Object> employeeList = new ArrayList<Object>();
	
  	try{
		 getController();
		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.ess")));
		 employeeList = dao.addMultipleEmployees(4);
	 
		 Login login = PageFactory.initElements(driver, Login.class);
		 MyInfo myInfo = login.validLoginToHRMS(testSuite);
		 Directory dir = myInfo.navigateToDirectory(testSuite);
		 dir.searchByValidEmployeeName(testSuite);
     
		}catch(Exception e) {
			testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_DIRECTORY_01 : " + e.getMessage());
		}finally{
			takeScreenshots(testSuite);
			driver.close();
			dao.deleteEmployee(testSuite.getEmp_number());
			dao.deleteMultipleEployees(employeeList);
		}
		System.out.println("      Execution Completed for : TC_DIRECTORY_01");
		return testSuite;
	}


public TestSuite TC_DIRECTORY_02(TestSuite testSuite) throws Exception{
	
  	TestDataDao dao = new TestDataDao();
  	List<Object> employeeList = new ArrayList<Object>();
	
  	try{
		 getController();
		 dao.addEmployee(testSuite , Integer.parseInt(applications.get("user.role.ess")));
		 employeeList = dao.addMultipleEmployees(4);
	 
		 Login login = PageFactory.initElements(driver, Login.class);
		 MyInfo myInfo = login.validLoginToHRMS(testSuite);
		 Directory dir = myInfo.navigateToDirectory(testSuite);
		 dir.searchByValidEmployeeID(testSuite);
     
		}catch(Exception e) {
			testSuite.setTestExecutionStatus("Failed");
			testSuite.setTestExecutionErrorMessage("Exception in TC_DIRECTORY_02 : " + e.getMessage());
		}finally{
			takeScreenshots(testSuite);
			driver.close();
			dao.deleteEmployee(testSuite.getEmp_number());
			dao.deleteMultipleEployees(employeeList);
		}
		System.out.println("      Execution Completed for : TC_DIRECTORY_02");
		return testSuite;
	}

}
