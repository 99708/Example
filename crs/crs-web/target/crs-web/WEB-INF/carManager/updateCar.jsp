<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/select-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/editor/kindeditor.js"></script>

    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });

        });
    </script>
    <script type="text/javascript">
        KE.show({id:"ecp",width:"800px",height:"300px"});
    </script>
</head>

<body>

<div id="inner-hd">
    <div class="crumbs">
        <i class="crumbs-arrow"></i>
        <a href="javascript:;" class="crumbs-label">添加汽车信息</a>
    </div>
</div>

<div class="formbody">
    <form id="formId" action="<%=request.getContextPath() %>/updateCar" method="post" enctype="multipart/form-data">
        <ul class="forminfo">
            <li>
                <label>汽车编号<b>*</b></label>
                <input name="carid" id="carid"  type="text" value="${car.carid }" class="dfinput" />
                <span id="caridSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>汽车型号<b>*</b></label>
                <input name="type" id="carType" type="text" value="${car.type }" class="dfinput" />
                <span id="carTypeSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>汽车颜色<b>*</b></label>
                <input name="color" id="color" type="text" value="${car.color }" class="dfinput" />
                <span id="colorSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>汽车价格<b>*</b></label>
                <input name="price" id="price" type="text" value="${car.price }" class="dfinput" />
                <span id="priceSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>汽车租金<b>*</b></label>
                <input name="rentprice" id="rentPrice" type="text" value="${car.rentprice }" class="dfinput" />
                <span id="rentPriceSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>租用情况<b>*</b></label>
                <div class="vocation">
                    <select class="select1" name="status" id="status">
                        <c:if test="${car.status == '未出租' }">
                            <option value="未出租" selected >未出租</option>
                            <option value="已出租" >已出租</option>
                        </c:if>
                        <c:if test="${car.status == '已出租' }">
                            <option value="未出租"  >未出租</option>
                            <option value="已出租" selected>已出租</option>
                        </c:if>
                    </select>
                </div>
            </li>
            <li>
                <label>汽车图片<b>*</b></label>
                <label><img src=<%=request.getContextPath() %>/Car-Photo/${car.img } width="80px" height="50px" title="${car.img }"/></label>
                <input name="file" id="file" type="file" value="${car.img }"/>
                <span id="fileSpan" class="idcardSpan"></span>
            </li>
            <li>
                <label>汽车简介</label>
                <textarea name="desc" cols="" rows="" id="ecp" class="textinput">${car.desc }</textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input type="submit" class="btn" value="确认更改" />
            </li>
        </ul>
    </form>
</div>
<script type="text/javascript">

    //非空校验
    $(function () {
        $("#formId").submit(function(){
            $("#carid,#carType,#color,#price,#rentPrice,#file").trigger("blur");
            if($(".error").length > 0){
                alert("请检查你的输入");
                return false;
            }else{
                return true;
            }
        });

        $("#carid").blur(function(){
            var carid = $("#carid").val();
            if(carid.length < 1){
                $("#caridSpan").text("汽车编号不能为空").addClass("error").removeClass("ok");
            }else{
                $("#caridSpan").text("").addClass("ok").removeClass("error");
            }
        });
        $("#carType").blur(function(){
            var carType = $("#carType").val();
            if(carType.length < 1){
                $("#carTypeSpan").text("汽车型号不能为空").addClass("error").removeClass("ok");
            }else{
                $("#carTypeSpan").text("").addClass("ok").removeClass("error")
            }
        });
        $("#color").blur(function(){
            var color = $("#color").val();
            if(color.length < 1){
                $("#colorSpan").text("汽车颜色不能为空").addClass("error").removeClass("ok");
            }else {
                $("#colorSpan").text("").addClass("ok").removeClass("error")
            }
        });
        $("#price").blur(function(){
            var price = $("#price").val();
            if(price.length < 1){
                $("#priceSpan").text("汽车价格不能为空").addClass("error").removeClass("ok");
            }else {
                $("#priceSpan").text("").addClass("ok").removeClass("error")
            }
        });
        $("#rentPrice").blur(function(){
            var rentPrice = $("#rentPrice").val();
            if(rentPrice.length < 1){
                $("#rentPriceSpan").text("汽车租金不能为空").addClass("error").removeClass("ok");
            }else {
                $("#rentPriceSpan").text("").addClass("ok").removeClass("error")
            }
        });
    })
</script>
</body>

</html>
