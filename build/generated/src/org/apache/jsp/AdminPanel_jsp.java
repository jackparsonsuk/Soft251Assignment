package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Users.Secretary;
import java.util.ArrayList;
import Users.Doctor;

public final class AdminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Hello World!</h1>\r\n");
      out.write("        <h2> Remove a Doctor</h2>\r\n");
      out.write("        <form action=\"AdminServlet\" >\r\n");
      out.write("        \r\n");
      out.write("            <select name=\"Doctors\">\r\n");
      out.write("                ");

                    Doctor d = new Doctor();
                    ArrayList<Doctor> docs = d.readDoctor();
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
      out.write("        <input type=\"submit\" value=\"Remove\"/>\r\n");
      out.write("        \r\n");
      out.write("    </form>\r\n");
      out.write("        <h2> Remove a Secretary</h2>\r\n");
      out.write("        <form action=\"AdminServlet\">\r\n");
      out.write("        \r\n");
      out.write("            <select name=\"Secs\">\r\n");
      out.write("                ");

                    Secretary sec = new Secretary();
                    ArrayList<Secretary> secs = sec.readSecretary();
                    for (int v = 0; v < secs.size(); v++) {
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(secs.get(v).getID());
      out.write("\"> ");
      out.print(secs.get(v).getID());
      out.write(" </option>\r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                a\r\n");
      out.write("            </select>\r\n");
      out.write("        <input type=\"submit\" value=\"Remove\"/>\r\n");
      out.write("        \r\n");
      out.write("    </form>\r\n");
      out.write("                <form action=\"AdminServlet\">\r\n");
      out.write("                    \r\n");
      out.write("                    <select name=\"DocRating\">\r\n");
      out.write("                ");

                    for (int i = 0; i < docs.size(); i++) {
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(docs.get(i).getID());
      out.write("\"> ");
      out.print(docs.get(i).getID());
      out.write(" </option>\r\n");
      out.write("                        \r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </select>\r\n");
      out.write("                    <input type=\"submit\" value=\"Rating?\"/>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                </form>\r\n");
      out.write("        ");
      out.print( request.getAttribute("Rating") );
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
