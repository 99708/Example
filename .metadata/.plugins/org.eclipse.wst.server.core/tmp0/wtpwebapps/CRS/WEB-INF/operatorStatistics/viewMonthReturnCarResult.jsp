<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewMonthReturnCarResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>css/public.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <style type="text/css">
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
				background-color: #EEF2FB;
			}
			</style>
			<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.STYLE1 {font-size: 12px}
		.STYLE4 {
			font-size: 12px;
			color: #1F4A65;
			font-weight: bold;
		}
		
		a:link {
			font-size: 12px;
			color: #06482a;
			text-decoration: none;
		
		}
		a:visited {
			font-size: 12px;
			color: #06482a;
			text-decoration: none;
		}
		a:hover {
			font-size: 12px;
			color: #FF0000;
			text-decoration: underline;
		}
		a:active {
			font-size: 12px;
			color: #FF0000;
			text-decoration: none;
		}
		.STYLE7 {font-size: 12}
		
		-->
		</style>
		<script>
				var  highlightcolor='#EEF2FB';
				//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
				var  clickcolor='red';
				function  changeto(){
				source=event.srcElement;
				if  (source.tagName=="TR"||source.tagName=="TABLE")
				return;
				while(source.tagName!="TD")
				source=source.parentElement;
				source=source.parentElement;
				cs  =  source.children;
				//alert(cs.length);
				if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
				for(i=0;i<cs.length;i++){
					cs[i].style.backgroundColor=highlightcolor;
				}
				}
				
				function  changeback(){
				if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
				return
				if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
				//source.style.backgroundColor=originalcolor
				for(i=0;i<cs.length;i++){
					cs[i].style.backgroundColor="";
				}
				}
				
				function  clickto(){
				source=event.srcElement;
				if  (source.tagName=="TR"||source.tagName=="TABLE")
				return;
				while(source.tagName!="TD")
				source=source.parentElement;
				source=source.parentElement;
				cs  =  source.children;
				//alert(cs.length);
				if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
				for(i=0;i<cs.length;i++){
					cs[i].style.backgroundColor=clickcolor;
				}
				else
				for(i=0;i<cs.length;i++){
					cs[i].style.backgroundColor="";
				}
				}
		</script>
	 <script type="text/javascript">
		function subForm(pageIndex){
				document.getElementById('pageIndex').value = pageIndex;	
				document.forms[0].submit();
		}
		function subGo(index){
		var obj = document.getElementById('goPage').value;
		if(obj > index){
		alert("超出页数，请重新填写");
		return ;
		}else if(obj <= 0){
			alert("输入页数有误请重新输入");
			return ;
		}else{
		document.getElementById('pageIndex').value = obj;	
				document.forms[0].submit();
		 }
	  }
	  function checkAll(){
		var obj = document.getElementById("all");
		var arr = document.getElementsByName("dels");
		for(var i = 0; i < arr.length; i++)
		{
			arr[i].checked = obj.checked;
			
		} 
	}
	  function findMonthReturnCarByInfo(tableId){
	  	document.forms[0].action = 'FindMonthReturnCarByInfo.do';
	  	document.getElementById('tableId').value = tableId;
	  	document.forms[0].submit();
	  }
	  function preUpdate(tableId){
	  	document.getElementById('method').value='findTheMonthReturnCarInfo';
	  	document.getElementById('tableId').value = tableId;
	    document.forms[0].submit();
	  }
	</script>
  </head>
  
  <body>
   <form action="MonthStatisticsCarAction.do" method="post">
    <h5><font color="red">${requestScope.msg }</font></h5>
   <input type="hidden" name="method" value="theCurrentMonth" id="method"/>
   <input type="hidden" name="tableId" id="tableId"/>
   <input type="hidden" name="pageIndex" value="" id="pageIndex">
  </form>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">查询结果</div></td>
      </tr>
    </table></td>
     <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><span class="left_bt">
     <!-- startTable -->	
     <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">检查单查询结果</span></td>
        <td width="281" background="images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                        <input type="checkbox" name="checkbox62" value="checkbox" id="all" onClick="checkAll()"/>
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">新增</div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/114.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">修改</div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="4%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="4%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">序号</div></td>
            <td width="14%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">出租单编号</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">起租日期</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">应归还日期</div></td>
            <td width="6%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">客户号</div></td>
             <td width="12%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">车号</div></td>
              <td width="12%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">出租单状态</div></td>
               <td width="12%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">服务人员编号</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">编辑</div></td>
          </tr>
          <c:forEach var="rent" items="${requestScope.page.result}"  varStatus="s">
    		<tr class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'">
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <input name="dels" type="checkbox" class="STYLE2" value="checkbox" />
            </div></td>
               <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${s.count }</div></td>
    			 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${rent.tableid }</div></td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><fmt:formatDate value="${rent.begindate }" pattern="yyyy-MM-dd"/></div></td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><fmt:formatDate value="${rent.shouldreturndate }" pattern="yyyy-MM-dd"/></div></td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${rent.customers.identity }</div></td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${rent.cars.carnumber }</div></td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">
    			<c:choose>
    				<c:when test="${rent.rentflag eq 0}">
    				出租中
    				</c:when>
    				<c:otherwise>
    			    已入库/已生成检查单
    				</c:otherwise>
    			</c:choose>
    			</div>
    			</td>
    			<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${rent.users.username }</div></td>
    			<td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a onclick="preUpdate('${rent.tableid }')" style="font-size: 10px; cursor: hand; color: blue; ">编辑</a><span class="STYLE1">]</span></div></td>
    		</tr>
    	</c:forEach>
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"><span class="STYLE1">共${requestScope.page.totalNumber }条纪录，当前第${requestScope.page.currentPage }/${requestScope.page.totalPage }页，每页${requestScope.page.pageNumber }条纪录</span></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <c:if test="${requestScope.pageIndex > 1}">
                  <td width="62" height="22" valign="middle"><div align="right"><a onclick="subForm('${1}')" style="cursor: hand;"><img src="images/first.gif" width="37" height="15"/></a></div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><a onclick="subForm('${requestScope.pageIndex -1 }')" style="cursor: hand;"><img src="images/back2.gif" width="43" height="15" /></a></div></td>
                  </c:if>
                  <c:if test="${requestScope.pageIndex < requestScope.page.totalPage}">
                  <td width="54" height="22" valign="middle"><div align="right"><a onclick="subForm('${requestScope.pageIndex +1 }')" style="cursor: hand;"><img src="images/next.gif" width="43" height="15" /></a></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><a onclick="subForm('${requestScope.page.totalPage}')" style="cursor: hand;"><img src="images/last.gif" width="37" height="15" /></a></div></td>
                 	</c:if>
                  <td width="59" height="22" valign="middle"><div align="right" class="STYLE2 STYLE1">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:20px; width:25px;" size="5" value="${requestScope.pageIndex }" id="goPage"/>
                  </span></td>
                  <td width="23" height="22" valign="middle" class="STYLE2 STYLE1">页</td>
                  <td width="30" height="22" valign="middle"><a onclick="subGo('${requestScope.page.totalPage}')" style="cursor: hand;"><img src="images/go.gif" width="37" height="15" /></a></td>
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
     <!-- endTable -->
  
     	
</span>
	</td>
      </tr>
     
      <tr>
        
        <td valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
        </table></td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
  </body>
</html>
