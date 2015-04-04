/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import javax.servlet.*;

/**
 *
 * @author Arj
 */
public class UserDB 
{
//    ArrayList<User> users = new ArrayList<User>();
//    public UserDB(){
//        
//    users.add(new User("Arjun","Arjun","Srinivasa","arjun.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","arjun"));
//    users.add(new User("Prashanth","Prashanth","Vardhan","arjun.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","prashanth"));
//    users.add(new User("Madhu","Madhu","Chatra","arjun.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","madhu"));
//    users.add(new User("Sourabh","Sourabh","Bunan","arjun.004@gmail.com","UT_Drive","charlotte,NC","Charlotte","NC","28262","USA","sourabh"));
//
//}
// public ArrayList<User> getUsers(){
//      return users;
//    }    




// This class handles the USER table.
//    public void createUserTable() {
//
//        Statement statement = DbAdmin.getNewStatement();
//
//        try {
//            statement.execute("CREATE TABLE users("
//                    + "userID int,firstName VARCHAR(50),"
//                    + "lastName VARCHAR(50), emailAddr VARCHAR(50),"
//                    + "address1 VARCHAR(50), address2 VARCHAR(50),"
//                    + "city VARCHAR(50),state VARCHAR(50),zipcode VARCHAR(50),"
//                    + "country VARCHAR(50),"
//                    + "PRIMARY KEY (userID))");
//
//            System.out.println("Created a new table: " + "USER");
//        } catch (SQLException se) {
//            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
//                // we got the expected exception when the table is already there
//            } else {
//                // if the error code or SQLState is different, we have an unexpected exception
//                System.out.println("ERROR: Could not create USER table: " + se);
//            }
//        }
//    }

//    public User addUser(int userID, String firstName, String lastName, String email,
//                        String address1, String address2, String city, String state,
//            String zipcode, String country,String password) {
//
//        Connection connection = DbAdmin.getConnection();
//        PreparedStatement insertRow;
//        // insert the new row into the table
//        try {
//            insertRow = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
//            insertRow.setInt(1, userID);
//            insertRow.setString(2, firstName);
//            insertRow.setString(3, lastName);
//            insertRow.setString(4, email);
//            insertRow.setString(5, address1);
//            insertRow.setString(6, address2);
//            insertRow.setString(7, city);
//            insertRow.setString(8, state);
//            insertRow.setString(9, zipcode);
//            insertRow.setString(10, country);
//            insertRow.setString(11, password);
//            insertRow.executeUpdate();
//
//        } catch (SQLException se) {
//            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
//                System.out.println("ERROR: Could not insert record into USER; dup primary key: " + userID);
//            } else {
//                System.out.println("ERROR: Could not add row to USER table: " + userID + " " + se.getCause());
//            }
//            return null;
//        } catch (Exception e) {
//            System.out.println("ERROR: Could not add row to USER table: " + userID);
//            return null;
//        }
//        System.out.println("Added user to USER table: " + userID);
//
//        // return the new User object
//        return new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
//    }
////
//    public User addUser(User user) {
//
//        Connection connection = DbAdmin.getConnection();
//        PreparedStatement ps;
//        // insert the new row into the table
//        try {
//            ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//            ps.setInt(1, user.getUserID());
//            ps.setString(2, user.getFirstName());
//            ps.setString(3, user.getLastName());
//            ps.setString(4, user.getEmailAddress());
//            ps.setString(5, user.getAddress1Field());
//            ps.setString(6, user.getAddress2Field());
//            ps.setString(7, user.getCity());
//            ps.setString(8, user.getState());
//            ps.setString(9, user.getPostCode());
//            ps.setString(10, user.getCountry());
//            ps.executeUpdate();
//
//        } catch (SQLException se) {
//            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
//                System.out.println("ERROR: Could not insert record into USER; dup primary key: " + user.getUserID());
//            } else {
//                System.out.println("ERROR: Could not add row to USER table: " + user.getUserID() + " " + se.getCause());
//            }
//            return null;
//        } catch (Exception e) {
//            System.out.println("ERROR: Could not add row to USER table: " + user.getUserID());
//            return null;
//        }
//        System.out.println("Added user to USER table: " + user.getUserID());
//
//        // return the  User object
//        return user;
//    }

//    public User getUser(int userID) {
//
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        ResultSet resultSet = null;
//        PreparedStatement ps = null;
//
//        String firstName = "";
//        String lastName = "";
//        String emailAddr = "";
//        String address1Field = "";
//        String address2Field = "";
//        String city = "";
//        String state = "";
//        String zipPostalCode = "";
//        String country = "";
//
//        String query = "";
//        query = "SELECT firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country FROM user WHERE userID = "+ userID;
//       
//        try {
//            // Find the speciic row in the table
//            
//
//            ps = connection.prepareStatement(query);
//            resultSet = ps.executeQuery();
//            
//            if (!resultSet.next()) {
//                System.out.println("WARNING: Could not find user in USER table: " + userID);
//                return null;
//            } else {
//                firstName = resultSet.getString("firstName");
//                lastName = resultSet.getString("lastName");
//                emailAddr = resultSet.getString("emailAddr");
//                address1Field = resultSet.getString("address1Field");
//                address2Field = resultSet.getString("address2Field");
//                city = resultSet.getString("city");
//                state = resultSet.getString("state");
//                zipPostalCode = resultSet.getString("zipPostalCode");
//                country = resultSet.getString("country");
//
//                System.out.println("Found user in user table: " + userID);
//            }
//        } catch (SQLException se) {
//            System.out.println("ERROR: Could not execute SQL statement: " + query);
//            System.out.println("SQL error: " + se);
//            return null;
//        }
//
//        return new User(userID, firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country);
//    }
    
