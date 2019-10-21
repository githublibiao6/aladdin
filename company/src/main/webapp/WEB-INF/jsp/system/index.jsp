<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>管理员主功能界面</title>
        <!-- 引入公用的js和css --start -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/font-awesome/css/font-awesome.min.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/css/app.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/index/css/themes/default.css" media="all" id="skin" kit-skin />
        <!-- 引入公用的js和css --end -->
        <!-- jquery 引入-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-1.9.1.min.js"></script>
        <!-- 浏览器tab图标 -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/image/common/favicon.ico" />
        <style>
            /*.fa{*/
            /*    margin-top: 12px;*/
            /*}*/
        </style>
    </head>
<body class="kit-theme">
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理系统</div>
        <div class="layui-logo kit-logo-mobile"></div>
        <ul class="layui-nav layui-layout-left kit-nav">
            <li class="layui-nav-item"><a href="javascript:;">控制台</a></li>
            <li class="layui-nav-item"><a href="javascript:;">商品管理</a></li>
            <li class="layui-nav-item"><a href="javascript:;" id="pay"><i class="fa fa-gratipay" aria-hidden="true"></i> 捐赠我</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">邮件管理</a></dd>
                    <dd><a href="javascript:;">消息管理</a></dd>
                    <dd><a href="javascript:;">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <i class="layui-icon">&#xe63f;</i> 皮肤
                </a>
                <dl class="layui-nav-child skin">
                    <dd><a href="javascript:;" data-skin="default" style="color:#393D49;"><i class="layui-icon">&#xe658;</i> 默认</a></dd>
                    <dd><a href="javascript:;" data-skin="orange" style="color:#ff6700;"><i class="layui-icon">&#xe658;</i> 橘子橙</a></dd>
                    <dd><a href="javascript:;" data-skin="green" style="color:#00a65a;"><i class="layui-icon">&#xe658;</i> 原谅绿</a></dd>
                    <dd><a href="javascript:;" data-skin="pink" style="color:#FA6086;"><i class="layui-icon">&#xe658;</i> 少女粉</a></dd>
                    <dd><a href="javascript:;" data-skin="blue.1" style="color:#00c0ef;"><i class="layui-icon">&#xe658;</i> 天空蓝</a></dd>
                    <dd><a href="javascript:;" data-skin="red" style="color:#dd4b39;"><i class="layui-icon">&#xe658;</i> 枫叶红</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img"> ${user.loginName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" kit-target data-options="{url:'basic.html',icon:'&#xe658;',title:'基本资料',id:'966'}"><span>基本资料</span></a></dd>
                    <dd><a href="javascript:;">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="system/logout.do"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" id="menuList" kit-navbar>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i> 请稍等...</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2017 &copy;
        <a href="http://kit.zhengjinfan.cn/">kit.zhengjinfan.cn/</a> MIT license
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js" type="text/javascript"></script>
<script>
    $(function(){
        $.ajax({
            url: "menu/list.do",
            success: function (text) {
                if(text.success){
					loadMenu(text.data);
				}
            }
        })
    });
    function loadMenu(text){
        var html = "";
        for (var i = 0; i < text.length; i++) {
            var obj = text[i];
            if(obj.parent == -1){
                html+="<li class='layui-nav-item layui-nav-itemed'><a class='' href='javascript:;'><i class='"+obj.iconCls+"' aria-hidden='true'></i><span> "+obj.menuText+"</span></a>";
                html = loadMenuChild(html,obj.menuId,text);
                html+="</li>"
            }
        }
        $("#menuList").empty();
        $("#menuList").html(html);
    }
    function loadMenuChild(html,parent_id,text){
        html += "<dl class='layui-nav-child'>";
        for (var i = text.length-1; i > -1; i--) {
            var obj = text[i];
            if(obj.parent == parent_id){
				console.log(obj.url)
                html+="<dd>";
                html += "<a href='javascript:;' kit-target data-options=\"{url:'"+obj.url+"',icon:'"+obj.iconCls+"',title:'"+obj.menuText+"',id:'"+obj.menuId+"'}\">"
                    +"<i class='"+obj.iconCls+"'></i><span> "+obj.menuText+"</span></a>";
                html+="</dd>";
            }
        }
        html+="</dl>";
        return html;
    }
    var message;
    layui.config({
        base: '${pageContext.request.contextPath}/static/index/js/',
        version: '1.0.1'
    }).use(['app', 'message'], function() {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();
        $('#pay').on('click', function() {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="/src/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
        $('dl.skin > dd').on('click', function() {
            var $that = $(this);
            var skin = $that.children('a').data('skin');
            switchSkin(skin);
        });
        var setSkin = function(value) {
                layui.data('kit_skin', {
                    key: 'skin',
                    value: value
                });
            },
            getSkinName = function() {
                return layui.data('kit_skin').skin;
            },
            switchSkin = function(value) {
                var _target = $('link[kit-skin]')[0];
                _target.href = _target.href.substring(0, _target.href.lastIndexOf('/') + 1) + value + _target.href.substring(_target.href.lastIndexOf('.'));
                setSkin(value);
            },
            initSkin = function() {
                var skin = getSkinName();
                switchSkin(skin === undefined ? 'default' : skin);
            }();
    });
</script>
</body>
</html>