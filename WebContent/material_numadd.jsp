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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>文档</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 物资列表  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<article class="page-container" id = 'form-item-add'>
	<form class="form form-horizontal" id="add"	enctype="multipart/form-data">
		<label class="form-label col-xs-4 col-sm-3">物资名称：</label>
		<div class="formControls col-xs-8 col-sm-7">
			<input type="text" class="input-text" value="" readonly="readonly" id="materialname" name="materialname">
		</div>
		<label class="form-label col-xs-4 col-sm-3">物资用处：</label>
		<div class="formControls col-xs-8 col-sm-7">
		<textarea name="" id='materialuse' name="materialuse" cols="" rows=""  readonly="readonly"class="textarea" ></textarea>
		</div>
		<input type="hidden" id="materialId" name="materialId">
		<label class="form-label col-xs-4 col-sm-3">新增数量：</label>
			<div class="formControls col-xs-8 col-sm-7" >
				<input type="number" min="0" class="input-text" value="0" id="materialover" name="materialover">
				<label id="over" class="f-12 c-666"></label>
			</div>
			
				<div class="row cl">
				<div class="form-label col-xs-4 col-sm-3">
					<input class="btn btn-primary radius" type="button" onclick="add()"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">			
				</div>
			</div>
	</form>
	</article>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>

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
			
				$("#over").html("余量："+data.materialover);
			},
			error : function(data) {
				console.log(data.msg);
			},
		});
		
	})
function add(){

		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
		var form = new FormData(document.getElementById("add"));			
		var userId = getCookie("userId");
		form.append("userId",userId)
		$.ajax({
			
			type : 'POST',
			url : "/management/modifryMaterialover.do",
			data : form,
			async : false,
			processData : false,
			contentType : false,
			success : function(data) {
				layer.msg('已添加!', {
					icon : 1,
					time : 15000
				});

			},
			error : function(data) {
				console.log(data.msg);
			},
		});
		var index = parent.layer.getFrameIndex(window.name);
		parent.$('.btn-refresh').click();
		parent.layer.close(index);
	}
	
	
</script>
</body>
</html>