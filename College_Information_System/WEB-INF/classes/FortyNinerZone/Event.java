/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.Serializable;

/**
 *
 * @author LokeshPC
 */
public class Event implements Serializable{
    String eventid;
    String eventtitle;
    String eventdescription;
    String eventfare;
    
    
public  Event (String ei,String et,String ed,String ef) 
{
    this.eventid = ei;
    this.eventtitle=et;
    this.eventdescription=ed;
    this.eventfare=ef;
   
    

}

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public String getEventfare() {
        return eventfare;
    }

    public void setEventfare(String eventfare) {
        this.eventfare = eventfare;
    }

    
}
