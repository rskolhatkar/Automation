package com.asi.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class FileUtil {

	public static Map loadPropertiyFile(String file) {
		File f = new File(file);
		Properties pro = new Properties();
		
	    if(f.exists()){
	    	try {
	    		FileInputStream in = new FileInputStream(f);
		  	    pro.load(in);
	    	} catch(IOException e) {
	    		System.out.println("loadPropertyFile() - error: " + e.getMessage());
	    		e.printStackTrace();
	    	}
	    }
	    else{
	      System.out.println("File not found! - " + file);
	    }
	    return pro;
	}

}

