package com.hrms.populateTestSuite;

import java.lang.reflect.Method;
import java.util.List;


public class TestCaseSelector {
	
	String testSuitePackage = "com.asi.testSuite.";
	
	public void executeTestCases(List<Object> testSuiteObject) throws Exception{
		
		for (int i = 0; i < testSuiteObject.size();i++){
     		TestSuite testSuite = (TestSuite) testSuiteObject.get(i);
     		
     		String testExecutionFlag = testSuite.getTestExecutionFlag();
			String testSuiteName = testSuitePackage.concat(testSuite.getTestSuiteName());
			String testCaseID = testSuite.getTestCaseId();
			 	System.out.println(i+1 + "-->  Execution STARTED for   : " + testCaseID + ".");
			if(testExecutionFlag.equalsIgnoreCase("N")){
				testSuite.setTestExecutionStatus("No Run");
				System.out.println("      Execution COMPLETED for : " + testCaseID + ".");	
			}else{
				
				
				
				Class<?> c = Class.forName(testSuiteName);
				Object hrms = c.newInstance(); 
				Method method = hrms.getClass().getMethod(testCaseID, TestSuite.class);
				testSuite = (TestSuite) method.invoke(hrms, testSuite);
			}
		}
	}
}
