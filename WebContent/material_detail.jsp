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
		<label class="form-label col-xs-4 col-sm-3">物资名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" readonly="readonly" placeholder="物资名称" id="materialname" name="materialname">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">物资介绍:</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" readonly="readonly" placeholder="物资介绍" id="materialuse" name="materialuse">
		</div>
	</div>
		
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">余额</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" readonly="readonly" readonly="readonly" placeholder="余额" id="materialover" name="materialover">
		</div>
	</div>
	<input type="hidden" id="materialId" name="materialId">

	<div class="mt-15 mb-15">
	<hr/>
	</div>	
	</form>
	<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="9">物资操作记录</th>
				</tr>
				<tr class="text-c">
					<th width="10%">序号</th>
					<th width="25%">时间</th>		
					<th width="45%">操作员</th>
					<th width="20%">操作</th>		
				</tr>
			</thead>
			<tbody id = 'tbody-alldoc'>
			</tbody>
			
		</table>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
function getCookie(Name){
	var search = Name + "="//查询检索的值
	   var returnvalue = "";//返回值
	   if (document.cookie.length > 0) {
	     sd = document.cookie.indexOf(search);
	     if (sd!= -1) {
	        sd += search.length;
	        end = document.cookie.indexOf(";", sd);
	        if (end == -1)
	         end = document.cookie.length;
	         //unescape() 函数可对通过 escape() 编码的字符串进行解码。
	        returnvalue=unescape(document.cookie.substring(sd, end))
	      }
	   } 
	   return returnvalue;
}
function GetRequest() {   
	   var url = location.search; 
	   url=decodeURI(url)
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}
$(document).ready(function (){
	var Request = new Object();
	Request = GetRequest();
	var materialId = Request["materialId"];
	var params={
			"materialId":materialId,
	}
	
	$.ajax({

		type : 'POST',
		url : "/management/SearchMaterial.do",
        data: JSON.stringify(params),
        dataType: "json", 
		async : false,
		processData : false,
		contentType : false,
		success : function(data) {
			$("#materialname").val(data.materialname);
			$("#materialuse").val(data.materialuse);
			$("#materialId").val(data.materialId);
			$("#materialover").val(data.materialover);
		
		},
		error : function(data) {
			console.log(data.msg);
		},
	});
	
	$.ajax({

		type : 'POST',
		url : "/management/loadMaterialMateriallog.do",
        data: JSON.stringify(params),
        dataType: "json", 
		async : false,
		processData : false,
		contentType : false,
		success : function(data) {

	      	var str = "";  
    		for(var i = 0; i < data.length; i++){     	
    			str += "<tr class='text-c'>"+
				"<td>"+(i+1)+"</td>"+
				"<td>"+data[i].date+"</td>"+
				"<td>"+data[i].userId+"</td>"+
				"<td>"+data[i].num+"</td>"+
				"</tr>";
				str+=""   			
    		}
        	$("#tbody-alldoc").html(str); 
		},
		error : function(data) {
			console.log(data.msg);
		},
	});
	
})



</script> 

</body>
</html>