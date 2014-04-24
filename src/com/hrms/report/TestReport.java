package com.hrms.report;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;

import com.hrms.populateTestSuite.TestSuite;
import com.hrms.testSuite.*;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class TestReport {

	EmailWithReport emailwithReport;
	
	
	  public void getTestResultReport(List<Object> testSuiteObject ) throws MessagingException{
	    	try {
	    		
	    		/*java.util.Date date= new java.util.Date();
	    		
	    		String executionDate = new Timestamp(date.getTime()).toString();
	    		String filepath = "../SYN_HRMS/reports/";
	    		String fileName = "TestResult_";
	    		String extension = ".xls";
	    			    		
	    		String tempDate = executionDate.replace(":", "_");
	    		executionDate = tempDate.substring(0, 19);
	    		
	    		String reportName = filepath.concat(fileName).concat(executionDate).concat(extension);*/
	    		
	            File exlFile = new File("../AutomationProject/reports/HRMS_TestResult_Report.xls");
	            WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);
	 
	            WritableSheet writableSheet = writableWorkbook.createSheet("Sheet", 0);
	 
                Label testSuiteName = new Label(0, 0, "Test Suite Name" , titleCellFormat() );
	            Label testId = new Label(1, 0, "Test ID" , titleCellFormat());
	            Label testCaseName = new Label(2, 0, "Test Case Name" , titleCellFormat());
	            Label executionFlag = new Label(3, 0, "Test Execution Flag" , titleCellFormat());
	            Label executionStatus = new Label(4, 0, "Execution Status" , titleCellFormat());
	            Label errorMessage = new Label(5, 0, "Error Message" , titleCellFormat());
	           
	            
	            writableSheet.addCell(testSuiteName);
	            writableSheet.addCell(testId);
	            writableSheet.addCell(testCaseName);
	            writableSheet.addCell(executionFlag);
	            writableSheet.addCell(executionStatus);
	            writableSheet.addCell(errorMessage);

	            writableSheet.setColumnView(0, 20);
	            writableSheet.setColumnView(1, 20);
	            writableSheet.setColumnView(2, 30);
	            writableSheet.setColumnView(3, 20);
	            writableSheet.setColumnView(4, 20);
	            writableSheet.setColumnView(5, 80);
	           
	            
	            
	            int size = testSuiteObject.size();
	            int j = 0;
	            for (int i = 1; i <= size ; i++){
	            	
	            	TestSuite testCase = (TestSuite) testSuiteObject.get(j);
	                	writableSheet.addCell(new Label (0,i,testCase.getTestSuiteName(),CellFormat(Colour.BLACK , Alignment.CENTRE)));
	                	writableSheet.addCell(new Label (1,i,testCase.getTestCaseId(),CellFormat(Colour.BLACK, Alignment.CENTRE)));
	                	writableSheet.addCell(new Label (2,i,testCase.getTestCaseName(),CellFormat(Colour.BLACK, Alignment.CENTRE)));
	                	writableSheet.addCell(new Label (3,i,testCase.getTestExecutionFlag(),CellFormat(Colour.BLACK, Alignment.CENTRE)));
	                	System.out.println(testCase.getTestExecutionStatus());
	                	if (testCase.getTestExecutionStatus().equalsIgnoreCase("Failed") ){
	                		writableSheet.addCell(new Label (4,i,testCase.getTestExecutionStatus(),CellFormat(Colour.RED, Alignment.CENTRE)));
	                	}else if(testCase.getTestExecutionStatus().equalsIgnoreCase("Passed")){
	                		writableSheet.addCell(new Label (4,i,testCase.getTestExecutionStatus(),CellFormat(Colour.GREEN, Alignment.CENTRE)));
	                	}else{
	                	writableSheet.addCell(new Label (4,i,testCase.getTestExecutionStatus(),CellFormat(Colour.BLUE, Alignment.CENTRE)));
	                	}
	                	
	                	writableSheet.addCell(new Label (5,i,testCase.getTestExecutionErrorMessage(),CellFormat(Colour.RED, Alignment.LEFT)));
	                	
	             j++;   
	            }
	 
	            //Write and close the workbook .
	            writableWorkbook.write();
	            writableWorkbook.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (RowsExceededException e) {
	            e.printStackTrace();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        }
	    	
	    	
	//    	sendEmail ();
	    	
	    }

	  private void sendEmail() throws MessagingException {
		// TODO Auto-generated method stub
		  
		  
			String mailBody =" Automation Execution Results!! " ;
			/*try{
				  // Open the file that is the first 			 
				  FileInputStream fstream = new FileInputStream(common.dir_name+common.Result);
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)   {
					  // Print the content on the console
					  System.out.println (strLine);
					  mailBody = mailBody+strLine+"\n" ;
				  }
				  //Close the input stream
				  in.close();
			    }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				}*/
			
			
		  Properties properties = new Properties();
		  emailwithReport = new EmailWithReport();
		  
			String[] send_To = new String[1];
			String emailSubjectTxt = null;
			String emailFromAddress = null;
			String reportFilePath = null;
		    try {
		        properties.load(new FileInputStream("../AutomationProject/config/email.properties"));	    	
		    	String sendTo =properties.getProperty("send_to");
		    	//String[] send_To = new String[1];
		    	send_To[0]=sendTo;
		    	emailSubjectTxt =properties.getProperty("email_subject_txt");
		    	emailFromAddress =properties.getProperty("email_from_address");
		    	reportFilePath = properties.getProperty("csv_file_path");
		    } catch (Exception e) {
		      System.out.println("Gotch");
		    }
			 
			 //common.sendSSLMessage(send_To, emailSubjectTxt, mailBody, emailFromAddress, common.dir_name+common.Result);
		    emailwithReport.sendSSLMessage(send_To, emailSubjectTxt, mailBody, emailFromAddress, reportFilePath);
		
	}

	public WritableCellFormat CellFormat(Colour color , Alignment alignment) throws WriteException{
		  WritableFont wfontStatus = new WritableFont(WritableFont.createFont("Arial"), 
          		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, color);
          WritableCellFormat fCellstatus = new WritableCellFormat(wfontStatus);
          fCellstatus.setWrap(true);
          fCellstatus.setAlignment(alignment);
          fCellstatus.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
          fCellstatus.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
          fCellstatus.setBackground(Colour.LIGHT_GREEN);
          return fCellstatus;
	  }
	  
	  public WritableCellFormat titleCellFormat() throws WriteException{
		   WritableFont wfontStatus = new WritableFont(WritableFont.createFont("Arial"), 
           		WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
           WritableCellFormat fCellstatus = new WritableCellFormat(wfontStatus);
           fCellstatus.setWrap(true);
           fCellstatus.setAlignment(jxl.format.Alignment.CENTRE);
           fCellstatus.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           fCellstatus.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM, jxl.format.Colour.BLACK);
           fCellstatus.setBackground(Colour.GRAY_80);
           return fCellstatus;
	  }
	  
	  
}
