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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>监测数据</label>
				<select style='width:45%' class="select" size="1"name="infectid" id="infectid">
				

				</select>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>预警下限</label>
		<div class="formControls col-xs-6 col-sm-5">
			<input type="number" class="input-text" value="" placeholder="预警下限" id="minvaule" name="minvaule">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>预警上限</label>
		<div class="formControls col-xs-6 col-sm-5">
			<input type="number" class="input-text" value="" placeholder="预警上限" id="maxvaule" name="maxvaule">
		</div>
	</div>
			<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报警下限</label>
		<div class="formControls col-xs-6 col-sm-5">
			<input type="number" class="input-text" value="" placeholder="报警下限" id="minalarm" name="minalarm">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报警上限</label>
		<div class="formControls col-xs-6 col-sm-5">
			<input type="number" class="input-text" value="" placeholder="报警上限" id="maxalarm" name="maxalarm">
		</div>
	</div>
		<input type="hidden"  id="stationId" name="stationId">


<center>
<div class="row cl">
		<div class="form-label col-xs-4 col-sm-3">
			<input class="btn btn-primary radius" type="button" onclick = "add()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
</center>
	</form>
</article>

<link
		href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css"
		rel="stylesheet" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript" src="lib/select2.min.js"></script>
	<script type="text/javascript" src="lib/select2.min.css"></script>
	<!--/_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	
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


$(document).ready(function() {		
	var Request = new Object();
	Request = GetRequest();
	var stationId = Request['stationId'];
	$("#stationId").val(stationId);

	var params = {
			"stationId" : stationId,
		}
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/loadInfect.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 
	        	var str="<option value='1' selected>请选择</option>";
	        	for(var i=0;i<data.length;i++){
	        		str+="<option value='"+data[i].InfectCode+"' >"+data[i].InfectName+"</option>"
	        	}
	        	
	        	$("#infectid").html(str); 
	        	 $('infectid').select2();
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
	
	minvaule=$("#minvaule").val();
	maxvaule=$("#maxvaule").val();
	maxalarm=$("#maxalarm").val();
	minalarm=$("#minalarm").val();
	if(minvaule>maxvaule||maxalarm<minalarm){
		alert("下线不能超过上线");
	}
	else{
		$.ajax({
			
			type: 'POST',
			url: "/management/addStandard.do", 
			data:form, 
	        async: false,
	        processData:false,
	        contentType:false,
			success: function(data){	
				if(data.msg!=null){
					alert(data.msg);					
				}
				else{layer.msg('已添加!',{icon:1,time:15000});}
		
			},
			error:function(data) {
				alert(data.msg);
				console.log(data.msg);
			},
		});	
		var index = parent.layer.getFrameIndex(window.name);
		layer.msg('已添加!',{icon:1,time:15000});
		console.log("123123213");
		parent.$('.btn-refresh').click();
		parent.layer.close(index);
	}
	
	
	
	
	
	
	


}
</script> 

</body>
</html>