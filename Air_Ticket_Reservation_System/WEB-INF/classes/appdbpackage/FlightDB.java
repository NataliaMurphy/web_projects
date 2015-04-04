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
import java.util.ArrayList;

/**
 *
 * @author Arj
 */
public class FlightDB {
     public void AddFlight(String flightnum,String source,String destination,String flighttype,String arrival,String departure) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        //bookprice b = new bookprice();
        // insert the new row into the table
        try {
            ps1 = connection.prepareStatement("INSERT INTO flight_details(Flight_Number,Source,Destination,Flight_type) "
                    + "VALUES (?, ?, ?, ?)");
            ps1.setString(1, flightnum);
            ps1.setString(2, source);
            ps1.setString(3, destination);
            ps1.setString(4, flighttype);
            ps2 = connection.prepareStatement("INSERT INTO flight_timing(Flight_Number,Arrival,Departure) "
                    + "VALUES (?, ?, ?)");
            ps2.setString(1, flightnum);
            ps2.setString(2, arrival);
            ps2.setString(3, departure);
             
           ps1.executeUpdate();
           ps2.executeUpdate();

        } catch (SQLException se) {
            //return null;
        } 
        finally {
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closePreparedStatement(ps2);
            pool.freeConnection(connection);
        }

        // return the  User object
        //return b;
    }
 
     
      public String getFlight(String i, String j) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String item ="";
        String query = "";
        query = "SELECT "+i+" from flight_details where "+i+" = '"+j+"'";
       
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
      
      public FlightDetails getFlights(String j) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
       
        
        String flightnum = "";
        String source = "";
        String destination = "";
        String flighttype = "";
        String arrival = "";
        String departure="";
        
        FlightDetails flightd = new FlightDetails();
        
        String query1 = "";
        
       
        query1 = "SELECT fd.Flight_Number, Source , Destination , Flight_type, Arrival , Departure\n" +
        "from flight_details fd inner join flight_timing ft \n" +
        "on fd.Flight_Number = ft.Flight_Number \n" +
        "where fd.Flight_Number = '"+j+"'";
        
        try {
            // Find the speciic row in the table
            ps1 = connection.prepareStatement(query1);
            resultSet = ps1.executeQuery();
           
            
            while(resultSet.next()){
                flightnum = resultSet.getString("Flight_Number");
                source = resultSet.getString("Source");
                destination = resultSet.getString("Destination");
                flighttype = resultSet.getString("Flight_type");
                arrival = resultSet.getString("Arrival");
                departure = resultSet.getString("Departure");
              
                
                flightd = new FlightDetails(flightnum,source,destination,flighttype,arrival,departure);
                
            }
        } catch (SQLException se) {
            //System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps1);
            pool.freeConnection(connection);
        }

        return flightd;
    }
  
      
     public void updateFlightDetails(String flightnumber,String source,String destination,
             String flighttype,String arrival,String departure) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
              
        String query1 = "";
        String query2= "";
       
        query1 = "update flight_details fd join flight_timing ft on fd.Flight_Number = ft.Flight_Number set Source= ? ,Destination= ? , Flight_Type = ? , Arrival= ? ,Departure= ? "
                + "   where fd.Flight_Number = '"+flightnumber+"'";
        
        
         try {
            // Find the speciic row in the table
            ps1 = connection.prepareStatement(query1);
            //ps2 = connection.prepareStatement(query2);

            ps1.setString(1,source);
            ps1.setString(2,destination);
            ps1.setString(3,flighttype);
            
             
            ps1.setString(4,arrival);
            ps1.setString(5,departure);
            
            ps1.executeUpdate();
            //ps2.executeUpdate();
            
        } catch (SQLException se) {
            //System.out.println("ERROR: Could not execute SQL statement: " + query);
           System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps1);
            //DBUtil.closePreparedStatement(ps2);
            pool.freeConnection(connection);
        }
    }
     
     
      public void deleteFlightChild(String fno) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String query = "";
       
        query = "Delete from flight_timing where Flight_Number  = '"+fno+"'";
        
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
      
     public void deleteFlightParent(String fno) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String query = "";
       
        query = "Delete from flight_details where Flight_Number  = '"+fno+"'";
        
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
}
