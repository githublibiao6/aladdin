<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE  html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>admin</title>
  </head>
  <body>
  admin
  <a href="test/logout">退出</a>
  </body>
</html>
