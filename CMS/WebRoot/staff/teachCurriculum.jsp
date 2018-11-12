<%@ page language="java" isELIgnored = "false" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teachCurriculum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<meta charset="UTF-8"/>
	</head>
	
	<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		
		$(function(){
			
			//声明变量记录当前的页码数
    		var pageNum;
			//声明变量记录总的页码数
			var pages;
			//加载第一个数据
    		getData(1, 2);
			
			//提交按钮
			$("#sub").click(function(){
				getData(1, 2);
			})
			
			//重置按钮
			$("#rename").click(function(){
				$("#teacherid").val("");
				$("#hiredate").val("");
			})
			
			//教师编号失去焦点
			$("#teacherid").blur(function(){
				getData(1, 2);
			})
			
			
    		//下一页功能
			$("#next").click(function(){
				if(pageNum<pages){
					getData(pageNum+1, 2);
				}else{
					alert("已经是最后一页");
				}
			})
			//上一页功能
			$("#up").click(function(){
				if(pageNum>1){
					getData(pageNum-1, 2);
				}else{
					alert("已经是第一页");
				}
			})
			
			$("#serchButton").click(function(){
				
				getData(1, 2);
				
			})
			
			//封装ajax分页功能函数
	    	function getData(pn,ps){
				
				//查询条件
				var teacherid = $("#teacherid").val();
				var subject = $("#subject").val();
				var hiredate = $("#hiredate").val();
    			
					$.ajax({
						url : "teacherServlet.bjsxt?method=teacherSubBySTH" ,
						data : "teacherid="+teacherid+"&subject="+subject+"&hiredate="+hiredate
									+"&num="+pn+"&pageSize="+ps,
						dataType : "json" ,
						type : "post" ,
						success : function(rsData){
							
							//使用eval方法将数据转换为js对象
							//eval("var obj="+rsData);
							
	    					//获取当次请求的页码数
	    					 pageNum=rsData.num;
	    					 pages=rsData.pages;
	    					//获取表格对象
	    						var tb=$("#tbody");
	    						tb.empty();
							
							for(var i = 0;i<rsData.ts.length;i++){
								tb.append("<tr>"+
								  	"<td>"+rsData.ts[i].tname+"</td>"+
									"<td>"+rsData.ts[i].sex+"</td>"+
									"<td>"+rsData.ts[i].age+"</td>"+
									"<td>"+rsData.ts[i].education+"</td>"+
									"<td>"+rsData.ts[i].major.mname+"</td>"+
									"<td>"+rsData.ts[i].marry+"</td>"+
								"</tr>");
							}
							//获取Span对象
    						var span=$("#nums");
    						//清空
    						span.empty();
							//填充页码
    						for(var i=1;i<=pages;i++){
    							span.append("<a id='"+i+"' href='javaScript:void(0)'>"+i+"</a>"+"&emsp;");
    						}
							
    						//给页码超链接添加	
    						$("#nums a").click(function(){
    							getData($(this).html(), 2);
    						})
    						//当前页变色
    						$("#"+pageNum).css("color","blue");
    						
						}
					});
				
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
		td{
			width: 110px;
			height: 8px;
			font-size: 10px;
			font-weight: bold;
		}
		
	</style>
	
	
	
	<body>
		
		<div id="showDiv" style="border: solid 0px; border-color: gray; height: 840px;width: 800px;margin: auto;">
				<span id="showSpan" style="float: right; margin-right:36px;">
					<br />
					======  教职任课   ======
					<br /><br />
					教师编号 ：<input type="text" name="teacherid" id="teacherid" value="" />
	                <div id="serch" style="float: left;">
	                	任课科目 : 
	                	<select id = "subject" name = "subject" style="height: 22px";>
		                	<c:forEach  var = "ft" items="${fts }">
		                		<option>${ft.subname }</option>
		                	</c:forEach>
	                    </select>
	                </div>
					任职日期 ：<input type="date" name="hiredate" id="hiredate" value="" />
					<input type="button" name="serchButton" id="serchButton" value="查询" />
					<br /><br />
				</span><br /><br />
			<table align="center" border="1px" cellspacing="" cellpadding="5px" id="showTable">
				<thead>
					<tr>
					<td>教师姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>学历</td>
					<td>授课专业</td>
					<td>结婚状态</td>
				</tr>
				</thead>
				
				<tbody id="pageSerch">
					
				</tbody>
				
				<tbody id="tbody">
					
				</tbody>
				
			</table>
			
			&emsp;&emsp;&emsp;
			
				<a id="up" href="javaScript:void(0)">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			   	<span id="nums"></span>
			    <a id="next"  href="javaScript:void(0)">下一页</a>
			
			<br /><br />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<input type="button" name="sub" id="sub" value="提交" />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<input type="button" name="rename" id="rename" value="重置" />
			<p style="color: steelblue;"></p>
		</div>
		
		
	</body>
</html>