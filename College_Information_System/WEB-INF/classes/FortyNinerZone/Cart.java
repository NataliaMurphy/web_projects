/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {

    private List<OrderItem> orderItems;
    private double totalCost;
    
    public Cart() {
        orderItems = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return orderItems;
    }

    public void addItem(Item product, int quantity) {
        boolean isOrderExists = false;
        for (int i = 0; i < orderItems.size(); i++) {
            if (orderItems.get(i).getProduct().getItemID() == (product.getItemID())) {
                orderItems.get(i).setQuantity(orderItems.get(i).getQuantity() + quantity);
                isOrderExists = true;
                break;
            }
        }

        if (!isOrderExists) {
            OrderItem item = new OrderItem(product, quantity);
            orderItems.add(item);
        }
    }

    public void removeItem(Item product) {
        for (int j = 0; j < orderItems.size(); j++) {
            if (orderItems.get(j).getProduct().getItemID() == (product.getItemID())) {
                orderItems.remove(j);
            }
        }
    }

    public void emptyCart() {
        orderItems.clear();
    }    
    
    public double getTotalCost() {
        this.totalCost = 0.0;
        int orderSize = this.orderItems.size();
        for(int c = 0; c < orderSize; c++)
        {
            this.totalCost += this.orderItems.get(c).getTotal();
        }
        return this.totalCost;
    }
}
