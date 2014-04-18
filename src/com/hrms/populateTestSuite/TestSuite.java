package com.hrms.populateTestSuite;

public class TestSuite {

	
	String testExecutionFlag;
	String testCaseId;
	String testCaseName;
	String testSuiteName;
	String testExecutionStatus;
	String testExecutionErrorMessage;
	int emp_number;
	public LoginTestData loginTestData;
	

	public TestSuite(){
		loginTestData = new LoginTestData();
	}
	
	public int getEmp_number() {
		return emp_number;
	}
	public void setEmp_number(int emp_number) {
		this.emp_number = emp_number;
	}
	
	public String getTestExecutionFlag() {
		return testExecutionFlag;
	}
	public void setTestExecutionFlag(String testExecutionFlag) {
		this.testExecutionFlag = testExecutionFlag;
	}
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public String getTestExecutionStatus() {
		return testExecutionStatus;
	}
	public void setTestExecutionStatus(String testExecutionStatus) {
		this.testExecutionStatus = testExecutionStatus;
	}
	public String getTestExecutionErrorMessage() {
		return testExecutionErrorMessage;
	}
	public void setTestExecutionErrorMessage(String testExecutionErrorMessage) {
		this.testExecutionErrorMessage = testExecutionErrorMessage;
	}
	
	public LoginTestData getLoginTestData(){
		return loginTestData;
	}
	
	public void setLoginTestData(LoginTestData loginTestData){
		this.loginTestData = loginTestData;
	}
}
