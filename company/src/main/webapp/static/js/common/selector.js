/*条件选择相关js*/

var isFirst = true;
//初始化一行
(function($){
	$.fn.initSelectorLine=function(options){
		
		var $selected_all_line=$("<div id='selectedDiv' style='height: auto;margin: 0 0 5px 0;' class='container-fluid'><div id='allcondition' class='allselected'>全部结果:</div></div>");
		if(isFirst){
			$(this).before($selected_all_line);
			isFirst = false;
		}
		var $selector_line=$("<div id='"+options.id+"' class='J_selector_line'></div>");
		//将选中后要执行的方法根据转换为与id关联的全局方法（未找到其他方案，后续考虑优化）
		var selectedMethodName = "selectedMethod_"+options.id;
		window[selectedMethodName] = options.selected;
		var initMethodName = "initMethod_"+options.id;
		window[initMethodName] = options.init;
		$(this).append($selector_line);
		//标题key
		var line_title = createTitle(options.title);
		$selector_line.append(line_title);
		//选项区域value
		var sl_value=createSl_value(options.id,options.letterBrand.isShow);
		$selector_line.append(sl_value);
		//首字母搜索 拼音搜索
		if(options.letterBrand.isShow){
			sl_value.append(createJ_brandLetter(options));
			sl_value.append(createPySearch(options));
		}
		//选项区域
		sl_value.append(createOptionArea(options.id));
		//多选的确定 清除按钮
		sl_value.append(createBtnArea(options));
		//获取数据部分 data或者 dataurl（如果data存在直接使用data）
		if(options.data != null){
			$("#"+options.id).refreshDataByJSON(options);
		}else{
			var queryParam={};
			$("#"+options.id).refreshData(options,queryParam,options.dataUrl);		
		}
		
		if(!options.letterBrand.isShow){
			$("#"+options.id+"_options").removeClass("J_option_content").addClass("J_option_content_all");
		}
		//扩展按钮
		$selector_line.append(createSl_ext(options,options.id));
	};
})(jQuery);
/*确定选择后，已选框内添加已选择的条件*/
function createCondition(names,options){
		var id = options.id;
		$("#"+options.id+"selected").remove();
		var $selected_line=$("<div class='selected_all selectedcondition' id='"+id+"selected'>"+options.title+":<span style='color:red'>"+names+"</span><i></i></div>");
		$('#'+id+'all').addClass("dataselected");
		$selected_line.children('#'+id+'selected i').bind("click",function(){
			$("#"+options.id+"selected").remove();
			$("#"+options.id+"all").click();
		});
		$('#allcondition').bind("click",function(){
			$(".selectedcondition").remove();
			$(".dataselected").click();
		});
		$("#selectedDiv").append($selected_line);
	};

