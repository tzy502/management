<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>运行服务信息化管理系统</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<p class="f-20 text-success">欢迎使用运行服务信息化管理系统！</p>
	<p id="time" name="time">现在时间是</p>
	<table class="table table-border table-bordered table-bg mt-20 ">
		<thead>
			<tr>
				<th colspan="1" scope="col">信息统计</th>
			</tr>
		</thead>
		<tbody  id = 'tbody-allItem'>
		</tbody>
	</table>
</div>


<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
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
		function startTime()   
		{
			var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
			$("#time").html("    现在时间是"+now);
			setTimeout('startTime()',1000);
		}
		$(document).ready(function (){
			startTime()
			var userId = getCookie("userId");
			var userName = getCookie("userName");
			var params = {
				"userId" : userId,
			}
			$.ajax({  
				 type: "post",    
			        async: true,    
			        url: "/management/loadmain.do",  
			        data: JSON.stringify(params),
			        dataType: "json", 
			        contentType: "application/json; charset=utf-8",   
			        error: function(data){  
			        	alert("出错了！！:"+data.msg);
			        } , 
			        success: function(data) { 	
			        	console.log(data)
			        	var str="";
			        	str += "<tr >";
			        	if(data.newwarning!=0){
			        		str += "<tr >";
			        		str += "<td>有"+data.newwarning+"条数据达到报警（预警）边界</td>";
			        		str+="</tr>";
			        	}
			        	if(data.newmission!=0){
			        		str += "<tr >";
			        		str +="<td>上级布置了："+data.newmission+"个任务</td>";
			        		str+="</tr>";
			        	}
			        	if(data.newautomission!=0){
			        		str += "<tr >";
			        		str +="<td>新增定时新任务数目："+data.newautomission+"</td>";
			        		str+="</tr>";
			        	}	
			        	str += "<tr >";
			        	str +=	"<td>目前还未完成任务数目："+data.unfinish+"</td>";
			        	str+="</tr>";
			        	str += "<tr >"+
			        		"<td>已有"+data.newmessage+"条任务信息被修改，请去任务版查看</td>"+
			        		"</tr>";
			        	$("#tbody-allItem").html(str); 
			        }
			})
				
		})
</script>
</body>

</html>