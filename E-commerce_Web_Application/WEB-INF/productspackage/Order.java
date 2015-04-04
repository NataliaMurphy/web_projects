/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Arj
 */
public class Order implements  Serializable
{
   private int order_number;
   private String date;
   String userID;
   private float tax_rate;
   private double total_cost;
   private ArrayList<OrderItem> items;
   private boolean paid;
   private String message;
      
   public Order() 
   {
    }

    public Order(int order_number, String date, String userID, float tax_rate, double total_cost, ArrayList<OrderItem> items) {
        this.order_number = order_number;
        this.date = date;
        this.userID = userID;
        this.tax_rate = tax_rate;
        this.total_cost = total_cost;
        this.items = items;
    }
    
    public Order(int order_number,String userID,String date, double total_cost) {
        this.order_number = order_number;
        this.userID = userID;
      this.date = date;
        this.total_cost = total_cost;
        //this.paid = paid;
    }
     public Order(String userID,float tax_rate, double total_cost,String date,Boolean paid) {
        this.date = date;
        this.userID = userID;
        this.tax_rate = tax_rate;
        this.total_cost = total_cost;
        this.paid = paid;
        
    }
    public ArrayList<OrderItem> getItems(){
    return items;
    }
    public void setItems(ArrayList<OrderItem> items){
    this.items= items;
    }
    public int getOrderNumber() {
        return order_number;
    }

    public void setOrderNumber(int order_number) {
        this.order_number = order_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return userID;
    }

    public void setUser(String userID) {
        this.userID = userID;
    }

    public float getTaxRate() {
        return tax_rate;
    }

    public void setTaxRate(float tax_rate) {
        this.tax_rate = tax_rate;
    }

    public double getTotalCost() {
        return total_cost;
    }

    public void setTotalCost(double total_cost) {
        this.total_cost = total_cost;
    }
   public void setPaid(boolean paid){
   this.paid = paid;
   }
   
   public boolean isPaid() {
   return paid;
   }
   public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
