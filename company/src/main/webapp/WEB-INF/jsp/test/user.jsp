<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE  html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>user</title>
  </head>
  <body>
  user1
  <a href="system/logout.do">退出</a>
  ${user1}
  ${user}
  管理员
  welcome：<shiro:principal></shiro:principal>
  <shiro:hasRole name="admin">
    <a href="test/admin.do">admin</a>
  </shiro:hasRole>
  <shiro:hasRole name="user">
    <a href="test/user.do">user</a>
  </shiro:hasRole>
  <a href="test/logout">退出</a>
  </body>
</html>
