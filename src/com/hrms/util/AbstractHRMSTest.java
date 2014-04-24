package com.hrms.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.common.Common;
import com.hrms.common.FileUtil;
import com.hrms.populateTestSuite.TestSuite;

public  class AbstractHRMSTest   {


	public static Map<String, String> server = new HashMap<String, String>();
	public static Map<String, String> applications = new HashMap<String, String>();
	public static Map<String, String> uilocation = new HashMap<String, String>();
	public static Map<String, String> expected = new HashMap<String, String>();
	
	
	public WebDriver driver;
	public WebElement webElement;
	private String baseUrl;
	

	

public void setUp () throws Exception {

	server.putAll((Map) FileUtil.loadPropertiyFile("../AutomationProject/config/server.properties"));
	applications.putAll((Map) FileUtil.loadPropertiyFile("../AutomationProject/config/applications.properties"));
    uilocation.putAll((Map) FileUtil.loadPropertiyFile("../AutomationProject/config/ui_locations.properties"));
    expected.putAll((Map) FileUtil.loadPropertiyFile("../AutomationProject/config/expected.properties"));
    
}

public WebDriver getController () throws Exception

	{
		setUp();
		driver = new FirefoxDriver();
		baseUrl=server.get("hrms.url");
		driver.get(baseUrl);
		return driver;
		
	}
	
public void takeScreenshots(TestSuite testSuite){
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile, new File("../AutomationProject/reports/screenshots/" + testSuite.getTestCaseId()+
				"_" +testSuite.getTestExecutionStatus() + ".png"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
