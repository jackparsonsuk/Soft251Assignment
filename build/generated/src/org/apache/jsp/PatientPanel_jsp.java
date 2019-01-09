package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.UUID;
import Users.Patient;
import Other.Appointment;
import Users.Secretary;
import java.util.ArrayList;
import Users.Doctor;

public final class PatientPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Paitent</h1>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <h2>Doctors</h2>\r\n");
      out.write("                <form action=\"");
 
        
        String drId = request.getParameter("Doctors");
        Doctor d = new Doctor();
        Patient p = new Patient();
        ArrayList<Doctor> docs = d.readDoctor();
        ArrayList<Patient> pats = p.readPatient();
        Appointment ap = new Appointment();
            for(int x = 0; x<docs.size(); x++){
                if (docs.get(x).getID().equals(drId)) {
                        ap.setDoc(docs.get(x));
                    }
            }
            
            for(int x = 0; x<pats.size(); x++){
                if (pats.get(x).getID().equals(session.getAttribute("ID"))) {
                        
                        ap.setPat(pats.get(x));
                    }
            }
            String uniqueID = UUID.randomUUID().toString();
            ap.setAppointmentID(uniqueID);
            ap.SaveAppointment(ap);
        
        
        
        
        
        
            
      out.write("\" method=\"POST\">\r\n");
      out.write("        ");
      out.print(session.getAttribute("ID"));
      out.write("\r\n");
      out.write("            <select name=\"Doctors\">\r\n");
      out.write("                ");

                    for (int i = 0; i < docs.size(); i++) {
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(docs.get(i).getID());
      out.write("\"> ");
      out.print(docs.get(i).getID());
      out.write(" </option>\r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </select>\r\n");
      out.write("        <input type=\"submit\" value=\"Create Appointment\"/>\r\n");
      out.write("        \r\n");
      out.write("                </form>\r\n");
      out.write("        <h2> Rate your doctor</h2>\r\n");
      out.write("        <form action=\"PatientServlet\">\r\n");
      out.write("            \r\n");
      out.write("             <select name=\"RateDoc\">\r\n");
      out.write("                ");

                    for (int i = 0; i < docs.size(); i++) {
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(docs.get(i).getID());
      out.write("\"> ");
      out.print(docs.get(i).getID());
      out.write(' ');
      out.print(docs.get(i).viewRating());
      out.write(" </option>\r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("            \r\n");
      out.write("             </select>\r\n");
      out.write("                <input type=\"Text\" name=\"Rating\">\r\n");
      out.write("                <input type=\"submit\" value=\"Rate\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
