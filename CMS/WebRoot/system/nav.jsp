<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'nav.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet" type="text/css" href="css/skin_/nav.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<title>底部内容页</title>
</head>

<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <ul class="nav">
	            <c:if test="${rid==1 }">
	            	<li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">档案管理</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="studentServlet.bjsxt?method=findMyInfo" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">学生基本信息</span></a></li>
	                    </ul>
	                </li>
	                <li class="nav-li current"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">成绩管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="result/resultInquiry.jsp" data-id="8"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">成绩查询</span></a></li>
						</ul></li>
					<li class="nav-li user-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户维护</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="system/userPwd.jsp" data-id="25"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">修改密码</span></a></li>
	                    </ul>
	                </li>
	            </c:if>
	            <c:if test="${rid==2 }">
	            	 <li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">档案管理</span></a>
	                    <ul class="subnav">
	                        <li class="subnav-li" href="teacherServlet.bjsxt?method=findMyInfo" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教师基本信息</span></a></li>
	                    </ul>                 
	                </li>
	                <li class="nav-li current"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">成绩管理</span></a>
						<ul class="subnav">
							<li class="subnav-li current" href="scoreServlet.bjsxt?method=findSubjectByTid" data-id="7"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">成绩录入</span></a></li>
							<li class="subnav-li" href="result/resultInquiry.jsp" data-id="8"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">成绩查询</span></a></li>
						</ul></li>
					<li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">教职工管理</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="teacherServlet.bjsxt?method=teacherSubList" data-id="11"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教职任课</span></a></li>
	                        <li class="subnav-li" href="teacherServlet.bjsxt?method=classesSubList" data-id="12"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">任课主任</span></a></li>
	                        <li class="subnav-li" href="staff/teachSerch.jsp" data-id="13"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">任课教师查询</span></a></li>
	                        <li class="subnav-li" href="staff/teachBoss.jsp" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">班主任查询</span></a></li>
	                    </ul>
	                </li>
					<li class="nav-li user-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户维护</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="system/userPwd.jsp" data-id="25"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">修改密码</span></a></li>
	                    </ul>
	                </li>
	            </c:if>
	            <c:if test="${rid==3 }">
	            	<li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">档案管理</span></a>
	                    <ul class="subnav">
	                        <li class="subnav-li" href="archives/studentReg.jsp" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">学生入校登记</span></a></li>
	                        <li class="subnav-li" href="archives/studentSearch.jsp" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">学生登记查询</span></a></li>
	                        <li class="subnav-li" href="teacherServlet.bjsxt?method=findMyInfo" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教师基本信息</span></a></li>
	                        <li class="subnav-li" href="archives/teacherDate.jsp" data-id="6"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教师信息维护</span></a></li>
	                    </ul>
	                </li>
	                <li class="nav-li current">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">成绩管理</span></a>
						<ul class="subnav">
							<li class="subnav-li" href="result/resultInquiry.jsp" data-id="8"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">成绩查询</span></a></li>
							<li class="subnav-li" href="result/resultStatisticsclass.jsp"
								data-id="9"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">班级成绩统计</span></a></li>
							<li class="subnav-li" href="result/resultStatisticsgrade.jsp"
								data-id="10"><a href="javascript:;" class="ue-clear"><i
									class="subnav-icon"></i><span class="subnav-text">年级成绩统计</span></a></li>
						</ul>
					</li>
					<li class="nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">教职工管理</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="teacherServlet.bjsxt?method=teacherSubList" data-id="11"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教职任课</span></a></li>
	                        <li class="subnav-li" href="teacherServlet.bjsxt?method=classesSubList" data-id="12"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">任课主任</span></a></li>
	                        <li class="subnav-li" href="staff/teachSerch.jsp" data-id="13"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">任课教师查询</span></a></li>
	                        <li class="subnav-li" href="staff/teachBoss.jsp" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">班主任查询</span></a></li>
	                    </ul>
	                </li>
					<li class="nav-li system-nav-li">
	                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户维护</span></a>
	                    <ul class="subnav">
	                    	<li class="subnav-li" href="system/userRegister.jsp" data-id="26"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户注册</span></a></li>
	                        <li class="subnav-li" href="system/userSerch.jsp" data-id="27"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户查询</span></a></li>
	                        <li class="subnav-li" href="system/userPwd.jsp" data-id="25"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">修改密码</span></a></li>
	                    </ul>
	                </li>
	            </c:if>              
            </ul>
            <div class="tree-list outwindow">
            	<div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
        	<div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">
                   
                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>
	<div class="more-bab-list">
		<ul></ul>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
		<div class="opt-panel-bl"></div>
	</div>
</body>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	// 左侧树结构加载
	var setting = {};

		var zNodes =[
			{ name:"新闻管理",
			   children: [
				 { name:"新闻视频管理",icon:'img/skin_/leftlist.png'},
				 { name:"新闻频道管理",icon:'img/skin_/leftlist.png'},
				 { name:"地方新闻管理",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"用户信息设置", open:true,
			   children: [
				 { name:"首页", checked:true,icon:'img/skin_/leftlist.png'},
				 { name:"表单",icon:'img/skin_/leftlist.png'},
				 { name:"表格",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"工作安排",
			   children: [
				 { name:"工作安排",icon:'img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]},
			{ name:"数据管理",
			   children: [
				 { name:"工作安排",icon:'img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'img/skin_/leftlist.png'}
			]}
		];

	$.fn.zTree.init($(".tree"), setting, zNodes);
	
	
	$('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
    });
	
	$(document).click(function(e) {
		if(!$(e.target).is('.tab-more')){
			 $('.tab-more').removeClass('active');
			 $('.more-bab-list').hide();
		}
    });
</script>
</html>