    public User getLogin(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String userID ="";
        String name ="noname";
        String password ="";
        User end_user = new User();
        String query = "";
        query = "SELECT userID,password FROM user where userID = '" + i + "'";
       
        try {
            // Find the speciic row in the table
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return end_user;
            } else {
                userID = resultSet.getString("userID");
                password = resultSet.getString("password");
                end_user = new User(userID,password);
                System.out.println("Found user in user table: " + userID);
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
    

//    public ArrayList<User> getAllUsers() {
//        ArrayList<User> users = new ArrayList<>();
//
//        Statement statement = DbAdmin.getNewStatement();
//        ResultSet resultSet = null;
//
//        int userID = 0;
//        String firstName = "";
//        String lastName = "";
//        String email = "";
//        String address1 = "";
//        String address2 = "";
//        String city = "";
//        String state = "";
//        String zipcode = "";
//        String country = "";
//        try {
//            // Find the speciic row in the table
//            resultSet = statement.executeQuery(
//                    "SELECT userID, firstName, lastName, email, address1, address2, city, state, zipcode, country FROM user ORDER BY userName");
//            while (resultSet.next()) {
//                userID = resultSet.getInt("userID");
//                firstName = resultSet.getString("firstName");
//                lastName = resultSet.getString("lastName");
//                email = resultSet.getString("email");
//                address1 = resultSet.getString("address1");
//                address2 = resultSet.getString("address2");
//                city = resultSet.getString("city");
//                state = resultSet.getString("state");
//                zipcode = resultSet.getString("zipcode");
//                country = resultSet.getString("country");
//                User user = new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
//                users.add(user);
//                System.out.println("Found user in USER table: " + userID);
//            }
//        } catch (SQLException se) {
//            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.getAllUsers()");
//            System.out.println("ERROR: Could not execute SQL statement: " + se);
//            return null;
//        }
//
//        return users;
//    }
//
    
     public User addUser(User user) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, user.getUserID());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmailAddress());
            ps.setString(5, user.getAddress1Field());
            ps.setString(6, user.getAddress2Field());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());        
            ps.setString(9, user.getPostCode());
            ps.setString(10, user.getCountry());  
            ps.setString(11, user.getPassword());
                       
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
     
     
     public User getUser(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String userID ="";
        User end_user = new User();
        String query = "";
        query = "SELECT userID FROM user where userID = '" + i + "'";
       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
               
            } else {
                userID = resultSet.getString("userID");
                end_user = new User(userID);
                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return end_user;
    }
 
     public User getUserOrder(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String userID ="";
        User end_user = new User();
        String query = "";
        query = "SELECT userID FROM orders where userID = '" + i + "'";
       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                
            } else {
                userID = resultSet.getString("userID");
                end_user = new User(userID);
                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
          
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return end_user;
    }
 
     public ArrayList<Order> getUserOrderList(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        ArrayList<Order> ol = new ArrayList<>();

        String userID ="";
        int ordernumber =0;
        String date = "";
        double totalcost = 0.0;
        Order end_user = new Order();
        String query = "";
        query = "SELECT * FROM orders where userID = '" + i + "'";
       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                do {
                ordernumber = resultSet.getInt("OrderNumber");
                userID = resultSet.getString("userID");
                date = resultSet.getString("Date");
                totalcost = resultSet.getDouble("TotalCost");
                end_user = new Order(ordernumber,userID,date,totalcost);
                ol.add(end_user);
                System.out.println("Found user in user table: " + userID);
                }
                while(resultSet.next());
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return ol;
    }
 
      public ArrayList<Order> getAdminOrderList() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        ArrayList<Order> ol = new ArrayList<>();

        String userID ="";
        int ordernumber =0;
        String date = "";
        double totalcost = 0.0;
        Order end_user = new Order();
        String query = "";
        query = "SELECT * FROM orders ";
       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                do {
                ordernumber = resultSet.getInt("OrderNumber");
                userID = resultSet.getString("userID");
                date = resultSet.getString("Date");
                totalcost = resultSet.getDouble("TotalCost");
                end_user = new Order(ordernumber,userID,date,totalcost);
                ol.add(end_user);
                System.out.println("Found user in user table: " + userID);
                }
                while(resultSet.next());
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return ol;
    }
        public User getUserAddress(String u) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
      

        String address1field ="";
        String address2field ="";
        String city ="";
        String state = "";
        String zip="";
        String country ="";
        User end_user = new User();
        String query = "";
        query = "select address1Field, address2Field,city,state,zipPostalCode,country from user where userID = '" + u + "'";

       
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            if (!resultSet.next()) {
                //System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                address1field = resultSet.getString("address1Field");
                address2field = resultSet.getString("address2Field");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zip = resultSet.getString("zipPostalCode");
                country = resultSet.getString("country");
                end_user = new User(address1field,address2field,city,state,zip,country);
                
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

        return end_user;
    }
     
}