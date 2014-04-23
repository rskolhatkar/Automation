package com.hrms.runner;

import java.util.List;
import com.hrms.populateTestSuite.PopulateTestSuite;
import com.hrms.populateTestSuite.TestCaseSelector;
import com.hrms.report.TestReport;


public class Main {
	
	
	public static void main(String[] args)throws Exception{
	
		PopulateTestSuite testSuite = new PopulateTestSuite();

		List<Object> testSuiteParametrersObject	 =	testSuite.populateTestSuiteParameters();
		List<Object> testSuiteObject = testSuite.populateTestSuite(testSuiteParametrersObject);
	
		System.out.println("******* TEST EXECUTION IS STARTED *******");
		System.out.println("Total Test Cases to execute : " + testSuiteObject.size());
		
		TestCaseSelector selector = new TestCaseSelector();
		selector.executeTestCases(testSuiteObject);
		
		System.out.println("****** TEST EXECUTION IS COMPLETED ******");
		
		TestReport testResultReport = new TestReport();
		testResultReport.getTestResultReport(testSuiteObject);
	}

}
