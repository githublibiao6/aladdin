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
			<div class="layui-col-md7">
				<table class="layui-table" lay-filter="menutable" id="menutable" style=""></table>
			</div>
			<div class="layui-col-md5 layui-card" style="margin-top: 10px;">
				<button class="layui-btn layui-btn-normal" onclick="add()" style="margin-left: 5px"><i class="layui-icon">&#xe654;</i>新增</button>
				<button class="layui-btn layui-btn-normal" onclick="addSon()"><i class="layui-icon">&#xe654;</i>新增子节点</button>
				<!-- <button class="layui-btn layui-btn-warm" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</button> -->
				<button class="layui-btn layui-btn-danger" onclick="remove()"><i class="layui-icon">&#xe640;</i>删除</button>
				<form class="layui-form" lay-filter="form" style="margin-top: 15px;" id="form">
					<input type="text" name="menuId" style="display: none;">
					<input type="text" name="parent" id="parent" style="display: none;">
					<div class="layui-form-item">
						<label class="layui-form-label" style="width: 15%;">层级：</label>
						<div class="layui-input-block">
							<input type="text" name="level" id="level" disabled="disabled" style="width: 80%;" autocomplete="off" placeholder="请输入"
							 class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label" style="width: 15%;">菜单名称：</label>
						<div class="layui-input-block">
							<input type="text" name="menuText" id="menuText" lay-verify="menuText" style="width: 80%;" autocomplete="off" placeholder="请输入"
							 class="layui-input">
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label" style="width: 15%;">访问地址：</label>
						<div class="layui-input-block">
							<input type="text" name="url" lay-verify="menuUrl" style="width: 80%;" autocomplete="off" placeholder="请输入"
							 class="layui-input">
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label" style="width: 15%;">图标：</label>
						<div class="layui-input-inline">
							<input type="text" name="iconCls" lay-verify="iconCls" id="iconCls" style="width: 116%;" disabled autocomplete="off"
							 placeholder="请选择" class="layui-input">
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
						<div class="layui-input-inline">
							<select name="menuType" lay-filter="menuType" style="width: 100%;" lay-verify="menuType">
								<option value="1">菜单</option>
								<option value="2">按钮</option>
								<option value="3">tab页</option>
							</select>
						</div>
						<label class="layui-form-label" style="width: 15%;">是否启用：</label>
						<div class="layui-input-inline">
							<select name="effectiveFlag" lay-filter="effectiveFlag" style="width: 100%;" lay-verify="effectiveFlag">
								<option value="1">启用</option>
								<option value="0">停用</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label" style="width: 15%;">说明：</label>
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
			</div>
		</div>
	</body>
	<script type="text/javascript">
		var layer;
		var menutable;
		var treeTable;
		var form;
		var $;
		var option = "";
		var id = null;
		var level = null;
		layui.config({
			base: '${pageContext.request.contextPath}/static/plugins/layui/lay/extend/treetable/',
		})
		layui.use(['table', 'form', 'treeTable'], function() {
			layer = layui.layer;
			var table = layui.table;
			form = layui.form;
			treeTable = layui.treeTable;
			$ = layui.jquery;
			menutable = treeTable.render({
				elem: '#menutable',
				toolbar: "#toolbar",
				height: "full-40",
				url: 'menu/pagelist.do' //数据接口
					,
				is_checkbox: false,
				icon_key: 'menuText',
				primary_key: 'menuId',
				parent_key: 'parent',
				title: 'menuText',
				top_value: -1
					// ,page: true //开启分页
					,
				cols: [{
						key: 'menuText',
						title: '菜单名称',
						width: '100px',
						align: 'center',
					},
					{
						key: 'url',
						title: '地址',
						width: '100px',
						align: 'center',
					}, {
						key: 'notes',
						title: '备注',
						width: '100px',
						align: 'center',
					}, {
						key: 'iconCls',
						title: '图标',
						width: '100px',
						align: 'center',
					}, {
						key: 'menu_type',
						title: '类型',
						width: '100px',
						align: 'center',
					}
				]
			});
			/* table.on('toolbar(menutable)', function(obj) {
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
			}); */
			/* table.on('row(menutable)', function(obj) {
				obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click'); //选中行样式
				obj.tr.find('input[lay-type="layTableRadio"]').prop("checked", true);
				var index = obj.tr.data('index')
				var thisData = table.cache.menutable;
				//重置数据单选属性
				layui.each(thisData, function(i, item) {
					if (index === i) {
						item.LAY_CHECKED = true;
					} else {
						delete item.LAY_CHECKED;
					}
				});
				form.render('radio');
			}); */
			
			form.on('submit(save)', function(data) {
				if (option == "view") {
					return;
				}
				var saveData = data.field;
				saveData.level = $("#level").val();
				var url = "";
				if(option == "add"){
					url = "menu/add.do";
				}else if(option == "edit"){
					url = "menu/update.do";
				}
				$.post(url, saveData, function(res) {
					if (res.success) {
						parent.layer.msg(res.message, {
							icon: 6
						});
						treeTable.render(menutable);
					} else {
						parent.layer.msg(res.message, {
							icon: 5
						});
					}
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
			$(document).on("click","table tbody tr",function(e){
				option = "edit";
				$(this).addClass("selected").siblings().removeClass("selected");
				id = $(this).attr("data-id");
				$.post("menu/findById.do", {menuId:id}, function(res) {
					form.val('form', res.data);//iconCls
					level = res.data.level;
					$("#icon").removeClass($("#icon").attr("class")); 
					$("#icon").addClass( res.data.iconCls);
				});
			});
			
		});
		
		// 选择图标
		function selectIcon(){
			openGetData("选择图标","menu/selecticon.do","800px","600px",{},function(data){
				$("#iconCls").val(data.icon);
				$("#icon").removeClass($("#icon").attr("class")); 
				$("#icon").addClass( data.icon);
				form.render();
			});
		}

		function add() {
			option = "add";
			form.val("");
			$("#cancel").click();
			$("#parent").val("-1");
			$("#level").val("0");
			/* open("新增", "menu/addoreditrender.do", "800px", "600px", {
				option: "add"
			}, function(data) {
				menutable.reload();
			}); */
		}
		
		function addSon() {
			if(id == null){
				layer.msg("请选中一条查看！", {
					icon: 2
				});
				return;
			}
			option = "add";
			$("#cancel").click();
			$("#parent").val(id);
			level = parseInt(level)+1;
			$("#level").val(level);
			form.val('form', {"parent":id,"menuText":""});//iconCls
			form.render();
			/* open("新增", "menu/addoreditrender.do", "800px", "600px", {
				option: "add"
			}, function(data) {
				menutable.reload();
			}); */
		}

		/* function edit(table, obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			var data = checkStatus.data;
			if (data.length < 1) {
				layer.msg("请选中一条查看！", {
					icon: 2
				});
				return;
			}
			open("编辑", "menu/addoreditrender.do", "800px", "600px", {
				menuId: data[0].menuId,
				option: "edit"
			}, function(data) {
				menutable.reload();
			});
		}
 */
		function remove(table, obj) {
			if(id == null){
				layer.msg("请选中一条查看！", {
					icon: 2
				});
				return;
			}
			/* if (data.length < 1) {
				layer.msg("请选中一条查看！", {
					icon: 2
				});
				return;
			} */
			var index =layer.confirm('是否确认删除?', {
				icon: 3,
				title: '提示'
			}, function(index) {
				//do something
				$.post("menu/remove.do", {
					menuId: id
				}, function(res) {
					if (res.success) {
						parent.layer.msg(res.message, {
							icon: 6
						});
						treeTable.render(menutable);
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
