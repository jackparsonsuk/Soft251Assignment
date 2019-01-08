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
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <h2> Remove a Doctor</h2>\n");
      out.write("        <form action=\"");
 
        String drId = request.getParameter("Doctors");
        Doctor d = new Doctor();
        ArrayList<Doctor> docs = d.readDoctor();
            for(int x = 0; x<docs.size(); x++){
                if (docs.get(x).getID().equals(drId)) {
                        d.removeDoctor(docs.get(x));
                    }
            }
        
        
        
        
        
        
            
      out.write("\" method=\"POST\">\n");
      out.write("        \n");
      out.write("            <select name=\"Doctors\">\n");
      out.write("                ");

                    for (int i = 0; i < docs.size(); i++) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(docs.get(i).getID());
      out.write("\"> ");
      out.print(docs.get(i).getID());
      out.write(" </option>\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </select>\n");
      out.write("        <input type=\"submit\" value=\"Remove\"/>\n");
      out.write("        \n");
      out.write("    </form>\n");
      out.write("        <h2> Remove a Secretary</h2>\n");
      out.write("        <form action=\"");
 
        String secId = request.getParameter("Secs");
        Secretary s = new Secretary();
        ArrayList<Secretary> secs = s.readSecretary();
            for(int z = 0; z<secs.size(); z++){
                if (secs.get(z).getID().equals(secId)) {
                        s.removeSecretary(secs.get(z));
                    }
            }
        
        
        
        
        
        
            
      out.write("\" method=\"POST\">\n");
      out.write("        \n");
      out.write("            <select name=\"Secs\">\n");
      out.write("                ");

                    for (int v = 0; v < secs.size(); v++) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(secs.get(v).getID());
      out.write("\"> ");
      out.print(secs.get(v).getID());
      out.write(" </option>\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                a\n");
      out.write("            </select>\n");
      out.write("        <input type=\"submit\" value=\"Remove\"/>\n");
      out.write("        \n");
      out.write("    </form>\n");
      out.write("                <form action=\"\n");
      out.write("                      ");
 String dID = request.getParameter("DocRating"); 
                      for(int z = 0; z<docs.size(); z++)
                      
                       if (docs.get(z).getID().equals(dID)) {
                           docs.get(z).calculateRating(5d);
                        request.setAttribute("Rating", docs.get(z).viewRating());
                    }
                      
                      
      out.write("\n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      \n");
      out.write("                      \">\n");
      out.write("                    \n");
      out.write("                    <select name=\"DocRating\">\n");
      out.write("                ");

                    for (int i = 0; i < docs.size(); i++) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(docs.get(i).getID());
      out.write("\"> ");
      out.print(docs.get(i).getID());
      out.write(" </option>\n");
      out.write("                        \n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </select>\n");
      out.write("                    <input type=\"submit\" value=\"Remove\"/>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("        ");
      out.print( request.getAttribute("Rating") );
      out.write("\n");
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
