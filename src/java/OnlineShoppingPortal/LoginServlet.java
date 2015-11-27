package OnlineShoppingPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String user = request.getParameter("user");
            String pass = request.getParameter("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3308/shopping", "root", "ajay");
            Statement s = c.createStatement();
            RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
            ResultSet rs = s.executeQuery("select email,password from user where email='"+user+"'");
            
            while(rs.next())
            {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                if(user.equals(s1) && pass.equals(s2))
               {
                   out.println("WELCOME!");
                   HttpSession hs = request.getSession();
                   hs.setAttribute("email",s1);
                   rd.include(request, response);
                   //response.sendRedirect("HomeServlet");
               }
             else
                {
                    out.println("Invlaid user name or password");
                    out.println("<a href='WelcomeHtml.html'>Login again</a>");
                }

            }

            c.close();
            //out.println("<br>Conncetion closed");

            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
