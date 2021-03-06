package com.hrms.util;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.util.Properties;  
  
public class DbUtil {  
  
  
  
    private static Connection connection = null;  
  
  
  
    public static Connection getConnection() {  
  
        if (connection != null)  
  
            return connection;  
  
        else {  
  
            try {  
  
                Properties prop = new Properties();  
                prop.load(new FileInputStream("../AutomationProject/config/db.properties"));
                String driver = prop.getProperty("driver");  
                String url = prop.getProperty("url");  
                String user = prop.getProperty("user");  
                String password = prop.getProperty("password");  
                Class.forName("com.mysql.jdbc.Driver");  
                connection = DriverManager.getConnection(url, "root", "");  
  
            } catch (ClassNotFoundException e) {  
  
                e.printStackTrace();  
  
            } catch (SQLException e) {  
  
                e.printStackTrace();  
  
            } catch (FileNotFoundException e) {  
  
                e.printStackTrace();  
  
            } catch (IOException e) {  
  
                e.printStackTrace();  
  
            }  
  
            return connection;  
  
        }  
  
  
  
    }  
  
}  