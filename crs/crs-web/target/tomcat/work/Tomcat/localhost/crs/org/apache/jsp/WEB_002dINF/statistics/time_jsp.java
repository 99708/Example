/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-22 12:10:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.statistics;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class time_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>无标题文档</title>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/base.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/echarts.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("  <body style=\"height: 100%; margin: 0\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("      <div id=\"inner-hd\">\r\n");
      out.write("          <div class=\"crumbs\">\r\n");
      out.write("              <i class=\"crumbs-arrow\"></i>\r\n");
      out.write("              <a href=\"javascript:;\" class=\"crumbs-label\">客户租期统计</a>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div >\r\n");
      out.write("        <h1 align=\"center\">客户租期统计</h1>\r\n");
      out.write("      </div>\r\n");
      out.write("     <div id=\"container\" style=\"height: 90%\"></div>\r\n");
      out.write("  </div>\r\n");
      out.write("     <script type=\"text/javascript\">\r\n");
      out.write("\t     $(function(){\r\n");
      out.write("\t    \tvar dom = document.getElementById(\"container\");\r\n");
      out.write("\t   \t\tvar myChart = echarts.init(dom);\r\n");
      out.write("\t   \t\tvar app = {};\r\n");
      out.write("\t   \t\toption = null;\r\n");
      out.write("\t   \t\t$.ajax({\r\n");
      out.write("\t   \t\t\turl:\"");
      out.print(request.getContextPath() );
      out.write("/selReturnTime\",\r\n");
      out.write("\t   \t\t\tdata:\"\",\r\n");
      out.write("\t   \t\t\tdataType:\"json\",\r\n");
      out.write("\t   \t\t\ttype:\"post\",\r\n");
      out.write("\t   \t\t\tsuccess:function(rsData){\r\n");
      out.write("\t   \t\t\t\tvar dayNumArr = [];\r\n");
      out.write("\t   \t\t\t\tfor ( var i in rsData) {\r\n");
      out.write("\t   \t\t\t\t\trsData[i].name = \"租期为\"+rsData[i].name+\"天\";\r\n");
      out.write("\t   \t\t\t\t\tdayNumArr[i] = rsData[i].name;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t   \t\t\t\toption = {\r\n");
      out.write("   \t\t\t\t\t    tooltip: {\r\n");
      out.write("   \t\t\t\t\t        trigger: 'item',\r\n");
      out.write("   \t\t\t\t\t        formatter: \"{a} <br/>{b}: {c} ({d}%)\"\r\n");
      out.write("   \t\t\t\t\t    },\r\n");
      out.write("   \t\t\t\t\t    legend: {\r\n");
      out.write("   \t\t\t\t\t        orient: 'vertical',\r\n");
      out.write("   \t\t\t\t\t        x: 'left',\r\n");
      out.write("   \t\t\t\t\t        data:dayNumArr\r\n");
      out.write("   \t\t\t\t\t    },\r\n");
      out.write("   \t\t\t\t\t    series: [\r\n");
      out.write("   \t\t\t\t\t        {\r\n");
      out.write("   \t\t\t\t\t            name:'租期统计',\r\n");
      out.write("   \t\t\t\t\t            type:'pie',\r\n");
      out.write("   \t\t\t\t\t            radius: ['50%', '70%'],\r\n");
      out.write("   \t\t\t\t\t            avoidLabelOverlap: false,\r\n");
      out.write("   \t\t\t\t\t            label: {\r\n");
      out.write("   \t\t\t\t\t                normal: {\r\n");
      out.write("   \t\t\t\t\t                    show: false,\r\n");
      out.write("   \t\t\t\t\t                    position: 'center'\r\n");
      out.write("   \t\t\t\t\t                },\r\n");
      out.write("   \t\t\t\t\t                emphasis: {\r\n");
      out.write("   \t\t\t\t\t                    show: true,\r\n");
      out.write("   \t\t\t\t\t                    textStyle: {\r\n");
      out.write("   \t\t\t\t\t                        fontSize: '30',\r\n");
      out.write("   \t\t\t\t\t                        fontWeight: 'bold'\r\n");
      out.write("   \t\t\t\t\t                    }\r\n");
      out.write("   \t\t\t\t\t                }\r\n");
      out.write("   \t\t\t\t\t            },\r\n");
      out.write("   \t\t\t\t\t            labelLine: {\r\n");
      out.write("   \t\t\t\t\t                normal: {\r\n");
      out.write("   \t\t\t\t\t                    show: false\r\n");
      out.write("   \t\t\t\t\t                }\r\n");
      out.write("   \t\t\t\t\t            },\r\n");
      out.write("   \t\t\t\t\t            data:rsData\r\n");
      out.write("   \t\t\t\t\t        }\r\n");
      out.write("   \t\t\t\t\t    ]\r\n");
      out.write("\t   \t\t\t\t\t};\r\n");
      out.write("\t   \t\t\t\tif (option && typeof option === \"object\") {\r\n");
      out.write("\t   \t\t\t\t    myChart.setOption(option, true);\r\n");
      out.write("\t   \t\t\t\t}\r\n");
      out.write("\t   \t\t\t}\r\n");
      out.write("\t   \t\t});\r\n");
      out.write("\t     })\r\n");
      out.write(" \t</script>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>");
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
