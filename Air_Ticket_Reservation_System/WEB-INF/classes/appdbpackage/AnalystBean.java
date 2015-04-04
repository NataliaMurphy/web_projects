/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;
import java.io.Serializable;


/**
 *
 * @author Admin
 */
public class AnalystBean implements Serializable
{

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }

    public String getDestination_onward() {
        return destination_onward;
    }

    public void setDestination_onward(String destination_onward) {
        this.destination_onward = destination_onward;
    }

    public String getDestination_return() {
        return destination_return;
    }

    public void setDestination_return(String destination_return) {
        this.destination_return = destination_return;
    }

    public String getFlight_onward() {
        return flight_onward;
    }

    public void setFlight_onward(String flight_onward) {
        this.flight_onward = flight_onward;
    }

    public String getFlight_return() {
        return flight_return;
    }

    public void setFlight_return(String flight_return) {
        this.flight_return = flight_return;
    }

    public int getPassengers_onward() {
        return passengers_onward;
    }

    public void setPassengers_onward(int passengers_onward) {
        this.passengers_onward = passengers_onward;
    }

    public int getPassengers_return() {
        return passengers_return;
    }

    public void setPassengers_return(int passengers_return) {
        this.passengers_return = passengers_return;
    }
    public AnalystBean()
    {}
    private String destination_onward;
    private String destination_return;
    private String flight_onward;
    private String flight_return;
    private int passengers_onward;
    private int passengers_return;
    private String flight_class;
           
}
