/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-22 08:38:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.systemManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showLoginLogInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>car.jsp</title>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/base.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/work_summary.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/amazeui.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div id=\"inner-hd\">\r\n");
      out.write("\t\t<div class=\"crumbs\">\r\n");
      out.write("\t\t\t<i class=\"crumbs-arrow\"></i>\r\n");
      out.write("\t\t\t<a href=\"javascript:;\" class=\"crumbs-label\">登录信息</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"inner-bd\">\r\n");
      out.write("\t\t<div class=\"year-summary\">\r\n");
      out.write("\t\t\t<div class=\"kv-group-outer\">\r\n");
      out.write("\t\t\t\t<div class=\"kv-group clearfix\">\r\n");
      out.write("\t\t\t\t\t<div class=\"kv-item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-lt\">用户名：</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-rt\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"uname\" name=\"uname\" value=\"\" style=\"width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"kv-item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-lt\">Ip地址：</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-rt\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"ip\" name=\"ip\" value=\"\" style=\"width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"kv-item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-lt\">登录时间：</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"item-rt\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"time\" name=\"time\" value=\"\" onClick=\"WdatePicker()\" style=\"width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"button-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"button current\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"button-label\" id=\"btn\">查询</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"button current\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"button-label\" id=\"export\">导出Excel</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"table-zone\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"number\">序号</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"comment\">用户名</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"comment\">Ip地址</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"comment\">登录时间</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"tb\">\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"am-margin am-cf\">\r\n");
      out.write("\t\t\t\t\t<hr/>\r\n");
      out.write("\t\t\t\t\t<p class=\"am-fl\">共 <i id=\"countId\" class=\"blue\">0</i> 条记录,当前显示第 <i id=\"numId\" class=\"blue\">0</i> / <i id=\"pageId\" class=\"blue\">0</i> 页</p>\r\n");
      out.write("\t\t\t\t\t<ol id=\"page\" class=\"am-pagination am-fr\">\r\n");
      out.write("\t\t\t\t\t\t<li id=\"up\" ><a href=\"javascript:void(0)\">&laquo;</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"num\" class=\"am-active\"><a href=\"#\">0</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"next\" ><a href=\"javascript:void(0)\">&raquo;</a></li>\r\n");
      out.write("\t\t\t\t\t</ol>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var pageNum; //当前页\r\n");
      out.write("    var pageSize;//分页大小\r\n");
      out.write("    var pageCount;//总页数\r\n");
      out.write("    var conunt;\t//总记录数\r\n");
      out.write("    var rData; //查询结果\r\n");
      out.write("    var navigationNumber = 5;//(每页的)导航个数\r\n");
      out.write("    var begin;//导航栏的起始数\r\n");
      out.write("    var end ;//导航的结束数\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        getData(1,5);\r\n");
      out.write("\r\n");
      out.write("        $(\"#btn\").click(function(){\r\n");
      out.write("            getData(1,5);\r\n");
      out.write("        });\r\n");
      out.write("        //导出\r\n");
      out.write("        $(\"#export\").click(function(){\r\n");
      out.write("            post('");
      out.print(request.getContextPath() );
      out.write("/exportLoginExcel',{\"login\":rData});\r\n");
      out.write("        });\r\n");
      out.write("        function post(url, params) {\r\n");
      out.write("            // 创建form元素\r\n");
      out.write("            var temp_form = document.createElement(\"form\");\r\n");
      out.write("            // 设置form属性\r\n");
      out.write("            temp_form .action = url;\r\n");
      out.write("            temp_form .target = \"_self\";\r\n");
      out.write("            temp_form .method = \"post\";\r\n");
      out.write("            temp_form .style.display = \"none\";\r\n");
      out.write("            // 处理需要传递的参数\r\n");
      out.write("            for (var x in params) {\r\n");
      out.write("                var opt = document.createElement(\"textarea\");\r\n");
      out.write("                opt.name = x;\r\n");
      out.write("                opt.value = params[x];\r\n");
      out.write("                temp_form .appendChild(opt);\r\n");
      out.write("            }\r\n");
      out.write("            document.body.appendChild(temp_form);\r\n");
      out.write("            // 提交表单\r\n");
      out.write("            temp_form .submit();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    function getData(pNum, pSize){\r\n");
      out.write("        var tb = $(\"#tb\");\r\n");
      out.write("        tb.empty();\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: \"");
      out.print(request.getContextPath() );
      out.write("/selLoginInfo\",\r\n");
      out.write("            data: \"uname=\" + $(\"#uname\").val() + \"&ip=\" + $(\"#ip\").val()\r\n");
      out.write("            + \"&time=\" + $(\"#time\").val() + \"&pageNum=\" + pNum + \"&pageSize=\" + pSize,\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            type: \"post\",\r\n");
      out.write("            success: function (rsData) {\r\n");
      out.write("                pageNum = rsData.pageNum;\r\n");
      out.write("                pageSize = rsData.pageSize;\r\n");
      out.write("                count = rsData.count;\r\n");
      out.write("                pageCount = rsData.pages;\r\n");
      out.write("                rData = JSON.stringify(rsData.loginList);\r\n");
      out.write("\r\n");
      out.write("                for (var i = 0; i < rsData.loginList.length; i++) {\r\n");
      out.write("                    var login = rsData.loginList[i];\r\n");
      out.write("                    tb.append(\r\n");
      out.write("                        \"<tr>\"+\r\n");
      out.write("                        \"<td>\"+(i+1)+\"</td>\"+\r\n");
      out.write("                        \"<td>\"+login.user.uname+\"</td>\"+\r\n");
      out.write("                        \"<td>\"+login.ip+\"</td>\"+\r\n");
      out.write("                        \"<td>\"+login.time.substr(0,10)+\"</td>\"+\r\n");
      out.write("                        \"</tr>\");\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                $(\"#countId\").html(count);//设置总的记录数\r\n");
      out.write("                $(\"#pageId\").html(pageCount);//设置总的分页数\r\n");
      out.write("                $(\"#numId\").html(pageNum);//设置当前页码数\r\n");
      out.write("\r\n");
      out.write("                //显示分页页码\r\n");
      out.write("                $(\"#page\").empty();\r\n");
      out.write("\r\n");
      out.write("                //导航栏第一个位置的数(begin)\r\n");
      out.write("                begin = Math.max(pageNum - Math.floor(navigationNumber/2), 1);\r\n");
      out.write("                //导航栏最后一个位置的数(end)\r\n");
      out.write("                end = Math.min(begin + navigationNumber - 1, pageCount);\r\n");
      out.write("                //特殊情况处理\r\n");
      out.write("                if(end - begin < 4){\r\n");
      out.write("                    begin = Math.max(end - 4, 1);\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                $(\"#page\").append(\"<li id='up'><a href='javascript:;''>&laquo;</a></li>\");\r\n");
      out.write("                for(var i=begin; i<=end; i++){\r\n");
      out.write("                    $(\"#page\").append(\r\n");
      out.write("                        \"<li id=\"+i+\"><a href='javascript:;''>\"+i+\"</a></li>\"\r\n");
      out.write("                    );\r\n");
      out.write("                }\r\n");
      out.write("                $(\"#page\").append(\"<li id='next'><a href='javascript:;''>&raquo;</a></li>\");\r\n");
      out.write("\r\n");
      out.write("                //添加点击事件\r\n");
      out.write("                $(\"#page a\").click(function(){\r\n");
      out.write("                    if($(this).html() != \"«\" && $(this).html() != \"»\"){\r\n");
      out.write("                        getData($(this).html(), pageSize);\r\n");
      out.write("                    }else if($(this).html() == \"«\"){\r\n");
      out.write("                        //上一页\r\n");
      out.write("                        $(\"#up\").click(function(){\r\n");
      out.write("                            if(pageNum > 1){\r\n");
      out.write("                                getData(pageNum-1, pageSize);\r\n");
      out.write("                            }else{\r\n");
      out.write("                                alert(\"已经是第一页了\");\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                    }else{\r\n");
      out.write("                        //下一页\r\n");
      out.write("                        $(\"#next\").click(function(){\r\n");
      out.write("                            if(pageNum < pageCount){\r\n");
      out.write("                                getData(pageNum+1, pageSize);\r\n");
      out.write("                            }else{\r\n");
      out.write("                                alert(\"已经是最后一页了\");\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                //添加当前页样式\r\n");
      out.write("                $(\"#\"+pageNum).addClass(\"am-active\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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
