/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;


import java.sql.*;
import java.util.*;
/**
 *
 * @author priyanka
 */
public class UserDB {

	// Arjun's methods


	public ArrayList<NewUser> getUsers(String i,String j) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        ResultSet resultSet = null;
	        PreparedStatement ps = null;
	        ArrayList<NewUser> s = new ArrayList<NewUser>();

	        String firstname ="";
	        String lastname ="";
	        String EmailAddress ="";
	        String course ="";
	        String dept ="";
	        String club = "";
	        NewUser end_user = new NewUser();

	        String query = "";

	        query = "SELECT FirstName , LastName , Club , Department , EmailAddress , Course from user where "+i+" = '"+j+"'";

	        try {
	            // Find the speciic row in the table
	            ps = connection.prepareStatement(query);
	            resultSet = ps.executeQuery();

	            while(resultSet.next()){
	                firstname = resultSet.getString("FirstName");
	                lastname = resultSet.getString("LastName");
	                club = resultSet.getString("Club");
	                dept = resultSet.getString("Department");
	                EmailAddress = resultSet.getString("EmailAddress");
	                course = resultSet.getString("Course");

	                end_user = new NewUser(firstname,lastname,club,dept,EmailAddress,course);
	                s.add(end_user);
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

	        return s;
	    }


	  public String getItem(String i, String j) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        ResultSet resultSet = null;
	        PreparedStatement ps = null;

	        String item ="";
	        NewUser end_user = new NewUser();
	        String query = "";
	        query = "SELECT "+i+" from user where "+i+" = '"+j+"'";

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


	 public NewUser addUser(NewUser user) {

	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        // insert the new row into the table
	        try {
	            ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?)");
	            ps.setString(1, user.getUserID());
	            ps.setString(2, user.getFirstName());
	            ps.setString(3, user.getLastName());
	            ps.setString(4, user.getEmailAddress());
	            ps.setString(5, user.getAddress());
	            ps.setString(6, user.getCity());
	            ps.setString(7, user.getState());
	            ps.setString(8, user.getCountry());
	            ps.setString(9, user.getZIP());
	            ps.setString(10, user.getDateOfBirth());
	            ps.setString(11, user.getPhoneNum());
	            ps.setString(12, user.getCourse());
	            ps.setString(13, user.getDepartment());
	            ps.setString(14, user.getClub());
	            ps.setString(15, user.getGender());
	            ps.setInt(16, user.getUserType());
	            ps.setString(17, user.getUserpassword());
	            ps.setString(18, user.getQuestion1());
	            ps.setString(19, user.getAnswer1());
	            ps.setString(20, user.getQuestion2());
	            ps.setString(21, user.getAnswer2());

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


	 public NewUser getUser(String i) {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        ResultSet resultSet = null;
	        PreparedStatement ps = null;

	        String userID ="";
	        NewUser end_user = new NewUser();
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
	                end_user = new NewUser(userID);
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


	// from priyanka part

    public UserDetails getLogin(String i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String userID ="";
        String password ="";
        String firstName = "";
        String lastName = "";
        String email = "";
        String city = "";
        String state = "";
        String zip ="";
        String address = "";
        String ques1 = "";
        String ans1 = "";
        String ques2 = "";
        String ans2 ="";


        int userType = 0;
        UserDetails end_user = new UserDetails();
        String query = "";
        query = "SELECT userID,userpassword,firstName,usertype,address,lastname,city,state,zip ,ques1,ans1,ques2,ans2,emailaddress FROM user where userID = '" + i + "'";
                try {
            // Find the speciic row in the table


            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                userID = resultSet.getString("userID");
                password = resultSet.getString("userpassword");
                firstName = resultSet.getString("firstName");
                userType = resultSet.getInt("usertype");
                lastName = resultSet.getString("lastname");
                address = resultSet.getString("address");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zip = resultSet.getString("zip");
                ques1 = resultSet.getString("ques1");
                ques2 = resultSet.getString("ques2");
                ans1  = resultSet.getString("ans1");
                ans2 = resultSet.getString("ans2");
                email = resultSet.getString("emailaddress");
                end_user = new UserDetails(userID,password,firstName,lastName,email,address,city,state,zip,userType,ques1,ans1,ques2,ans2);
                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        } finally
         {
             pool.freeConnection(connection);
             DBUtil.closeResultSet(resultSet);
             DBUtil.closePreparedStatement(ps);
         }

        return end_user;
    }


    public ArrayList<UserDetails> getAllUsers() {
        ArrayList<UserDetails> users = new ArrayList<UserDetails>();


        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String userID = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement("SELECT userID, firstName, lastName, emailaddress, address,city, state, zip, country FROM user ORDER BY userID");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                userID = resultSet.getString("userID");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("emailaddress");
                address1 = resultSet.getString("address");

                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zip");
                country = resultSet.getString("country");
                UserDetails user = new UserDetails(userID, firstName, lastName, email, address1,city, state,country, zipcode);
                users.add(user);
                System.out.println("Found user in USER table: " + userID);
            }
        return users;
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }


    }

    void setpassword(String newpasswd , String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result;
        String query= "UPDATE user set userpassword=? where userid=?";
      try
      {
        ps=connection.prepareStatement(query);
        ps.setString(1, newpasswd);
        ps.setString(2, userID);
        result=ps.executeUpdate();
        System.out.println("Updated password for user in USER table: " + userID);

      }
      catch(Exception e)
      {
         System.out.println("ERROR: Could not execute SQL statement in: " + "UserDB.setpassword()");
         System.out.println("ERROR: Could not execute SQL statement: " + e);
      }finally {

            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
    }


