<%-- 
    Document   : des
    Created on : 3 Dec, 2014, 2:47:57 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="content">
<h2> Location Analysis Report </h2>
<p> Most preferred Location - Onward : ${a.destination_onward} </p>
<p> Most preferred Location - Return : ${b.destination_return} </p>
</div>

<%@ include file= "footer.jsp" %>