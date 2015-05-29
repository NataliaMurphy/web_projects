/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LokeshPC
 */
public class AdminEvent extends HttpServlet {
    HttpSession session = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminEvent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEvent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
        session = request.getSession();
        Eventdb event_obj = new Eventdb();
        ArrayList<Event> event_list = new ArrayList<Event>();
        event_list = event_obj.getAllEvent();
       UserDetails user=new UserDetails();
        user=(UserDetails)session.getAttribute("theUser");
            int userType = user.getUserType();
            String userID=user.getUserID();
            if(userType == 1)
            {
       
        out.println("<form action=\"AdminEvent\" method=\"get\">");
        if(request.getParameter("eventid")!=null)
        if (request.getParameter("eventid").equalsIgnoreCase("heading1"))
        {
            for(int i=0;i<event_list.size();i++) {
                
                out.print("<input type='radio' name = 'eventid' value="+event_list.get(i).getEventid()+" />");
               out.print("<h2> <a href=\"Controller?newsid="+event_list.get(i).getEventid()+"\">"+event_list.get(i).getEventtitle()+"</a> </h2> <br>");
               System.out.print("Inside Heading");               
            }
            
        out.println("<input type = 'submit' value='update' name='redirecting' >");
        
          out.println("<input type = 'submit' value='delete' name='redirecting' >");
          out.println("<input type = 'submit' value='add' name='redirecting' >");
          
        out.println("</form>"); 
            
            }
            }
            else
            {
                if (request.getParameter("eventid").equalsIgnoreCase("heading1"))
        {
            for(int i=0;i<event_list.size();i++) {
               out.println("<h2> <a href=\"EventController?eventid="+event_list.get(i).getEventid()+"\">"+event_list.get(i).getEventtitle()+"</a> </h2> <br>");
               System.out.print("Hi all");               
            }
            }
            }
        
        if (request.getParameter("redirecting").equalsIgnoreCase("update"))
        {
  
        for(int i=0;i<event_list.size();i++) {
            
            if(request.getParameter("eventid").equalsIgnoreCase(event_list.get(i).getEventid())) 
            {
                
                request.setAttribute("eventid",event_list.get(i).getEventid());
                request.setAttribute("eventtitle",event_list.get(i).getEventtitle());
                request.setAttribute("eventdescription",event_list.get(i).getEventdescription());
                request.setAttribute("eventfare",event_list.get(i).getEventfare());
               
                
                request.getRequestDispatcher("adminEventpage.jsp").forward(request, response);
            }
            }
        }
                
        if (request.getParameter("redirecting").equalsIgnoreCase("delete"))
        {
            String eventID = request.getParameter("eventid");
      System.out.println(eventID);
      Eventdb eventdb = new Eventdb();
      eventdb.deleteevent(eventID);
      response.sendRedirect("AdminEvent.jsp");
     ;
      
        }
        if (request.getParameter("redirecting").equalsIgnoreCase("add"))
        {
            System.out.println("inside Add");
           
            response.sendRedirect("AdminEventadd.jsp");
                  
        }
        
        
        
     
        } 
        
        finally {
            out.close();
        }
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("checkRedirect")!=null)
        if (request.getParameter("checkRedirect").equalsIgnoreCase("Update Database"))
        {
        
      String eventID = request.getParameter("eventid");
      System.out.println(eventID);
      String eventTitle = request.getParameter("eventtitle");
      System.out.println(eventTitle);
      String eventdescription = request.getParameter("eventdescription");
      System.out.println(eventdescription);
     
      String eventfare=request.getParameter("eventfare");
       System.out.println(eventfare);
      Eventdb eventdb = new Eventdb();
      eventdb.updateEvent(eventID,eventTitle,eventdescription,eventfare);
       response.sendRedirect("AdminEvent.jsp");
    
    }
     if (request.getParameter("checkRedirect").equalsIgnoreCase("Add"))
     {
        String eventID = request.getParameter("eventid");
      System.out.println(eventID);
      String eventTitle = request.getParameter("eventtitle");
      System.out.println(eventTitle);
      String eventdescription = request.getParameter("eventdescription");
      System.out.println(eventdescription);
      String eventfare=request.getParameter("eventfare");
      System.out.println(eventfare);
      Eventdb eventdb = new Eventdb();
      eventdb.addEvent(eventID,eventTitle,eventdescription,eventfare);
       response.sendRedirect("AdminEvent.jsp");
     }

}
}