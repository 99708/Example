/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-22 09:56:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.userManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class showUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
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
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>无标题文档</title>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/base.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"inner-hd\">\r\n");
      out.write("    <div class=\"crumbs\">\r\n");
      out.write("        <i class=\"crumbs-arrow\"></i>\r\n");
      out.write("        <a href=\"javascript:;\" class=\"crumbs-label\">查看用户</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"formbody\">\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"forminfo\">\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>账号</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>身份证号码</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.idcard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>姓名</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.uname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>性别</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>联系地址</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>联系电话</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>职位</label>\r\n");
      out.write("            <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u.role.rname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <label>&nbsp;</label>\r\n");
      out.write("            <input id=\"sure\" type=\"button\" class=\"btn\" value=\"返回\" />\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(\"#sure\").click(function () {\r\n");
      out.write("        window.location.href=\"");
      out.print(request.getContextPath() );
      out.write("/jsp/userManager/findUser\";\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
