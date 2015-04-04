/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

/**
 *
 * @author Arj
 */
public class FlightDetails {
    String FLightNumber,Source,Destination,FlightType,Arrival,Departure;

    public FlightDetails() {}
    
    public FlightDetails(String FlightNumber, String Source, String Destination, String FlightType ,String Arrival,String Departure) {
        
        this.FLightNumber = FlightNumber;
        this.Source = Source;
        this.Destination = Destination;
        this.FlightType = FlightType;
        this.Arrival = Arrival;
        this.Departure= Departure;
    }
    
    public FlightDetails(String FLightNumber, String Source, String Destination, String FlightType) {
        this.FLightNumber = FLightNumber;
        this.Source = Source;
        this.Destination = Destination;
        this.FlightType = FlightType;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String Arrival) {
        this.Arrival = Arrival;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }

    public String getFLightNumber() {
        return FLightNumber;
    }

    public void setFLightNumber(String FLightNumber) {
        this.FLightNumber = FLightNumber;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getFlightType() {
        return FlightType;
    }

    public void setFlightType(String FlightType) {
        this.FlightType = FlightType;
    }
    
}
