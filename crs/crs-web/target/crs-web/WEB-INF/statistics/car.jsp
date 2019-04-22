<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>car.jsp</title> 
	<link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/work_summary.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/amazeui.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
</head> 
<body>
    <div class="container">
        <div id="inner-hd">
            <div class="crumbs">
				<i class="crumbs-arrow"></i>
				<a href="javascript:;" class="crumbs-label">当月应还车辆</a>
			</div>
        </div>

        <div id="inner-bd">
          <div class="year-summary">
              <div class="kv-group-outer">
                  <div class="kv-group clearfix">
                  	  <div class="kv-item">
                          <div class="item-lt">起租日期：</div>
                          <div class="item-rt">
                          	<input type="text" id="begindateId" name="begindate" value="" onClick="WdatePicker()" style="width: 190px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                          </div>
                      </div>
                      <div class="kv-item">
                          <div class="item-lt">应归还日期：</div>
                          <div class="item-rt">
                          	<input type="text" id="dateableId" name="dateable" value="" onClick="WdatePicker()" style="width: 190px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                          </div>
                      </div>
                      <div class="kv-item">
                          <div class="item-lt">服务人员编号：</div>
                          <div class="item-rt">
                          		<input type="text" id="uid" name="uid" value="" style="width: 190px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                          </div>
                      </div>
                       <div class="button-group">
					        <div class="button current">
					            <span class="button-label" id="btn">查询</span>
					        </div>
					        <div class="button current">
			                  <span class="button-label" id="export">导出Excel</span>
			              	</div>
					   </div>
                  </div>
              </div>
              <div class="table-zone">
                  <table>
                    <thead>
                      <tr>
                        <td class="number">序号</td>
                        <td class="comment">出租单编号</td>
                        <td class="comment">起租日期</td>
                        <td class="comment">应归还日期</td>
                        <td class="comment">客户身份证号码</td>
                        <td class="comment">租用车车号</td>
                        <td class="comment">出租单状态</td>
                        <td class="comment">服务人员编号</td>
                      </tr>
                    </thead>
                    <tbody id="tb">
                    </tbody> 
                 </table>

                  <div class="am-margin am-cf">
                      <hr/>
                      <p class="am-fl">共 <i id="countId" class="blue">0</i> 条记录,当前显示第 <i id="numId" class="blue">0</i> / <i id="pageId" class="blue">0</i> 页</p>
                      <ol id="page" class="am-pagination am-fr">
                          <li id="up" ><a href="javascript:void(0)">&laquo;</a></li>
                          <li id="num" class="am-active"><a href="#">0</a></li>
                          <li id="next" ><a href="javascript:void(0)">&raquo;</a></li>
                      </ol>
                  </div>
    		</div>
              </div>
          </div>
        </div>

    <script type="text/javascript">
    	$('select').select();
    	var pageNum; //当前页
		var pageSize;//分页大小
		var pageCount;//总页数
		var conunt;	//总记录数
		var rData; //查询结果
    
    	$(function(){
    		getData(1,5);
    		$("#btn").click(function(){
    			getData(1,5);
    		});
    		//导出
            //导出
            $("#export").click(function(){
                post('<%=request.getContextPath() %>/exportExcel',{"rentalList":rData});
            });
            function post(url, params) {
                // 创建form元素
                var temp_form = document.createElement("form");
                // 设置form属性
                temp_form .action = url;
                temp_form .target = "_self";
                temp_form .method = "post";
                temp_form .style.display = "none";
                // 处理需要传递的参数
                for (var x in params) {
                    var opt = document.createElement("textarea");
                    opt.name = x;
                    opt.value = params[x];
                    temp_form .appendChild(opt);
                }
                document.body.appendChild(temp_form);
                // 提交表单
                temp_form .submit();
            }
    	})
    	
    	function getData(pNum, pSize){
    		var tb = $("#tb");
    		tb.empty();
    		$.ajax({
    			url:"<%=request.getContextPath() %>/selCarReturn",
    			data:"begindate="+$("#begindateId").val()+"&dateable="+$("#dateableId").val()
    			+"&uid="+$("#uid").val()+"&pageNum="+pNum+"&pageSize="+pSize,
    			dataType:"json",
    			type:"post",
    			success:function(rsData){
    				pageNum = rsData.pageNum;
    				pageSize = rsData.pageSize;
    				pageCount = rsData.count;
    				count = rsData.pages;
    				rData = JSON.stringify(rsData.rentalList);
    				
    				for (var i = 0; i < rsData.rentalList.length; i++) {
    					var rental = rsData.rentalList[i];
    					tb.append("<tr>"+
								"<td>"+(i+1)+"</td>"+
		                        "<td>"+rental.rentid+"</td>"+
		                        "<td>"+rental.begindate.substr(0,10)+"</td>"+
		                        "<td>"+rental.dateable.substr(0,10)+"</td>"+
		                        "<td>"+rental.idcard+"</td>"+
		                        "<td>"+rental.carid+"</td>"+
		                        "<td>"+rental.status+"</td>"+
		                        "<td>"+rental.uid+"</td>"+
	                        "</tr>");
					}
    				$("#countId").html(count);//设置总的记录数
    				$("#numId").html(pageNum);//设置当前页码数
                    $("#pageId").html(pageCount);//设置页码总数

                    //显示分页页码
                    $("#page").empty();
                    $("#page").append("<li id='up'><a href='javascript:;''>&laquo;</a></li>");
                    for(var i=1; i<=pageCount; i++){
                        $("#page").append(
                            "<li id="+i+"><a href='javascript:;''>"+i+"</a></li>"
                        );
                    }
                    $("#page").append("<li id='next'><a href='javascript:;''>&raquo;</a></li>");

                    //添加点击事件
                    $("#page a").click(function(){
                        if($(this).html() != "«" && $(this).html() != "»"){
                            getData($(this).html(), pageSize);
                        }else if($(this).html() == "«"){
                            //上一页
                            $("#up").click(function(){
                                if(pageNum > 1){
                                    getData(pageNum-1, pageSize);
                                }else{
                                    alert("已经是第一页了");
                                }
                            });
                        }else{
                            //下一页
                            $("#next").click(function(){
                                if(pageNum < pageCount){
                                    getData(pageNum+1, pageSize);
                                }else{
                                    alert("已经是最后一页了");
                                }
                            });
                        }
                    });

                    //添加当前页样式
                    $("#"+pageNum).addClass("am-active");
                }
            });
    	}
    </script>
</body> 
</html>



