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

public class HomeServlet extends HttpServlet {
   
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
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "ajay");
Statement s = c.createStatement();
//Getting email from session and retrieving its id from database.
String email = (String) hs.getAttribute("email");
out.println("Email in HomeServlet:"+email);
ResultSet rs = s.executeQuery("select id from user where email='"+email+"'");
String id = "1";
while(rs.next())
{
     id = rs.getString(1);
     //id = Integer.parseInt(sid);
}
//Set the user id as attribute of session

hs.setAttribute("id", id);



out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
out.println("<head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
out.println("<title>HOME PAGE</title>");
out.println("<link rel='stylesheet' type='text/css' href='BasicPage(OSP).css'>");
out.println("<link rel='stylesheet' type='text/css' href='Navigation(OSP).css'>");
out.println("<script type='text/javascript'>");
out.println("window.history.forward(1)");
out.println("function noBack(){");
out.println("window.history.forward();}");
//out.println("<script type='text/javascript'>");
out.println("var image1=new Image()");
out.println("image1.src='images/first.jpg'");
out.println("var image2=new Image()");
out.println("image2.src='images/second.jpg'");
out.println("var image3=new Image()");
out.println("image3.src='images/third.jpg'");
out.println("var image4=new Image()");
out.println("image4.src='images/fourth.jpg'");
out.println("var image5=new Image()");
out.println("image5.src='images/fifth.jpg'");
out.println("var image6=new Image()");
out.println("image6.src='images/six.jpg'");
out.println("</script>");

out.println("<style type='text/css'>");
out.println("#Layer5 {position:absolute;width:785px;height:315px;z-index:2;left: 232px;");
out.println("top: 207px;background-image:url(image-01.jpg);");
out.println("}#Layer6 {	position:absolute;width:200px;height:224px;z-index:3;left: 46px;top: 579px;");
out.println("background-image:url(image-05.jpg)}");
out.println("#Layer7 {position:absolute;width:232px;height:226px;z-index:4;left: 377px;top: 576px;");
out.println("background-image:url(image-04.jpg)}");
out.println("#Layer8 {position:absolute;width:203px;height:256px;z-index:5;left: 740px;top: 575px;");
out.println("background-image:url(image-02.jpeg)}");
out.println("#Layer9 {position:absolute;width:236px;height:247px;z-index:6;left: 1026px;top: 579px;");
out.println("background-image:url(image-06.jpeg)}");
out.println("</style></head>");

out.println("<body onload='noBack();' onunload=''>");
//out.println("<div id='Layer5'><a href='MobileServlet'></a></div>");
out.println("<div id='Layer17'><center><strong>&copy;ONLINE SHOPPING PORTAL</strong></center><center>All Rights Reserved</center></div>");
out.println("<div id='Layer1'></div>");
out.println("<div id='Layer4'><marquee>ONLINE SHOPPING PORTAL</marquee></div>");


out.println("  <div id='Layer3'>");
out.println("  <table width='752'>");
out.println("  <th width='10%'><a href='HomeServlet'>HOME</a></th>");
out.println("<th width='208'><a href='MobileServlet'>Mobiles</a></th>");
out.println("  <th width='232'><a href='ComputerServlet'>Computers</a></th>");
out.println("  <th width='351'><a href='ShoesServlet'>Shoes</a></th>");
out.println("  <th width='351'><a href='CartServlet'>Cart</a></th>");
out.println("  <th width='351'><a href='Logout'>Logout</a></th>");
out.println("  <th width='353'><a href='AboutUs'>ABOUT US</a></th>");
out.println("  </table>");
out.println("  </div>");


out.println("<a href='MobileServlet'><div id='Layer6'></div></a>");
out.println("<a href='MobileServlet'><div id='Layer7'></div></a>");
out.println("<a href='ShoesServlet'><div id='Layer8'></div></a>");
out.println("<a href='ComputerServlet'><div id='Layer9'></div></a>");
out.println("<a href='#'><br><br><br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
out.println("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/first.jpg' name='slide' width=900 height=300></a></td>");
out.println("<script type='text/javascript'>");

   //variable that will increment through the images
out.println("var step=1");
out.println("function slideit(){");
out.println("document.images.slide.src=eval('image'+step+'.src')");
out.println("if (step<7)");
out.println("step++");
out.println("else");
out.println("step=1");
	//call function 'slideit()' every 4 seconds
out.println("setTimeout('slideit()',6000)   }");
out.println("slideit()");
out.println("</script></body></html>");

out.println("<a href='MobileServlet'>Mobile</a>");
out.println("<a href='ComputerServlet'>Computer</a>");
out.println("<a href='ShoesServlet'>Shoes</a>");
String val[] = request.getParameterValues("check");
if(val != null)
{
    for(int i=0;i<val.length;i++)
    {
        out.println("value:"+val[i]);
    }
 }
//Retrieve the id and price of each selected item and then insert them into cart
int i=0;

if(val != null)
{
    while (i < val.length)
    {
        String s1 = null,s2 = null;
        rs = s.executeQuery("select price from item where name='"+val[i]+"'");
        while(rs.next())
        {
                s1 = rs.getString(1);
        }
        s.executeUpdate("insert into cart values('"+val[i]+"','"+id+"','"+s1+"')");
        i++;
     }
    
}

String value[] = request.getParameterValues("check1");
if(value != null)
{
    for(i=0;i<value.length;i++)
    {
        //out.println("value:"+value[i]);
    }
}
//Retrieve the id and price of each selected item and then insert them into cart
i=0;
rs = null;
if(value != null)
{
    while (i < value.length)
    {
        String s1 = null,s2 = null;
        rs = s.executeQuery("select price from item where name='"+value[i]+"'");
        while(rs.next())
        {
                s1 = rs.getString(1);
        }
        s.executeUpdate("insert into cart values('"+value[i]+"','"+id+"','"+s1+"')");
        i++;
      }
}
String value1[] = request.getParameterValues("check2");
if(value1 != null)
{
    for(i=0;i<value1.length;i++)
    {
        //out.println("value:"+value1[i]);
    }
 }
//Retrieve the id and price of each selected item and then insert them into cart
i=0;
if(value1 != null)
{
    while (i < value1.length)
    {
        String s1 = null,s2 = null;
        rs = s.executeQuery("select price from item where name='"+value1[i]+"'");
        while(rs.next())
        {
                s1 = rs.getString(1);
         }
        s.executeUpdate("insert into cart values('"+value1[i]+"','"+id+"','"+s1+"')");
        i++;
     }
}
c.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
