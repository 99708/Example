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
              <a href="javascript:;" class="crumbs-label">客户租期统计</a>
          </div>
      </div>
      <div >
        <h1 align="center">客户租期统计</h1>
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
	   			url:"<%=request.getContextPath() %>/selReturnTime",
	   			data:"",
	   			dataType:"json",
	   			type:"post",
	   			success:function(rsData){
	   				var dayNumArr = [];
	   				for ( var i in rsData) {
	   					rsData[i].name = "租期为"+rsData[i].name+"天";
	   					dayNumArr[i] = rsData[i].name;
					}
	   				option = {
   					    tooltip: {
   					        trigger: 'item',
   					        formatter: "{a} <br/>{b}: {c} ({d}%)"
   					    },
   					    legend: {
   					        orient: 'vertical',
   					        x: 'left',
   					        data:dayNumArr
   					    },
   					    series: [
   					        {
   					            name:'租期统计',
   					            type:'pie',
   					            radius: ['50%', '70%'],
   					            avoidLabelOverlap: false,
   					            label: {
   					                normal: {
   					                    show: false,
   					                    position: 'center'
   					                },
   					                emphasis: {
   					                    show: true,
   					                    textStyle: {
   					                        fontSize: '30',
   					                        fontWeight: 'bold'
   					                    }
   					                }
   					            },
   					            labelLine: {
   					                normal: {
   					                    show: false
   					                }
   					            },
   					            data:rsData
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