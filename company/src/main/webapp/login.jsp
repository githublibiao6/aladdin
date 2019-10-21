<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>公司管理员登陆</title>
<!-- 引入公用的js和css --start -->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!-- 引入公用的js和css --end -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/static/plugins/bootstrap-3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="company login jsp">
<meta name="author" content="libiao">
<!-- CSS -->
<style type="text/css">
html,body { 
    margin: 0; 
    padding:0; 
    height: 100%;
    width: 100%;
}
body{
    background: url("${pageContext.request.contextPath}/static/image/login/1.gif") center no-repeat;
    height: 100%;
    width: 100%;
    background-size:100%;
    overflow-x:hidden; 
}
#loginDiv{
    position:absolute;
    width: 600px; 
    height: 350px;
    top: 25%;
    background: rgba(255, 255, 255, 0.55) none repeat scroll 0 0 !important; 
}
.form{background: rgba(255,255,255,0.2);width:400px;}
</style>
<script type="text/javascript">
    var basepath = "${pageContext.request.contextPath}";
</script>
</head>
<body>
<div>
    <div class="form row">
        <div class="form-horizontal col-md-offset-4" id="loginDiv">
            <h3 class="form-title" style="margin-left: 250px;">管理员登陆</h3>
            <form action="${pageContext.request.contextPath}/system/login.do" id="login_form" method="post">
                <div class="form-group col-sm-12" style="margin-top:40px;">
                    <div class="col-sm-3 text-right">
                        <label class="">用户名：</label> 
                    </div>
                    <div class="col-sm-9">
                        <input id="name" value="" name="loginName" type="text" class="form-control" >
                    </div>
                </div>
                <div class="form-group col-sm-12">
                    <div class="col-sm-3 text-right">
                        <label>密&emsp;码：</label> 
                    </div> 
                    <div class="col-sm-9">
                        <input id="pass" value="" name="loginPassword" type="password" class="password form-control col-sm-5">
                    </div>
                </div>

                <div class="form-group col-sm-12" style="margin-top: 20px;">
                    <div id="submit_btn" class="text-center">
                        <input type="button" class="btn btn-primary" value="登录" style="width: 250px;"/></br>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="col-sm-12" style="text-align: center;bottom: 50px;position: fixed;">版权所有 &copy; 2017-2018 公司管理系统
    </strong> All rights reserved. <b>Developed by LiB R&D Item First </b>
    </div>
<!-- <div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>{{details()}}</h1>
    <div id="example"></div> 
</div> 

-->
<!-- <script type="text/babel">  

      ReactDOM.render(
        <h1>Hello, react!</h1>,
        document.getElementById('example')
      );
</script> -->
<script type="text/javascript">
//JavaScript Document
//支持Enter键登录
document.onkeydown = function(e) {
if ($(".bac").length == 0) {
    if (!e)
        e = window.event;
    if ((e.keyCode || e.which) == 13) {
        $("#submit_btn").click();
        }
    }
};

$(function(){
    // 提交表单
    $('#submit_btn').click(function() {
        //var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; // 邮件正则
		if ($('#loginName').val() == '') {
			layer.msg('请填写用户名！');
			$('#loginName').focus();
			return;
		}
		if ($('#password').val() == '') {
			layer.msg("请输入密码！");
			$('#password').focus();
			return;
		}
		$("#login_form").submit();
    });
});
 /*  var vm = new Vue({
        el: '#vue_det',
        data: {
            site: "菜鸟教程",
            url: "www.runoob.com",
            alexa: "10000"
        },
        methods: {
            details: function() {
                return  this.site + " - 学的不仅是技术，更是梦想！";
            }
        }
    });
   */ 
</script>
</body>
</html>