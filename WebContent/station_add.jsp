<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加项目</title>
<meta name="keywords"
	content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="page-container" id='form-item-add'>
	<form class="form form-horizontal" id="add"
		enctype="multipart/form-data">

		<table class="table table-border table-bordered">
			<tr>
				<th width='13%'>所属公司名称</th>
				<td width='20%'><select class="select" size="1"
					name="companyid" id="companyid">
						<option value="-1" selected>请选择</option>

				</select></td>
				<th width='13%'>负责人</th>
				<td width='20%'><select class="select" size="1"
					name="principal" id="principal">
					<option value="-1" selected>请选择</option>
				</select></td>

				<th width='13%'></th>
				<td width='20%'></td>

			</tr>
			<tr>
				<th width='13%'>站点名称</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="stationname"
					name="stationname"></td>
				<th width='13%'>站点类型</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="type" name="type"></td>

				<th width='13%'>所在地区</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="city" name="city">市
					<input type="text" class="input-text formControls" value=""
					id="area" name="area">区</td>

			</tr>
			<tr>
				<th width='13%'>行政区代码</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="areaid" name="areaid"></td>
				<th width='13%'>站位编码A</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="codeA" name="codeA"></td>

				<th width='13%'>站位编码B</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="codeB" name="codeB"></td>
			</tr>

			<tr>
				<th width='13%'>控制级别</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="level" name="level"></td>
				<th width='13%'>行业</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="industry"
					name="industry"></td>
				<th width='13%'>排放去向</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="togo" name="togo"></td>
			</tr>
			<tr>
				<th width='13%'>纳污区域</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="pollution"
					name="pollution"></td>
				<th width='13%'>排放模式</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="model" name="model"></td>

				<th width='13%'>运维单位</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="unit" name="unit"></td>
			</tr>
			<tr>
				<th width='13%'>站点现状</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="status" name="status"></td>
				<th width='13%'>监管部门</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="regulatoryauthorities"
					name="regulatoryauthorities"></td>

				<th width='13%'>经度</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="longitude"
					name="longitude"></td>
			</tr>
			<tr>
				<th width='13%'>纬度</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="latitude"
					name="latitude"></td>
				<th width='13%'>详细地址</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="address"
					name="address"></td>

				<th width='13%'>设计处理能力</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="ability"
					name="ability"></td>
			</tr>
			<tr>
				<th width='13%'>验收验收时间</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="acceptance"
					name="acceptance"></td>
				<th width='13%'>是否监督考核</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" id="assessment"
					name="assessment"></td>


			</tr>
		</table>

		<center>
			<div class="row cl">
				<div class="form-label col-xs-4 col-sm-3">
					<input class="btn btn-primary radius" type="button" onclick="add()"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</center>
	</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
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
	
	$(document).ready(function() {		
		$.ajax({  
			 type: "post",    
		        async: true,    
		        url: "/management/loadAllCompany.do",  
		        //data: JSON.stringify(params),
		        dataType: "json", 
		        contentType: "application/json; charset=utf-8",   
		        error: function(data){  
		        	alert("出错了！！:"+data.msg);
		        } , 
		        success: function(data) { 
		        	var str="<option value='1' selected>请选择</option>";
		        	for(var i=0;i<data.length;i++){
		        		str+="<option value='"+data[i].companyId+"' >"+data[i].companyname+"</option>"
		        	}
		        	alert(str);
		        	$("#companyid").html(str); 
		        }
	})
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/loadAllUser.do",  
	        //data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 
	        	var str="<option value='1' selected>请选择</option>";
	        	for(var i=0;i<data.length;i++){
	        		str+="<option value='"+data[i].userId+"' >"+data[i].userName+"</option>"
	        	}
	        	alert(str);
	        	$("#principal").html(str); 
	        }
})
		$('companyid').select2();
		$('select').select2();
		//
	
})
		
		function add() {
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			var form = new FormData(document.getElementById("add"));
			$.ajax({

				type : 'POST',
				url : "/management/addStation.do",
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
			layer.msg('已添加!', {
				icon : 1,
				time : 15000
			});
			console.log("123123213");
			parent.$('.btn-refresh').click();
			parent.layer.close(index);

		}
		function role(title,url,w,h){
			layer_show(title,url,w,h);
			
		}
	</script>

</body>
</html>