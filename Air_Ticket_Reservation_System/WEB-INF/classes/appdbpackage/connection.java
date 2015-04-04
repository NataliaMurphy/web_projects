package appdbpackage;

import appdbpackage.Login;
/**
 *
 * @author Admin
 */

import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class connection 
{
    
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
       public AnalystBean Seasonal_Onward() 
      {
        AnalystBean a=new AnalystBean();
        String query= "SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Onward=f.Flight_Number group by  f.Destination order by count(fc.Flight_Number_Onward) desc limit 1";
       // String query1="SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Return=f.Flight_Number group by f.Destination order by count(fc.Flight_Number_Return) desc limit 1;";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        ResultSet rs=null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                
                a.setDestination_onward(resultSet.getString("f.Destination"));
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return a;
    }
      
        public AnalystBean Seasonal_Return() 
      {
        AnalystBean a=new AnalystBean();
        //String query= "SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Onward=f.Flight_Number group by  f.Destination order by count(fc.Flight_Number_Onward) desc limit 1";
        String query="SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Return=f.Flight_Number group by f.Destination order by count(fc.Flight_Number_Return) desc limit 1;";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        ResultSet rs=null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                
                a.setDestination_return(resultSet.getString("f.Destination"));
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return a;
    }
        
      
       
        public AnalystBean Flight_Class() 
      {
        AnalystBean a=new AnalystBean();
        //String query= "SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Onward=f.Flight_Number group by  f.Destination order by count(fc.Flight_Number_Onward) desc limit 1";
        String query="select class from order_details group by class order by count(class) desc limit 1";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        ResultSet rs=null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                a.setFlight_class(resultSet.getString("class"));
               
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return a;
    }
        public AnalystBean Onward_flight() 
      {
        AnalystBean a=new AnalystBean();
        //String query= "SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Onward=f.Flight_Number group by  f.Destination order by count(fc.Flight_Number_Onward) desc limit 1";
        String query="select Flight_Number_Onward from order_details group by  Flight_Number_Onward order by count(Flight_Number_Onward) desc limit 1";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        ResultSet rs=null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                a.setFlight_onward(resultSet.getString("Flight_Number_Onward"));
               
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return a;
    }
         public AnalystBean Return_flight() 
      {
        AnalystBean a=new AnalystBean();
        //String query= "SELECT f.Destination from order_details fc join flight_details f where fc.Flight_Number_Onward=f.Flight_Number group by  f.Destination order by count(fc.Flight_Number_Onward) desc limit 1";
        String query="select Flight_Number_Return from order_details group by  Flight_Number_Return order by count(Flight_Number_Return) desc limit 1";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
        ResultSet rs=null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                a.setFlight_return(resultSet.getString("Flight_Number_Return"));
               
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return a;
    }
        
      public ArrayList<UserOrder> Orders(String userid) 
      {
        ArrayList<UserOrder> array =new ArrayList<UserOrder>();
        
        String query="select Order_ID,Ticket_number,Flight_Number_Onward,Flight_Number_Return,From_Date,Return_Date,UserID,Passengers,Total_Price,Class,Departure_Forward,Departure_Return from order_details where UserID='"+userid+"'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
       
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                UserOrder o=new UserOrder();
                o.setOrder_ID(resultSet.getInt("Order_ID"));
                o.setTicket_number(resultSet.getInt("Ticket_number"));
                o.setFlight_Number_Onward(resultSet.getString("Flight_Number_Onward"));
                o.setFlight_Number_Return(resultSet.getString("Flight_Number_Return"));
                o.setFrom_Date(resultSet.getString("From_Date"));
                o.setReturn_Date(resultSet.getString("Return_Date"));
                o.setUserID(resultSet.getString("UserID"));
                o.setPassengers(resultSet.getInt("Passengers"));
                o.setTotal_Price(resultSet.getDouble("Total_Price"));
                o.setFlight_Class(resultSet.getString("Class"));
                o.setDeparture_Forward(resultSet.getString("Departure_Forward"));
                o.setDeparture_Return(resultSet.getString("Departure_Return"));
               
                array.add(o);
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return array;
    }
        
      
       public ArrayList<UserOrder> AllOrders() 
      {
        ArrayList<UserOrder> array =new ArrayList<UserOrder>();
        
        String query="select Order_ID,Ticket_number,Flight_Number_Onward,Flight_Number_Return,From_Date,Return_Date,UserID,Passengers,Total_Price,Class,Departure_Forward,Departure_Return from order_details";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;
       
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
           // rs=statement.executeQuery(query1);
            while (resultSet.next())
            {
                UserOrder o=new UserOrder();
                o.setOrder_ID(resultSet.getInt("Order_ID"));
                o.setTicket_number(resultSet.getInt("Ticket_number"));
                o.setFlight_Number_Onward(resultSet.getString("Flight_Number_Onward"));
                o.setFlight_Number_Return(resultSet.getString("Flight_Number_Return"));
                o.setFrom_Date(resultSet.getString("From_Date"));
                o.setReturn_Date(resultSet.getString("Return_Date"));
                o.setUserID(resultSet.getString("UserID"));
                o.setPassengers(resultSet.getInt("Passengers"));
                o.setTotal_Price(resultSet.getDouble("Total_Price"));
                o.setFlight_Class(resultSet.getString("Class"));
                o.setDeparture_Forward(resultSet.getString("Departure_Forward"));
                o.setDeparture_Return(resultSet.getString("Departure_Return"));
               
                array.add(o);
               
            }
           

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return array;
    }
      public int DeleteOrder(int ordernumber)
      {
        
        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps=null;
        int result;
       
        String query= "delete from order_details where Order_ID='"+ ordernumber+"'";
       
      try
      {
        ps = connection.prepareStatement(query);
        //ps=connection.prepareStatement(query);
        //ps.setInt(1, ordernumber);
            
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
      
      
}
