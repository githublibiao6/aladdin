var cuurentLayerIndex;

// 常用
function open(title,url,width,height,data,func){
	
	cuurentLayerIndex = top.layer.open({
		type: 2,
		area: [width, height],
		title: title,
		max:true,//修改了lay。js 设置为true时，只显示最大按钮
		maxmin: true, //开启最大化最小化按钮
		content: url,
		// btn: ['确定','关闭2','关闭'],
		// btnAlign: 'c',
		offset:['100'],//弹出位置的设定
		success:function (layero,index){
			var iframeWin = $(layero).find("iframe")[0].contentWindow;
			iframeWin.setData(data);
		},
		// 销毁回调
		end: function(index){
			func();
		},
	}); 
}
// 获取数据
function openGetData(title,url,width,height,data,func){
	var iframeWin = null;
	cuurentLayerIndex = top.layer.open({
		type: 2,
		area: [width, height],
		title: title,
		max:true,//修改了lay。js 设置为true时，只显示最大按钮
		maxmin: true, //开启最大化最小化按钮
		content: url,
		// btn: ['确定','关闭2','关闭'],
		// btnAlign: 'c',
		offset:['100'],//弹出位置的设定
		success:function (layero,index){
			iframeWin = $(layero).find("iframe")[0].contentWindow;
			iframeWin.setData(data);
		},
		// 销毁回调
		end: function(layero,index){
			var  data = iframeWin.getData(data);
			func(data);
		},
	});
}

//元数据管理  添加属性时用到
function openDialogAdd(title,url,width,height){
	
	cuurentLayerIndex = top.layer.open({
		
		type: 2,  
		area: [width, height],
		title: title,
		max:true,//修改了lay。js 设置为true时，只显示最大按钮
		maxmin: true, //开启最大化最小化按钮
		content: url,
		btn: ['确定','关闭'],
		offset:['100'],//弹出位置的设定
		yes:function (index,layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];
			if(iframeWin.submit()){
				top.layer.close(index);
			}
			$("#dictProTable").dataTable().fnDraw(false);
//			id = $(layero).find("iframe")[0].contentWindow.id;
//			alert(id);
//			if(id){
//				reloadSt(id);
//			}
//			$('#propertyTable').submit();
//			$("#dictProTable").dataTable().fnDraw(false);

		},
		cancel: function(index){ 
		}
	}); 
}

//量测添加对比时用到
function openDialogContrast(title,url,width,height){
	
	cuurentLayerIndex = top.layer.open({
		
		type: 2,  
		area: [width, height],
		title: title,
		max:true,//修改了lay。js 设置为true时，只显示最大按钮
		maxmin: true, //开启最大化最小化按钮
		content: url,
		btn: ['确定','关闭'],
		offset:['60px'],//弹出位置的设定
		yes:function (index,layero){
			
			$(layero).find("iframe")[0].contentWindow.check();
			data = $(layero).find("iframe")[0].contentWindow.data;
			if(data == 0){
				top.layer.alert('请选择有效数据', 
						{
						  icon: 2,
						  title:'提示信息'
						});
			}else{
				contrast(data);
				top.layer.close(index);
			}
		},
		cancel: function(index){ 
		},
	}); 
}