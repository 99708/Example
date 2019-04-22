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
				<a href="javascript:;" class="crumbs-label">日志管理</a>
			</div>
        </div>

        <div id="inner-bd">
          <div class="year-summary">
              <div class="kv-group-outer">
                  <div class="kv-group clearfix">
                  	      <div class="kv-item">
	                          <div class="item-lt">日志内容：</div>
	                          <div class="item-rt">
	                          		<input type="text" id="oper" name="oper" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
	                          </div>
                  	      </div>
                  	      <div class="kv-item">
	                         <div class="item-lt">用户ID：</div>
	                         <div class="item-rt">
	                          		<input type="text" id="uid" name="uid" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
	                         </div>
                  	      </div>
                  	      <div class="kv-item">
	                          <div class="item-lt">事件时间：</div>
	                          <div class="item-rt">
	                          	<input type="text" id="opertime" name="opertime" value="" onClick="WdatePicker()" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
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
              </div>
              <div class="table-zone">
                  <table>
                    <thead>
                      <tr>
						<td class="number">序号</td>
						<td class="comment">用户ID</td>
						<td class="comment">日志内容</td>
						<td class="comment">事件时间</td>
					    <td class="comment">事件结果</td>
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
        var pageNum; //当前页
        var pageSize;//分页大小
        var pageCount;//总页数
        var conunt;	//总记录数
        var rData; //查询结果
        var navigationNumber = 5;//(每页的)导航个数
        var begin;//导航栏的起始数
        var end ;//导航的结束数

        $(function(){
            getData(1,5);

            $("#btn").click(function(){
                getData(1,5);
            });
            //导出
            $("#export").click(function(){
                post('<%=request.getContextPath() %>/exportSlfExcel',{"slf":rData});
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
                url: "<%=request.getContextPath() %>/selSlflog",
                data: "oper=" + $("#oper").val() + "&uid=" + $("#uid").val()
                + "&opertime=" + $("#opertime").val() + "&pageNum=" + pNum + "&pageSize=" + pSize,
                dataType: "json",
                type: "post",
                success: function (rsData) {
                    pageNum = rsData.num;
                    pageSize = rsData.pageSize;
                    count = rsData.count;
                    pageCount = rsData.pages;
                    rData = JSON.stringify(rsData.slf);

                    for (var i = 0; i < rsData.slf.length; i++) {
                        var slf = rsData.slf[i];
                        tb.append(
                            "<tr>"+
                            "<td>"+(i+1)+"</td>"+
                            "<td>"+slf.uid+"</td>"+
                            "<td>"+slf.oper+"</td>"+
                            "<td>"+slf.opertime.substr(0,10)+"</td>"+
                            "<td>"+slf.success+"</td>"+
                            "</tr>");
                    }

                    $("#countId").html(count);//设置总的记录数
                    $("#pageId").html(pageCount);//设置总的分页数
                    $("#numId").html(pageNum);//设置当前页码数

                    //显示分页页码
                    $("#page").empty();

                    //导航栏第一个位置的数(begin)
                    begin = Math.max(pageNum - Math.floor(navigationNumber/2), 1);
                    //导航栏最后一个位置的数(end)
                    end = Math.min(begin + navigationNumber - 1, pageCount);
                    //特殊情况处理
                    if(end - begin < 4){
                        begin = Math.max(end - 4, 1);
                    }

                    $("#page").append("<li id='up'><a href='javascript:;''>&laquo;</a></li>");
                    for(var i=begin; i<=end; i++){
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



