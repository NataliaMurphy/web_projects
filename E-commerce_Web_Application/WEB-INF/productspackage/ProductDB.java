package productspackage;

import java.util.*;
//public class ProductDB 
//
//{     public List<Product> pro = new ArrayList<>();
//      Product item1 = new Product("1XX1","Casual-shirts", "Menclothing","Android(4.4.2),5.1 inches display,432 ppi,\n" +
//"                                 Light sensor, Proximity sensor and\n" +
//"                                 Scratch-resistant glass.Quad Core processor and 32 GB in built storage.",699.0,"images/Casualshirt.jpg");
//      
//      Product item2 = new Product("1XX2","Jeans", "Menclothing","very good quality jeans available.All sorts\n" +
//"                                 of brands are present here.All kinds of styles -'Regular fit','Skinny fit',\n" +
//"                                 Slim fit jeans etc.",1200.00,"images/Jeans.jpg");
//      
//      Product item3 = new Product("1XX3","sports-wear", "Menclothing","very good quality sports wear available.All sorts\n" +
//"                                 of brands are present here.All kinds of styles -Track pants, track suits,\n" +
//"                                 Track shorts, sports t-shirts etc.",100.00,"images/Sportswear.jpg");
//      
//      Product item4 = new Product("1XX4","Mobiles", "Electronics","Very good quality and latest mobile phones available\n" +
//"                                 All kinds of brands are present here like - Motorola , samsung , apple , blackberry ,HTC ,\n" +
//"                                 Nokia , LG etc.",800.0,"images/Mobile.jpg");
//      
//      Product item5 = new Product("1XX5","Laptops", "Electronics","Excellent quality laptops are available here\n" +
//"                                 All kinds of brands are available like - Lenovo , Toshiba , LG , Compaq , Dell" +
//"                                 Sony , ASUS etc",860.00,"images/lenovo.jpg");
//      
//      Product item6 = new Product("1XX6","Televisions", "Electronics","Excellent quality televisions are available here\n" +
//"                                 All sorts of brands with 3D technology are present like - ONIDA ,Sony ,Samsung , LG ," +
//"                                 Sony Bravia , Croma etc",1200.00,"images/Television.jpg");
//      Product item7 = new Product("","", "catalog_page","",0.0,"");
//      
//      
//  
//      public ProductDB()
//      {
//      pro.add(item1);
//      pro.add(item2);
//      pro.add(item3);
//      pro.add(item4);
//      pro.add(item5);
//      pro.add(item6);
//      pro.add(item7);
//}
//      public List<Product> getProducts(){
//      return pro;
//    }    
//      
//    public Product getProduct(String productCode) {
//    
//        for(Product p: pro) {
//            if(p.getProductCode().equals(productCode)){
//            return p;
//            }
//        }
//        return null;
//    }
//}   

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class ProductDB {

    //public void createProductTable() {

        //Statement statement = DbAdmin.getNewStatement();

//        try {
//
//            statement.execute("CREATE TABLE product("
//                    + "productCode VARCHAR(40),productName VARCHAR(50),"
//                    + "catalogCategory VARCHAR(50),"
//                    + "price double,description VARCHAR(100),ImageURL VARCHAR(50),"
//                    + "PRIMARY KEY (productCode))");
//            System.out.println("Created a new table: " + "PRODUCT");
//        } catch (SQLException se) {
//            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
//                // we got the expected exception when the table is already there
//            } else {
//                // if the error code or SQLState is different, we have an unexpected exception
//                System.out.println("ERROR: Could not create PRODUCT table: " + se);
//            }
//        }
   // }

//    public Product addProduct(String productCode, String productName, String catalogCategory,
//            double price, String description, String ImageURL) {
//
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        // insert the new row into the table
//        try {
//            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
//            ps.setString(1, productCode);
//            ps.setString(2, productName);
//            ps.setString(3, catalogCategory);
//            ps.setDouble(4, price);
//            ps.setString(5, description);
//            ps.setString(6, ImageURL);
//
//            ps.executeUpdate();
//
//        } catch (SQLException se) {
//            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
//                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + productCode);
//            } else {
//                System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode + " " + se.getCause());
//            }
//            return null;
//        }finally {
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
////        catch (Exception e) {
////            System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode);
////            return null;
////        }
////        System.out.println("Added product to PRODUCT table: " + productCode);
//
//        return new Product(productCode, productName,catalogCategory,
//                 description,price, ImageURL);
//        
//    }
//
//    public Product addProduct(Product product) {
//
//        Connection connection = DbAdmin.getConnection();
//        PreparedStatement ps;
//        // insert the new row into the table
//        try {
//            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
//            ps.setString(1, product.getProductCode());
//            ps.setString(2, product.getProductName());
//            ps.setString(3, product.getCatalogCategory());
//            ps.setDouble(4, product.getPrice());
//            ps.setString(5, product.getDescription());
//            ps.setString(6, product.getImageURL());
//
//            ps.executeUpdate();
//
//        } catch (SQLException se) {
//            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
//                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + product.getProductCode());
//            } else {
//                System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode() + " " + se.getCause());
//            }
//            return null;
//        } catch (Exception e) {
//            System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode());
//            return null;
//        }
//        System.out.println("Added product to PRODUCT table: " + product.getProductCode());
//        // return the  product object
//        return product;
//    }

    public Product getProduct(String pcode) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Product product = new Product();
        product.setProductCode(pcode);
        System.out.println("product code is" + pcode);
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        String query = "select productCode,productName,catalogCategory,price,description,imageURL"
                + " from product where productCode = '" + pcode + "'";
        //Statement statement = DbAdmin.getNewStatement();
        
        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        double price = 0.0;
        String description = "";
        String imageURL = "";
        

        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
           
            while (resultSet.next()) {
                  productCode = resultSet.getString("productCode");
                  productName = resultSet.getString("productName");
                  catalogCategory = resultSet.getString("catalogCategory");
                  price = resultSet.getDouble("price");
                  description = resultSet.getString("description");
                  imageURL = resultSet.getString("imageURL");
                  product = new Product(productCode, productName, catalogCategory, description, price, imageURL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        System.out.println("product is:"+ product);
        return product;
        
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        double price = 0.0;
        String description = "";
        String ImageURL = "";
         String query= 
                    "SELECT productCode, productName, catalogCategory, price, description, imageURL  FROM product ORDER BY productCode";

        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();        
            while (resultSet.next()) {
                productCode = resultSet.getString("productCode");
                productName = resultSet.getString("productName");
                catalogCategory = resultSet.getString("catalogCategory");
                price = resultSet.getDouble("price");
                description = resultSet.getString("description");
                ImageURL = resultSet.getString("imageURL");
               

                Product product = new Product(productCode, productName, catalogCategory, description, price, ImageURL);
                products.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
                System.out.println("Found product in PRODUCT table: " + productName);
                System.out.println("Found product in PRODUCT table: " + price);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not execute SQL statement in: " + "ProductDB.getAllProducts()");
            System.out.println("ERROR: Could not execute SQL statement: " + se);
            return null;
        }finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return products;
    }
    
    
        public OrderItem addOrderItems(OrderItem itm,int onum) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        // insert the new row into the table
        try {
            
            ps = connection.prepareStatement("INSERT INTO orderitem VALUES (?, ?, ?)");
            ps.setInt(1, onum);
            ps.setString(2, itm.getProduct().getProductCode());
            ps.setInt(3, itm.getQuantity());
            ps.executeUpdate();
            

        } catch (SQLException se) {
            //System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode());
            return null;
        }finally {
            //DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        //System.out.println("Added product to PRODUCT table: " + product.getProductCode());
        // return the  product object
        return itm;
    }
        
        public Order addOrder(String user_id,float taxrate,double totalcost,String date,Boolean paid) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null;
        //Date ordate = new Date();
        
        // insert the new row into the table
        try {
            
            ps1 = connection.prepareStatement("INSERT INTO orders(UserID,TaxRate,TotalCost,Date,Paid) VALUES (?, ?, ?, ?, ?)");
           // ps1.setInt(1, ordernumber);
            ps1.setString(1, user_id);
            ps1.setFloat(2, taxrate);
            ps1.setDouble(3, totalcost);
            ps1.setString(4, date);
            ps1.setBoolean(5, paid);
            ps1.executeUpdate();       
            } 
        catch (SQLException se) {
            //System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode());
            return null;
        }finally {
            //DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps1);
            pool.freeConnection(connection);
        }
        //System.out.println("Added product to PRODUCT table: " + product.getProductCode());
        // return the  product object
        return new Order(user_id,taxrate,totalcost,date,paid);
    }
        
        public int getOrderNum() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps1 = null;
        ResultSet resultSet = null;
        int ordernumber =0;
         String query= 
                    "select OrderNumber from orders  order by OrderNumber desc limit 1;";

        try {       
             ps1 = connection.prepareStatement(query);
            resultSet = ps1.executeQuery();
            
        while (resultSet.next()) {
            ordernumber = resultSet.getInt("OrderNumber");      
            } 
        }
        catch (SQLException se) {
            //System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductCode());
            return 0;
        }finally {
            //DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(ps1);
            pool.freeConnection(connection);
        }
        //System.out.println("Added product to PRODUCT table: " + product.getProductCode());
        // return the  product object
        return ordernumber;
    }

}

