<%-- 
    Document   : user-navigation
    Created on : 10 Nov, 2014, 9:35:37 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="navigation">
		<ul>
                    <c:choose>
                        <c:when test="${user==null}">
                            <li><a href="Login.jsp">Login</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="LoginController?action=logout">Logout</a></li>
                            <li><a href="UpdateInformation?action=orders">My Orders</a></li>
                        </c:otherwise>
                    </c:choose>
			<li><a href="search.jsp">Search Flight</a></li>
			
		</ul>
</div>
