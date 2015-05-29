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
import java.util.ArrayList;

/**
 *
 * @author Arj
 */
public class BookDB {
    
    public String getBook(String i, String j) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String item ="";
        NewUser end_user = new NewUser();
        String query = "";
        query = "SELECT "+i+" from book where "+i+" = '"+j+"'";
       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while(resultSet.next()) {
                if(!(resultSet.getString(""+i+"").isEmpty())) {
                item = resultSet.getString(""+i+"");
                }
            }           
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return item;
    }
    
    public ArrayList<bookprice> getBooks(String i,String j) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        ArrayList<bookprice> bp = new ArrayList<bookprice>();
        
        String isbn = "";
        String title = "";
        String author = "";
        String subject = "";
        String year = "";
        String imageurl="";
        String availability = "";
        String links = "";
        String links2 = "";
        String price = "";
        bookprice books = new bookprice();
        
        String query = "";
       
        query = "SELECT ISBN , BookTitle , Author , BookSubject , Year ,ImageURL ,Availability , Links, Links2, Price from book where "+i+" = '"+j+"'";
        
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                isbn = resultSet.getString("ISBN");
                title = resultSet.getString("BookTitle");
                author = resultSet.getString("Author");
                subject = resultSet.getString("BookSubject");
                year = resultSet.getString("Year");
                imageurl = resultSet.getString("ImageURL");
                availability = resultSet.getString("Availability");
                links = resultSet.getString("Links");
                links2 = resultSet.getString("Links2");
                price = resultSet.getString("Price");
                
                books = new bookprice(isbn,title,author,subject,year,imageurl,availability,links,links2,price);
                bp.add(books);
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

        return bp;
    }
  
    
    public bookprice getSpecificBook(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
       
        
        String isbn = "";
        String title = "";
        String author = "";
        String subject = "";
        String year = "";
        String imageurl="";
        String availability = "";
        String links = "";
        String links2 = "";
        String price = "";
        bookprice book = new bookprice();
        
        String query = "";
       
        query = "SELECT ISBN, BookTitle , Author , BookSubject , Year ,ImageURL ,Availability , Links , Links2, Price from book where ISBN  = '"+i+"'";
        
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
             while(resultSet.next()){
                isbn = resultSet.getString("ISBN");
                title = resultSet.getString("BookTitle");
                author = resultSet.getString("Author");
                subject = resultSet.getString("BookSubject");
                year = resultSet.getString("Year");
                imageurl = resultSet.getString("ImageURL");
                availability = resultSet.getString("Availability");
                links = resultSet.getString("Links");
                links2 = resultSet.getString("Links2");
                price = resultSet.getString("Price");
                
                book = new bookprice(isbn,title,author,subject,year,imageurl,availability,links,links2,price);
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

        return book;
    }
 
    
    public void updateSpecificBook(String isbn, String title, String author, String subject, String year
             ,String imageurl,String availability,String links ,String links2,String Price) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
       
      
        bookprice book = new bookprice();
        
       
        String query = "";
       
        query = "update book set BookTitle= ?, Author= ? ,BookSubject= ? , Year = ? ,"
                + " ImageURL= ? ,Availability= ?,Links = ?,Links2 = ?,Price = ? where ISBN  = '"+isbn+"'";
        
         try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
//            ps.setString(1,isbn);
            ps.setString(1,title);
            ps.setString(2,author);
            ps.setString(3,subject);
            ps.setString(4,year);
            ps.setString(5,imageurl);
            ps.setString(6,availability);
            ps.setString(7,links);
            ps.setString(8,links2);
            ps.setString(9,Price);
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
    
    public void deleteSpecificBook(String isbn) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        bookprice book = new bookprice();

        String query = "";
       
        query = "Delete from book where ISBN  = '"+isbn+"'";
        
         try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public bookprice AddBook(String isbn,String title,String author,String subject,String year,String imageurl,
               String availability,String links,String links2,String price) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        bookprice b = new bookprice();
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO book(ISBN,BookTitle,Author,BookSubject,Year,ImageURL,Availability,Links,Links2,Price) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,? ,?)");
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, subject);
            ps.setString(5, year);
            ps.setString(6, imageurl);
            ps.setString(7, availability);
            ps.setString(8, links);
            ps.setString(9, links2);
            ps.setString(10, price);
             
           ps.executeUpdate();

        } catch (SQLException se) {
            return null;
        } 
        finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        // return the  User object
        return b;
    }
 
 
}
