

<%@page import="appdbpackage.FlightDetails"%>
<%@include file="header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "side-navigation.jsp" %>
  <div id="content">
    
    
    <% HttpSession flight = request.getSession();
    FlightDetails b = (FlightDetails) flight.getAttribute("the_flight_list");
    %>
    <h1> UPDATE FLIGHT DETAILS </h1>
    
    <form action="update_flight_details" method="post">
    
    <input type="hidden"  class="flightnum" name ="flightnum" value="<%=b.getFLightNumber()%>">
    <h3>Source :  </h3>
    <input type="text"  class="source" name ="source" required="required" value="<%=b.getSource()%>">
    <h3>Destination :</h3>
    <input type="text"  class="destination" name ="destination" required="required"  value="<%=b.getDestination()%>">
    <h3>Flight Type :</h3>
    <input type="text"  class="flighttype" name ="flighttype" required="required" value="<%=b.getFlightType()%>">
    <h3>Arrival :</h3>
    <input type="text" name="arrival" required="required" value="<%=b.getArrival()%>">
    <h3>Departure :</h3>
    <input type="text" name="departure" required="required" value="<%=b.getDeparture()%>">
    
    <input type="submit" value="Update" class="addupdate-button">    
    <input type="reset" value="Clear" class="clear-button">
    </form>

</div>
<%@include file="footer.jsp" %> 

