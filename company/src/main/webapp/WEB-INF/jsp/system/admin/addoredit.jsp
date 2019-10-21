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
		<title>管理员</title>
		<!-- 引入公用的js和css 11--start -->
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<!-- 引入公用的js和css --end -->
	</head>
	<body>
		<form class="layui-form" lay-filter="form" style="margin-top: 15px;">
			<input type="text" name="id" style="display: none;">
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 15%;">管理员：</label>
				<div class="layui-input-block" >
					<input type="text" name="loginName" lay-verify="loginName" style="width: 80%;" autocomplete="off" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label" style="width: 15%;">备注：</label>
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
		var $;
		function setData(data){
			option = data.option;
			id = data.id;
			layui.use(['form'], function() {
				var form = layui.form;
				$ = layui.jquery;
				form.render();
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
						url = "admin/add.do";
					}else if(option == "edit"){
						url = "admin/update.do";
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
					loginName: function(value) {
						if (value.length < 1) {
							return '管理员账号不能为空！';
						}
					}
				});
				if(option == "edit"){
					$.post("admin/findById.do", {id:id}, function(res) {
						form.val('form', res.data);//iconCls
						$("#icon").removeClass($("#icon").attr("class"));
						$("#icon").addClass( res.data.iconCls);
					});
				}
			});

		}

		// 取消
		function cancel() {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
</html>
