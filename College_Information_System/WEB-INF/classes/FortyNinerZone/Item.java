/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FortyNinerZone;

import java.io.Serializable;
public class Item  implements  Serializable
{
   private int  itemID;
   private String itemName;
   private String itemDescription;
   private String catalogName;
   private String catalogDescription;
   private double price;
   private String imageURL;

   public Item() 
   {
       

    }
   public Item(int itemID,String itemName,String itemDescription,String catalogName,String catalogDescription,double price,String imageURL) 
   {
       this.itemID = itemID;
       this.itemName = itemName;
       this.itemDescription = itemDescription;
       this.catalogName = catalogName;
       this.catalogDescription = catalogDescription;
       this.price = price;
       this.imageURL = imageURL;
               
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
   
  

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

  
   public double getPrice()
   { 
       return price;
   }
    public void setprice(double price )
   {    
       this.price = price;
   }
   public String getImageURL()
   {
       return imageURL;
   }
   public void setImageURL(String imageURL)
   {
       this.imageURL = imageURL;
   }
   
   @Override
    public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
       return ((Item) obj).itemID == this.itemID;
    
    }
}
     
 

   