/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;

import java.io.Serializable;
public class Product  implements  Serializable
{
   private String product_code;
   private String product_name;
   private String catalog_category;
   private String description;
   private double price;
   private String imageURL;

   public Product() 
   {
       product_code = "";
       product_name ="";
       catalog_category = "";
       description="";
       price=0.0;
       imageURL="";

    }
   public Product(String productCode,String productName,String catalogCategory,String description,double price,String imageURL) 
   {
       this.product_code = productCode;
       this.product_name = productName;
       this.catalog_category = catalogCategory;
       this.description = description;
       this.price = price;
       this.imageURL = imageURL;   
    }
   
   public String getProductCode()
   {
      return product_code;
   }
   public void setProductCode(String productCode)
   {    
       this.product_code = productCode;
   }
   public String getProductName()
   {
      return product_name;
   }
   public void setProductName(String productName)
   {    
       this.product_name = productName;
   }
   public String getCatalogCategory()
   {
       return catalog_category;
   }
   public void setCatalogCategory(String catalogCategory )
   {    
       this.catalog_category = catalogCategory;
   }
   public String getDescription()
   {
       return description;
   }
   public void setDescription(String description )
   {    
       this.description = description;
   }
   public double getPrice()
   { 
       return price;
   }
    public void setPrice(double price )
   {    
       this.price = price;
   }
   public String getImageURL()
   {
       return imageURL;
       //return String.format("images/%s.png",this.product_code);
   }
   public void setImageURL(String imageURL)
   {
       this.imageURL = imageURL;
   }

    Object getTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
     
 

   