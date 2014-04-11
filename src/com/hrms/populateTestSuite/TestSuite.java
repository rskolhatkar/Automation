package com.hrms.populateTestSuite;

public class TestSuite {

	
	String testExecutionFlag;
	String testCaseId;
	String testCaseName;
	String testSuiteName;
	String testExecutionStatus;
	String testExecutionErrorMessage;
	String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password;
	
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
	
}
