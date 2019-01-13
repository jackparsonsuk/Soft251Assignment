package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Other.Medicine;
import Other.Notification;
import Other.Appointment;
import Users.Secretary;
import java.util.ArrayList;
import Users.Patient;

public final class SecretaryPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("       \r\n");
      out.write("  ");
 
        Secretary sec = new Secretary();
        Secretary realSec = sec.getSecretary(session.getAttribute("ID").toString());
        System.out.println(realSec.getID());
        System.out.println(session.getAttribute("ID").toString());
        
        
        
      out.write("\r\n");
      out.write("        <h1>Secretary</h1>\r\n");
      out.write("        \r\n");
      out.write("        <h2> Approve a patient</h2>\r\n");
      out.write("        <form action=\"Secretary\">\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"unApproved\">\r\n");
      out.write("        ");
 
            Patient p = new Patient();
            ArrayList<Patient> pats = p.readPatient();

            for(int i = 0; i< pats.size(); i++){
                if (pats.get(i).isApproved()== false) {
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(pats.get(i).getID());
      out.write("\"> ");
      out.print( pats.get(i).getID());
      out.write(" </option>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

                
 
                    }

            }
        
        
      out.write("\r\n");
      out.write("        </select>  \r\n");
      out.write("        \r\n");
      out.write("        <input type=\"submit\" value=\"Approve\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("                <h2> Approve an Appointment</h2>\r\n");
      out.write("        <form action=\"Secretary\" >\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"unAppoinments\">\r\n");
      out.write("        ");
 
            Appointment ap = new Appointment();
                ArrayList<Appointment> apss =ap.readAppointment();
            for(int u = 0; u< apss.size(); u++){
                if (apss.get(u).getApproved()== false) {
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(apss.get(u).getAppointmentID());
      out.write("\"> ");
      out.print( apss.get(u).getDoc().getID());
      out.write("  + ");
      out.print( apss.get(u).getPat().getID());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

                
 
                    }

            }
        
        
      out.write("\r\n");
      out.write("        </select>  \r\n");
      out.write("        \r\n");
      out.write("        <input type=\"submit\" value=\"Approve\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("                <form action=\"Secretary\" >\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"wantsTermination\">\r\n");
      out.write("        ");
 
            ArrayList<Patient> ps = p.readPatient();
            for(int f = 0; f< ps.size(); f++){
                if (ps.get(f).getWantsTermination()== true) {
                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <option value=\"");
      out.print(ps.get(f).getID());
      out.write("\"> ");
      out.print( ps.get(f).getID());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

                
 
                    }

            }
        
        
      out.write("\r\n");
      out.write("        </select>  \r\n");
      out.write("        \r\n");
      out.write("        <input type=\"submit\" value=\"Remove\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <h2> Stock medicine</h2>\r\n");
      out.write("                </form>\r\n");
      out.write("                <form action=\"Secretary\" >\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"wantsTermination\">\r\n");
      out.write("        ");
 
            Medicine m = new Medicine();
            ArrayList<Medicine> meds = m.readMedicine();
            for(int g = 0; g< meds.size(); g++){

                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <option value=\"");
      out.print(meds.get(g).getMedicineID());
      out.write("\"> ");
      out.print( meds.get(g).getMedicineID());
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

                
 


            }
        
        
      out.write("\r\n");
      out.write("        </select>  \r\n");
      out.write("        \r\n");
      out.write("        <input type=\"submit\" value=\"Restock\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("            \r\n");
      out.write("            <h3>Your notifications</h3>\r\n");
      out.write("            ");


            ArrayList<String> notes = realSec.getNotis();
            
            for(int y = 0; y<notes.size(); y++){
                
            
            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <h4>");
      out.print(realSec.getNotis().get(y).toString());
      out.write("</h4>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

         
            }
            
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </body> \r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
