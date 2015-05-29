
 
package FortyNinerZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LokeshPC
 */
@WebServlet(name = "NewsController", urlPatterns = {"/NewsController"})
public class NewsController extends HttpServlet {
    HttpSession session = null;  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
        
        Newsdb news_obj = new Newsdb();
        ArrayList<News> new_list = new ArrayList<News>();
       
        new_list = news_obj.getAllNews();
        System.out.println("here");
        if (request.getParameter("newsid").equalsIgnoreCase("heading"))
        {
            String newsid = request.getParameter("newsid");
             Newsdb comment_obj = new Newsdb();
            ArrayList<Comment> comment_list = new ArrayList<Comment>();
            comment_list = comment_obj.getAllComment(newsid);
                    
            for(int i=0;i<new_list.size();i++) {
               out.println("<h2> <a href=\"NewsController?newsid="+new_list.get(i).getNewsid()+"\">"+new_list.get(i).getNewstitle()+"</a> </h2> <br>");
               System.out.print("Inside Heading");               
            }
        }
  
        for(int i=0;i<new_list.size();i++) {
            if(request.getParameter("newsid").equals(new_list.get(i).getNewsid())) 
            {
                 String newsid = request.getParameter("newsid");
                     Newsdb comment_obj = new Newsdb();
                    ArrayList<Comment> comment_list = new ArrayList<Comment>();
                     comment_list = comment_obj.getAllComment(newsid);
                session.setAttribute("newsid", request.getParameter("newsid"));
                session.setAttribute("newstitle", new_list.get(i).getNewstitle());
                session.setAttribute("description", new_list.get(i).getDescription());
                session.setAttribute("comment", comment_list);
                
                request.getRequestDispatcher("NewsPage.jsp").forward(request, response);
            }
            }
         if (request.getParameter("newsid").equalsIgnoreCase("comment")){
                Newsdb comment_obj = new Newsdb();
                ArrayList<Comment> comment_list = new ArrayList<Comment>();
                String newsId = (String)session.getAttribute("newsid");
                  comment_list = comment_obj.getAllComment(newsId);
                    for (Comment comment_list1 : comment_list) {
                     out.println(comment_list1.getComment());
                    }
             }
        }
        finally {
            out.close();
        }
       
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
       
        if(request.getParameter("header").equalsIgnoreCase("comment")){
            UserDetails user=new UserDetails();
        user=(UserDetails)session.getAttribute("theUser");
        String Username=user.getFirstName();
           
                Newsdb newsdb = new Newsdb();
                System.out.println("comment enterere"+request.getParameter("addComment"));
                int result = Newsdb.addComment(request.getParameter("addComment"),request.getParameter("newsid"),Username);
                System.out.println("Returend from add comment and status: "+result);
                    ArrayList<Comment> c = new ArrayList<Comment>();
                    c = Newsdb.getAllComment(request.getParameter("newsid")+"");
                   session.setAttribute("comments", c);
                   request.getRequestDispatcher("NewsPageSuccess.jsp").forward(request, response);
                
            }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
