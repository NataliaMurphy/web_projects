/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdbpackage;

import java.io.Serializable;

/**
 *
 * @author Arj
 */
public class Search implements Serializable {

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }
        String flight_number,source,destination,departure,arrival,flight_class;
        int price,available_seats;

    public Search(String flight_number, String source, String destination, String departure, String arrival, String flight_class, int price,int available_seats) {
        this.flight_number = flight_number;
        this.source = source;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.flight_class = flight_class;
        this.price = price;
        this.available_seats= available_seats;

    }

    public Search() {
        
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
        
}
