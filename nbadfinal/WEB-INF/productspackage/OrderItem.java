/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;
import java.io.Serializable;

/**
 *
 * @author Arj
 */
public class OrderItem implements  Serializable 
{
   private Product product;
   int quantity;
   private double total;
   
public OrderItem()
{
}

public OrderItem(Product Prod, int Quantity) 
{
    this.product = Prod;
    this.quantity = Quantity;
}

 public Product getProduct()
   {
      return product;
   }
   public void setProduct(Product Prod)
   {    
       this.product = Prod;
   }
   public int getQuantity()
   {
      return quantity;
   }
   public void setQuantity(int Quantity)
   {    
       this.quantity = Quantity;
   }
   public double getTotal()
   {
      double total; 
      total = (product.getPrice() * quantity);
      return total;
   }
//   public void setTotal(double Total)
//   {    
//       this.total = Total;
//   }

//    void remove(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

