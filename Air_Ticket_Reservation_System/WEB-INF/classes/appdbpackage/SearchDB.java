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
public class SearchDB {
    public ArrayList<Search> getSearch1(String i, String j,String k,String l) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        ArrayList<Search> s = new ArrayList<Search>();
        
        String flight_number ="";
        String source ="";
        String destination ="";
        String departure ="";
        String arrival ="";
        String flight_class ="";
        int price =0;
        Search end_user = new Search();
        String query = "";
        int available=0;
        query = "SELECT fdfp.Flight_Number,fd.Source,fd.Destination,ft.Departure,ft.Arrival,fdfp.Flight_Class,fcp.Price \n" +
"from \n" +"Flight_details_has_flight_price fdfp join Flight_Details fd on fdfp.Flight_Number=fd.Flight_Number\n" +
"join Flight_Class_Price fcp on fdfp.Flight_Class=fcp.Flight_Class\n" +
"join Flight_Timing ft on fd.Flight_Number=ft.Flight_Number\n" +
"where fd.Source='"+i+"' and fd.Destination= '"+j+"' and fdfp.Flight_Class='"+k+"'";
       
        
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
//            if (!resultSet.next()) {
//                //System.out.println("WARNING: Could not find user in USER table: " + userID);
//                return null;
//            } else {
            while(resultSet.next()){
                flight_number = resultSet.getString("Flight_Number");
                source = resultSet.getString("Source");
                destination = resultSet.getString("Destination");
                departure = resultSet.getString("departure");
                arrival = resultSet.getString("arrival");
                flight_class = resultSet.getString("flight_class");
                price = resultSet.getInt("price");
                available= checkavailability(flight_class,l, departure,flight_number);
                end_user = new Search(flight_number,source,destination,departure,arrival,flight_class,price,available);
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
 
    
       public ArrayList<Search> getSearch2(String i, String j,String k,String l) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        ArrayList<Search> s = new ArrayList<Search>();
        
        String flight_number ="";
        String source ="";
        String destination ="";
        String departure ="";
        String arrival ="";
        String flight_class ="";
        int price =0;
        int available=0;
        Search end_user = new Search();
        String query = "";
        query = "SELECT fdfp.Flight_Number,fd.Source,fd.Destination,ft.Departure,ft.Arrival,fdfp.Flight_Class,fcp.Price \n" +
"from \n" +"Flight_details_has_flight_price fdfp join Flight_Details fd on fdfp.Flight_Number=fd.Flight_Number\n" +
"join Flight_Class_Price fcp on fdfp.Flight_Class=fcp.Flight_Class\n" +
"join Flight_Timing ft on fd.Flight_Number=ft.Flight_Number\n" +
"where fd.Source='"+i+"' and fd.Destination= '"+j+"' and fdfp.Flight_Class='"+k+"'";
       
        
        try {
            // Find the speciic row in the table
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
//            if (!resultSet.next()) {
//                //System.out.println("WARNING: Could not find user in USER table: " + userID);
//                return null;
//            } else {
            while(resultSet.next()){
                flight_number = resultSet.getString("Flight_Number");
                source = resultSet.getString("Source");
                destination = resultSet.getString("Destination");
                departure = resultSet.getString("departure");
                arrival = resultSet.getString("arrival");
                flight_class = resultSet.getString("flight_class");
                price = resultSet.getInt("price");
                available= checkavailability(flight_class,l, departure,flight_number);
                end_user = new Search(flight_number,source,destination,departure,arrival,flight_class,price,available);
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
    
       public int checkavailability(String class1,String date,String dep_for,String flightnumber)
       {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        String a=date;
        int available=0;
        String query="select Total_seats from flight_class_price where Flight_Class='"+class1+"'";
        
         try {
           
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                available=resultSet.getInt("Total_seats");
               // available = resultSet.getInt(1);
                //resultSet.g
            }
         }
         catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         return available;
       }
}
