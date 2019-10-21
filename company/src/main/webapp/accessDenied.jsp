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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/plugins/bootstrap-3.3.7/css/bootstrap.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="company login jsp">
		<meta name="author" content="libiao">
		<!-- CSS -->
		<style type="text/css">
			
		</style>
		<script type="text/javascript">
			var basepath = "${pageContext.request.contextPath}";
		</script>
	</head>
	<body>
		<!-- 页面内容 start -->
		<div id="mpanel"></div>
		<!-- 页面内容 end -->

		<!-- js start -->
		<script type="text/javascript">
			var waitSeconds = 5;
			console.log(111)
			layer.alert("拒绝访问，请重新登录！<br/><br/><font id='count' color='green'>" + waitSeconds + "</font>秒后自动跳转到登陆界面", {
				btn: ['确定'] //按钮
			}, function() {
				topL();
			});
			
			var interval = setInterval(function() {
				waitSeconds--;
				if (waitSeconds == 0) {
					clearInterval(interval);
					topL();
				} else {
					$("#count").html(waitSeconds);
				}
			}, 1000);

			function topL() {
				top.location.href = "${pageContext.request.contextPath}/login.jsp";
			}
		</script>
	</body>
</html>
