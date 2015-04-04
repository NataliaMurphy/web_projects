<%-- 
    Document   : displaycatalogitem
    Created on : 18 Sep, 2014, 5:03:43 PM
    Author     : Arj
--%>

<%@page import="java.util.ArrayList"%>"
<%@page import="java.util.List"%>"
<%@page import ="productspackage.ProductDB" %>
<%@page import ="productspackage.Product" %>
<% ProductDB pros = new ProductDB();
List itm = new ArrayList();
ArrayList<Product> pro_db = pros.getAllProducts();
for (int j = 0 ; j <  pro_db.size() ; j++ ) {
itm.add( pro_db.get(j).getProductName());
}
List category = new ArrayList();
for (int k=0; k < pro_db.size() ; k++) {
category.add( pro_db.get(k).getCatalogCategory());
}
%>
