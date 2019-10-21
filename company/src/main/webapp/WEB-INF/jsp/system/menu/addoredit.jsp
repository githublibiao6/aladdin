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
		<form class="layui-form" lay-filter="form" style="margin-top: 15px;">
			<input type="text" name="menuId" style="display: none;">
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 15%;">菜单名称：</label>
				<div class="layui-input-block" >
					<input type="text" name="menuText" lay-verify="menuText" style="width: 80%;" autocomplete="off" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">访问地址：</label>
				<div class="layui-input-block">
					<input type="text" name="url" lay-verify="menuUrl" style="width: 80%;" autocomplete="off" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">图标：</label>
				<div class="layui-input-inline">
					<input type="text" name="iconCls" lay-verify="iconCls" id="iconCls" style="width: 116%;" disabled autocomplete="off" placeholder="请选择" class="layui-input">
				</div>
				<div class="layui-input-inline" style="margin-left: 50px;">
					<a class="layui-btn " onclick="selectIcon()">选择</a>
					<span style="margin-left: 10px;">
						<i id="icon" class="fa fa-edge" aria-hidden="true"></i>
					</span>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">菜单类型：</label>
				<div class="layui-input-inline" >
					<select name="menuType" lay-filter="menuType" style="width: 100%;" lay-verify="menuType">
						<option value="1">菜单</option>
						<option value="2" >按钮</option>
						<option value="3" >tab页</option>
					</select>
				</div>
				<label class="layui-form-label" style="width: 15%;">是否启用：</label>
				<div class="layui-input-inline">
					<select name="effectiveFlag" lay-filter="effectiveFlag" style="width: 100%;" lay-verify="effectiveFlag">
						<option value="1">启用</option>
						<option value="0" >停用</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">说明：</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" id="notes" name="notes" style="width: 80%;" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item" style="margin-left: 43%; position: absolute;bottom: 40px;">
				<div class="layui-input-inline">
					<button class="layui-btn" lay-submit="" lay-filter="save">确定</button>
					<button class="layui-btn layui-btn-danger" onclick="cancel()">取消</button>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		var option = "";
		var form = layui.form;
		form.render();
		function setData(data){
			option = data.option;
			menuId = data.menuId;
			if(option == "edit"){
				$.post("menu/findById.do", {menuId:menuId}, function(res) {
					form.val('form', res.data);//iconCls
					$("#icon").removeClass($("#icon").attr("class")); 
					$("#icon").addClass( res.data.iconCls);
				});
			}
		}
		form.on('submit(save)', function(data) {
			if (option == "view") {
				cancel();
				return;
			}
			var saveData = data.field;
			var url = "";
			if(option == "add"){
				saveData.parent = "-1";
				saveData.level = "0";
				saveData.parent = "-1";
				url = "menu/add.do";
			}else if(option == "edit"){
				url = "menu/update.do";
			}
			$.post(url, saveData, function(res) {
				console.log(res);
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
			}
			,menuUrl: function(value) {
				if (value.length < 1) {
					return '访问地址不能为空！';
				}
			}
			,iconCls: function(value) {
				if (value == "") {
					return '请选择菜单图标！';
				}
			}
		});
		// 选择图标
		function selectIcon(){
			openGetData("选择图标","menu/selecticon.do","800px","600px",{},function(data){
				$("#iconCls").val(data.icon);
				$("#icon").removeClass($("#icon").attr("class")); 
				$("#icon").addClass( data.icon);
			});
		}
		
		// 取消
		function cancel() {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
</html>
