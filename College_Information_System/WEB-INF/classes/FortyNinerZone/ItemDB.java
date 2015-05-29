/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

/**
 *
 * @author priyanka
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDB {

           


    public Item getProduct(int pcode) {

        Item item = new Item();
        item.setItemID(pcode);
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            ps = connection.prepareStatement("SELECT itemID,itemName,itemDescription,catalogName,catalogDescription,itemprice,imageURL from ITEM where itemID =?");
            ps.setInt(1,pcode);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                item.setItemName(resultSet.getString("itemName"));
                item.setItemDescription(resultSet.getString("itemDescription"));
                item.setCatalogName(resultSet.getString("catalogName"));
                item.setCatalogDescription(resultSet.getString("catalogDescription"));
                item.setprice(resultSet.getDouble("itemprice"));
                item.setImageURL(resultSet.getString("imageURL"));
                
            }
            return item;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public ArrayList<Item> getAllProducts() {
        ArrayList<Item> items = new ArrayList<Item>();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        int itemID = 0;
        String itemName = "";
        String itemDescription= "";
        String catalogName = "";
        String catalogDescription = "";
        double price = 0.00;
        String imageURL = "";
        

        try {
            ps = connection.prepareStatement("SELECT itemID,itemName,itemDescription,catalogName,catalogDescription,itemprice, imageURL from ITEM order by itemID");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                itemID = resultSet.getInt("itemID");
                itemName = resultSet.getString("itemName");
                itemDescription = resultSet.getString("itemDescription");
                catalogName = resultSet.getString("catalogName");
                catalogDescription = resultSet.getString("catalogDescription");
                price = resultSet.getDouble("itemprice");
                imageURL = resultSet.getString("imageURL");
                

                Item item = new Item(itemID, itemName, itemDescription, catalogName,catalogDescription,price,imageURL);
                items.add(item);
                System.out.println("Found product in Item table: " + itemID);
            }
            return items;
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ItemDB.getAllProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }


        
    }

    void deleteCatalog(String catname) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result;
         String query="delete from item where CatalogName=?";
         
        try {
            ps=connection.prepareStatement(query);
            ps.setString(1, catname);
             result=ps.executeUpdate();
             System.out.println("Deleted successfully:"+ catname);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.deleteCatalog()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        
    }

    void updateCatalog(String catname1, String catdesc1, String catold) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result;
        String query= "UPDATE item set catalogname=?, catalogdescription=? where catalogname=?";
      try
      {
        ps=connection.prepareStatement(query);
        ps.setString(1, catname1);
        ps.setString(2, catdesc1);
        ps.setString(3, catold);
        result=ps.executeUpdate();
        System.out.println("Updated catalog detail for item table: " + catold);
        
      }
      catch(Exception e)
      {
         System.out.println("ERROR: Could not execute SQL statement in: " + "itemDB.updateCatalog()");
         System.out.println("ERROR: Could not execute SQL statement: " + e); 
      }finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    void deleteItem(int itemidval) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result;
         String query="delete from item where itemid=?";
         
        try {
            ps=connection.prepareStatement(query);
            ps.setInt(1, itemidval);
             result=ps.executeUpdate();
             System.out.println("Deleted successfully:"+ itemidval);
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ItemDB.deleteItem()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            //return 0;
        } finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        
    }

    void updateItem(int itemID, String itemName, String itemDesc, double price, String imageURL) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int result;
        String query= "UPDATE item set itemname=?, itemdescription=?, itemprice=?, imageURL=? where itemID=?";
      try
      {
        ps=connection.prepareStatement(query);
        ps.setString(1, itemName);
        ps.setString(2, itemDesc);
        ps.setDouble(3, price);
        ps.setString(4, imageURL);
        ps.setInt(5, itemID);
        result=ps.executeUpdate();
        System.out.println("Updated item details in item table: " + itemID);
        
      }
      catch(Exception e)
      {
         System.out.println("ERROR: Could not execute SQL statement in: " + "itemDB.updateItem()");
         System.out.println("ERROR: Could not execute SQL statement: " + e); 
      }finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    void addItem(int itemID, String name, String desc, String catName, String catDesc, double price, String imageurl) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query= "INSERT into item (ItemID, ItemName, ItemDescription, CatalogName, catalogDescription, ItemPrice, ImageURL)"
                + "Values(?, ?, ?, ?, ?, ?, ?)";
         try
      {
        ps=connection.prepareStatement(query);
        ps.setInt(1, itemID);
        ps.setString(2, name);
        ps.setString(3, desc);
        ps.setString(4, catName);
        ps.setString(5, catDesc);
        ps.setDouble(6, price);
        ps.setString(7, imageurl);
        int result=ps.executeUpdate();
        System.out.println("Add item in item table: " + itemID);
        
      }
      catch(Exception e)
      {
         System.out.println("ERROR: Could not execute SQL statement in: " + "itemDB.addItem()");
         System.out.println("ERROR: Could not execute SQL statement: " + e); 
      }finally {
            
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
}




