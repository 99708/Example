<%@ page language="java" import="java.util.*,com.bjsxt.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生登记查询</title>
<meta charset="UTF-8" />
</head>



<style type="text/css">

/*a标签全局CSS*/
a {
	text-decoration: none;
	color: blue;
	font-size: 16px;
	font-weight: bold;
	margin: 5px;
}



/*table标签全局CSS*/
table {
	text-align: center;
	border-collapse: collapse;
}


</style>



<body>

	<div id="showDiv"
		style="border: solid 0px; border-color: gray; height: 840px;width: 800px;margin: auto;">
		<form action="studentServlet.bjsxt?method=findStudent" method="post">
			<span id="showSpan" style="float: right; margin-right:36px;"> <br />
			<div id="serch" style="float: left;">
				学生编号: <input type="text" name="serchText" id="serchText" value="" /> 
				学生班级: <select id="sel">
							<option value="0">全部班级</option>
						</select>
			</div>  
			<input type="button" id="searchButton" value="查询" />
		</span><br /> <br /> <br />
		</form>
		<table align="center" border="1px" cellspacing="" cellpadding="5px"
			id="showTable">
			<thead>
				<tr>
					<td width="150px">学生编号</td>
					<td width="150px">学生姓名</td>
					<td width="150px">学生班级</td>
					<td width="150px">年级</td>
					<td width="150px">出生日期</td>
					<td width="150px">入学日期</td>			
					<td width="150px">维护</td>	
				</tr>
			</thead>			
			<tbody id="tb"></tbody>
		</table>
		<div style="margin-top: 15px" align="center" >
			<a id="up" href="javaScript:void(0)">上一页</a>&nbsp;&nbsp;
		   	<span id="nums"></span>&nbsp;&nbsp;
		    <a id="next"  href="javaScript:void(0)">下一页</a>
		</div>
		<p style="color: steelblue;"></p>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
			$(function(){
				var sel = $("#sel");
				$.ajax({
					date:"",
					type:"post",
					url:"studentServlet.bjsxt?method=findClasses",
					dataType:"json",
					success:function(rsData){						
						for(var i=0;i<rsData.length;i++){
							sel.append("<option value="+rsData[i].cid+">"+rsData[i].cname+"</option>");
						}
					}
				})
								
				//声明变量记录当前的页码数
	    		var pageNum;
	    		//声明变量记录总的页码数
	    		var pages;
				var sid = $("#serchText").val();
				var cid = $("#sel").val();
				getData(1,5,sid,cid);
				
				$("#up").click(function(){
					sid = $("#serchText").val();
					cid = $("#sel").val();
					if(pageNum>1){
    					getData(pageNum-1,5,sid,cid);
    				}else{
    					alert("已经是第一页");
    				}
				})
				$("#next").click(function(){
					sid = $("#serchText").val();
					cid = $("#sel").val();
					if(pageNum<pages){
    					getData(pageNum+1,5,sid,cid);
    				}else{
    					alert("已经是第一页");
    				}
				})
				
				$("#searchButton").click(function(){
					sid = $("#serchText").val();
					cid = $("#sel").val();
					getData(1,5,sid,cid);
				})
			
				//封装ajax分页功能函数
		    	function getData(pn,ps,sid,cid){
    				//发起ajax请求，请求用户信息  $.get(url,data,deal200)
	    			 $.get("studentServlet.bjsxt?method=findStudents",{num:pn,pageSize:ps,sid:sid,cid:cid},function(data){
	    				//使用eval方法将数据转换为js对象
	    					eval("var obj="+data);
	    				//处理响应数据 ,把用户数据填充到表格中
	    					//获取当次请求的页码数
	    					 pageNum=obj.num;
	    					 pages=obj.pages;
	    					//获取表格对象
	    						var tb=$("#tb");
	    						tb.empty();
	    					//遍历，填充
	    						for(var i=0;i<obj.ls.length;i++){
	    							tb.append("<tr>"+
	    					    			"<td>"+obj.ls[i].sid+"</td>"+
	    					    			"<td>"+obj.ls[i].sname+"</td>"+
	    					    			"<td>"+obj.ls[i].classes.cname+"</td>"+
	    					    			"<td>"+obj.ls[i].gcode+"</td>"+
	    					    			"<td>"+obj.ls[i].birthdate+"</td>"+
	    					    			"<td>"+obj.ls[i].enterdate+"</td>"+
	    					    			"<td><a href='javaScript:void(0)'>维护</a></td>"+
	    					    		"</tr>");
	    						}
	    					//创建页面的页码显示
	    						//获取Span对象
	    						var span=$("#nums");
	    						//清空
	    						span.empty();
	    						//填充页码
	    						for(var i=1;i<=pages;i++){
	    							span.append("<a id='"+i+"' href='javaScript:void(0)'>"+i+"</a>");	    							
	    						}
	    					//给页码超链接添加	
	    						sid = $("#serchText").val();
								cid = $("#sel").val();
	    						$("#nums a").click(function(){
	    							getData($(this).html(), 5,sid,cid);
	    						})
	    					//当前页变色
	    						$("#"+pageNum).css("color","red");
	    						$("#tb a").click(function(){
									var sid = $(this).parent().siblings().first().html();
									window.location.href="studentServlet.bjsxt?method=findStudent&sid="+sid;
								})
	    			}) 
    			}	
			})
		</script>
	</div>
</body>
</html>