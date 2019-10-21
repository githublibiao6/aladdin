<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE  html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>测试</title>
  </head>
  <body>
  测试页面
  </body>
</html>
