package OnlineShoppingPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ajay
 */
public class ThankYou extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
HttpSession hs = request.getSession(false);
if(hs == null)
{
    out.println("<br><br><br><center><a href='WelcomeHtml.html'><Strong>First Login Here</strong></center>");
}
 else
{
//Getting the updated values from user
String city = request.getParameter("city");
String state = request.getParameter("state");
String mobile = request.getParameter("mobile");
String pincode = request.getParameter("pincode");
String address = request.getParameter("address");
//Getting id of user from Session
String id = (String) hs.getAttribute("id");
//out.println("<br>id="+id);
Class.forName("com.mysql.jdbc.Driver");
//out.println("<br>"+city+""+state+""+pincode+""+mobile) ;
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","ajay");
Statement s = c.createStatement();
s.executeUpdate("update user set city='"+city+"',state='"+state+"',pincode='"+pincode+"',mobile='"+mobile+"',address='"+address+"' where id ='"+id+"'");
//out.println("<br> "+city+""+state+""+pincode+""+mobile) ;
//Design of the Page
out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
out.println("<head>");
out.println("<link rel='stylesheet' type='text/css' href='BasicPage(OSP).css'>");
out.println("<link rel='stylesheet' type='text/css' href='Navigation(OSP).css'>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");

out.println("<title>Thank You</title>");
out.println("<script>");
out.println("window.history.forward(1)");
out.println("function noBack(){");
out.println("window.history.forward();}");
out.println("</script>");
out.println("<style type='text/css'>");
out.println("#Layer26 {	position:absolute;width:617px;height:272px;z-index:13;left: 310px;top: 235px;");
out.println("background-color:#0066CC;color:#FFFFFF;text-align:center;font-size:24px;");
out.println("font-family:Georgia, 'Times New Roman', Times, serif;}");

out.println("</style></head><body onload='noBack();' onunload=''>");
out.println("<div id='Layer1'></div>");
out.println("<div id='Layer2'></div>");
out.println("<div id='Layer4'><marquee>ONLINE SHOPPING PORTAL</marquee></div>");
out.println("<div id='Layer17'><center><strong>&copy;ONLINE SHOPPING PORTAL</strong></center><center>All Rights Reserved</center></div>");
out.println("<div id='Layer23'></div>");
out.println("<div id='Layer3'>");
out.println("<table width='752'>");
out.println("  <th width='10%'><a href='HomeServlet'>HOME</a></th>");
out.println("  <th width='208'><a href='MobileServlet'>Mobiles</a></th>");
out.println("  <th width='232'><a href='ComputerServlet'>Computers</a></th>");
out.println("  <th width='351'><a href='ShoesServlet'>Shoes</a></th>");
out.println("  <th width='351'><a href='Logout'>Logout</a></th>");
out.println("  <th width='353'><a href='AboutUs'>ABOUT US</a></th>");
out.println("  </table></div>");

out.println("<div id='Layer26'><br><br><br>Thank You for Using our Services.<br>Your Order will be shipped within 5-6 working days.</div>");
out.println("</body></html>");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ThankYou.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThankYou.class.getName()).log(Level.SEVERE, null, ex);
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
