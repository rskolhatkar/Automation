package com.asi.runner;

import java.util.List;
import com.asi.populateTestSuite.PopulateTestSuite;
import com.asi.populateTestSuite.TestCaseSelector;
import com.asi.report.TestReport;


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
