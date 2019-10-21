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
		<title>菜单新增</title>
		<!-- 引入公用的js和css 11--start -->
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<!-- 引入公用的js和css --end -->
	</head>
	<body>
		<form class="layui-form" lay-filter="form" style="margin-top: 15px;" id="form">
			<input type="text" name="id" style="display: none;">

			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 15%;">角色代码：</label>
				<div class="layui-input-block">
					<input type="text" name="code" id="code" lay-verify="code" style="width: 80%;" autocomplete="off" placeholder="请输入"
					 class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">角色名称：</label>
				<div class="layui-input-block">
					<input type="text" name="name" id="name" lay-verify="name" style="width: 80%;" autocomplete="off" placeholder="请输入"
					 class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">描述：</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" id="notes" name="notes" style="width: 80%;" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item" style="margin-left: 43%; position: absolute;">
				<div class="layui-input-inline">
					<button class="layui-btn" lay-submit="" lay-filter="save">确定</button>
					<button type="reset" id="cancel" class="layui-btn layui-btn-danger">取消</button>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		var option = "";
		var form ;

		function setData(data) {
			layui.use(['table', 'form'], function() {
				form = layui.form;
				form.render();
				console.log(data);
				option = data.option;
				id = data.id;
				if (option == "edit") {
					$.post("role/findById.do", {
						id: id
					}, function(res) {
						form.val('form', res.data); //iconCls
					});
				}
				
				form.on('submit(save)', function(data) {
					if (option == "view") {
						cancel();
						return;
					}
					var saveData = data.field;
					var url = "";
					if (option == "add") {
						saveData.parent = "-1";
						saveData.level = "0";
						saveData.parent = "-1";
						url = "role/add.do";
					} else if (option == "edit") {
						url = "role/update.do";
					}
					$.post(url, saveData, function(res) {
						if (res.success) {
							parent.layer.msg(res.message, {
								icon: 6
							});
						} else {
							parent.layer.msg(res.message, {
								icon: 5
							});
						}
						cancel();
					});
					return false;
				});
				
				//规则验证
				form.verify({
					menuText: function(value) {
						if (value.length < 1) {
							return '菜单名称不能为空！';
						}
					},
					menuUrl: function(value) {
						if (value.length < 1) {
							return '访问地址不能为空！';
						}
					},
					iconCls: function(value) {
						if (value == "") {
							return '请选择菜单图标！';
						}
					}
				});
			});
			
		}

		// 取消
		function cancel() {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
</html>
