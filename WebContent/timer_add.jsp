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
						<input class="btn btn-primary radius" type="button" onClick="modaldemo()"
						value="&nbsp;&nbsp;使用指南&nbsp;&nbsp;">
		<form class="form form-horizontal" id="add"	enctype="multipart/form-data">
		<div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>任务名</label>
		<input type="text" style='width:40%' class="input-text" value="" placeholder="" 
					id="timername" name="timername">
		</div>
		<br/>
		<div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>定时类型</label>
		<select  style='width:40%' class="select" size="1" name="timer" id="timer">
			<option value="1" >每日</option>
			<option value="2" >每周</option>
			<option value="3" >每月</option>
		</select>
		</div>
			<br/>
			<div>
	<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开始时间</label>
		<input type="text" style='width:40%' class="input-text" value="" placeholder="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
		id="start" name="start">
	</div>
		<br/>
		<div>
		<label class="form-label col-xs-6 col-sm-3"><span class="c-red">*</span>任务描述</label>	
		<textarea name="timerdescription" id='timerdescription' style='width:60%' cols="" rows="" class="textarea" ></textarea>		
</div>

			<div class="row cl">
				<div class="form-label col-xs-4 col-sm-3">
					<input class="btn btn-primary radius" type="button" onclick="add()"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
						

					
				</div>
			</div>
			
			<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content radius">
						<div class="modal-header">
							<h3 class="modal-title">使用指南</h3>
							<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
						</div>
						<div class="modal-body">
							<p><b><font size="4">用处:</font></b></p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;定时任务将按预先设定的对检测站相关负责人布置任务</p>
							<p><b><font size="4">类型:</font></b></p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;每日：在每天早上六点的时候将会布置任务</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;每周：在每周周一早上六点的时候将会布置任务</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;每月：在每月一号早上六点的时候将会布置任务</p>
							<p><b><font size="4">起始时间:</font></b></p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;任务会在起始时间后才开始计算
							<br/>&nbsp;&nbsp;&nbsp;&nbsp;例如：新建每日任务会在开始时间后的下一个早上六点进行布置。</p>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						</div>
					</div>
				</div>
			</div>
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
	var j = 0;
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
	Date.prototype.Format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"S" : this.getMilliseconds()
		//毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(fmt)) {
				fmt = fmt.replace(RegExp.$1,
						(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
								.substr(("" + o[k]).length)));
			}
		}
		return fmt;
	}		

	function modaldemo(){
		$("#modal-demo").modal("show")}
		function add() {

			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			var form = new FormData(document.getElementById("add"));	
			console.log(form)
			var Request = new Object(); 
			Request = GetRequest(); 
			StationId = Request['StationId'];	
	
			form.append("stationId",StationId)

			$.ajax({

				type : 'POST',
				url : "/management/addtimer.do",
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
		function role(title,url,w,h){
			layer_show(title,url,w,h);
			
		}
	</script>

</body>
</html>