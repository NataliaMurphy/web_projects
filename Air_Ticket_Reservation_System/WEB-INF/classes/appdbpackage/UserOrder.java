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
public class UserOrder implements Serializable
{

    public String getFlight_Class() {
        return Flight_Class;
    }

    public void setFlight_Class(String Flight_Class) {
        this.Flight_Class = Flight_Class;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public int getTicket_number() {
        return Ticket_number;
    }

    public void setTicket_number(int Ticket_number) {
        this.Ticket_number = Ticket_number;
    }

    public String getFlight_Number_Onward() {
        return Flight_Number_Onward;
    }

    public void setFlight_Number_Onward(String Flight_Number_Onward) {
        this.Flight_Number_Onward = Flight_Number_Onward;
    }

    public String getFlight_Number_Return() {
        return Flight_Number_Return;
    }

    public void setFlight_Number_Return(String Flight_Number_Return) {
        this.Flight_Number_Return = Flight_Number_Return;
    }

    public String getFrom_Date() {
        return From_Date;
    }

    public void setFrom_Date(String From_Date) {
        this.From_Date = From_Date;
    }

    public String getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(String Return_Date) {
        this.Return_Date = Return_Date;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public int getPassengers() {
        return Passengers;
    }

    public void setPassengers(int Passengers) {
        this.Passengers = Passengers;
    }

    public double getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }


    public String getDeparture_Forward() {
        return Departure_Forward;
    }

    public void setDeparture_Forward(String Departure_Forward) {
        this.Departure_Forward = Departure_Forward;
    }

    public String getDeparture_Return() {
        return Departure_Return;
    }

    public void setDeparture_Return(String Departure_Return) {
        this.Departure_Return = Departure_Return;
    }
   private int Order_ID;
   private int Ticket_number;
   private String Flight_Number_Onward;
   private String Flight_Number_Return;
   private String From_Date;
   private String Return_Date;
   private String UserID;
   private int Passengers;
   private double Total_Price;
   private String Flight_Class;
   private String Departure_Forward;
   private String Departure_Return;
}
