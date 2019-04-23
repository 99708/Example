<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>

</head>

<body>

<div id="inner-hd">
	<div class="crumbs">
		<i class="crumbs-arrow"></i>
		<a href="javascript:;" class="crumbs-label">角色管理</a>
	</div>
</div>

<div class="formbody">

	<ul class="forminfo">
		<li>
			<label style="width: 150px; height: 32px;">角色名称<b>*</b></label>
			<input name="" type="text" class="dfinput" name="roleName" id="roleName" /><i></i>
			<input name="" type="button" id="btn" class="btn" value="查询"  />
			<span id="roleNameSpan" class="roleNameSpan"></span>
		</li>
	</ul>

</div>
<script type="text/javascript">
	//非空校验
    $("#roleName").blur(function(){
        var roleName = $("#roleName").val();
        if(roleName.length < 1){
            $("#roleNameSpan").text("角色名称不能为空").addClass("error").removeClass("ok");
        }else{
            $("#roleNameSpan").text("").addClass("ok").removeClass("error")
        }
    });
</script>
<script type="text/javascript">
    //查询点击事件
    $("#btn").click(function () {
        $("#roleName").trigger("blur");
        if($(".error").length > 0){
            alert("请检查你的输入");
            return false;
        }else{
            $.ajax({
                url: "<%=request.getContextPath() %>/selRoleView",
                data: "roleName=" + $("#roleName").val(),
                dataType: "json",
                type: "post",
                success: function (rsData) {
					if(rsData){//该角色存在，跳转到角色列表界面
						window.location.href="<%=request.getContextPath() %>/selRoleByRoleName?roleName="+$("#roleName").val();
					}else{//该角色不存在
                        if (confirm("该角色不存在，是否添加该角色")){//到添加角色界面
                            window.location.href="<%=request.getContextPath() %>/insRoleView?roleName="+$("#roleName").val();
                        }else{//清空搜索框中的内容
                            $("#roleName").val("");
                        }
					}
                }
            });
        }
    });
</script>
</body>

</html>
