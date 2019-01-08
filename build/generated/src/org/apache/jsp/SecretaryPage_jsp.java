package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("\n");
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("\n");
      out.write("        <h1>Secretary</h1>\n");
      out.write("        \n");
      out.write("        <h2> Approve a patient</h2>\n");
      out.write("        <form action=\"");
 
        String sid = request.getParameter("unApproved");
        Patient p  = new Patient();
         ArrayList<Patient> pats =p.readPatient();
         Secretary sec = new Secretary();
                for(int x = 0; x <pats.size(); x++){
                    if (pats.get(x).getID().equals(sid)) {
                            sec.approvePatientAccount(pats.get(x));
                            p.savePatient(pats.get(x));
                        }
                }
                
        
        
      out.write("\n");
      out.write("              \"method=\"POST\">\n");
      out.write("            \n");
      out.write("             <select name=\"unApproved\">\n");
      out.write("        ");
 

            for(int i = 0; i< pats.size(); i++){
                if (pats.get(i).isApproved()== false) {
                
      out.write("\n");
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(pats.get(i).getID());
      out.write("\"> ");
      out.print( pats.get(i).getID());
      out.write(" </option>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                
 
                    }

            }
        
        
      out.write("\n");
      out.write("        </select>  \n");
      out.write("        \n");
      out.write("        <input type=\"submit\" value=\"Approve\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("                <h2> Approve a Appointment</h2>\n");
      out.write("        <form action=\"");
 
        String apoints = request.getParameter("unAppoinments");
        Appointment ap = new Appointment();
         ArrayList<Appointment> aps =ap.readAppointment();

                for(int x = 0; x <aps.size(); x++){
                    if (aps.get(x).getAppointmentID().equals(apoints)) {
                            sec.createAppoitment(aps.get(x));
                            aps.get(x).SaveAppointment(aps.get(x));
                        }
                }
                
        
        
      out.write("\n");
      out.write("              \"method=\"POST\">\n");
      out.write("            \n");
      out.write("             <select name=\"unAppoinments\">\n");
      out.write("        ");
 
                ArrayList<Appointment> apss =ap.readAppointment();
            for(int u = 0; u< apss.size(); u++){
                if (apss.get(u).getApproved()== false) {
                
      out.write("\n");
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(apss.get(u).getAppointmentID());
      out.write("\"> ");
      out.print( apss.get(u).getApproved());
      out.write(" </option>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                
 
                    }

            }
        
        
      out.write("\n");
      out.write("        </select>  \n");
      out.write("        \n");
      out.write("        <input type=\"submit\" value=\"Approve\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <h2> \n");
      out.write("\n");
      out.write("        \n");
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
