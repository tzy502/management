<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
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
<title>用户评定</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<style type="text/css">
	p 
		{
			text-indent: 30px;
		}
</style>
</head>
<body>
<article class="page-container" id='form-item-add'>
	<div id="title">
		选择年份
		<select class="select" style='width:25%'  size="1"	name="year" id="year">
		
		</select>
		选择时间段
		<select class="select" style='width:25%'  size="1"	name="date" id="date">	
			<option value="-1" >第一季度</option>
			<option value="-2" >第二季度</option>
			<option value="-3" >第三季度</option>
			<option value="-4" >第四季度</option>
			<option value="0" selected>全年</option>
			<option value="1" >一月份</option>
			<option value="2" >二月份</option>
			<option value="3" >三月份</option>
			<option value="4" >四月份</option>
			<option value="5" >五月份</option>
			<option value="6" >六月份</option>
			<option value="7" >七月份</option>
			<option value="8" >八月份</option>
			<option value="9" >九月份</option>
			<option value="10" >十月份</option>
			<option value="11" >十一月份</option>
			<option value="12" >十二月份</option>
		</select>
		<input class="btn btn-primary size-s radius" onclick="assess()" type="button" value="评估">
	</div>
	<div class="mt-15 mb-15">
	<hr/>
	</div>
	<p id="str"></p>
	<div id="assess" style="width: 600px; height: 400px;">
	
	
	</div>
	
	
</article>
<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/echarts.min.js"></script>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css"
		rel="stylesheet" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
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
		      for(var i = 0; i < strs.length; i ++) {   
		         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
		      }   
		   }   
		   return theRequest;   
	}   
	var Request = new Object(); 
	Request = GetRequest(); 
	var userId;
	userId = Request['userId'];
	
	$(document).ready(function (){
		var year=new Date().getFullYear(); //获取当前年份
		var str="";
		for ( var i = year; i >= 2010; i--){
			str+="<option value='"+i+"' >"+i+"</option>";	
		}
		$("#year").html(str); 
		assess()	
	})




	function assess() {

	str="";
	var params = {
			"userId":userId,
			"year":$("#year").val(),
			"date":$("#date").val(),
	}
	//加载数据
	var myChart = echarts.init(document.getElementById('assess'));
	str=""
		$.ajax({    
	        type: "post",    
	        async: false,    
	        url: "/management/AssessUser.do",  
	        dataType: "json", 
	        data:JSON.stringify(params),
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 
	        	$("#str").html(data.str); 
	        	option = {
	        		    title : {
	        		        text: "用户："+data.userName,
	        		    
	        		        x:'center'
	        		    },
	        		    tooltip : {
	        		        trigger: 'item',
	        		        formatter: "{a} <br/>{b} : {c} ({d}%)"
	        		    },
	        		    legend: {
	        		    
	        		        bottom: 10,
	        		        left: 'center',
	        		        data: ['在规定时限内完成','未在规定时限内完成','目前还未完成','目前任务已经超过规定时限还未完成']
	        		    },
	        		    series : [
	        		        {
	        		            name: '任务状态',
	        		            type: 'pie',
	        		            radius : '65%',
	        		            center: ['50%', '50%'],
	        		            selectedMode: 'single',
	        		            data:[
	        		                {value:data.finish, name:'在规定时限内完成'},
	        		                {value:data.unoverfinish, name:'未在规定时限内完成'},
	        		                {value:data.unfinish, name:'目前还未完成'},
	        		                {value:data.overfinish, name:'目前任务已经超过规定时限还未完成'},
	        		            ],
	        		            itemStyle: {
	        		                emphasis: {
	        		                    shadowBlur: 10,
	        		                    shadowOffsetX: 0,
	        		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	        		                }
	        		            }
	        		        }
	        		    ]
	        		};

	        	 myChart.setOption(option); 
	        }     
	    });
	
		
	
	}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>