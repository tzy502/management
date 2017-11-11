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
	<form class="form form-horizontal" id="add"	enctype="multipart/form-data">
		<label class="form-label col-xs-4 col-sm-3">任务名</label>
		<input type="text" style='width:40%' readonly="readonly" class="input-text" value="" placeholder="" 
					id="missionname" name="missionname">
		<br/>
		<label class="form-label col-xs-4 col-sm-3">负责人</label>
			<input type="text" style='width:40%'  readonly="readonly" class="input-text" value="" placeholder="" 
				id="username" name="username">
			<br/>
		<label class="form-label col-xs-4 col-sm-3">预计结束时间</label>
		<input type="text" style='width:40%'  readonly="readonly" class="input-text" value="" placeholder="" 
					id="end" name="end">
		<br/>
		<label class="form-label col-xs-4 col-sm-3">状态</label>
			<input type="text" style='width:40%'  readonly="readonly" class="input-text" value="" placeholder="" 
				id="staus" name="staus">
			<br/>
		<label class="form-label col-xs-4 col-sm-3">任务描述</label>	
		<textarea name="description" id='description'  readonly="readonly" style='width:60%' cols="" rows="" class="textarea" ></textarea>	

	</form>
		<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-2">
			<input class="btn btn-primary radius" id="over" type="button" onclick = "add()" value="&nbsp;&nbsp;完成&nbsp;&nbsp;">	
		</div>
	</div>
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
	 <span class="l">
		 <a href="javascript:;" onclick="role('运维日志添加','missionlog_add.jsp','400','350')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 运维日志添加</a>
	 </span>  
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">运维日志</th>
			</tr>
			<tr class="text-c">
				<th width="10%">序号</th>
				<th width="15%">操作员</th>	
				<th width="25%">运维时间</th>	
				<th width="35%">详情</th>
				<th width="15%">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-log'>
		</tbody>		
	</table>
	</article>

	<!--_footer 作为公共模版分离出去-->

	
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
	
	$(document).ready(function() {	
		var Request = new Object();
		Request = GetRequest();
		var missionId = Request['missionId'];
		
		var params = {
			"missionId" : missionId,
			
		}
		var level =getCookie("level");
		if(level!=1){
			$.ajax({  
				 type: "post",    
			        async: true,    
			        url: "/management/viewMission.do",  
			        data: JSON.stringify(params),
			        dataType: "json", 
			        contentType: "application/json; charset=utf-8",   
			        error: function(data){  
			        	alert("出错了！！:"+data.msg);
			        } , 
			        success: function(data) { 
						console.log("ok") 	
			        }
				})
		}
		
		$.ajax({  
			 type: "post",    
		        async: true,    
		        url: "/management/searchMission.do",  
		        data: JSON.stringify(params),
		        dataType: "json", 
		        contentType: "application/json; charset=utf-8",   
		        error: function(data){  
		        	alert("出错了！！:"+data.msg);
		        } , 
		        success: function(data) { 
		        	$("#missionname").val(data.missionname);
		        	$("#end").val(data.enddate);
		        	$("#username").val(data.username);
		        	$("#description").val(data.description);
		        	$("#staus").val(data.statusname);   
						if(data.status==6||data.status==3){
							$("#over").css("display","none");
						}
						
		        	}	        
			})
			$('body').on('click','#delete',function(event){
			var missionlogId = this.name;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"missionlogId":missionlogId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delmissionlog.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
						layer.msg('删除失败!',{icon:1,time:15000});
						window.location.reload()
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						window.location.reload()
					},
				});		
			})
			})
			$('body').on('click','#update',function(event){
				layer_show('运维任务编辑','missionlog_modifry.jsp?missionlogId='+this.name,'500','450');
			}); 
			$('body').on('click','#detail',function(event){
				layer_show('运维任务详情','missionlog_detail.jsp?missionlogId='+this.name,'500','450');
			});
			$.ajax({  
				 type: "post",    
			        async: true,    
			        url: "/management/loadAllmissionlog.do",  
			        data: JSON.stringify(params),
			        dataType: "json", 
			        contentType: "application/json; charset=utf-8",   
			        error: function(data){  
			        	alert("出错了！！:"+data.msg);
			        } , 
			        success: function(data) { 
			        	var str = "";  
			    		for(var i = 0; i < data.length; i++){     	
			       			str += "<tr class='text-c'>"+
							"<td>"+(i+1)+"</td>"+
							"<td>"+data[i].user+"</td>"+
							"<td>"+data[i].missionlogtime+"</td>"+
							"<td>"+data[i].missionlogdetail+"</td>"+
							
							"<td class='td-manage'>"+
							"<a style='text-decoration:none' id = 'detail' href='javascript:;'	title=\"详情\" name='"+data[i].missionlogId+"'>"+
							"<i class='Hui-iconfont'>&#xe720;</i>"+
							"</a>"+
							"<a style='text-decoration:none' id = 'update' href='javascript:;' title=\"编辑\" name='"+data[i].missionlogId+"'>"+
							"<i class='Hui-iconfont'>&#xe6df;</i>"+
						"</a>"+
							"<a style='text-decoration:none' id = 'delete' href='javascript:;' title=\"删除 \"name='"+data[i].missionlogId+"'>"+
								"<i class='Hui-iconfont'>&#xe6e2;</i>"+
							"</a>"+

							
							"</td>"
							"</tr>";
							str+=""			
			    		} 	
			    		$("#tbody-log").html(str); 
					}//
			})
			
			
			
		})
		function add(){
			var Request = new Object();
			Request = GetRequest();
			var missionId = Request['missionId'];
		
			var userId = getCookie("userId");
			var params = {
				"missionId" : missionId,
				"userId":userId,
			}
			$.ajax({  
				 type: "post",    
			        async: true,    
			        url: "/management/endMission.do",  
			        data: JSON.stringify(params),
			        dataType: "json", 
			        contentType: "application/json; charset=utf-8",   
			        error: function(data){  
			        	alert("出错了！！:"+data.msg);
			        } , 
			        success: function(data) { 
						layer.msg('已更新!',{icon:1,time:15000});
						window.location.reload()
			        }
				})
			
		}
		function role(title,url,w,h){
			var Request = new Object();
			Request = GetRequest();
			var missionId = Request['missionId'];
			url+="?missionId="+missionId
		
			layer_show(title,url,w,h);
			
		}
	</script>

</body>
</html>