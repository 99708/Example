/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-11-24 08:36:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>My JSP 'login.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: #1D3647;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("if(window.parent.length > 0){\r\n");
      out.write("\t\t\twindow.parent.location = \"login.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("//刷新验证码\r\n");
      out.write("\t\tfunction reloadImg(url){\r\n");
      out.write("\t\t document.getElementById('img1').src =\"ValidateCodeServlet.do?\"+Math.random();\r\n");
      out.write("\t\t}\r\n");
      out.write("function correctPNG()\r\n");
      out.write("{\r\n");
      out.write("    var arVersion = navigator.appVersion.split(\"MSIE\")\r\n");
      out.write("    var version = parseFloat(arVersion[1])\r\n");
      out.write("    if ((version >= 5.5) && (document.body.filters)) \r\n");
      out.write("    {\r\n");
      out.write("       for(var j=0; j<document.images.length; j++)\r\n");
      out.write("       {\r\n");
      out.write("          var img = document.images[j]\r\n");
      out.write("          var imgName = img.src.toUpperCase()\r\n");
      out.write("          if (imgName.substring(imgName.length-3, imgName.length) == \"PNG\")\r\n");
      out.write("          {\r\n");
      out.write("             var imgID = (img.id) ? \"id='\" + img.id + \"' \" : \"\"\r\n");
      out.write("             var imgClass = (img.className) ? \"class='\" + img.className + \"' \" : \"\"\r\n");
      out.write("             var imgTitle = (img.title) ? \"title='\" + img.title + \"' \" : \"title='\" + img.alt + \"' \"\r\n");
      out.write("             var imgStyle = \"display:inline-block;\" + img.style.cssText \r\n");
      out.write("             if (img.align == \"left\") imgStyle = \"float:left;\" + imgStyle\r\n");
      out.write("             if (img.align == \"right\") imgStyle = \"float:right;\" + imgStyle\r\n");
      out.write("             if (img.parentElement.href) imgStyle = \"cursor:hand;\" + imgStyle\r\n");
      out.write("             var strNewHTML = \"<span \" + imgID + imgClass + imgTitle\r\n");
      out.write("             + \" style=\\\"\" + \"width:\" + img.width + \"px; height:\" + img.height + \"px;\" + imgStyle + \";\"\r\n");
      out.write("             + \"filter:progid:DXImageTransform.Microsoft.AlphaImageLoader\"\r\n");
      out.write("             + \"(src=\\'\" + img.src + \"\\', sizingMethod='scale');\\\"></span>\" \r\n");
      out.write("             img.outerHTML = strNewHTML\r\n");
      out.write("             j = j-1\r\n");
      out.write("          }\r\n");
      out.write("       }\r\n");
      out.write("    }    \r\n");
      out.write("}\r\n");
      out.write("       \r\n");
      out.write("    </script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    //登陆名提示\r\n");
      out.write("    \r\n");
      out.write("    function click_loginusername_input(){\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').className=\"s1\";\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').innerHTML=\"登录名6-12位字符组成(包括大小写字母，数字，下划线)\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//登陆名错误提示\r\n");
      out.write("\t\r\n");
      out.write("\tfunction check_loginusername_input(){\r\n");
      out.write("\t\tvar re = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;\r\n");
      out.write("\t\tvar login = document.getElementById('username').value;\r\n");
      out.write("\t\r\n");
      out.write("\t\tif ( login == '' || login == null ) {\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').className=\"s2\";\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').innerHTML=\"系统检测到你未有任何输入，此项为必填内容，请重新填写！\";\r\n");
      out.write("\t\t}else if(!re.test(login)){\r\n");
      out.write("\t    \tdocument.getElementById('reglogininfo').className=\"s2\";\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').innerHTML=\"你输入的内容不符合规范，请重新填写！\";\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').className = 's3';\r\n");
      out.write("\t\t\tdocument.getElementById('reglogininfo').innerHTML = '输入的内容符合规范，可以使用！';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
      out.write("       //密码提示\r\n");
      out.write("       function click_loginuserpwd_input(){\r\n");
      out.write("         \tdocument.getElementById('userloginpassword').className=\"s1\";\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').innerHTML=\"密码4-12位字符组成(包括大小写字母，数字，下划线)\";\r\n");
      out.write("       }\r\n");
      out.write("       //密码错误提示\r\n");
      out.write("       function check_loginuserpwd_input(){\r\n");
      out.write("       \t\tvar re = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;\r\n");
      out.write("\t\tvar login = document.getElementById('password').value;\r\n");
      out.write("\t\tif ( login == '' || login == null) {\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').className=\"s2\";\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').innerHTML=\"系统检测到你未有任何输入，此项为必填内容，请重新填写！\";\r\n");
      out.write("\t\t}else if(!re.test(login)){\r\n");
      out.write("\t    \tdocument.getElementById('userloginpassword').className=\"s2\";\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').innerHTML=\"你输入的内容不符合规范，请重新填写！\";\r\n");
      out.write("\t    }else{\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').className = 's3';\r\n");
      out.write("\t\t\tdocument.getElementById('userloginpassword').innerHTML = '输入的内容符合规范，可以使用！';\r\n");
      out.write("\t\t}\r\n");
      out.write("       }\r\n");
      out.write("       //验证码提示\r\n");
      out.write("       function click_validate_input(){\r\n");
      out.write("         \tdocument.getElementById('uservalidate').className=\"s1\";\r\n");
      out.write("\t\t\tdocument.getElementById('uservalidate').innerHTML=\"验证码不能为空\";\r\n");
      out.write("       }\r\n");
      out.write("       //验证码为空提示\r\n");
      out.write("       function check_validate_input(){\r\n");
      out.write("\t\tvar login = document.getElementById('code').value;\r\n");
      out.write("\t\tif ( login == '' || login == null ) {\r\n");
      out.write("\t\t\tdocument.getElementById('uservalidate').className=\"s2\";\r\n");
      out.write("\t\t\tdocument.getElementById('uservalidate').innerHTML=\"系统检测到你未有任何输入，此项为必填内容，请重新填写！\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tdocument.getElementById('uservalidate').className = 's3';\r\n");
      out.write("\t\t\tdocument.getElementById('uservalidate').innerHTML = '输入的内容符合规范，可以使用！';\r\n");
      out.write("\t\t}\r\n");
      out.write("       }\r\n");
      out.write("       function subForm(){\r\n");
      out.write("       var userNameRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;\r\n");
      out.write("       var userPwdRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,12}$/;\r\n");
      out.write("       var userName = document.getElementById('username');\r\n");
      out.write("       var userPwd = document.getElementById('password');\r\n");
      out.write("       var code = document.getElementById('code');\r\n");
      out.write("       if(userName.value == '' || !userNameRegex.test(userName.value)){\r\n");
      out.write("       \t\tuserName.onfocus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       }\r\n");
      out.write("       \tif(userPwd.value == '' || !userPwdRegex.test(userPwd.value)){\r\n");
      out.write("       \t\tuserPwd.onfocus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       \t}\r\n");
      out.write("       \tif(code.value == '' || code.value == null){\r\n");
      out.write("       \t\tcode.onfocus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       \t}\r\n");
      out.write("       }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t.s1{\r\n");
      out.write("\tborder:1pt double #BDD6E8;\r\n");
      out.write("\theight:16pt;\r\n");
      out.write("\tpadding: 2pt inherit;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tcolor: #0099CC;\r\n");
      out.write("\tbackground-color: #E5EAFE;\r\n");
      out.write("    }\r\n");
      out.write("\t.s2{\r\n");
      out.write("\t\tborder:1pt double #FF0000;\r\n");
      out.write("\t\theight:16pt;\r\n");
      out.write("\t\tpadding: 2pt inherit;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tcolor: #e50000;\r\n");
      out.write("\t\tbackground-color: #fff2f2;\r\n");
      out.write("\t}\r\n");
      out.write("\t.s3{\r\n");
      out.write("\t\tborder:1pt double #00dd00;\r\n");
      out.write("\t\theight:16pt;\r\n");
      out.write("\t\tpadding: 2pt inherit;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tcolor: #009900;\r\n");
      out.write("\t\tbackground-color: #f2fdf2;\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("    <link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("   <table width=\"100%\" height=\"166\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"42\" valign=\"top\"><table width=\"100%\" height=\"42\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_top_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"1%\" height=\"21\">&nbsp;</td>\r\n");
      out.write("        <td height=\"42\">&nbsp;</td>\r\n");
      out.write("        <td width=\"17%\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\"><table width=\"100%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"49%\" align=\"right\"><table width=\"91%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg2\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"138\" valign=\"top\"><table width=\"89%\" height=\"427\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"149\">&nbsp;</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"80\" align=\"right\" valign=\"top\"><img src=\"images/logo.png\" width=\"279\" height=\"68\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td height=\"198\" align=\"right\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td width=\"35%\">&nbsp;</td>\r\n");
      out.write("                      <td height=\"25\" colspan=\"2\" class=\"left_txt\"><p>1- 地区商家信息网门户站建立的首选方案...</p></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>&nbsp;</td>\r\n");
      out.write("                      <td height=\"25\" colspan=\"2\" class=\"left_txt\"><p>2- 一站通式的整合方式，方便用户使用...</p></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>&nbsp;</td>\r\n");
      out.write("                      <td height=\"25\" colspan=\"2\" class=\"left_txt\"><p>3- 强大的后台系统，管理内容易如反掌...</p></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>&nbsp;</td>\r\n");
      out.write("                      <td width=\"30%\" height=\"40\"><img src=\"images/icon-demo.gif\" width=\"16\" height=\"16\"><a href=\"http://www.mycodes.net\" target=\"_blank\" class=\"left_txt3\"> 使用说明</a> </td>\r\n");
      out.write("                      <td width=\"35%\"><img src=\"images/icon-login-seaver.gif\" width=\"16\" height=\"16\"><a href=\"http://www.mycodes.net\" class=\"left_txt3\"> 在线客服</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("        </table></td>\r\n");
      out.write("        <td width=\"1%\" >&nbsp;</td>\r\n");
      out.write("        <td width=\"50%\" valign=\"bottom\"><table width=\"100%\" height=\"59\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"4%\">&nbsp;</td>\r\n");
      out.write("              <td width=\"96%\" height=\"38\"><span class=\"login_txt_bt\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>&nbsp;</td>\r\n");
      out.write("              <td height=\"21\"><table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" id=\"table211\" height=\"328\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td height=\"164\" colspan=\"2\">\r\n");
      out.write("                    <form name=\"myform\" action=\"");
      out.print(request.getContextPath() );
      out.write("/login\" method=\"post\">\r\n");
      out.write("                        <table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" height=\"143\" id=\"table212\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"38\" class=\"top_hui_text\"><span class=\"login_txt\">用户名：&nbsp;&nbsp;</span></td>\r\n");
      out.write("                            <td height=\"38\" colspan=\"2\" class=\"top_hui_text\"><input name=\"uid\" id=\"uid\" class=\"editbox4\" value=\"10000\" size=\"20\"><span id=\"reglogininfo\"></span></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"35\" class=\"top_hui_text\"><span class=\"login_txt\"> 密 码： &nbsp;&nbsp; </span></td>\r\n");
      out.write("                            <td height=\"35\" colspan=\"2\" class=\"top_hui_text\"><input class=\"editbox4\" type=\"password\" size=\"20\" name=\"pwd\" value=\"123456\" id=\"password\">\r\n");
      out.write("                              <img src=\"images/luck.gif\" width=\"19\" height=\"18\"><span id=\"userloginpassword\" style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userError }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"13%\" height=\"35\" ><span class=\"login_txt\">验证码：</span></td>\r\n");
      out.write("                            <td height=\"35\" colspan=\"2\" class=\"top_hui_text\"><input class=wenbenkuang name=\"code\" id=\"code\" type=text value=\"\" maxLength=4 size=10/>\r\n");
      out.write("                             \t  <cite><img id=\"verifyid\" alt=\"验证码\" width=\"114px\" height=\"46px\" src=\"jsp/validate/image\" /></cite> \r\n");
      out.write("                              \t<span id=\"uservalidate\" style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${codeError }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("                              </td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                          \r\n");
      out.write("                            <td height=\"35\" >&nbsp;</td>\r\n");
      out.write("                            <td width=\"20%\" height=\"35\" ><input name=\"Submit\" type=\"submit\" class=\"button\" id=\"Submit\" value=\"登 陆\" /> </td>\r\n");
      out.write("                            <td width=\"67%\" class=\"top_hui_text\"><input name=\"cs\" type=\"button\" class=\"button\" id=\"cs\" value=\"取 消\" onClick=\"showConfirmMsg1()\"></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    </form></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"433\" height=\"164\" align=\"right\" valign=\"bottom\"><img src=\"images/login-wel.gif\" width=\"242\" height=\"138\"></td>\r\n");
      out.write("                    <td width=\"57\" align=\"right\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("              </table></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"20\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"login-buttom-bg\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"center\"><span class=\"login-buttom-txt\">Copyright &copy; 2009-2010 www.mycodes.net</span></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
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