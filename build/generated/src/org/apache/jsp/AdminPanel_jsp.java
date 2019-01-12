package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Other.Review;
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Admin page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
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
      out.write("            </select>\r\n");
      out.write("        <input type=\"submit\" value=\"Remove\"/>\r\n");
      out.write("        \r\n");
      out.write("    </form>\r\n");
      out.write("                \r\n");
      out.write("                <table class=\"table\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            Doctor\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            Rating\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            Comments\r\n");
      out.write("                        </th> \r\n");
      out.write("                        <th>\r\n");
      out.write("                            Comments\r\n");
      out.write("                        </th>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                         ");

                    
                   Review r = new Review();
                    for (int i = 0; i < docs.size(); i++) {
                            
                         ArrayList<Review> docR = r.getDoctorReview(docs.get(i).getID());
                        
      out.write("\r\n");
      out.write("                         <tr>\r\n");
      out.write("                        <th> ");
      out.print(docs.get(i).getID());
      out.write(" </th>\r\n");
      out.write("                        <th> ");
      out.print(docs.get(i).viewRating());
      out.write(" </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            ");

                            for(int x = 0; x<docR.size(); x++){
                                
      out.write("\r\n");
      out.write("                                ");
      out.print(docR.get(x).getMessage());
      out.write("<br> \r\n");
      out.write("                                ");

                            }
                            
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                            ");

                                for(int z = 0; z<docs.get(i).getFeedback().size();z++){
                                
      out.write("\r\n");
      out.write("                                ");
      out.print(docs.get(i).getFeedback().get(z));
      out.write("\r\n");
      out.write("                                ");

                                }
                            
      out.write("\r\n");
      out.write("                        </th>\r\n");
      out.write("                         <br>\r\n");
      out.write("                             </tr>\r\n");
      out.write("                        \r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                </table>\r\n");
      out.write("                \r\n");
      out.write("                <form action=\"AdminServlet\">\r\n");
      out.write("                    <h2>Give feedback to doctor</h2>\r\n");
      out.write("            <select name=\"Docs\">\r\n");
      out.write("                ");


                    for (int l = 0; l < docs.size(); l++) {
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(docs.get(l).getID());
      out.write("\"> ");
      out.print(docs.get(l).getID());
      out.write(" </option>\r\n");
      out.write("                        ");

                            
                        }
                
                
                
                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("            </select>\r\n");
      out.write("                <input type=\"text\" name=\"feedDoc\">\r\n");
      out.write("        <input type=\"submit\" value=\"Give Feedback\"/>\r\n");
      out.write("        \r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("               \r\n");
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
