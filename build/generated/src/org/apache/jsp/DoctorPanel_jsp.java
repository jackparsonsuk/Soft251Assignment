package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Users.Doctor;
import Other.Appointment;
import java.util.ArrayList;

public final class DoctorPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Doctor</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Doctor</h1>\n");
      out.write("\n");
      out.write("        ");
 
        Doctor doc = new Doctor();
        Doctor realDoc = doc.getDoctor(session.getAttribute("ID").toString());
        
        
        
        
      out.write("\n");
      out.write("        Welcome ");
      out.print(realDoc.getID());
      out.write("<br>\n");
      out.write("        Current Rating: ");
      out.print(realDoc.getRating() );
      out.write("<br>\n");
      out.write("        Comments:");
      out.print(realDoc.getFeedback().get(0) );
      out.write("\n");
      out.write("\n");
      out.write("        <h2>Upcomming appointments</h2>\n");
      out.write("\n");
      out.write("        ");

            Appointment ap = new Appointment();
            ArrayList<Appointment> aps = ap.readAppointment();
            for(int i = 0; i < aps.size(); i++){
                if (ap.getAppointment(aps.get(i).getAppointmentID()).getDoc().getID().equals(session.getAttribute("ID"))) {
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        ");
      out.print(aps.get(i).getApproved());
      out.write("\n");
      out.write("                        ");
      out.print(aps.get(i).getPat().getID());
      out.write("<br>\n");
      out.write("                       \n");
      out.write("                                \n");
      out.write("                        \n");
      out.write("                        ");

                    }
            
            }
         
        
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"DoctorServlet\">\n");
      out.write("            <select name=\"SelectedAp\">\n");
      out.write("            ");

             for(int i = 0; i < aps.size(); i++){
                if (ap.getAppointment(aps.get(i).getAppointmentID()).getDoc().getID().equals(session.getAttribute("ID"))) {

                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(ap.getAppointment(aps.get(i).getAppointmentID()).getAppointmentID());
      out.write("\"> ");
      out.print(ap.getAppointment(aps.get(i).getAppointmentID()).getPat().getID() );
      out.write("</option>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");

                }
             }
            
            
            
            
            
            
      out.write("\n");
      out.write("            \n");
      out.write("            </select>\n");
      out.write("            <Input type=\"Submit\" value=\"View Appointment\">\n");
      out.write("        </form>\n");
      out.write("        <h2>Create new medicine</h2>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
