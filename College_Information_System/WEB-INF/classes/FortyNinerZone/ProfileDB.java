/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arj
 */
public class ProfileDB {
    
    public UserDetails getSpecificProfile(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
       
        
        String firstname = "";
        String lastname = "";
        String club = "";
        String dept = "";
        String emailid = "";
        String course="";
        UserDetails ud = new UserDetails();
        
        String query = "";
       
        query = "SELECT FirstName , LastName ,Club ,Department , EmailAddress ,Course from user where EmailAddress  = '"+i+"'";
        
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
             while(resultSet.next()){
                firstname = resultSet.getString("FirstName");
                lastname = resultSet.getString("LastName");
                club = resultSet.getString("Club");
                dept = resultSet.getString("Department");
                emailid = resultSet.getString("EmailAddress");
                course = resultSet.getString("Course");
                
                
                ud = new UserDetails(firstname,lastname,club,dept,emailid,course);
               // bp.add(books);
                //System.out.println("Found user in user table: " + userID);
             }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return ud;
    }
 
    
     public void updateSpecificProfile(String firstname,String lastname,String club,String dept,String emailid,String course) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
       
      
        bookprice book = new bookprice();
        
       
        String query = "";
       
        query = "update user set FirstName = ?, LastName= ?, Club= ? ,Department= ? , EmailAddress = ? ,"
                + " Course= ? where EmailAddress  = '"+emailid+"'";
        
         try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.setString(3,club);
            ps.setString(4,dept);
            ps.setString(5,emailid);
            ps.setString(6,course);
            ps.executeUpdate();
//             }
            
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
//            System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

//        return book;
    }
     
     
     public UserDetails AddProfile(String userid,String firstname,String lastname,String club,String dept,String emailid,String course) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        UserDetails user = new UserDetails();
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO  user(UserID,FirstName,LastName,Club,Department,EmailAddress,Course) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, userid);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, club);
            ps.setString(5, dept);
            ps.setString(6, emailid);
            ps.setString(7, course);
                       
           ps.executeUpdate();

        } catch (SQLException se) {
            return null;
        } 
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        // return the  User object
        return user;
    }
 
       public void deleteSpecificProfile(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        bookprice book = new bookprice();
 
        String query = "";
       
        query = "Delete from user where EmailAddress  = '"+i+"'";
        
         try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
//            System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

//        return book;
    }
}
