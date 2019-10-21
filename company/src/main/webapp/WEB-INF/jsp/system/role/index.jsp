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
		<title>菜单管理</title>
		<!-- 引入公用的js和css 11--start -->
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<!-- 引入公用的js和css --end -->
	</head>
	<style>
		.selected{
			background-color: #e9e9e9;
		}
    </style>
	<body>
		<div class="layui-row">
			<table class="layui-table" lay-filter="roletable" id="roletable" style="margin-top: 0;"></table>
		</div>
	</body>
	<script type="text/html" id="toolbar">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-normal" lay-event="add"><i class="layui-icon">&#xe654;</i>新增</button>
			<button class="layui-btn layui-btn-warm" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</button>
			<button class="layui-btn layui-btn-danger" lay-event="remove"><i class="layui-icon">&#xe640;</i>删除</button>
		</div>
	</script>
	<script type="text/javascript">
		var layer;
		var roletable;
		var form;
		var $;
		var option = "";
		var id = null;
		var level = null;
		layui.use(['table', 'form'], function() {
			layer = layui.layer;
			var table = layui.table;
			form = layui.form;
			$ = layui.jquery;
			roletable = table.render({
				elem: '#roletable',
				toolbar: "#toolbar",
				height: "full-30",
				url: 'role/pagelist.do', //数据接口
				cols: [
					[ //表头
						{type:'radio'},
						{field: 'code', title: '角色代码' }
						,{field: 'name', title: '角色名称' }
						,{field: 'notes', title: '备注' }
					]
				],
				page:true
			});
			 table.on('toolbar(roletable)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
					case 'add':
						add();
						break;
					case 'edit':
						edit(table, obj);
						break;
					case 'remove':
						remove(table, obj);
						break;
				};
			});
			 table.on('row(roletable)', function(obj) {
				obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click'); //选中行样式
				obj.tr.find('input[lay-type="layTableRadio"]').prop("checked", true);
				var index = obj.tr.data('index')
				var thisData = table.cache.roletable;
				//重置数据单选属性
				layui.each(thisData, function(i, item) {
					if (index === i) {
						item.LAY_CHECKED = true;
					} else {
						delete item.LAY_CHECKED;
					}
				});
				form.render('radio');
			});
		});

		function add() {
			open("新增","role/addoreditrender.do","800px","600px",{option:"add"},function(data){
				roletable.reload();
			});
		}
		
		function edit(table, obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			var data = checkStatus.data;
			if (data.length < 1) {
				layer.msg("请选中一条编辑！", {
					icon: 2
				});
				return;
			}
			open("编辑", "role/addoreditrender.do", "800px", "600px", {
				id: data[0].id,
				option: "edit"
			}, function(data) {
				roletable.reload();
			});
		}

		function remove(table, obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			var data = checkStatus.data;
			if (data.length < 1) {
				layer.msg("请选中一条查看！", {
					icon: 2
				});
				return;
			}
			var index =layer.confirm('是否确认删除?', {
				icon: 3,
				title: '提示'
			}, function(index) {
				//do something
				$.post("role/remove.do", {
					id: data[0].id
				}, function(res) {
					if (res.success) {
						parent.layer.msg(res.message, {
							icon: 6
						});
						roletable.reload();
						layer.close(index);
					} else {
						parent.layer.msg(res.message, {
							icon: 5
						});
						layer.close(index);
					}
				});
			});
		}

		$(function() {

		});
	</script>
</html>
