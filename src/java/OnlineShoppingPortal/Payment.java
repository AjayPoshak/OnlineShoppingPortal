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

/**
 *
 * @author Ajay
 */
public class Payment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
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
String id = (String) hs.getAttribute("id");

Class.forName("com.mysql.jdbc.Driver");
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "ajay");
Statement s = c.createStatement();


//Design of page
out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
out.println("<head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
out.println("<title>Payment</title>");
out.println("<link rel='stylesheet' type='text/css' href='BasicPage(OSP).css'>");
out.println("<link rel='stylesheet' type='text/css' href='Navigation(OSP).css'>");
out.println("<script>");
out.println("window.history.forward(1)");
out.println("function noBack(){");
out.println("window.history.forward();}");
out.println("</script>");
out.println("<style type='text/css'>");
out.println("#table1 th");
out.println("{color:#FFFFFF;width:50%;}");
out.println("#table1 td {text-align:center;}");
out.println("#Layer22 {	position:absolute;width:384px;height:359px;z-index:3;left: 841px;top: 251px;}");
out.println("#Layer23 {	position:absolute; width:451px; height:460px; z-index:13; left:15px; top:248px;");
out.println("background-image:url(cart.jpeg);}");
out.println("#Layer24 {	position:absolute;width:261px;height:356px;z-index:14;left: 536px;top: 255px;}");


out.println("</style></head>");

out.println("<body>");
out.println("<div id='Layer1'></div>");
out.println("<div id='Layer2'></div>");
out.println("<div id='Layer4'><marquee>ONLINE SHOPPING PORTAL</marquee></div>");
out.println("<div id='Layer17'><center><strong>&copy;ONLINE SHOPPING PORTAL</strong></center><center>All Rights Reserved</center></div>");
out.println("<div id='Layer3'>");
out.println("<table width='752'>");
out.println("<th width='10%'><a href='HomeServlet'>HOME</a></th>");
out.println("<th width='208'><a href='MobileServlet'>Mobiles</a></th>");
out.println("<th width='232'><a href='ComputerServlet'>Computers</a></th>");
out.println("<th width='351'><a href='ShoesServlet'>Shoes</a></th>");
out.println("  <th width='351'><a href='Logout'>Logout</a></th>");
out.println("<th width='353'><a href='AboutUs'>ABOUT US</a></th>");
out.println("</table>");
out.println("</div><div id='Layer23'></div>");
out.println("<div id='Layer22'>");
//out.println("<table id='table1'><tr><th>Name</th><th>Price</th></tr>");*/
//Getting the checked values of cart

String valu[] = request.getParameterValues("check1");
//Delete the checked values from Cart
    if(     valu != null)
    {
        for(int i=0;i<valu.length;i++)
    {
        //out.println("Value:"+valu[i]);
    }
        for (int i = 0; i < valu.length; i++)
        {
            s.executeUpdate("delete from cart where name='"+valu[i]+"'");
        }
    }

//Dynamic Table
out.println("<table id='table1'>");
out.println("<tr><th>Name</th>");
out.println("<th>Price</th></tr>");

ResultSet rs = s.executeQuery("select name,price from cart");
    while (rs.next())
    {
        String s1 = rs.getString(1);
        out.println("<tr><td>"+s1+"</td>");
        String s2 = rs.getString(2);
        out.println("<td>"+s2+"</td></tr>");
    }

Statement s1=c.createStatement();
ResultSet rs1 = s1.executeQuery("select sum(price) from cart");
String sum=null;
while(rs1.next())
{
    sum = rs1.getString(1);
}
 out.println("<tr><th>Total</th><th colspan=2>"+sum+"</th></tr>");
out.println("</table>");
out.println("</div>");
//Retrieval of user data and displayed in form
rs = s.executeQuery("select * from user where id='"+id+"'");
String name=null,email=null,city=null,state=null,pincode=null,mobile=null;
while(rs.next())
{
    name = rs.getString(1);
    email = rs.getString(2);
    city = rs.getString(5);
    state = rs.getString(6);
    pincode = rs.getString(7);
    mobile = rs.getString(8);
}
//Display form
out.println("<div id='Layer24'>");
out.println("<form id='form1' name='form1' method='post' action='ThankYou'>");
out.println("<p>Name&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;");
out.println("<input name='name' type='text' size='20'value='"+name+"' maxlength='20' disabled='disabled'/></p>");
out.println("<p>Email Id&nbsp;&nbsp;");
out.println("<input name='email' type='text' size='25' maxlength='25' value='"+email+"' disabled='disabled'/></p>");
out.println("<p>Address&nbsp;&nbsp;&nbsp;");
out.println("<textarea name='address' cols='20' rows='3' ></textarea></p>");
out.println("<p>City&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("<input name='city' type='text' size='20' maxlength='20' value='"+city+"' /></p>");
out.println("<p>State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("<input name='state' type='text' size='20' maxlength='20' value='"+state+"'/></p>");
out.println("<p>Mobile&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("<input name='mobile' type='text' size='10' maxlength='10' value='"+mobile+"'/></p>");
out.println("<p>PinCode&nbsp;");
out.println("<input name='pincode' type='text' size='6' maxlength='6' value='"+pincode+"'/></p>");
out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("<input type='submit' name='Submit' value='Confirm' /></p>");
out.println("</form></div>");

out.println("</body></html>");

            }
        }
    catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    catch (ClassNotFoundException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

         finally {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
