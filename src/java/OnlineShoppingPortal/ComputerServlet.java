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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComputerServlet extends HttpServlet {
   
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
Class.forName("com.mysql.jdbc.Driver");
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3308/shopping", "root", "ajay");
Statement s = c.createStatement();
ResultSet rs = s.executeQuery("select id from category where name='laptops'");
String c_id=null;
while(rs.next())
{
      c_id = rs.getString(1);
}

out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
out.println("<head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
out.println("<title>Mobiles</title>");
out.println("<link rel='stylesheet' type='text/css' href='BasicPage(OSP).css'>");
out.println("<link rel='stylesheet' type='text/css' href='Navigation(OSP).css'>");
out.println("<style type='text/css'>");
out.println("#Layer2 {position:absolute;width:1351px;height:854px;z-index:2;left: 1px;top: 133px;background-color:#666699;}");
out.println("#Layer19 {position:absolute;width:296px;height:240px;z-index:3;left: 83px;top: 249px;background-image:url(Laptops/image1.jpg);}");
out.println("#Layer18 {position:absolute;width:260px;height:196px;z-index:4;left: 560px;top: 297px;background-image:url(Laptops/image3.jpg);");
out.println("background-repeat:no-repeat;}");
out.println("#Layer5 {position:absolute;width:277px;height:190px;z-index:5;left: 1056px;top: 299px;background-image:url(Laptops/image4.jpg);}");
out.println("#Layer6 {position:absolute;width:244px;height:203px;z-index:6;left: 318px;top: 671px;background-image:url(Laptops/image6.jpg);}");
out.println("#Layer7 {position:absolute;width:296px;height:184px;z-index:7;left: 775px;top: 685px;background-image:url(Laptops/image8.jpeg);");
out.println("background-Repeat:no-repeat;}");
out.println("#Layer8 {position:absolute;width:201px;height:39px;z-index:8;left: 557px;top: 514px;}");
out.println("#Layer9 {position:absolute;width:200px;height:36px;z-index:9;left: 781px;top: 906px;}");
out.println("#Layer10 {position:absolute;width:199px;height:44px;z-index:10;left: 1066px;top: 507px;}");
out.println("#Layer11 {position:absolute;width:196px;height:41px;z-index:1;left: 325px;top: 905px;}");
out.println("#Layer13 {position:absolute;width:200px;height:47px;z-index:11;left: 120px;top: 514px;}");
out.println("#Layer12 {position:absolute;width:200px;height:45px;z-index:1;left: 93px;top: 511px;}");
out.println("#Layer14 {position:absolute;width:154px;height:45px;z-index:11;left: 1319px;top: 185px;}");
out.println("</style></head><body>");
//out.println("<div id='layer4'></div>");
out.println("<div id='Layer7'></div>");
out.println("<div id='Layer6'></div>");
out.println("<div id='Layer5'></div>");

out.println("<div id='Layer4'><marquee>ONLINE SHOPPING PORTAL</marquee>");
out.println("<div id='layer3'></div></div>");

out.println("<div id='Layer19'></div>");
out.println("<div id='Layer18'></div>");
out.println("<div id='Layer17'><center><strong>&copy;ONLINE SHOPPING PORTAL</strong></center><center>All Rights Reserved</center></div>");

out.println("<div id='Layer3'><table width='752'>");
out.println("  <th width='10%'><a href='HomeServlet'>HOME</a></th>");
out.println("  <th width='208'><a href='MobileServlet'>Mobiles</th>");
out.println("  <th width='232'><a href='ComputerServlet'>Computers</a></th>");
out.println("  <th width='351'><a href='ShoesServlet'>Shoes</a></th>");
out.println("  <th width='351'><a href='Logout'>Logout</a></th>");
out.println("  <th width='353'><a href='AboutUs'>ABOUT US</a></th></table></div>");
out.println("<div id='Layer1'></div>");

out.println("<form name='form' action='HomeServlet'>");
out.println("<div id='Layer14'><input type='submit'  name='submit' value='Add to Cart' /></div>");
rs = s.executeQuery("select name,price from item where categoryid='"+c_id+"'");
int i=8;
while(rs.next())
{
    String s1 = rs.getString(1);
    String s2 = rs.getString(2);
    out.println("<br>s1="+s1+" s2="+s2);
    out.println("<div id='Layer"+i+"'><input type='checkbox' name='check' value='"+s1+"'>"+s1+"<br>Price: "+s2+"</div>");
    i++;
}

out.println("<div id='Layer11'><input type='checkbox' name='check1' value='Compaq'>Compaq<br>Price:21000</div>");
out.println("<div id='Layer8'><input type='checkbox' name='check1' value='Apple'>Apple<br>Price:91000</div>");
out.println("<div id='Layer9'><input type='checkbox' name='check1' value='Toshiba'>Toshiba<br>Price:72000</div>");
out.println("<div id='Layer13'><input type='checkbox' name='check1' value='HP'>HP<br>Price:51000</div>");
out.println("<div id='Layer10'><input type='checkbox' name='check1' value='Dell XPS'>Dell XPS<br>Price:75000</div>");
out.println("</form></body></html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComputerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComputerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
