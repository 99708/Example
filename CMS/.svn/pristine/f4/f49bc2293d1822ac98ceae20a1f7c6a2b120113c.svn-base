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
    
    <title>任课主任</title>
    
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
	
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		
		$(function(){
			
			//提交按钮点击事件
			$("#subid").click(function(){
				
				var teacherid = $("#teacherid").val();
				var hiredate = $("#hiredate").val();
				var clazzid = $("#clazzSelect option:selected").val();
				
				if(teacherid == null || hiredate == null || hiredate == "" || clazzid == 0){
					alert("请将信息补全再提交");
				}else{
					
					$.ajax({
						url : "teacherServlet.bjsxt?method=teacherToBoss",
						data : "teacherid="+teacherid+"&hiredate="+hiredate+"&clazzid="+clazzid,
						type : "post",
						dataType : "json",
						success : function(rsData){
							
							if(rsData == 1){
								alert("已成功将编号这位亲爱的老师任命为班主任~!");
							}
							
							//更新页面
							$("#tb").empty();
							
							var teacherid = $("#teacherid").val();
							
							$.ajax({
								
								url : "teacherServlet.bjsxt?method=getTeacherByTid",
								data : "teacherid="+teacherid,
								dataType : "json",
								type : "post",
								success : function(rsData){
									$("#tb").append(" <tr> "+
																"<td>"+rsData.tname+"</td> "+
																"<td>"+rsData.sex+"</td> "+
																"<td>"+rsData.age+"</td> "+
																"<td>"+rsData.education+"</td> "+
																"<td>"+rsData.major.mname+"</td> "+
																"<td>"+rsData.marry+"</td> "+
															"</tr>");
								}
								
							})
							
							
							
						}
					})
					
				}
				
			})
			
			//tid失去焦点
			$("#teacherid").blur(function(){
				
				$("#tb").empty();
				
				var teacherid = $("#teacherid").val();
				
				$.ajax({
					
					url : "teacherServlet.bjsxt?method=getTeacherByTid",
					data : "teacherid="+teacherid,
					dataType : "json",
					type : "post",
					success : function(rsData){
						$("#tb").append(" <tr> "+
													"<td>"+rsData.tname+"</td> "+
													"<td>"+rsData.sex+"</td> "+
													"<td>"+rsData.age+"</td> "+
													"<td>"+rsData.education+"</td> "+
													"<td>"+rsData.major.mname+"</td> "+
													"<td>"+rsData.marry+"</td> "+
												"</tr>");
					}
					
				})
				
			})
			
			$("#clazzSelect").change(function(){
				
				var clazzid = $("#clazzSelect option:selected").val();
				
				$.ajax({
					
					url : "teacherServlet.bjsxt?method=getGCIDByClassName" ,
					data : "clazzid="+clazzid,
					dataType : "json" ,
					type : "post" ,
					success : function(rsData){
						//获取专业框对象
						var major = $("#majorid");
						//获取年级框对象
						var grade = $("#gradeid");
						
						major.val(rsData.mname);
						grade.val(rsData.grade);
					} 
					
				})  //ajax后括号mf 	
				
			}) //change事件function后括号
			
			
			
			
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
				请输入教师编号：<input type="text" name="teacherid" id="teacherid" value=""  />
			</span><br /><br /><br />
			<table align="center" border="1px" cellspacing="" cellpadding="5px" id="showTable">
				<thead>
					<tr>
						<td>教师名称</td>
						<td>性别</td>
						<td>年龄</td>
						<td>学历</td>
						<td>授课专业</td>
						<td>结婚状态</td>
					</tr>
				</thead>
				
				<tbody id="tb" name="tb">
					
				</tbody>
				
			</table>
			<br /><br />
			<div id="serch" style="float: left;">
                	&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;班级名称 : 
	                <select id = "clazzSelect" name = "clazzSelect" style="height: 22px;">
		                	<option value ="0">------请选择班级------</option>
		                	<c:forEach var = "clazz" items="${ftc }">
			                		<option value ="${clazz.cid }">${clazz.cname}</option>
	                		</c:forEach>
	                </select>
            </div>
            &emsp;&emsp;&emsp;
                              专业：<input type="text" name="majorid" id="majorid" value="" /><br /><br />
            &emsp;&emsp;&emsp;&emsp;&emsp;
                              年级：<input type="text" name="gradeid" id="gradeid" value="" />
            &emsp;&emsp;&emsp;&emsp;
                           任职日期：<input type="date" name="hiredate" id="hiredate" value="" /><br /><br />
                           &emsp;&emsp;&emsp;&emsp;&emsp;
            <input type="button" name="subid" id="subid" value="提交" />
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            <input type="button" name="" id="" value="重置" /><br /><br />
            &emsp;&emsp;&emsp;&emsp;&emsp;
                             单击“提交”按钮，将教师任职为班主任
			<p style="color: steelblue;"></p>
		</div>
		
		
	</body>
</html>