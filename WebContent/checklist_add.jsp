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
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认选择站点名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" class="input-text" value="" readonly="readonly"  placeholder="站点名称" id="stationname" name="stationname">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>文档类型:</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
			<select class="select"  name="type" id="type">
				<option value="1" >废水污染源在线监测设备日常巡检记录表</option>
				<option value="2">刷卡排污总量控制系统维护记录</option>
				<option value="3">刷卡排污总量控制系统维护记录</option>
				<option value="4">刷卡污染源在线监测系统维修记录表</option>
				<option value="5">烟气污染源在线监测设备日常巡检记录表</option>
				<option value="6">烟气污染源在线监测设备校准校验记录表</option>
				<option value="7">在线监测系统实样比对校核记录表（废水）</option>
				<option value="8">在线监测系统实样比对校核记录表（废气）</option>
				<option value="9">设备问题追踪单</option>
			</select>
			</span> </div>
		<center>
		<div class="row cl">
		<div class="form-label col-xs-4 col-sm-3">
			<input class="btn btn-primary radius" type="button" onclick = "add()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</center>
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
		StationId = Request['StationId'];	

	
		stationname = Request['stationname'];	
		$("#stationname").val(stationname);
	})
function add(){
		var Request = new Object(); 
		Request = GetRequest(); 
		StationId = Request['StationId'];	
		$("#StationId").val(StationId);
		stationname = Request['stationname'];	
		$("#stationname").val(stationname);
		var type=document.getElementById("type").value
		var str=""
		switch (type)
		{
		case "1":
			str="water_daily_checklist_add.jsp";
			 break;
		case "2":
			 str="water_check_checklist_add.jsp";
		 break;
		case "3":
			 str="gas_total_pollution_add.jsp";
		 break;
		case "4":
			 str="pollution_maintain_add.jsp";
		 break;
		case "5":
			 str="gas_daily_checklist_add.jsp";
		 break;
		case "6":
			 str="gas_calibration_checklist_add.jsp";
		 break;
		case "7":
			 str="water_monitor_comparison_add.jsp";
		 break;
		case "8":
			 str="gas_monitor_comparison_add.jsp";
		 break;	 
		case "9":
			 str="device_problem_tracking_add.jsp";
		 break;	
		}
		stationname=encodeURIComponent(stationname);
		url=str+"?StationId="+StationId+"&stationname="	+stationname
			
		window.location.href=url
	//	layer_show('文档详情',url,'800','500');

	}
</script> 

</body>
</html>