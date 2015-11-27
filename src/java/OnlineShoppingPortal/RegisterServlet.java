package OnlineShoppingPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class RegisterServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession hs = request.getSession();
            String name = request.getParameter("firstname");
            String email = request.getParameter("email");
            hs.setAttribute("email", email);

            String password = request.getParameter("password");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String mobile = request.getParameter("mobile");
            String pincode = request.getParameter("pincode");
            Class.forName("com.mysql.jdbc.Driver");
            out.println(" "+name+" "+email+" "+password+""+city+""+state+""+pincode+""+mobile) ;
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","ajay");
            Statement s = c.createStatement();
            /*PreparedStatement ps = null;
            ps.setString(1,"Ajay");
            ps.setString(2,"poshakajay@gmail.com");
            ps.setString(3,"ajay");

            ps = c.prepareStatement("insert into user values(?,?,?)");*/
            
            s.executeUpdate("insert into user(name,email,password,city,state,pincode,mobile) values('"+name+"','"+email+"','"+password+"','"+city+"','"+state+"','"+pincode+"','"+mobile+"')");
            out.println("<br> "+name+" "+email+" "+password+""+city+""+state+""+pincode+""+mobile) ;
            response.sendRedirect("WelcomeHtml.html");
            c.close();
            out.println("Good");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
