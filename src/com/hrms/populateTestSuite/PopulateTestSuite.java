package com.hrms.populateTestSuite;

import jxl.*;
import jxl.read.biff.BiffException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Workbook;



public class PopulateTestSuite {

	public List<String> testCaseList;
	public List <String> testSuiteList;
	public int number_of_testCases; 
	public int number_of_testSuites;
	
	
		/*
		 * Method to get test Suite parameters.
		 * Number of test suites
		 * Execution flag for the test suite execution
		 * Number of test cases to be executed.
		 */
	
	    public List<String> getTestSuiteParameters() throws BiffException, IOException{
            
	    	Workbook wrk1 =  Workbook.getWorkbook(new File("../AutomationProject/config/HRMS_TestSuite.xls"));
            testSuiteList = new ArrayList<String>();
            
             Sheet sheet1 = wrk1.getSheet(0);
             Cell cell;
             // get number of Test Cases to be executed.
             cell = sheet1.getCell(9,1);
             number_of_testCases = Integer.parseInt(cell.getContents());
             // get total number of test suites to be executed.
             cell = sheet1.getCell(9,2);
             number_of_testSuites = Integer.parseInt(cell.getContents());		 
             
             int cols_number_of_parameters = 5;
             
        	// rows = number_of_testSuites.
    		// columns = number_of_parameters;
            for (int i = 1; i <= number_of_testSuites ; i++){
            	for (int j = 0; j < cols_number_of_parameters ; j++){
            		cell = sheet1.getCell(j, i);
            		testSuiteList.add(cell.getContents());
            		
            	}
            }
            
    	return testSuiteList; 
	    }
	    
	    /*
	     * Populate TestSuiteParameters object with the values.
	     */
	    
	    public List<Object> populateTestSuiteParameters() throws Exception{
			
			
	    	List testSuiteList = getTestSuiteParameters();
	    	List<Object> testSuiteParameterObjectList = new ArrayList<Object>();

			int testSuiteNumber;
	    	String testSuiteName;
	    	int testCaseCount;
	    	int testSuiteParameterCount;
	    	String testSuiteExecutionFlag;
	    	
			int rows = number_of_testSuites;
			
			int size = testSuiteList.size()/rows;
			int l = size;			
			int k =0;
			int j ;
			for (int i=0 ; i < rows ; i++) {
				
				for (j= k; j < l; ) {

				testSuiteNumber = Integer.parseInt(testSuiteList.get(j).toString());
				testSuiteName = testSuiteList.get(j+1).toString();
				testCaseCount = Integer.parseInt(testSuiteList.get(j+2).toString());
				testSuiteExecutionFlag = (String) testSuiteList.get(j+3);
				testSuiteParameterCount = Integer.parseInt(testSuiteList.get(j+4).toString());
				j = l;
				
				TestSuiteParameters testSuiteParameters = new TestSuiteParameters();
				testSuiteParameters.setTestCaseCount(testCaseCount);
				testSuiteParameters.setTestSuiteExecutionFlag(testSuiteExecutionFlag);
				testSuiteParameters.setTestSuiteName(testSuiteName);
			    testSuiteParameters.setTestSuiteumber(testSuiteNumber);
			    testSuiteParameters.setTestSuiteParameterCount(testSuiteParameterCount);
				
				testSuiteParameterObjectList.add(testSuiteParameters);
				try{
				}catch( Exception e){
			    	System.out.println("EXCEPTION");
			    }
			}
			k = l; 
			l= l + size ;  
			
			}
			
			return testSuiteParameterObjectList;
		}    	    
	    
	    /*
	     * Get Test Case parameters such as TestSuiteName, Test Case Id , Test Execution Flag
	     */

	    public List<Object> populateTestSuite(List<Object> testSuiteParametrersObject) throws BiffException, IOException  {
		      

	    	Workbook wrk1 =  Workbook.getWorkbook(new File("../AutomationProject/config/HRMS_TestSuite.xls"));
	        testCaseList = new ArrayList<String>();
	    	List<Object> testSuiteObjectList = new ArrayList<Object>();
	    	PopulateSuites populate = new PopulateSuites();
	    	       
	            for (int i = 0; i < testSuiteParametrersObject.size();i++){

	            	TestSuiteParameters testSuiteParameters = (TestSuiteParameters) testSuiteParametrersObject.get(i);
	    			String testSuiteExecutionFlag = testSuiteParameters.getTestSuiteExecutionFlag();
	    			int testSuiteNumber = testSuiteParameters.getTestSuiteNumber();
	    			int testCaseCount = testSuiteParameters.getTestCaseCount();
	    			String testSuiteName = testSuiteParameters.getTestSuiteName();
	    		
	    				if(testSuiteExecutionFlag.equalsIgnoreCase("Y")){
	    		    		Sheet sheet1 = wrk1.getSheet(testSuiteNumber);
	          
	    		    		int rows_number_of_testCases = testCaseCount;
	             
	    		    		// rows = number_of_testCases.
	    		    		// columns = number_of_parameters;
	    		    		for (int k = 1; k <= rows_number_of_testCases ; k++){
	    		    			TestSuite testSuite = new TestSuite();
	    		    			testSuiteObjectList.add(populate.populate(testSuite, k, sheet1, testSuiteName));	
	    		    		}
	            
	    				} 
	            }    
	           
	   
	           return testSuiteObjectList;
	    }
	    

		
}
