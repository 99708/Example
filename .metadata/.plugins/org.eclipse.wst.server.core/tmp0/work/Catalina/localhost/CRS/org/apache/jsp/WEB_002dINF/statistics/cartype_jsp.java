/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-11-23 07:51:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.statistics;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cartype_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<title>无标题文档</title>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/echarts.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("  <body style=\"height: 100%; margin: 0\">\r\n");
      out.write("  <div >\r\n");
      out.write("  \t<h1 align=\"center\">客户租用车型统计</h1>\r\n");
      out.write("  </div>\t\r\n");
      out.write("     <div id=\"container\" style=\"height: 90%\"></div>\r\n");
      out.write("     <script type=\"text/javascript\">\r\n");
      out.write("     \t$(function(){\r\n");
      out.write("     \t\t\r\n");
      out.write("     \t\tvar dom = document.getElementById(\"container\");\r\n");
      out.write("     \t\tvar myChart = echarts.init(dom);\r\n");
      out.write("     \t\tvar app = {};\r\n");
      out.write("     \t\toption = null;\r\n");
      out.write("     \t\t\r\n");
      out.write("     \t\t$.ajax({\r\n");
      out.write("     \t\t\turl:\"");
      out.print(request.getContextPath() );
      out.write("/selCarTypeCount\",\r\n");
      out.write("     \t\t\tdata:\"\",\r\n");
      out.write("     \t\t\tdataType:\"json\",\r\n");
      out.write("     \t\t\ttype:\"post\",\r\n");
      out.write("     \t\t\tsuccess:function(rsData){\r\n");
      out.write("     \t\t\t\tconsole.log(rsData);\r\n");
      out.write("     \t\t\t\tvar carCountArr = [];\r\n");
      out.write("     \t\t\t\tvar typeArr = [];\r\n");
      out.write("     \t\t\t\t\r\n");
      out.write("     \t\t\t\tfor(var i in rsData){\r\n");
      out.write("     \t\t\t\t\ttypeArr[i] = rsData[i].name;\r\n");
      out.write("     \t\t\t\t}\r\n");
      out.write("     \t\t\t\tconsole.log(typeArr);\r\n");
      out.write("     \t\t\t\toption = {\r\n");
      out.write("     \t\t\t\t\t    tooltip : {\r\n");
      out.write("     \t\t\t\t\t        trigger: 'item',\r\n");
      out.write("     \t\t\t\t\t        formatter: \"{a} <br/>{b} : {c} ({d}%)\"\r\n");
      out.write("     \t\t\t\t\t    },\r\n");
      out.write("     \t\t\t\t\t    legend: {\r\n");
      out.write("     \t\t\t\t\t        orient: 'vertical',\r\n");
      out.write("     \t\t\t\t\t        left: 'left',\r\n");
      out.write("     \t\t\t\t\t        data: typeArr\r\n");
      out.write("     \t\t\t\t\t    },\r\n");
      out.write("     \t\t\t\t\t    series : [\r\n");
      out.write("     \t\t\t\t\t        {\r\n");
      out.write("     \t\t\t\t\t            name: '用户租用车型',\r\n");
      out.write("     \t\t\t\t\t            type: 'pie',\r\n");
      out.write("     \t\t\t\t\t            radius : '55%',\r\n");
      out.write("     \t\t\t\t\t            center: ['50%', '60%'],\r\n");
      out.write("     \t\t\t\t\t            data:rsData,\r\n");
      out.write("     \t\t\t\t\t            itemStyle: {\r\n");
      out.write("     \t\t\t\t\t                emphasis: {\r\n");
      out.write("     \t\t\t\t\t                    shadowBlur: 10,\r\n");
      out.write("     \t\t\t\t\t                    shadowOffsetX: 0,\r\n");
      out.write("     \t\t\t\t\t                    shadowColor: 'rgba(0, 0, 0, 0.5)'\r\n");
      out.write("     \t\t\t\t\t                }\r\n");
      out.write("     \t\t\t\t\t            }\r\n");
      out.write("     \t\t\t\t\t        }\r\n");
      out.write("     \t\t\t\t\t    ]\r\n");
      out.write("     \t\t\t\t\t};\r\n");
      out.write("     \t\t\t\tif (option && typeof option === \"object\") {\r\n");
      out.write("     \t\t\t\t    myChart.setOption(option, true);\r\n");
      out.write("     \t\t\t\t} \r\n");
      out.write("     \t\t\t}\r\n");
      out.write("     \t\t});\r\n");
      out.write("     \t})\r\n");
      out.write("</script>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>");
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