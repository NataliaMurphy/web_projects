/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdbpackage;

import java.io.Serializable;

/**
 *
 * @author Premkumar
 */
public class order implements Serializable {

    public String getDeparture_forward() {
        return Departure_forward;
    }

    public void setDeparture_forward(String Departure_forward) {
        this.Departure_forward = Departure_forward;
    }

    public String getDeparture_Return() {
        return Departure_Return;
    }

    public void setDeparture_Return(String Departure_Return) {
        this.Departure_Return = Departure_Return;
    }    

    public double getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(int ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public String getFlight_num_for() {
        return flight_num_for;
    }

    public void setFlight_num_for(String flight_num_for) {
        this.flight_num_for = flight_num_for;
    }

    public String getFlight_num_return() {
        return flight_num_return;
    }

    public void setFlight_num_return(String flight_num_return) {
        this.flight_num_return = flight_num_return;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    private int orderid;
    private int ticketnumber;
    private String flight_num_for;
    private String Departure_forward;
    private String Departure_Return;
    private String flight_num_return;  
   private String from_date;
    private String to_date;
    private int passenger;
    private double total_sum;
    private Login login;
    
}
