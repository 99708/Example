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
    
    <title>My JSP 'positionList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">岗位管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
      
   <div class="formtitle1"><span>岗位列表</span></div>
   
    <table class="tablelist" >
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>岗位名称</th>
        <th>岗位描述</th>
        <th>操作</th>
        </tr>
        </thead>
        
        <tbody>
        	<c:forEach var="position" items="${positionList }">
        		<tr>
			        <td><input name="" type="checkbox" value="" /></td>
			        <td>${position.posid }</td>
			        <td>${position.pname }</td>
			        <td>${position.pdesc }</td>
			        <td>  
				        <a href="javascript:void(0)" onclick="updatePositionQuery('${position.posid }')" class="tablelink">修改</a>   
				        <a href="javascript:void(0)" onclick="deletePosition('${position.posid }')" class="tablelink"> 删除</a>
			        </td>
		        </tr> 
        	</c:forEach>
        </tbody>
    </table>
    
       
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	<script type="text/javascript">
	function deletePosition(posid){
		var flag = window.confirm("您确定要删除吗？");
		if(flag){
			window.location.href = "positionServlet.servlet?method=deletePosition&posid="+posid;
		}
	}
	
	function updatePositionQuery(posid){
		window.location.href = "positionServlet.servlet?method=updatePositionQuery&posid="+posid;
	}
		
	</script>

</body>

</html>
