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
public class OrderDetails {
    int order_id,ticket_number;
    String flight_ticket_onward,flight_ticket_return,from_date,return_date,userid;

    public OrderDetails(int order_id, int ticket_number, String flight_ticket_onward, String flight_ticket_return, String from_date, String return_date, String userid) {
        this.order_id = order_id;
        this.ticket_number = ticket_number;
        this.flight_ticket_onward = flight_ticket_onward;
        this.flight_ticket_return = flight_ticket_return;
        this.from_date = from_date;
        this.return_date = return_date;
        this.userid = userid;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public String getFlight_ticket_onward() {
        return flight_ticket_onward;
    }

    public void setFlight_ticket_onward(String flight_ticket_onward) {
        this.flight_ticket_onward = flight_ticket_onward;
    }

    public String getFlight_ticket_return() {
        return flight_ticket_return;
    }

    public void setFlight_ticket_return(String flight_ticket_return) {
        this.flight_ticket_return = flight_ticket_return;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    
}
