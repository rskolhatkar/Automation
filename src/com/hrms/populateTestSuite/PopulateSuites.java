package com.hrms.populateTestSuite;

import jxl.Sheet;

public class PopulateSuites {
	
	
	public TestSuite populate (TestSuite testSuite,int k ,Sheet sheet1, String testSuiteName){
		
		if (testSuiteName.equalsIgnoreCase("LoginTestSuite")){
			populateLoginSuite(testSuite,k,sheet1);

		} else if(testSuiteName.equalsIgnoreCase("LeaveTestSuite")){
			
			populateLeaveSuite(testSuite,k,sheet1);
		}
		
		return testSuite;
	}
	
	/*
     * Populate Login TestSuite object with values.
     */
    
    public TestSuite populateLoginSuite (TestSuite testSuite,int k ,Sheet sheet1){
    	
    	testSuite.setTestSuiteName(sheet1.getCell(0, k).getContents());
		testSuite.setTestCaseId(sheet1.getCell(1, k).getContents());
		testSuite.setTestCaseName(sheet1.getCell(2, k).getContents());
		testSuite.setTestExecutionFlag(sheet1.getCell(3, k).getContents());
		testSuite.setUsername(sheet1.getCell(4, k).getContents());
		testSuite.setPassword(sheet1.getCell(5, k).getContents());
    	return testSuite;
    }

    /*
     * Populate Leave TestSuite object with values.
     */
public TestSuite populateLeaveSuite (TestSuite testSuite,int k ,Sheet sheet1){
    	
    	testSuite.setTestSuiteName(sheet1.getCell(0, k).getContents());
		testSuite.setTestCaseId(sheet1.getCell(1, k).getContents());
		testSuite.setTestCaseName(sheet1.getCell(2, k).getContents());
		testSuite.setTestExecutionFlag(sheet1.getCell(3, k).getContents());
		testSuite.setUsername(sheet1.getCell(4, k).getContents());
		testSuite.setPassword(sheet1.getCell(5, k).getContents());
    	return testSuite;
    }
}
