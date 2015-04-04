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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Premkumar
 */
public class OrderDB {
    
    public void insertorder(order Order,Search search)
    {       
     ConnectionPool pool = ConnectionPool.getInstance();
              Connection connection = pool.getConnection();
        String query="INSERT into order_details(Flight_Number_Onward,Departure_Forward,Flight_Number_Return,"
                + "Departure_Return,From_Date,Return_Date,passengers,Total_Price,Class,UserID,Ticket_number) "
                + "values(?,?,?,?,?,?,?,?,?,?,last_insert_id()+3000);";       
        PreparedStatement ps;
       // insert the new row into the table
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Order.getFlight_num_for());
            ps.setString(2, Order.getDeparture_forward());
            ps.setString(3, Order.getFlight_num_return());
            ps.setString(4, Order.getDeparture_Return());
            ps.setString(5, Order.getFrom_date());
            ps.setString(6, Order.getTo_date());
            ps.setInt(7, Order.getPassenger());
            ps.setDouble(8,Order.getTotal_sum());
            ps.setString(9,search.getFlight_class());
            ps.setString(10,Order.getLogin().getUserID() );
            
            ps.executeUpdate();          

        } 
        
         catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " +Order.getLogin().getUserID() );
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + Order.getLogin().getUserID() + " " + se.getCause());
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + Order.getLogin().getUserID());
            
        }
        System.out.println("Added product to PRODUCT table: " + Order.getLogin().getUserID());
        
      
    }
    public Search selecttime(String flightnum)
    {
    ConnectionPool pool = ConnectionPool.getInstance();
              Connection connection = pool.getConnection();
        String query="select Arrival,Departure from flight_timing where Flight_Number='"+flightnum+"';";       
        PreparedStatement ps;
        Search search=new Search();
        ResultSet resultset=null;
       // insert the new row into the table
        try {
            ps = connection.prepareStatement(query);
            resultset=ps.executeQuery();
             while (resultset.next())
             {
                 search.setDeparture(resultset.getString("Departure"));
                 search.setArrival(resultset.getString("Arrival"));
                 
             }     

        }          
        catch (SQLException se) 
        {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
        }
        return search;
    }
    public int selectprice(String flightclass)
    {
    ConnectionPool pool = ConnectionPool.getInstance();
              Connection connection = pool.getConnection();
        String query="select Price from flight_class_price where Flight_Class='"+flightclass+"';";       
        PreparedStatement ps;
        Search search=new Search();
        ResultSet resultset=null;
        int price=0;
       // insert the new row into the table
        try {
            ps = connection.prepareStatement(query);
            resultset=ps.executeQuery();
             while (resultset.next())
             {
                 price=resultset.getInt("Price");         
                 
             }     

        }          
        catch (SQLException se) 
        {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
        }
        return price;
    }
    }    
