/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-11-23 13:33:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.carManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class findCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'findCar.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t <style type=\"text/css\">\r\n");
      out.write("\t\tbody {\r\n");
      out.write("\t\t\tmargin-left: 0px;\r\n");
      out.write("\t\t\tmargin-top: 0px;\r\n");
      out.write("\t\t\tmargin-right: 0px;\r\n");
      out.write("\t\t\tmargin-bottom: 0px;\r\n");
      out.write("\t\t\tbackground-color: #EEF2FB;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction subForm(){\r\n");
      out.write("\t   \t\tdocument.forms[0].submit();\r\n");
      out.write("\t    }\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form action=\"findCarNow\" method=\"get\">\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"uid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.user.uid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("  \t\t<input  type=\"hidden\" name=\"method\" value=\"findCar\"/>\r\n");
      out.write("  \t\t<input  type=\"hidden\" name=\"num\" value=\"1\"/>\r\n");
      out.write("  \t\t<input  type=\"hidden\" name=\"pageSize\" value=\"2\"/>\r\n");
      out.write("   <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"17\" valign=\"top\" background=\"images/mail_leftbg.gif\"><img src=\"images/left-top-right.gif\" width=\"17\" height=\"29\" /></td>\r\n");
      out.write("    <td valign=\"top\" background=\"images/content-bg.gif\"><table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"31\"><div class=\"titlebt\">查询汽车</div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("     <td width=\"16\" valign=\"top\" background=\"images/mail_rightbg.gif\"><img src=\"images/nav-right-bg.gif\" width=\"16\" height=\"29\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"middle\" background=\"images/mail_leftbg.gif\">&nbsp;</td>\r\n");
      out.write("    <td valign=\"top\" bgcolor=\"#F7F8F9\"><table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td valign=\"top\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\" valign=\"top\"><span class=\"left_bt\">\r\n");
      out.write("     \t<table class=\"maintable\" width=\"97%\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"14%\"><div align=\"center\" class=\"left_txt\">车号</div></td>\r\n");
      out.write("      <td width=\"23%\"><input type=\"text\" name=\"carid\" id=\"carNumber\" >*</td>\r\n");
      out.write("      <td width=\"15%\"><div align=\"center\" class=\"left_txt\">型号</div></td>\r\n");
      out.write("      <td width=\"48%\"><input type=\"text\" name=\"type\" id=\"carType\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td><div align=\"center\"  class=\"left_txt\">颜色</div></td>\r\n");
      out.write("      <td><input type=\"text\" name=\"color\" id=\"color\" >*</td>\r\n");
      out.write("       <td><div align=\"center\" class=\"left_txt\">价值</div></td>\r\n");
      out.write("      <td><input type=\"text\" name=\"price\" id=\"price\">*</td>\r\n");
      out.write("      \r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td><div align=\"center\" class=\"left_txt\">租金</div></td>\r\n");
      out.write("      <td><input type=\"text\" name=\"rentprice\" id=\"rentPrice\">*</td>\r\n");
      out.write("     <td><div align=\"center\" class=\"left_txt\">押金</div></td>\r\n");
      out.write("      <td><input type=\"text\" name=\"deposit\" id=\"deposit\">*</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td><div align=\"center\" class=\"left_txt\">租用情况 </div></td>\r\n");
      out.write("      <td>\r\n");
      out.write("     <select name=\"status\" id=\"isRenting\" style=\"width: 80px;\">\r\n");
      out.write("\t\t\t<option value=\"未出租\" selected >未出租</option>\r\n");
      out.write("\t\t\t<option value=\"已出租\" >已出租</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("    <table align=\"left\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"107\">\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t<img  src=\"");
      out.print(basePath);
      out.write("images/carimg/ok.gif\" onclick=\"subForm()\" style=\"cursor: hand;\">\r\n");
      out.write("\t\t &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t <img  src=\"");
      out.print(basePath);
      out.write("images/carimg/reset.gif\" onclick=\"reset()\" style=\"cursor: hand;\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t  </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td height=\"30\" background=\"");
      out.print(basePath);
      out.write("images/tab/bg.gif\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</span>\r\n");
      out.write("\t</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("     \r\n");
      out.write("      <tr>\r\n");
      out.write("        \r\n");
      out.write("        <td valign=\"top\"><table width=\"100%\" height=\"144\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"line_table\">\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td background=\"images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_leftbg.gif\"><img src=\"images/buttom_left2.gif\" width=\"17\" height=\"17\" /></td>\r\n");
      out.write("    <td background=\"images/buttom_bgs.gif\"><img src=\"images/buttom_bgs.gif\" width=\"17\" height=\"17\"></td>\r\n");
      out.write("    <td valign=\"bottom\" background=\"images/mail_rightbg.gif\"><img src=\"images/buttom_right2.gif\" width=\"16\" height=\"17\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
