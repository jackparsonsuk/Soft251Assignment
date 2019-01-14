package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"text-align: center\">\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\"> Home</a>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"login.jsp\"> Login</a>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </nav>\r\n");
      out.write("        <h1>Login</h1>\r\n");
      out.write("        <div class=\"text-center\">\r\n");
      out.write("        <form action=\"Login\">\r\n");
      out.write("            <table style=\"margin: 0px auto;\" >\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                        <td> Who are you: </td>\r\n");
      out.write("                        <td><select name=\"userType\">\r\n");
      out.write("                <option value=\"D\">Doctor</option>\r\n");
      out.write("                <option value=\"P\">Patient</option>\r\n");
      out.write("                <option value=\"A\">Admin</option>\r\n");
      out.write("                <option value=\"S\">Secretary</option>\r\n");
      out.write("                \r\n");
      out.write("            </select></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Enter ID:  </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"id\" size=\"25\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Enter Password: </td>\r\n");
      out.write("                        <td> <input type=\"text\" name=\"pword\" size=\"25\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td> </td>\r\n");
      out.write("                        <td><input type=\"submit\" value=\"login\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("           \r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
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
