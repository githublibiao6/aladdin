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
    <table class="layui-table" lay-filter="admintable" id="admintable"  style="margin-top: 0;"></table>
</body>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
    <button class="layui-btn layui-btn-normal" lay-event="add"><i class="layui-icon">&#xe654;</i>新增</button>
    <button class="layui-btn layui-btn-warm" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn layui-btn-danger" lay-event="remove"><i class="layui-icon">&#xe640;</i>删除</button>
    </div>
</script>
<script type="text/javascript">
    var admintable;

    layui.use(['table','form'], function() {
        var table = layui.table;
		var form = layui.form;
        var layer = layui.layer;
        var admintable = table.render({
            elem: '#admintable'
            ,toolbar:"#toolbar"
            ,height: "full-40"
            ,url: 'admin/pagelist.do' //数据接口
            ,page: true //开启分页
            ,cols: [
                [ //表头
                {type:'radio'},
                 {field: 'loginName', title: '管理员' }
				,{field: 'notes', title: '备注' }
                ]
            ]
        });
        table.on('toolbar(admintable)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    add();
                    break;
                case 'edit':
                    edit(table,obj);
                    break;
                case 'remove':
                    remove(table,obj);
                    break;
            };
        });
		table.on('row(admintable)', function(obj){
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');//选中行样式
			obj.tr.find('input[lay-type="layTableRadio"]').prop("checked",true);
			var index = obj.tr.data('index')
			var thisData = table.cache.admintable;
			//重置数据单选属性
			layui.each(thisData, function(i, item){
				if(index === i){
					item.LAY_CHECKED = true;
				} else {
					delete item.LAY_CHECKED;
				}
			});
			form.render('radio');
		});
    });

    function add(){
        open("新增","admin/addoreditrender.do","800px","600px",{option:"add"},function(data){
            admintable.reload();
        });
    }
    function edit(table,obj){
        var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		if(data.length <1){
			layer.msg("请选中一条查看！", {icon: 2});
			return;
		}
        open("编辑","admin/addoreditrender.do","800px","600px",{id:data[0].id,option:"edit"},function(data){
			table.reload("admintable");
        });
    }
    function remove(table,obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		if(data.length <1){
			layer.msg("请选中一条查看！", {icon: 2});
			return;
		}
		layer.confirm('是否确认删除?', {icon: 3, title:'提示'}, function(index){
			//do something
			$.post("admin/remove.do", {id:data[0].id}, function(res) {
				if (res.success) {
					parent.layer.msg(res.message, {
						icon: 6
					});
					table.reload("admintable");
					layer.close(index);
				} else {
					parent.layer.msg(res.message, {
						icon: 5
					});
					table.reload("admintable");
					layer.close(index);
				}
			});
		});
    }

    $(function(){

    });
</script>
</html>