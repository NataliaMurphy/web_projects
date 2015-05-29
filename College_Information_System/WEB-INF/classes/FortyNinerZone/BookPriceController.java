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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arj
 */
@WebServlet(name = "BookPriceController", urlPatterns = {"/BookPriceController"})
public class BookPriceController extends HttpServlet {
String url="";
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            UserDB olyuser = new UserDB();
            ArrayList<bookprice> book_list;
            book_list = new ArrayList<>();  
            
            HttpSession book= request.getSession();
            HttpSession book2= request.getSession();
            HttpSession utype= request.getSession();
            int u = (int)utype.getAttribute("usertype");
            final JPanel panel = new JPanel();
            
            String isbn = request.getParameter("isbn");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String subject = request.getParameter("subject");
            String year = request.getParameter("year");
           
 
            BookDB b = new BookDB();
            String search = "";
 
                String ISBN = "ISBN" ,BookTitle = "BookTitle",Author = "Author",BookSubject = "BookSubject",
                        Year= "Year", item;
                
                if((isbn.equals(b.getBook(ISBN,isbn)) && (!isbn.isEmpty()))) {                    
                    search = ISBN;
                    item = isbn;    
                    book_list = b.getBooks(search,item);
                   
                }
                else if((title.equals(b.getBook(BookTitle,title)) && (!title.isEmpty()))){
                    
                    search = BookTitle;
                    item = title;
                    book_list = b.getBooks(search,item);
                   
                }
                else if((author.equals(b.getBook(Author,author)) && (!author.isEmpty()))){
                    
                    search = Author;
                    item = author;
                    book_list = b.getBooks(search,item);
                    
                }
                else if((subject.equals(b.getBook(BookSubject,subject)) && (!subject.isEmpty()))) 
                        {
                    
                    search = BookSubject;
                    item = subject;
                    book_list = b.getBooks(search,item);
                   
                }
                else if((year.equals(b.getBook(Year,year)) && (!year.isEmpty())))
                        {
                    
                    search = Year;
                    item = year;
                    book_list = b.getBooks(search,item);
                  
                }
                else {
               
                JOptionPane.showMessageDialog(null, "NO RESULTS FOUND !!!","Message", JOptionPane.INFORMATION_MESSAGE);
                
                url="/bookprice-home.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                }
 
                 book.setAttribute("the_book_list",book_list);
                 book2.setAttribute("the_book_list2",book_list);
                 
                if( u == 0) {
                 url="/bookresult.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);   
                }
                else {
                url="/adminbookresult.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);   
                }
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
