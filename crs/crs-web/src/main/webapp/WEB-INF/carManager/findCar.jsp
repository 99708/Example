<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>

</head>
<body>
<div class="container">
    <div id="inner-hd">
        <div class="crumbs">
            <i class="crumbs-arrow"></i>
            <a href="javascript:;" class="crumbs-label">查询汽车信息</a>
        </div>
    </div>

    <div id="inner-bd">
        <div class="year-summary">
            <div class="kv-group-outer">
                <div class="kv-group clearfix">
                    <div class="kv-item">
                        <div class="item-lt">汽车型号：</div>
                        <div class="item-rt">
                            <input type="text" id="carType" name="type" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                        </div>
                    </div>
                    <div class="kv-item">
                        <div class="item-lt">汽车价格：</div>
                        <div class="item-rt">
                            <input type="text" id="price" name="price" value="" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px"/>
                        </div>
                    </div>
                    <div class="kv-item">
                        <div class="item-lt">租用情况：</div>
                        <div class="item-rt">
                            <select class="select1" name="status" id="status" style="width: 210px; height:33px;border:1px solid #c2c2c2;padding:0 5px">
                                <option value="" >--请选择--</option>
                                <option value="未出租" >未出租</option>
                                <option value="已出租" >已出租</option>
                            </select>
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
                        <td class="comment">汽车图片</td>
                        <td class="comment">汽车编号</td>
                        <td class="comment">汽车型号</td>
                        <td class="comment">汽车价格</td>
                        <td class="comment">汽车租金</td>
                        <td class="comment">租用情况</td>
                        <td class="comment">操作</td>
                    </tr>
                    </thead>
                    <tbody id="tb">
                    </tbody>
                </table>
            </div>
            <div class="am-margin am-cf">
                <hr/>
                <p class="am-fl">共 <i id="countId" class="blue">0</i> 条记录,当前显示第 <i id="numId" class="blue">0</i> / <i id="pageId" class="blue">0</i>页</p>
                <ol id="page" class="am-pagination am-fr">
                    <li id="up" ><a href="javascript:void(0)">&laquo;</a></li>
                    <li id="num" class="am-active"><a href="#">0</a></li>
                    <li id="next" ><a href="javascript:void(0)">&raquo;</a></li>
                </ol>
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

    $(function(){
        getData(1,5);
        $("#btn").click(function(){
            getData(1,5);
        });
        //导出
        $("#export").click(function(){
            post('<%=request.getContextPath() %>/exportCarExcel',{"cs":rData});
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
            url: "<%=request.getContextPath() %>/selCar",
            data: "type=" + $("#carType").val() + "&price=" + $("#price").val()
            + "&status=" + $("#status").val() + "&pageNum=" + pNum + "&pageSize=" + pSize,
            dataType: "json",
            type: "post",
            success: function (rsData) {
                pageNum = rsData.num;
                pageSize = rsData.pageSize;
                count = rsData.count;
                pageCount = rsData.pages;
                rData = JSON.stringify(rsData.cs);

                for (var i = 0; i < rsData.cs.length; i++) {
                    var car = rsData.cs[i];
                    tb.append(
                        "<tr>"+
                        "<td>"+(i+1)+"</td>"+
                        "<td><img src=<%=request.getContextPath() %>/Car-Photo/"+car.img+" width=\"80px\" height=\"50px\"/></td>"+
                        "<td>"+car.carid+"</td>"+
                        "<td>"+car.type+"</td>"+
                        "<td>"+car.price+"</td>"+
                        "<td>"+car.rentprice+"</td>"+
                        "<td>"+car.status+"</td>"+
                        "<td>" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"showCar('"+car.carid+"')\">查看</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"upCar('"+car.carid+"')\">修改</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' class='tablelink' onclick=\"delCar('"+car.carid+"')\">删除</a>" +
                        "</td>"+
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
<script>
    //查看汽车详细信息
    function showCar(carid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/selOneCar?carid="+carid;
    }

    //修改汽车信息
    function upCar(carid) {
        window.location.href=window.location.href="<%=request.getContextPath() %>/upCarView?carid="+carid;
    }

    //删除汽车信息
    function delCar(carid) {
        if(window.confirm("您确定要这么做吗？")){
            window.location.href=window.location.href="<%=request.getContextPath() %>/delCar?carid="+carid;
        }else{
            return false;
        }
    }

</script>
</body>
</html>



