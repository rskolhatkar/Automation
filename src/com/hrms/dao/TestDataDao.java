package com.hrms.dao;  
  
  
  
import java.io.IOException;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

import jxl.read.biff.BiffException;

import com.hrms.testData.EmployeeLoginTestData;
import com.hrms.testData.EmployeeTestData;
import com.hrms.testData.populateTestData;
import com.hrms.populateTestSuite.*;
import com.hrms.util.DbUtil;  
  
  
  
public class TestDataDao {  
  
    private Connection connection;  
  
    public TestDataDao() {  
  
        connection = DbUtil.getConnection();  
  
    }  
    
    
    public int getMaxEmployeeNumber(){
    	int emp_number =0;
    	try {  
    		
    		
            Statement statement = connection.createStatement();  
            ResultSet rs = statement.executeQuery("SELECT MAX(emp_number) AS emp_number FROM orangehrm_db.hs_hr_employee"); 
            
            while (rs.next()) {  
            	emp_number =rs.getInt("emp_number");  
              }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
        return emp_number+1;
    }
    
  
    public TestSuite addEmployee(TestSuite testSuite , int user_role_id) throws BiffException, IOException{
    	
    	int emp_number = getMaxEmployeeNumber();
    	
    	populateTestData populate = new populateTestData();
    	EmployeeTestData e = populate.populateEmployee();
    	
    	e.setEmp_number(emp_number);
    	e.setEmp_id("E" + emp_number);
    	
    	testSuite.setEmp_number(emp_number);
    	
    	LoginTestData login = testSuite.getLoginTestData();
    	login.setPassword("test");
    	login.setUsername("test" + emp_number);
 
    	try{
    		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orangehrm_db.hs_hr_employee "
    				+ "(emp_number, "
    				+ "employee_id, "
    				+ "emp_lastname, "
    				+ "emp_firstname, "
    				+ "emp_middle_name, "
    				+ "emp_smoker, "
    				+ "emp_gender, "
    				+ "emp_marital_status, "
    				+ "job_title_code, "
    				+ "emp_street1, "
    				+ "emp_street2, "
    				+ "city_code, "
    				+ "coun_code, "
    				+ "provin_code, "
    				+ "emp_zipcode, "
    				+ "emp_mobile, "
    				+ "emp_work_email, "
    				+ "joined_date) "
    				+ "VALUES "
    				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		 preparedStatement.setInt(1, e.getEmp_number());
    		 preparedStatement.setString(2, e.getEmp_id() );
    		 preparedStatement.setString(3,  e.getEmplastname());
    		 preparedStatement.setString(4,  e.getEmpfirstname());
    		 preparedStatement.setString(5,  e.getEmpmiddle_name());
    		 preparedStatement.setInt(6,  e.getEmp_smoker());
     		 preparedStatement.setInt(7,  e.getEmp_gender());
    		 preparedStatement.setString(8,  e.getEmp_marital_status());
    		 preparedStatement.setInt(9,  e.getJob_title_code());
    		 preparedStatement.setString(10,  e.getEmpstreet1());
    		 preparedStatement.setString(11,  e.getEmpstreet1());
    		 preparedStatement.setString(12,   e.getCity_code());
    		 preparedStatement.setString(13,  e.getCoun_code());
    		 preparedStatement.setString(14,  e.getProvin_code());
    		 preparedStatement.setString(15,  e.getEmp_zipcode());
    		 preparedStatement.setString(16,  e.getEmp_mobile());
    		 preparedStatement.setString(17,  e.getEmp_work_email());
       		 preparedStatement.setDate(18,  e.getJoined_date());
       		preparedStatement.executeUpdate();  
       		
       		preparedStatement.close();
       		addLoginDetails(emp_number , user_role_id);
       		
    	}catch (SQLException ee) {  
           ee.printStackTrace();  
        } 
    	
    	return testSuite;
    }
    
    
    public void addLoginDetails(int emp_number , int user_role_id) throws BiffException, IOException{
    	
    	populateTestData populate = new populateTestData();
    	EmployeeLoginTestData e = populate.populateEmployeeLoginDetails();
    	e.setUser_role_id(user_role_id);
    	e.setEmp_number(emp_number);
    	
    	try{
    		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orangehrm_db.ohrm_user"
    				+ " (user_role_id,"
    				+ " emp_number,"
    				+ " user_name,"
    				+ " user_password,"
    				+ " deleted,"
    				+ " status,"
    				+ " date_entered,"
    				+ " date_modified,"
    				+ " modified_user_id,"
    				+ " created_by)"
    				+ " VALUES ("
    				+ " ?,?,?,?,?,?,?,?,?,? )");
    		
    		preparedStatement.setInt(1, e.getUser_role_id());
    		preparedStatement.setInt(2, e.getEmp_number());
    		preparedStatement.setString(3, e.getUser_name() );
    		preparedStatement.setString(4, e.getUser_password() );
    		preparedStatement.setInt(5, e.getDeleted());
    		preparedStatement.setInt(6, e.getStatus());
    		preparedStatement.setDate(7, e.getDate_entered());
    		preparedStatement.setDate(8, e.getDate_modified());
    		preparedStatement.setInt(9, e.getModified_user_id());
    		preparedStatement.setInt(10, e.getCreated_by());
    		
    		preparedStatement.executeUpdate();  
    		
    		preparedStatement.close();
    	}catch(SQLException ee){
    		ee.printStackTrace();
    	}
    }
    
    
    public void deleteEmployee(int emp_number){
    	try{
    	PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orangehrm_db.hs_hr_employee"
    			+ " WHERE emp_number= ?");
    	preparedStatement.setInt(1, emp_number);
		preparedStatement.executeUpdate();  
		
		preparedStatement.close();
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    
  /*
  
    public void addEmployee() {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into users(firstname,lastname,dob,email) values (?, ?, ?, ? )");  
  
            // Parameters start with 1  
          
            preparedStatement.setString(1, user.getFirstName());  
  
            preparedStatement.setString(2, user.getLastName());  
  
            preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));  
  
            preparedStatement.setString(4, user.getEmail());  
  
            preparedStatement.executeUpdate();  
           System.out.println( user.getFirstName());
        
        
           PreparedStatement preparedStatement1 = connection.prepareStatement("Select userid from users where "
            		+ " firstname=? AND lastname=? AND dob=? AND email=?");
            
            preparedStatement1.setString(1, user.getFirstName());  
            
            preparedStatement1.setString(2, user.getLastName());  
  
            preparedStatement1.setDate(3, new java.sql.Date(user.getDob().getTime()));  
  
            preparedStatement1.setString(4, user.getEmail());  
  
            ResultSet rs  = preparedStatement1.executeQuery();  
  
            int userID = 0;
            while (rs.next()) {  
            	
            	userID =	rs.getInt("userid");
            	
            	System.out.println("**************************** " + userID);
            }
           
            PreparedStatement preparedStatement2 = connection  
  
                    .prepareStatement("insert into department(dept_name,userid) values (?, ? )");  
  
            // Parameters start with 1  
  
           
            preparedStatement2.setString(1, user.getDepartment()); 
            preparedStatement2.setInt(2, userID); 
            preparedStatement2.executeUpdate();  
            
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteUser(int userId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from users where userid=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, userId);  
  
            preparedStatement.executeUpdate();  
  /*
          PreparedStatement preparedStatement1 = connection  
            		  
                    .prepareStatement("delete from department where userid=?");  
  
            // Parameters start with 1  
  
            preparedStatement1.setInt(1, userId);  
  
            preparedStatement1.executeUpdate(); 
 
 
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateUser(User user) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +  
  
                            "where userid=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, user.getFirstName());  
  
            preparedStatement.setString(2, user.getLastName());  
  
            preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));  
  
            preparedStatement.setString(4, user.getEmail());  
  
            preparedStatement.setInt(5, user.getUserid());  
  
            preparedStatement.executeUpdate();  
  
            PreparedStatement preparedStatement1 = connection  
            		  
                    .prepareStatement("update department set dept_name=?" +  
  
                            "where userid=?");  
            preparedStatement1.setString(1, user.getDepartment());
            preparedStatement1.setInt(2, user.getUserid());
            preparedStatement1.executeUpdate();  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<User> getAllUsers() {  
  
        List<User> users = new ArrayList<User>();  
  
        try {  
  
            Statement statement = connection.createStatement();  
            ResultSet rs = statement.executeQuery("SELECT users.userid, users.firstname, users.lastname,users.dob,"
            		+ "users.email, department.dept_name "
            		+ "FROM users "
            		+ "INNER JOIN department "
            		+ " ON users.userid=department.userid"); 
            
            
            while (rs.next()) {  
  
                User user = new User();  
  
                user.setUserid(rs.getInt("userid"));  
  
                user.setFirstName(rs.getString("firstname"));  
  
                user.setLastName(rs.getString("lastname"));  
  
                user.setDob(rs.getDate("dob"));  
  
                user.setEmail(rs.getString("email"));  
                user.setDepartment(rs.getString("dept_name")); 
                
                users.add(user);  
  
            }  
            
            
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return users;  
  
    }  
  
    
    public List<User> getSearchUsers(String firstName) {  
    	  
    	
    	if(firstName.equalsIgnoreCase("All")){
    		firstName ="";
    	}
        List<User> users = new ArrayList<User>();  
  
        try {  
  
        	PreparedStatement preparedStatement = connection.  
      			  
                    prepareStatement("SELECT users.userid, users.firstname, users.lastname,users.dob,"
            		+ "users.email, department.dept_name "
            		+ "FROM users "
            		+ "INNER JOIN department "
            		+ " ON users.userid=department.userid"
            		+ " Where users.firstname LIKE ? "
            		); 
        	
        	preparedStatement.setString(1, "%" + firstName + "%" );  
        	  
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {  
  
                User user = new User();  
  
                user.setUserid(rs.getInt("userid"));  
  
                user.setFirstName(rs.getString("firstname"));  
  
                user.setLastName(rs.getString("lastname"));  
  
                user.setDob(rs.getDate("dob"));  
  
                user.setEmail(rs.getString("email"));  
                user.setDepartment(rs.getString("dept_name")); 
                
                users.add(user);  
  
            }  
            
            
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return users;  
  
    } 
    
  
  
    public User getUserById(int userId) {  
  
        User user = new User();  
  
        try {  
  
    /*        PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select * from users where userid=?");  
  
            preparedStatement.setInt(1, userId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
        	
        	PreparedStatement preparedStatement = connection.  
        			  
                    prepareStatement("SELECT users.userid, users.firstname, users.lastname,users.dob,"
                    		+ "users.email, department.dept_name "
                    		+ "FROM users "
                    		+ "INNER JOIN department "
                    		+ " ON users.userid=department.userid where users.userid=?");  
  
            preparedStatement.setInt(1, userId);  
  
            ResultSet rs = preparedStatement.executeQuery(); 
            
  
            if (rs.next()) {  
  
                user.setUserid(rs.getInt("userid"));  
  
                user.setFirstName(rs.getString("firstname"));  
  
                user.setLastName(rs.getString("lastname"));  
  
                user.setDob(rs.getDate("dob"));  
  
                user.setEmail(rs.getString("email"));  
                
                user.setDepartment(rs.getString("dept_name"));
            }  
            
                
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return user;  
  
    }
    
    public LoginUser getLoginUser(String username, String password) {  
    	  
        LoginUser user = new LoginUser();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select * from loginusers where username=? and password=?");  
  
            preparedStatement.setString(1, username); 
            preparedStatement.setString(2, password); 
  
            ResultSet rs = preparedStatement.executeQuery();  
  
   
            if (rs.next()) {  
  
                user.setLoginid(rs.getInt("loginid"));  
  
                user.setUsername(rs.getString("username"));  
  
                user.setPassword(rs.getString("password"));  
  
                user.setRole(rs.getString("role"));  
  
                user.setStatus(rs.getString("status"));  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return user;  
  
    }
       
  */
}