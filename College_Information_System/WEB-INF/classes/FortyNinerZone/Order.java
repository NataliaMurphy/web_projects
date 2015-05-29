/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {

    private int orderNumber;
    private Date date;
    private UserDetails user;
    private List<OrderItem> orderItem;
    private double totalCost;
    private double taxRate;
    private boolean isPaid;

    public Order() {
        orderNumber = 0;
        date = new Date();
        user = new UserDetails();
        orderItem = new ArrayList<>();
        totalCost = 0.00;
        taxRate = 0.00;
        isPaid = false;

    }

    public Order(int orderNumber, Date date, UserDetails user, List<OrderItem> orderItem, double totalCost, double taxRate, boolean isPaid) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.user = user;
        this.orderItem = orderItem;
        this.totalCost = totalCost;
        this.taxRate = taxRate;
        this.isPaid = isPaid;

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public double getTotalCost() {
        this.totalCost = 0.0;
        int orderSize = this.orderItem.size();
        for(int c = 0; c < orderSize; c++)
        {
            this.totalCost += this.orderItem.get(c).getTotal();
        }
        return this.totalCost;
    }
    
    public double getTaxAmount() {
        return (this.totalCost * this.taxRate / 100);
    }
    
    public double getTotalCostAfterTax() {
        return this.totalCost + getTaxAmount();
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public boolean IsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}