//创建title部分
function createTitle(titleName){
	var $selector_line_title=$("<div class='sl_key'><span>"+titleName+"</span></div>");
	return $selector_line_title;
}
//创建选项区域 包含字母版（可能不包含）、选项部分
function createSl_value(id,isShow){
	var initMethodName = "initMethod_"+id;
	if(isShow){
		var $sl_value = $("<div class='sl_value'></div>");
	}else{
		var $sl_value = $("<div class='sl_value'><div id='"+id+"all' class ='all selected'>全部</div></div>");
		$sl_value.children('#'+id+'all').bind("click",function(){
			$("#"+id+"_options li").removeClass("selected");
			$("#"+id+"all").addClass("selected");
			$("input[name="+id+"_checkbox]").prop("checked",false);
			$('#'+id+'selected i').click();//点击全部时，将上面的已选条件删除
			//queryCondition[id]=null;
			window[initMethodName]();
			//inittable(queryCondition); dataselected
		});
	}
	
	return $sl_value;
}
var isOpen = false;
/*创建 扩展部分 更多、多选按钮*/
function createSl_ext(options,id){
	//var id = '"' + id + '"';
	var $sl_ext = $("<div class='sl_ext'></div>");
	$ext_more = $("<a id='"+id+"_more' class='sl_more' data-status_more='0'>更多<i></i></a>");
	$sl_ext.append($ext_more);
	$ext_more.bind("click",function(){
		if(isOpen){
			$(this).removeClass("opened");
			$(this).html("更多<i></i>");
			$("#"+id+"_options").scrollTop(0);
			if(!options.letterBrand.isShow){
				$("#"+id+"_options").removeClass("J_option_content_more_all").addClass("J_option_content_all");
			}else{
				$("#"+id+"_options").removeClass("J_option_content_more").addClass("J_option_content");
			}
			$(this).data("status_multiple",0);
			isOpen = false;
		}else{
			$(this).addClass("opened");
			$(this).html("收起<i></i>");
			if(!options.letterBrand.isShow){
				$("#"+id+"_options").removeClass("J_option_content_all").addClass("J_option_content_more_all");
			}else{
				$("#"+id+"_options").removeClass("J_option_content").addClass("J_option_content_more");
			}
			isOpen = true;
		}
	});
	if(options.multiple == null || options.multiple == true){
		$ext_multiple = $("<a id="+id+"_multiple class='sl_multiple' data-status_multiple='0'>多选<i></i></a>");
		$sl_ext.append($ext_multiple);
		$ext_multiple.bind("click",function(){
			$("#"+id+"_multiple").css("display","none");
			$("#"+id+"_more").css("display","none");
			if(!options.letterBrand.isShow){
				$("#"+id+"_options").removeClass("J_option_content_all").addClass("J_option_content_more_all");
			}else{
				$("#"+id+"_options").removeClass("J_option_content").addClass("J_option_content_more");
			}
			//按钮区域显示
			$("#"+id+"_btn").show();
			//复选框区域显示
			$("#"+id+"_options").find("li>input").show();
			//给复选框添加选中事件  有选中时确认按钮可用，无选中时，确认按钮不可用
			$("#"+id+"_options li input:checkbox").on('change', function(){
                if($("#"+id+"_options li input:checkbox:checked").val()) {
                	$('#'+id+'_confirm').attr('disabled',false);
                }else{
                	$('#'+id+'_confirm').attr('disabled',true);
                }
                if($(this).prop("checked")){
                	$(this).parent().addClass("selected");
                }else{
                	$(this).parent().removeClass("selected");
                }
            });
			//取消选中状态
			//$("#"+id+"_options li").removeClass("selected");
			//给全部加上选中状态
			$("#"+id+"all").addClass("selected");
			//修改点击方法
			$("#"+id+"_options li").unbind("click");
			$(this).data("status_multiple",1);
			$('#'+id+'_more').addClass("opened");
			$('#'+id+'_more').html("收起<i></i>");
		});
	}
	
	return $sl_ext;
}
/*创建字母版*/
function createJ_brandLetter(options){
	var id = options.id;
	var url = options.dataUrl;
	var $J_brandLetter = $("<div class='J_brandLetter'>");
	var letterArray = new Array("A","B","C","D","E","F","G","H",
			"I","J","K","L","M","N","O","P","Q","R","S","T","U",
			"V","W","X","Y","Z");
	//创建Ul元素
	var $ulElement = $("<ul></ul>");
	//处理ul下的li元素
	var liElement_html = "";
	liElement_html += "<li data-letter='0' class='selected' id='"+id+"all'>全部</li>";
	for(var i=0;i<letterArray.length;i++){
		liElement_html += "<li data-letter='"+letterArray[i]+"'>"+letterArray[i]+"</li>";
	}
	$ulElement.append(liElement_html);
	$J_brandLetter.append($ulElement);
	$ulElement.children("li").bind("click",function(){
		//修改样式
		$(this).addClass("selected").siblings().removeClass('selected');
		var initMethodName = "initMethod_"+id;
		var firstLetter = $(this).data("letter");
		/*var queryParam = {
				firstLetter:firstLetter
			};*/
		if(firstLetter == "0"){
			queryParam = {};
			//queryCondition[id]=null;
			$('#'+id+'selected i').click();//点击全部时，将上面的已选条件删除
			$("#"+id+"_options li").removeClass("selected");
			$("#"+id+"_confirm").prop("disabled",true);
			$("input[name="+id+"_checkbox]").prop("checked",false);
			window[initMethodName]();
			//inittable(queryCondition);
			//var queryParam = {pwrgridId:null};
			//联动刷新 电网下的厂站
			//$("#stId").refreshData(options,queryParam,"/cloudapp/common/getstation.do");
		}else{
			//点击的是字母是，重新请求数据
			var queryCondition = {
				firstLetter:firstLetter
			};
			var dataAreaEle = $("#"+id+"_options");
			//先清空数据
			dataAreaEle.empty();
			$.ajax({
				type:"post",
				url:url,
				data:queryCondition,
				dataType:"json",
				success:function(data){
					//再次清空 避免查询时间久导致的多次结果叠加
					dataAreaEle.empty();
					createOptions(options,id,dataAreaEle,data);
				}
			});
		}
		//执行相应的刷新方法
		//$("#"+id).refreshData(options,queryParam,url);
	});
	return $J_brandLetter;
}
/*创建拼音搜索框*/
var timer;
function queryByInput(options,queryParam,id,url){
	$("#"+id).refreshData(options,queryParam,url);
}
function createPySearch(options){
	var id = options.id;
	var url = options.dataUrl;
	var $search_div = $("<div class='J_search'></div>");
	var $search_input = $("<input type='text' class='input_search' placeholder='拼音搜索'/>");
	$search_div.append($search_input);
	$search_input.bind('input propertychange', function() {
		clearTimeout(timer);
		//延时执行 避免连续输入多次执行
	   	var queryParam = {
	   			keyWord:$(this).val()	
	   	};
	   	timer = setTimeout(function(){queryByInput(options,queryParam,id,url);},500);
	});
	return $search_div;
}
/*创建数据选项区域*/
function createOptionArea(id){
	var $J_option_content = $("<div id='"+id+"_options' class='J_option_content'></div>");
	return $J_option_content;
}
/*创建option选项*/
function createOptions(options,id,element,data){
	
	var $ulElement = $("<ul></ul>");
	//$ulElement.append("<li><input type='checkbox'><span title='唐山电网'>唐山电网</span></li>");
	if(element==null || data == null) return ;
	for(var i=0;i<data.length;i++){
		$ulElement.append("<li id='"+data[i].id+"' data-type='"+id+"'>"+
				"<input name="+id+"_checkbox type='checkbox' style='display:none'/>"+
				"<span title='"+data[i].name+"'>"+data[i].name+"</span></li>");
	}
	if(!options.letterBrand.isShow){
		$("#"+id+"_options").removeClass("J_option_content_more_all").addClass("J_option_content_all");
	}else{
		$("#"+id+"_options").removeClass("J_option_content_more").addClass("J_option_content");
	}
	//把刷新的区域已经选择的条件清除
	$('#'+id+'selected i').click();
	//要刷新的按钮区域隐藏
	$("#"+id+"_btn").hide();
	//更多和多选按键显示
	$("#"+id+"_more").html("更多<i></i>");
	$("#"+id+"_multiple").css("display","block");
	$("#"+id+"_more").css("display","block");
	var selectedMethodName = "selectedMethod_"+id;
	//处理样式变化
	$ulElement.children("li").bind("click",function(){
		$(this).addClass("selected").siblings().removeClass('selected');
		//将选中的checkbox设置为选中状态
		$("input[name="+id+"_checkbox]").prop("checked",false);
		$(this).children("input:checkbox").prop("checked",true);
		//确认按钮设置为可用
		$('#'+id+'_confirm').attr('disabled',false);
		$('#'+id+'all').removeClass('selected');
		window[selectedMethodName]($(this));
		var names = getSelectedNames($(this));//获得所选的名称
		createCondition(names,options);//在指定位置加上所选条件
	});
	element.append($ulElement);
}
/*创建多选时的确认按钮区域*/
function createBtnArea(options){
	var id = options.id;
	var $J_option_btn = $("<div id='"+id+"_btn' class='J_option_btn' style='display:none'></div>");
	$btn_submit = $("<button id='"+id+"_confirm' class='btn btn-info' style='width:80px' disabled='false'>确认</button>");
	$J_option_btn.append($btn_submit);
	$btn_submit.bind("click",function(){
		var selectedMethodName = "selectedMethod_"+id;
		//获取li下checkbox处于选中状态的li
		var selectedLi = $("#"+id+"_options li").has("input:checked");
		window[selectedMethodName](selectedLi);
		var names = getSelectedNames(selectedLi);//获得所选的名称
		createCondition(names,options);//在指定位置加上所选条件
		
	});
	$btn_cancel = $("<button class='btn btn-info' style='width:80px;margin-left:20px'>取消</button>");
	$J_option_btn.append($btn_cancel);
	$btn_cancel.bind("click",function(){
		$("#"+id+"_options").scrollTop(0);
		$("#"+id+"_multiple").css("display","block");
		$("#"+id+"_more").css("display","block");
		if(!options.letterBrand.isShow){
			$("#"+id+"_options").removeClass("J_option_content_more_all").addClass("J_option_content_all");
		}else{
			$("#"+id+"_options").removeClass("J_option_content_more").addClass("J_option_content");
		}
		$("#"+id+"_btn").hide();
		$("#"+id+"_options").find("li>input").hide();
		$("#"+id+"_more").removeClass("opened");
		$("#"+id+"_more").html("更多<i></i>");
		//触发一次全部的点击，
		$("#"+id+"all").click();
		//设置确认按钮不可用
		$('#'+id+'_confirm').attr('disabled',true);
		//将点击框全部取消
		$("#"+id+"_options li input").prop("checked",false);
		//恢复点击事件
		var selectedMethodName = "selectedMethod_"+id;
		$("#"+id+"_options li").bind("click",function(){
			$(this).addClass("selected").siblings().removeClass('selected');
			$('#'+id+'all').removeClass('selected');
			//将选中的checkbox设置为选中状态
			$("input[name="+id+"_checkbox]").prop("checked",false);
			$(this).children("input:checkbox").prop("checked",true);
			//确认按钮设置为可用
			$('#'+id+'_confirm').attr('disabled',false);
			window[selectedMethodName]($(this));
			var names = getSelectedNames($(this));//获得所选的名称
			createCondition(names,options);//在指定位置加上所选条件
		});
		isMore = false;
		isOpen = false;
	});
	return $J_option_btn;
}
/*数据刷新函数 刷新数据更新选项*/
(function($){
	$.fn.refreshData=function(options,queryCondition,url){
		//通过id查找到数据选项区域 
		var id = $(this).attr("id");
		var dataAreaEle = $("#"+id+"_options");
		//先清空数据
		dataAreaEle.empty();
		$.ajax({
			type:"post",
			url:url,
			data:queryCondition,
			dataType:"json",
			success:function(data){
				//再次清空 避免查询时间久导致的多次结果叠加
				dataAreaEle.empty();
				createOptions(options,id,dataAreaEle,data);
			}
		});
	};
})(jQuery);

/*数据刷新函数 刷新数据更新选项*/
(function($){
	$.fn.refreshDataByJSON=function(options){
		//通过id查找到数据选项区域 
		var JSONArray = options.data;
		var id = $(this).attr("id");
		var dataAreaEle = $("#"+id+"_options");
		//先清空数据
		dataAreaEle.empty();		
		createOptions(options,id,dataAreaEle,JSONArray);
	};
})(jQuery);
/*根据选中的对象获取 要查询的字符串 多选id以“-”分割*/
function getSelectedIds(elements){
	if(elements == null || elements.length == 0){
		return "";
	}
	//遍历获取选中对象的id存入array
	var ids = "";//获得选中的id
	for(var i=0;i<elements.length;i++){
		var tmp = elements[i].id;
		ids += tmp;
		if(i != elements.length-1){
			ids += "-";
}
	}
	var names = getSelectedNames(elements);
	return ids;
}
function getSelectedNames(elements){
	if(elements == null || elements.length == 0){
		return "";
	}
	//遍历获取选中对象的id存入array
	var names = "";//获得选中的名称
	for(var i=0;i<elements.length;i++){
		var name = elements[i].innerText;
		names += name;
		if(i != elements.length-1){
			names += "-";
		}
	}
	return names;
}
