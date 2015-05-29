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
 * @author LokeshPC
 */
public class Eventdb {
    ArrayList<Event> eventlist = new ArrayList<Event>();
    public Eventdb(){
    
}


public ArrayList<Event> getAllEvent() {
    
        ArrayList<Event> event_list = new ArrayList<Event>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String eventid = "";
        String eventtitle = "";
        String eventdescription = "";
        String eventfare = "";
       
         String query= 
                    "SELECT * FROM eventdb";

        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();        
            while (resultSet.next()) {
                eventid = resultSet.getString("eventid");
                eventtitle = resultSet.getString("eventtitle");
                eventdescription = resultSet.getString("eventdescription");
                eventfare = resultSet.getString("eventfare");
                
               

                Event eventobj = new Event(eventid, eventtitle, eventdescription, eventfare);
                event_list.add(eventobj);

            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "EventDB.getAllEvent()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        }

        return event_list;
    }

    void deleteevent(String eventID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String eventid = eventID;
 
        
         String query="delete from eventdb Where EventID = \'"+eventid+"\'";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.executeUpdate(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getdeleteEvent()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
 }
    }

    void updateEvent(String eventID, String eventTitle, String eventdescription,String eventfare) {
 ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String eventid = eventID;
        String eventTitle1 = eventTitle;
        String eventdescription1 = eventdescription;
        String eventfare1= eventfare;
        
         String query="update eventdb set EventTitle= \'"+eventTitle1+"\' , eventdescription= \'"+eventdescription1+"\',eventfare= \'"+eventfare1+"\' Where EventID = \'"+eventid+"\'";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.executeUpdate(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "NewsDB.getupdateEvent()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
                   
    }
    }
    void addEvent(String eventID, String eventTitle, String eventdescription,String eventfare) {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
    
        PreparedStatement ps = null;

        String eventid = eventID;
        String eventTitle1 = eventTitle;
        String eventdescription1 = eventdescription;
        String eventfare1=eventfare;
        
         String query="INSERT INTO eventdb (EventID,EventTitle,eventdescription,eventfare)VALUES ('"+eventid+"','"+eventTitle1+"','"+eventdescription1+"','"+eventfare1+"');";
         
        try {
            ps = connection.prepareStatement(query);
           
            System.out.println(query);
              ps.execute(query);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in:");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
            
 }
    
  }
       
    
}
