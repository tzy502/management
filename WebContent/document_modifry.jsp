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
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加汇总单</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container" id = 'form-item-add'>
<form id="upload"  method="post" enctype="multipart/form-data">  
<input type="hidden" id="documentid">
<input type="hidden" id="path">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>文档名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value=""  placeholder="文档名称" id="documentname" name="documentname">
		</div>
	</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>观看文档 等级：</label>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
					<select class="select" size="1" name="level" id="level">
						<option value="1" >1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5"selected>5</option>
					</select>
					</span> </div>
					</div>
					<div class="row cl">

</div>

	<center>
		<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-2">
			<input class="btn btn-primary radius" type="button" onclick = "add()" value="&nbsp;&nbsp;修改&nbsp;&nbsp;">	
		</div>
	</div>
	</center>
	
	</from>
	

</article>


<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">
var j = 0;
function GetRequest() {   
	   var url = location.search; 
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

function add(){
	var form = new FormData(document.getElementById("upload"));
	$.ajax({
        cache: true,
        type: "POST",
        url:"/management/modirfyDocument.do",
        data:form,  // 你的formid
        async: false,
        processData:false,
        contentType:false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	layer.msg('已添加!',{icon:1,time:15000});
        }
    });
	var index = parent.layer.getFrameIndex(window.name);
	layer.msg('已添加!',{icon:1,time:15000});
	console.log("123123213");
	parent.$('.btn-refresh').click();
	parent.layer.close(index);
}
var Request = new Object(); 
Request = GetRequest(); 
var documentid =Request['documentid']; 

$(function(){ 
	var documentid =Request['documentid']; 

	var params={
			"documentid": documentid
	}
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/SearchDoc.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！");
	        } , 
	        success: function(data) { 	        	
	        	$("#documentname").val(data.documentname);
	        	$("#level").val(data.level);
	        	$("#documentid").val(data.documentid);
	        	$("#path").val(data.path);
	        }
		
	}
	)

}
)







function article_save(){
	alert("刷新父级的时候会自动关闭弹层。")
	window.parent.location.reload();
}


</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>