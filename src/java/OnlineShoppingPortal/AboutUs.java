package OnlineShoppingPortal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ajay
 */
public class AboutUs extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
out.println("<head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
out.println("<title>About Us</title>");
out.println("<link rel='stylesheet' type='text/css' href='BasicPage(OSP).css'>");
out.println("<link rel='stylesheet' type='text/css' href='Navigation(OSP).css'>");
out.println("<style type='text/css'>");

out.println("#Layer5 {position:absolute;width:304px;height:396px;z-index:13;left: 963px;top: 188px;");
out.println("background-image:url(20130609_193833.jpg);}");
out.println("#Layer6 {position:absolute;width:901px;height:328px;z-index:14;left: 6px;top: 218px;");
out.println("background-color:#0066CC;color:#FFFFFF;font-size:24px;font-family:Georgia, 'Times New Roman', Times, serif;}");
out.println("</style></head>");
out.println("<body>");
out.println("<div id='Layer1'></div>");
out.println("<div id='Layer2'></div>");
out.println("<div id='Layer4'><marquee>ONLINE SHOPPING PORTAL</marquee></div>");
out.println("<div id='Layer17'></div>");
out.println("<div id='Layer3'>");
out.println("<table width='752'>");
out.println("  <th width='10%'><a href='HomeServlet'>HOME</a></th>");
out.println("  <th width='208'><a href='MobileServlet'>Mobiles</th>");
out.println("  <th width='232'><a href='ComputerServlet'>Computers</a></th>");
out.println("  <th width='351'><a href='ShoesServlet'>Shoes</a></th>");
out.println("  <th width='351'><a href='Logout'>Logout</a></th>");
out.println("  <th width='353'><a href='AboutUs'>ABOUT US</a></th>");
out.println("  </table></div>");
out.println("<div id='Layer5'></div>");
out.println("<div id='Layer6'>");
out.println("  <h2>Ajay Poshak</h2><hr size='7px' color='#FFFFFF' >");
out.println("<br>I am an student of B.Tech. III Yr. with specialization in Information Technology in<br>");
out.println("Govt. Engineering College Ajmer.<br>I made this website");
out.println("as a project assignment during my Summer Training Course from HP <br>");
out.println("under the guidance of our trainers <br>Shri Abhinav Mishra and Shri Gaurav Kukreti.");
out.println("</div></body></html>");

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
