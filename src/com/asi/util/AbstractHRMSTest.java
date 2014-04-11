package com.asi.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.asi.common.Common;
import com.asi.common.FileUtil;

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
	
}
