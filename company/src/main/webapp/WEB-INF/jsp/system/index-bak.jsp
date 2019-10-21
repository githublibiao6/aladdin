<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员主功能界面</title>
    <!-- 引入公用的js和css --start -->
    <%@ include file="/WEB-INF/jsp/common/header.jsp"%>
    <!-- 引入公用的js和css --end -->
    <style type="text/css">
    .mini-tabs-bodys{
        width: 100% !important;
    }
</style>
  </head>
<body>
 <%--  管理员
welcome：<shiro:principal></shiro:principal>
<shiro:hasRole name="admin">
<a href="system/admin.do">admin</a>
</shiro:hasRole>
<shiro:hasRole name="user">
<a href="system/user.do">user</a>
</shiro:hasRole>
<a href="system/logout">退出</a> --%>
<!-- 页面开始 -->
<div class="navbar">
    <div class="navbar-header">
        <div class="navbar-brand">LB<sup>&nbsp;admin</sup></div>
    </div>
    <div class="nav navbar-nav top-menu">
        <div id="mainMenu"></div>
    </div>
    <ul class="nav navbar-nav navbar-right">
        <li><input class="search-input" type="text" placeholder="搜索" /></li>
        <li><a href="#"><i class="fa fa-user"></i></a></li>
        <li><a href="#"><i class="fa fa-comments"></i></a></li>
        <li><a href="#"><i class="fa fa-tasks"></i></a></li>
        <li class="dropdown">
            <a class="dropdown-toggle userinfo">
                <img class="user-img" src="${pageContext.request.contextPath}/static/image/user.jpg" />个人资料<i class="fa fa-angle-down"></i>
            </a>
            <ul class="dropdown-menu pull-right">
                <li><a href="#"><i class="fa fa-user "></i>个人设置</a></li>
                <li class="divider"></li>
                <li>
                    <a href="#"> <i class="fa fa-question-circle-o"></i>帮助文档</a>
                </li>
                <li><a href="#"><i class="fa fa-arrows-alt"></i>全屏</a></li>
                <li><a href="#"><i class="fa fa-lock "></i>锁住系统</a></li>
                <li><a href="system/logout.do"><i class="fa fa-key "></i>注销</a></li>
            </ul>
        </li>
    </ul>
</div>

<div class="container">
    <div id="mainTabs" class="mini-tabs" activeIndex="0" style="height:100%;" plain="false"
            buttons="#tabsButtons" arrowPosition="side">
        <div name="index" iconCls="fa-android" title="控制台">
            <!--           <shiro:hasRole name="admin">admin
                <a href="${pageContext.request.contextPath}/system/admin.do">admin,do</a><br>
                <a href="../../system/admin.do">111111</a>
            </shiro:hasRole> 
            <a class="admin" href="${pageContext.request.contextPath}/system/admin.do">222</a><br> -->
            <canvas id="canvas" style="background:black" width="620" height="340"></canvas>
        </div>
    </div>
    <div id="tabsButtons">
        <a class="tabsBtn"><i class="fa fa-home"></i></a>
        <a class="tabsBtn"><i class="fa fa-refresh"></i></a>
        <a class="tabsBtn"><i class="fa fa-remove"></i></a>
        <a class="tabsBtn"><i class="fa fa-arrows-alt"></i></a>
    </div>
</div>
</body>

<!-- 页面结束 -->
</body>
</html>
<script>

    function activeTab(item) {
        var tabs = mini.get("mainTabs");
        var tab = tabs.getTab(item.id);
        if (!tab) {
            tab = { name: item.id, title: item.text, url: item.url, iconCls: item.iconcls, showCloseButton: true };
            tab = tabs.addTab(tab);
        }
        tabs.activeTab(tab);
    }

    $(function () {
        //menu
        var menu = new Menu("#mainMenu", {
            itemclick: function (item) {
                if (!item.children) {
                    activeTab(item);
                }
            }
        });
        $.ajax({
            url: "menu/index.do",
            success: function (text) {
                var data = mini.decode(text);
                menu.loadData(treeUtils(data));
            }
        })

        //dropdown 点击时打开
        $(".dropdown-toggle").click(function (event) {
            $(this).parent().addClass("open");
            return false;
        });
        //点击其他地方关闭
        $(document).click(function (event) {
            $(".dropdown").removeClass("open");
        });
    });
    
  //组装树结构类型数据
    function treeUtils(data) {
        var ptree = [];
        var tree = [];
        for (var i = 0; i < data.length; i++) {
            if (data[i].parent == '-1') {//获取父元素
                var o = sonsTree(data[i], data);
                ptree.push(o);
            }
        }
        return ptree;
    }
    
  //找儿子
    function sonsTree(obj, arr) {
        
      var children = new Array();
      for (var i = 0; i < arr.length; i++) {
          if (arr[i].parent == obj.id) {  //pid等于加入数组
              sonsTree(arr[i], arr);//递归出子元素
//               arr[i].pname = obj.name;
              children.push(arr[i]);
          }
      }
      if (children.length > 0) {
          obj.children = children;
      }
      return obj;
    }

    function logout(){
        $.ajax({
            url: "${pageContext.request.contextPath}/system/logout.do",
            success: function (text) {
                var data = mini.decode(text);
                menu.loadData(data);
            }
        })
    }
    /***************代码雨效果开始***********/
    window.onload = function(){
        //获取图形对象
        var canvas = document.getElementById("canvas");
        //获取图形的上下文
        var context = canvas.getContext("2d");
        //获取浏览器屏幕的宽度和高度
        var W = window.innerWidth;
        var H = window.innerHeight;
        //设置canvas的宽度和高度
        canvas.width = W;
        canvas.height = H;
        //每个文字的字体大小
        var fontSize = 15;
        //计算列
        var colunms = Math.floor(W /fontSize);
        //记录每列文字的y轴坐标
        var drops = [];
        //给每一个文字初始化一个起始点的位置
        for(var i=0;i<colunms;i++){
            drops.push(0);
        }

        //运动的文字
        var str ="01abcdefghijklmnopqurstuvwxyz";
        //4:fillText(str,x,y);原理就是去更改y的坐标位置
        //绘画的函数
        function draw(){
            //让背景逐渐由透明到不透明
            context.fillStyle = "rgba(0,0,0,0.05)";
            context.fillRect(0,0,W,H);
            //给字体设置样式
            //context.font = "700 "+fontSize+"px  微软雅黑";
            context.font = fontSize + 'px arial';
            //给字体添加颜色
            context.fillStyle ="green";//随意更改字体颜色
            //写入图形中
            for(var i=0;i<colunms;i++){
                var index = Math.floor(Math.random() * str.length);
                var x = i*fontSize;
                var y = drops[i] *fontSize;
                context.fillText(str[index],x,y);
                //如果要改变时间，肯定就是改变每次他的起点
                if(y >= canvas.height && Math.random() > 0.92){
                    drops[i] = 0;
                }
                drops[i]++;
            }
        };

        function randColor(){
            var r = Math.floor(Math.random() * 256);
            var g = Math.floor(Math.random() * 256);
            var b = Math.floor(Math.random() * 256);
            return "rgb("+r+","+g+","+b+")";
        }

        draw();
        setInterval(draw,33);
    };
    /***************代码雨效果结束***********/
</script>
