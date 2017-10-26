<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加项目</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container" id = 'form-item-add'>
	<form class="form form-horizontal" id="add" >
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">仪器名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value=""readonly="readonly" placeholder="仪器名称" id="instrumentname" name="instrumentname">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">购买时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" readonly="readonly"value="" placeholder="" onclick="WdatePicker({maxDate:'%y-%M-%d'})",dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					id="buy" name="buy">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">目前状态</label>
				<div class="formControls col-xs-8 col-sm-9"> 
				<span class="select-box">
					<select class="select"  name="status" id="status">
						<option value="1" >正常</option>
						<option value="2">出错</option>
						<option value="3">维修</option>
					</select>
				</span> 
				</div>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第一次使用时间时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" readonly="readonly"value="" placeholder="" onclick="WdatePicker({maxDate:'%y-%M-%d'})",dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					id="first" name="first">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">最后使用时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" readonly="readonly"value="" placeholder="" onclick="WdatePicker({maxDate:'%y-%M-%d'})",dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					id="last" name="last">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">最后校准时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" readonly="readonly"value="" placeholder="" onclick="WdatePicker({maxDate:'%y-%M-%d'})",dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					id="calibration" name="calibration">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">校准周期：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" min="0" class="input-text" value="" readonly="readonly"placeholder="校准周期" id="calibrationcycle" name="calibrationcycle">
		<label >天</label>
		</div>
	</div>
	<input type="hidden" id="instrumentId" name="instrumentId">
<center>
</center>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">

	function GetRequest() {
		var url = location.search;
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for (var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]] = unescape(strs[i]
						.split("=")[1]);
			}
		}
		return theRequest;
	}
	var Request = new Object();
	Request = GetRequest();
	var instrumentId = Request["instrumentId"];
	instrumentId=1
	var params={
			"instrumentId":instrumentId,
	}
		
	$(document).ready(function() {
		$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/management/searchinstrument.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8", 
	        success: function(data) { 	        	
    			var buytime=data.buytime;
    			var lastusetime=data.lastusetime;
    			var calibrationtime=data.calibrationtime;
    			var firstusetime=data.firstusetime;
				buytime=buytime.replace(/00:00:00.0/,"");
				lastusetime=lastusetime.replace(/00:00:00.0/,"");
				calibrationtime=calibrationtime.replace(/00:00:00.0/,"");
				firstusetime=firstusetime.replace(/00:00:00.0/,"");
	        	$("#instrumentname").val(data.instrumentname);
	        	$("#buy").val(buytime);
	        	$("#first").val(firstusetime);
	        	$("#last").val(lastusetime);
	        	$("#calibration").val(calibrationtime);
	        	$("#status").val(data.status);
	        	$("#calibrationcycle").val(data.calibrationcycle);
	         	$("#instrumentId").val(data.instrumentId);
	        	
	        }
	})
	})



	function add(){
	
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
		var form = new FormData(document.getElementById("add"));
		$.ajax({

			type : 'POST',
			url : "/management/modifryinstrument.do",
			data : form,
			async : false,
			processData : false,
			contentType : false,
			success : function(data) {
				layer.msg('已添加!', {
					icon : 1,
					time : 15000
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.$('.btn-refresh').click();
				parent.layer.close(index);
			},
			error : function(data) {
				console.log(data.msg);
			},
		});

	}
</script> 

</body>
</html>