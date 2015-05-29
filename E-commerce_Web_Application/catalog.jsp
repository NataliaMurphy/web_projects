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
                    >   <a href="CatalogController?catalog_category=Menclothing">Catalog</a>
                    </div>
                <div class="main-content">
                    <div class="Category1">
                        <label>
                            ${catalog_category}
                        </label><br>
                        <ul>
                           <li>
                               <a href="CatalogController?product_code=1XX1"><%=itm.get(0)%></a>
                           </li>
                           <li>
                               <a href="CatalogController?product_code=1XX2"><%=itm.get(1)%></a>
                           </li>
                           <li>
                               <a href="CatalogController?product_code=1XX3"><%=itm.get(2)%></a>
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
       
