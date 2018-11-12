<%@ page language="java" isELIgnored="false" import="java.util.*"   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>用户查询</title>
		<meta charset="UTF-8"/>
	</head>
	
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		
		$(function(){
		
		getData();
		
			$("#sub").click(function(){
				getData();
			})
			
			function getData(){
				var rid = $("#rid").val();
				var name = $("#name").val();
				var searchText = $("#searchText").val();
				var tb = $("#tb");
				tb.empty();
				$.ajax({
					url:"userServlet.bjsxt?method=findUsers&rid="+rid+"&name="+name+"&searchText="+searchText,
					data:"",
					type:"post",
					dataType:"json",
					success:function(rsData){
						console.log(rsData);
						for(var i=0;i<rsData.length;i++){
							if(rid==2){
								tb.append("<tr>"+
		    					    			"<td>"+rsData[i].tid+"</td>"+
		    					    			"<td>"+rsData[i].tname+"</td>"+
		    					    			"<td>"+rsData[i].rid+"</td>"+
		    					    	 "</tr>");
							}else{
								tb.append("<tr>"+
		    					    			"<td>"+rsData[i].sid+"</td>"+
		    					    			"<td>"+rsData[i].sname+"</td>"+
		    					    			"<td>"+rsData[i].rid+"</td>"+
		    					    	 "</tr>");
							}
							
						}
					}
				})
			}
			
		})	
	</script>
	
	<style type="text/css">
		
		/*a标签全局CSS*/
		a{
			text-decoration:none;
			color: chocolate;
			font-size: 14px;
			font-weight: bold;
		}
		a:hover{
			text-decoration: underline;
			color: red;
		}
		
		/*table标签全局CSS*/
		table{
			text-align: center;
			border-collapse:collapse;
		}

		
	</style>
	
	
	
	<body>
		
		<div id="showDiv" style="border: solid 0px; border-color: gray; height: 840px;width: 800px;margin: auto;">
			<form action="userServlet.bjsxt?method=find" method="post">
						<span id="showSpan" style="float: right; margin-right:36px;">
				<br />
                <div id="serch" style="float: left;">
                	请输入查询条件 : 
                	 <select style="height: 22px;" name="rid" id="rid">
                        <option  value="1">学生</option>
                        <option value="2">老师</option>
                    </select>
                	<select style="height: 22px;" name="name" id="name">
                        <option value="1">教职工编号</option>
                        <option value="2">姓名</option>
                        <option value="3">权限级别</option>
                    </select>
                </div>
				<input type="text" name="searchText" id="searchText" value="" />
				<input type="button" id="sub" name="sub" value="提交" />
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			</span>
			</form>
	<br /><br /><br /><br />
			<table align="center" border="1px" cellspacing="" cellpadding="5px" id="showTable">
				<thead>
					<tr>
						<td>教职工编号</td>
						<td>姓名</td>
						<td>权限级别</td>
					</tr>
				</thead>
				<tbody id="tb">						
				</tbody>			
			</table>
			<p style="color: steelblue;"></p>
		</div>		
	</body>
</html>