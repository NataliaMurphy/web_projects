/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private Item product;
    private int quantity;

    public OrderItem() {
        quantity = 0;
    }

    public OrderItem(Item product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;

    }

}
