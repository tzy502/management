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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车牌：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" readonly="readonly" placeholder="车牌" id="carId" name="carId">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>使用人：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="使用人" id="caruseuser" name="caruseuser">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>起始地点：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value=""  placeholder="起始地点" id="begin" name="begin">
		</div>
	</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>结束地点：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value=""  placeholder="结束地点" id="end" name="end">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开始时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text"  class="input-text" value="" placeholder="开始时间" 
			id="begintime1" name="begintime1">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>结束时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text"  class="input-text" value="" placeholder="结束时间" 
			id="endtime1" name="endtime1">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<textarea  id='remark' name='remark' cols="" rows="" class="textarea" ></textarea>	
	
		</div>
	</div>
	<input type="hidden" id="caruseId" name="caruseId">
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"	src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
var caruseId = Request["caruseId"];
var params = {
	"caruseId" : caruseId,
}
$(document).ready(function() {
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/searchcaruse.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！");
	        } , 
	        success: function(data) { 
    			var begintime=data.begintime;
    			begintime=begintime.replace(/ 00:00:00.0/,"");
    			if(data.endtime!=null){
    				var endtime=data.endtime;
    				endtime=endtime.replace(/ 00:00:00.0/,"");
    				$("#endtime1").val(endtime); 
    			}
	        	$("#carId").val(data.carId);
	        	$("#caruseuser").val(data.caruseuser);
	        	$("#username").val(data.username);
	        	$("#begintime1").val(begintime);
	        	$("#caruseId").val(data.caruseId);
	        	$("#begin").val(data.begin);
	        	$("#end").val(data.end);
	        	$("#remark").val(data.remark);
	     
	        }
		})
		

})


function add(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	var form = new FormData(document.getElementById("add"));

$.ajax({
		
		type: 'POST',
		url: "/management/modifrycaruse.do", 
		data:form, 
        async: false,
        processData:false,
        contentType:false,
		success: function(data){
			layer.msg('已添加!',{icon:1,time:15000});
			
		},
		error:function(data) {
			console.log(data.msg);
		},
	});	
	
	
	
	
	
		var index = parent.layer.getFrameIndex(window.name);
		layer.msg('已添加!',{icon:1,time:15000});
		console.log("123123213");
		parent.$('.btn-refresh').click();
		parent.layer.close(index);

}
</script> 

</body>
</html>