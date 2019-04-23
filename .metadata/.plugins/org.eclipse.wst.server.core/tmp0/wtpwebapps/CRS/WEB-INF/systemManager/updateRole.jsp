<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'updateRole.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript">
		function modifyRoleOK(roleId){
			var flag = window.confirm("是否真的要修改？")
			if(flag){
			document.getElementById('roleId').value = roleId;
			document.getElementById('method').value='updateRole';
			document.forms[0].submit();
			}
		}
		
		function selectSub(fatherId){
			var elms = document.getElementsByName("s"+fatherId.name.substring(1,fatherId.name.length));
			var flag = fatherId.checked;
			for(var i=0;i<elms.length;i++){
				elms[i].checked = flag;
			}
  }
	function selectFather(sunId){
		var fatherId = document.getElementsByName("f"+sunId.name.substring(1,sunId.name.length));
		var elms = document.getElementsByName(sunId.name);
		var flag = false;
		for(var i=0;i<elms.length;i++){
			if(elms[i].checked){
				flag=true;
				break;
			}
	 }
	fatherId[0].checked=flag;
}
	</script>
</head>

<body>
	<form action="RoleManagerAction.do" method="post">
		<input type="hidden" name="roleId" id="roleId" /> <input type="hidden"
			name="method" id="method" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="17" valign="top" background="images/mail_leftbg.gif"><img
					src="images/left-top-right.gif" width="17" height="29" /></td>
				<td valign="top" background="images/content-bg.gif"><table
						width="100%" height="31" border="0" cellpadding="0"
						cellspacing="0" class="left_topbg" id="table2">
						<tr>
							<td height="31"><div class="titlebt">修改角色</div></td>
						</tr>
					</table>
				<td width="16" valign="top" background="images/mail_rightbg.gif"><img
					src="images/nav-right-bg.gif" width="16" height="29" /></td>
			</tr>
			<tr>
				<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
				<td valign="top" bgcolor="#F7F8F9"><table width="98%"
						border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" valign="top">&nbsp;</td>
							<td>&nbsp;</td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" valign="top">
								<table>
									<tr>
										<td>
										    <c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==1 }">
														<input type="checkbox" value="1" checked="checked">用户管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="1">用户管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==7 }">
														<input type="checkbox" value="7" checked="checked">添加用户
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="7">添加用户
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==8 }">
														<input type="checkbox" value="8" checked="checked">查询用户
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="8">查询用户
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
									<tr>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==2 }">
														<input type="checkbox" value="2" checked="checked">客户管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="2">客户管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==9 }">
														<input type="checkbox" value="9" checked="checked">添加客户
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="9">添加客户
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==10 }">
														<input type="checkbox" value="10" checked="checked">查询客户
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="10">查询客户
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
									<tr>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==3 }">
														<input type="checkbox" value="3" checked="checked">汽车管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="3">汽车管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==11 }">
														<input type="checkbox" value="11" checked="checked">添加汽车信息
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="11">添加汽车信息
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==11 }">
														<input type="checkbox" value="12" checked="checked">查询汽车信息
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="12">查询汽车信息
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
									<tr>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==4 }">
														<input type="checkbox" value="4" checked="checked">业务管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="4">业务管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==13 }">
														<input type="checkbox" value="13" checked="checked">汽车出租
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="13">汽车出租
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==14 }">
														<input type="checkbox" value="14" checked="checked">汽车入库
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="14">汽车入库
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==15 }">
														<input type="checkbox" value="15" checked="checked">出租单管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="15">出租单管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==16 }">
														<input type="checkbox" value="16" checked="checked">检查单管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="16">检查单管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
									<tr>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==5 }">
														<input type="checkbox" value="5" checked="checked">业务统计
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="5">业务统计
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==17 }">
														<input type="checkbox" value="17" checked="checked">当月应还车辆
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="17">当月应还车辆
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==18 }">
														<input type="checkbox" value="18" checked="checked">汽车统计
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="18">汽车统计
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==19 }">
														<input type="checkbox" value="19" checked="checked">租期统计
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="19">租期统计
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==20 }">
														<input type="checkbox" value="20" checked="checked">收入统计
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="20">收入统计
													</c:if>
												</c:if>
											</c:forEach>
										</td>
									</tr>
									<tr>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==6 }">
														<input type="checkbox" value="6" checked="checked">系统管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="6">系统管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==21 }">
														<input type="checkbox" value="21" checked="checked">角色管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="21">角色管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==22 }">
														<input type="checkbox" value="22" checked="checked">日志管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="22">日志管理
													</c:if>
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:set var="isDoing" value="1"/>
											<c:forEach items="${roleList }" var="r" varStatus="s">
												<c:if test="${isDoing==1 }">
													<c:if test="${r.mid==23 }">
														<input type="checkbox" value="23" checked="checked">登录信息管理
														<c:set var="isDoing" value="0"/>								
													</c:if>
													<c:if test="${fn:length(roleList)==s.count}">
														<input type="checkbox" value="23">登录信息管理
													</c:if>
												</c:if>
											</c:forEach>
											<input type="hidden" id="info" value="${roleList[0].uname }">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			alert($("#info").val())
		})
	</script>
</body>
</html>
