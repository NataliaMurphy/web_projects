/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Premkumar
 */
public class UserDB {
    
    public void adduser(Login login)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query="INSERT into user_details(UserID,FirstName,LastName,Gender,"
                    + "EmailAddress,SSN,Address,city,state,zipcode,Date_Of_birth,Phone_Number) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String query1="Insert into login_details(UserID,Password,Security_Ques1,Answer1) values(?,?,?,?)";
        
        PreparedStatement ps;
       PreparedStatement ps1;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement(query);
            ps1=connection.prepareStatement(query1);
            ps.setString(1, login.getUserID());
            ps.setString(2, login.getFirstname());
            ps.setString(3, login.getLastname());
            ps.setString(4, login.getGender());
            ps.setString(5, login.getEmailaddress());
            ps.setString(6, login.getSSN());
            ps.setString(7, login.getAddress());
            ps.setString(8, login.getCity());
            ps.setString(9, login.getState());
            ps.setString(10, login.getZipcode());
            ps.setString(11, login.getDate_Of_birth());
            ps.setString(12, login.getPhone_Number()); 
            ps1.setString(1,login.getUserID());
            ps1.setString(2, login.getPassword());
            ps1.setString(3, login.getQuestion1());
            ps1.setString(4, login.getAnswer1());
            ps.executeUpdate();    
            ps1.executeUpdate();

        } 
        
         catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " +login.getUserID() );
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + login.getUserID() + " " + se.getCause());
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + login.getUserID());
            
        }
        System.out.println("Added product to PRODUCT table: " + login.getUserID());
        
      
    }
    
    public String getUser(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        
        String end_user ="";
        String query = "";
        query = "SELECT userID FROM user_details where userID = '" + i + "'";
       
        try {
       
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + i);
                return null;
            } else {
                end_user = resultSet.getString("userID");
               // end_user = new NewUser(userID);
                System.out.println("Found user in user table: " + i);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return end_user;
    }
    
    public boolean CheckUser(String username,String Pwd) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;       
        boolean a = false;
        String query = "";
        query = "SELECT userID,Password FROM login_details where userID = '" + username + "'";
       
        try {
       
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                
                a= false;
                
            } 
            
            else 
            {
                String password=resultSet.getString("Password");
                if (password.equals(Pwd))
                {
                    a= true;
                }
                else
                {
                    a= false;
                }
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

      return a;
    }
    public Login getUserDetails(String userid) 
      {
        Login l=new Login();
        String query= "SELECT UserID,Security_Ques1,Answer1 from Login_details where UserID='"+ userid +"'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                l.setUserID(resultSet.getString("UserID"));
                l.setQuestion1(resultSet.getString("Security_Ques1"));
                l.setAnswer1(resultSet.getString("Answer1"));
                i++;

            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        if(i>0)
        {
        return l;
        }
        else
        {
            return l;
        }

    }
      public int changePassword(String userid,String newpassword)
    {
        
        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        int result;
        String query= "UPDATE Login_details set Password=? where UserID=?";
       
      try
      {
        ps=connection.prepareStatement(query);
        ps.setString(1, newpassword);
        ps.setString(2, userid);
        result=ps.executeUpdate();
        
      }
      catch(Exception e)
      {
          return 0;
      }
         
      if (result>0)
      { return 1;}
      else
      {   return 0;}
        
        
    }
      public Login UserDetails(String userid) 
      {
        Login l=new Login();
        String query= "SELECT EmailAddress,Address,city,state,zipcode,Phone_Number from user_details where UserID='"+ userid +"'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                
                l.setEmailaddress(resultSet.getString("EmailAddress"));
                l.setAddress(resultSet.getString("Address"));
                l.setCity(resultSet.getString("city"));
                l.setState(resultSet.getString("state"));
                l.setZipcode(resultSet.getString("zipcode"));
                l.setPhone_Number(resultSet.getString("Phone_Number"));
               // l.setUserID(resultSet.getString("UserID"));
                //l.setQuestion1(resultSet.getString("Security_Ques1"));
                //l.setAnswer1(resultSet.getString("Answer1"));
                i++;

            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return l;
    }
      
       public int changeDetails(String userid,String emailaddress,String address,String city,String state,String zipcode,String phone)
    {
        
        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        int result;
       
        String query= "UPDATE user_details set EmailAddress=?,Address=?,city=?,state=?,zipcode=?,Phone_Number=? where UserID=?";
       
      try
      {
        ps=connection.prepareStatement(query);
        ps.setString(1, emailaddress);
        ps.setString(2, address);
        ps.setString(3, city);
        ps.setString(4, state);
        ps.setString(5, zipcode);
        ps.setString(6, phone);   
        ps.setString(7, userid);    
        result=ps.executeUpdate();
        
      }
      catch(Exception e)
      {
          return 0;
      }
         
      if (result>0)
      { return 1;}
      else
      {   return 0;}   
    }
      
     
       public Login getRole(String userid) 
      {
        Login l=new Login();
        String query= "SELECT Role from login_details where UserID='"+ userid +"'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                l.setUserID(resultSet.getString("UserID"));
               
                i++;

            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        if(i>0)
        {
        return l;
        }
        else
        {
            return l;
        }

    }
       
       public int getUserRole(String userid) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        int Role=0;
        String query = "";
        query= "SELECT Role from login_details where UserID='"+ userid +"'";
       
        try {
            // Find the speciic row in the table
            

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                //System.out.println("WARNING: Could not find user in USER table: " + userID);
                return 0;
            } else {
                Role = resultSet.getInt("Role");
                
                //System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return 0;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return Role;
    }
    
}
