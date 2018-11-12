<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'resultStatisticsclass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/echarts.js"></script>
	

 </head>

	<body style="height: 100%; margin: 0">
		<div >
	   		<h1 align="center">班级各科平均成绩统计柱状图</h1>
	   </div>	
		<div  style="height: 3%; width: 500px;  margin:0px auto;" >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			请选择班级：
			<select class="select1" id="select1" onchange="findClassSoore(this.value)" style="width: 330px; height: 28px">
				<option value="301200">一年(1)班</option>
				<option value="301201">一年(2)班</option>
				<option value="301202">二年(1)班</option>
				<option value="301203">二年(2)班</option>
			</select>			
		</div>
       <div id="container" style="height: 90%"></div>
       <script type="text/javascript">
       		$(function(){
       			//页面加载完毕调用一次默认传0
       			findClassSoore(301200);
       		})
       </script>
       <script type="text/javascript">
       		function findClassSoore(choose){
       		//获取div
       			var dom = document.getElementById("container");
				var myChart = echarts.init(dom);
				var app = {};
				var option = null;
       			//发起ajax请求
       			$.ajax({
       				url:"scoreServlet.bjsxt",
       				data:"method=findScoreByClasses&choose="+choose,
       				dataType:"json",
       				type:"post",
       				success:function(rsData){
       					var subArr = [];
       					var scoreArr = [];
       					for(var i in rsData){
       						var avgScore = rsData[i]
       						subArr[i] = avgScore.subname;
       						scoreArr[i] = avgScore.avg;
       					}
       					option = {
   						    color: ['#3398DB'],
   						    tooltip : {
   						        trigger: 'axis',
   						        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
   						            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
   						        }
   						    },
   						    grid: {
   						        left: '3%',
   						        right: '4%',
   						        bottom: '3%',
   						        containLabel: true
   						    },
   						    xAxis : [
   						        {
   						            type : 'category',
   						            data : subArr,
   						            axisTick: {
   						                alignWithLabel: true
   						            }
   						        }
   						    ],
   						    yAxis : [
   						        {
   						            type : 'value'
   						        }
   						    ],
   						    series : [
   						        {
   						            name:'平均成绩',
   						            type:'bar',
   						            barWidth: '60%',
   						            data:scoreArr
   						        }
   						    ]
   						};
       					if (option && typeof option === "object") {
       					    myChart.setOption(option, true);
       					}
       				}
       			});
       			
       		}
       </script>
   </body>
</html>
