<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>无标题文档</title>
    <link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/echarts.js"></script>
</head>
  <body style="height: 100%; margin: 0">
  <div class="container">
      <div id="inner-hd">
          <div class="crumbs">
              <i class="crumbs-arrow"></i>
              <a href="javascript:;" class="crumbs-label">客户租用车型统计</a>
          </div>
      </div>
      <div >
        <h1 align="center">客户租用车型统计</h1>
      </div>
     <div id="container" style="height: 90%"></div>
  </div>
     <script type="text/javascript">
     	$(function(){
     		
     		var dom = document.getElementById("container");
     		var myChart = echarts.init(dom);
     		var app = {};
     		option = null;
     		
     		$.ajax({
     			url:"<%=request.getContextPath() %>/selCarTypeCount",
     			data:"",
     			dataType:"json",
     			type:"post",
     			success:function(rsData){
     				console.log(rsData);
     				var carCountArr = [];
     				var typeArr = [];
     				
     				for(var i in rsData){
     					typeArr[i] = rsData[i].name;
     				}
     				console.log(typeArr);
     				option = {
     					    tooltip : {
     					        trigger: 'item',
     					        formatter: "{a} <br/>{b} : {c} ({d}%)"
     					    },
     					    legend: {
     					        orient: 'vertical',
     					        left: 'left',
     					        data: typeArr
     					    },
     					    series : [
     					        {
     					            name: '用户租用车型',
     					            type: 'pie',
     					            radius : '55%',
     					            center: ['50%', '60%'],
     					            data:rsData,
     					            itemStyle: {
     					                emphasis: {
     					                    shadowBlur: 10,
     					                    shadowOffsetX: 0,
     					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
     					                }
     					            }
     					        }
     					    ]
     					};
     				if (option && typeof option === "object") {
     				    myChart.setOption(option, true);
     				} 
     			}
     		});
     	})
</script>
   </body>
</html>