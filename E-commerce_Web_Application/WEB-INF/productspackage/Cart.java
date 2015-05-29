/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arj
 */
public class Cart implements  Serializable {
    
    final ArrayList<OrderItem> items;
    
    public Cart(){
    items = new ArrayList<OrderItem>();
    }
    
    public ArrayList<OrderItem> getItems() {
    return items;
    }
    
    public void addItem(OrderItem item){
    String code = item.getProduct().getProductCode();
    int quantity = item.getQuantity();
    for ( int i=0; i < items.size(); i++) {
    OrderItem orderitem = items.get(i);
    if(orderitem.getProduct().getProductCode().equals(code)) {
      orderitem.setQuantity(quantity);
      return;
     }
    }
    items.add(item);
    }
      
    public void removeItem(OrderItem item) {
    String code = item.getProduct().getProductCode();
    for ( int i=0; i < items.size(); i++) {
    OrderItem orderitem = items.get(i);
    if(orderitem.getProduct().getProductCode().equals(code)) {
      items.remove(i);
      return;
    }
    }
    }
    
    public void emptyCart() {
    items.removeAll(items);
    }
}
