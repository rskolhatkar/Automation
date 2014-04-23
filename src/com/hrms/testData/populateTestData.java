package com.hrms.testData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    	employee.setUser_password(sheet1.getCell(4, 1).getContents());
        employee.setDeleted(Integer.parseInt(sheet1.getCell(5, 1).getContents())); 
        employee.setStatus(Integer.parseInt(sheet1.getCell(6, 1).getContents())); 
        employee.setDate_entered(java.sql.Date.valueOf(sheet1.getCell(7, 1).getContents()));
        employee.setDate_modified(java.sql.Date.valueOf(sheet1.getCell(8, 1).getContents()));
        employee.setModified_user_id(Integer.parseInt(sheet1.getCell(9, 1).getContents())); 
        employee.setCreated_by(Integer.parseInt(sheet1.getCell(10, 1).getContents())); 
        return employee;
	}
	
	public List<Object> populateMultipleEmployee(int number_of_Employees) throws BiffException, IOException{
		Workbook wrk1 =  Workbook.getWorkbook(new File("../AutomationProject/testData/EmployeeRecord.xls"));
        
         Sheet sheet1 = wrk1.getSheet(0);
       
         List<Object> employeeList = new ArrayList<Object>();
      
         int number_of_rows = number_of_Employees + 4;		 

         for (int i = 4; i < number_of_rows ; i++){
          		EmployeeTestData employee= new EmployeeTestData();
          		employee.setEmp_id(sheet1.getCell(1, i).getContents());
                employee.setEmplastname(sheet1.getCell(2, i).getContents());
                employee.setEmpfirstname(sheet1.getCell(3, i).getContents());
                employee.setEmpmiddle_name(sheet1.getCell(4, i).getContents());
                employee.setEmp_smoker(Integer.parseInt(sheet1.getCell(6, i).getContents()));
                employee.setEmp_gender(Integer.parseInt(sheet1.getCell(10, i).getContents()));
                employee.setEmp_marital_status(sheet1.getCell(11, i).getContents());
                employee.setJob_title_code(Integer.parseInt(sheet1.getCell(19, i).getContents()));
                employee.setEmpstreet1(sheet1.getCell(22, i).getContents());
                employee.setEmpstreet2(sheet1.getCell(23, i).getContents());
                employee.setCity_code(sheet1.getCell(24, i).getContents());
                employee.setCoun_code(sheet1.getCell(25, i).getContents());
                employee.setProvin_code(sheet1.getCell(26, i).getContents());
                employee.setEmp_zipcode(sheet1.getCell(27, i).getContents());
                employee.setEmp_mobile(sheet1.getCell(28, i).getContents());
                employee.setEmp_work_email(sheet1.getCell(31, i).getContents());
                employee.setJoined_date(java.sql.Date.valueOf(sheet1.getCell(33, i).getContents()));
        		employeeList.add(employee);
        	
        }
        
         return employeeList;
	}
	
}
