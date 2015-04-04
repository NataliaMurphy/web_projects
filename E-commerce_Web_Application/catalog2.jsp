<%-- 
    Document   : catalog
    Created on : 13 Sep, 2014, 5:46:23 PM
    Author     : Arj
--%>
<%@include file="displaycatalogitem.jsp" %>
            <%@include file="header.jsp" %>
            <%@include file="user-navigation.jsp" %>
            <div class="area">
                <%@include file="site-navigation.jsp" %>
                <div id="navigation_links">
                        <a href="index.jsp">Home</a>
                    >   <a href="CatalogController?catalog_category=Electronics">Catalog</a>
                    </div>
                <div class="main-content">
                    <div class="Category2">
                        <label>
                            ${catalog_category}
                        </label><br>
                        <ul>
                           <li>
                               <a href="CatalogController?product_code=1XX4"><%=itm.get(3)%></a>
                           </li>
                           <li>
                               <a href="CatalogController?product_code=1XX5"><%=itm.get(4)%></a>
                           </li>
                           <li>
                               <a href="CatalogController?product_code=1XX6"><%=itm.get(5)%></a>
                           </li>
                        </ul>
                    </div>
                </div>
                <div class="ads">
                    <img src="images/ad-5.png" alt="ad-img"><a href="#"></a><br>
                    <img src="images/ad-6.png" alt="ad-img"><a href="#"></a><br>
                    <img src="images/ad-7.png" alt="ad-img"><a href="#"></a><br>
                    <img src="images/ad-8.png" alt="ad-img"><a href="#"></a>
                </div>
            </div>
            <%@include file="footer.jsp" %>
       
