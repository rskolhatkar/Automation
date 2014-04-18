package com.hrms.testData;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class populateTestData {

	public EmployeeTestData populateEmployee() throws BiffException, IOException{
		Workbook wrk1 =  Workbook.getWorkbook(new File("../AutomationProject/testData/EmployeeRecord.xls"));
		EmployeeTestData employee= new EmployeeTestData();
        
         Sheet sheet1 = wrk1.getSheet(0);
       
   
         employee.setEmplastname(sheet1.getCell(2, 1).getContents());
         employee.setEmpfirstname(sheet1.getCell(3, 1).getContents());
         employee.setEmpmiddle_name(sheet1.getCell(4, 1).getContents());
         employee.setEmp_smoker(Integer.parseInt(sheet1.getCell(6, 1).getContents()));
         employee.setEmp_gender(Integer.parseInt(sheet1.getCell(10, 1).getContents()));
         employee.setEmp_marital_status(sheet1.getCell(11, 1).getContents());
         employee.setJob_title_code(Integer.parseInt(sheet1.getCell(19, 1).getContents()));
         employee.setEmpstreet1(sheet1.getCell(22, 1).getContents());
         employee.setEmpstreet2(sheet1.getCell(23, 1).getContents());
         employee.setCity_code(sheet1.getCell(24, 1).getContents());
         employee.setCoun_code(sheet1.getCell(25, 1).getContents());
         employee.setProvin_code(sheet1.getCell(26, 1).getContents());
         employee.setEmp_zipcode(sheet1.getCell(27, 1).getContents());
         employee.setEmp_mobile(sheet1.getCell(28, 1).getContents());
         employee.setEmp_work_email(sheet1.getCell(31, 1).getContents());
         employee.setJoined_date(java.sql.Date.valueOf(sheet1.getCell(33, 1).getContents()));
         return employee;
	}
	
	public EmployeeLoginTestData populateEmployeeLoginDetails() throws BiffException, IOException{
		Workbook wrk1 =  Workbook.getWorkbook(new File("../AutomationProject/testData/EmployeeLoginDetails.xls"));
		EmployeeLoginTestData employee= new EmployeeLoginTestData();
        
         Sheet sheet1 = wrk1.getSheet(0);
//    	employee.setUser_name(sheet1.getCell(3, 1).getContents());
    	employee.setUser_password(sheet1.getCell(4, 1).getContents());
        employee.setDeleted(Integer.parseInt(sheet1.getCell(5, 1).getContents())); 
        employee.setStatus(Integer.parseInt(sheet1.getCell(6, 1).getContents())); 
        employee.setDate_entered(java.sql.Date.valueOf(sheet1.getCell(7, 1).getContents()));
        employee.setDate_modified(java.sql.Date.valueOf(sheet1.getCell(8, 1).getContents()));
        employee.setModified_user_id(Integer.parseInt(sheet1.getCell(9, 1).getContents())); 
        employee.setCreated_by(Integer.parseInt(sheet1.getCell(10, 1).getContents())); 
        return employee;
	}
	
	
}
