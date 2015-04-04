<%-- 
    Document   : item
    Created on : 13 Sep, 2014, 5:48:29 PM
    Author     : Arj
--%>
<%@page import ="productspackage.ProductDB" %>
            <%@include file="header.jsp" %>
            <%@include file="user-navigation.jsp" %>
            <div class="area">
                <%@include file="site-navigation.jsp" %>
                <div id="navigation_links">
                        <a href="index.jsp">Home</a>
                    >   <a href="CatalogController?catalog_category=catalog_page">Catalog</a>
                    >   <a href="#">Items</a>
                    </div>
                <div id="main-content_items">
                    <div class="item_display">
                        <h2>
                            ${product_name}
                        </h2>
                        <p>
                           <img src=${imageURL} alt="image">
                        </p>
                        <h4>Category:-</h4>
                        <p>
                            ${catalog_category}
                        </p>
                        <h4>Price:-</h4>
                        <p>
                            ${price}
                        </p>
                        <h4>Item Description</h4>
                        <p>
                            ${description}
                        </p>
                        <!--<form action="OrderController?product_code=" method="">
                        
                            <input type="submit" class="clic" value="Add to Cart">-->
<!--                        <form>
                            <input type="button" onClick="parent.location='OrderController?theShoppingCart=${product_code}&amp;quantity=1'" class="clic" value="Add to cart">
                        </form>-->
                        
                        <form action="updateCart" method="post">
                        <input type="hidden" name ="productList" value="${product_code}" />
                        <input type="hidden" name="${product_code}" value="1"/>
                        <input class="clic" type="submit" value="Add to Cart"/>
                        </form>
                        <form>
                        <input type="button" onClick="parent.location='CatalogController?catalog_category=catalog_page'" class="clic" value="Go to catalog">
                        </form>
                    </div>
                </div> 
            </div>
            <%@include file="footer.jsp" %>
       
