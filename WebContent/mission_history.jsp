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
<title>文档</title>
</head>
<body>
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
	人员信息列表 <a class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			选择时间(任务开始时间): <input type="text" style='width: 30%' class="input-text"
				value="" placeholder="开始时间"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
				id="start" name="start"> 到 <input type="text"
				style='width: 30%' class="input-text" value="" placeholder="结束时间"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
				id="end" name="end"> <input class="btn btn-primary radius"
				type="button" onclick="search()" value="&nbsp;&nbsp;查看&nbsp;&nbsp;">
		</div>
		<div class="mt-5 mb-5">
			<br />
		</div>
		<table class='table table-border table-bordered table-bg'>
			<thead>
				<tr class='text-c'>
					<th width='5%'>编号</th>
					<th width='15%'>负责人</th>
					<th width='30%'>运维任务名</th>
					<th width='20%'>预计结束时间</th>
					<th width='20%'>状态</th>
					<th width='10%'>操作</th>
				</tr>
			</thead>
			<tbody id='tbody-alldoc'>
			</tbody>

		</table>
	</div>

	<!--_footer 作为公共模版分离出去-->
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	Date.prototype.Format = function (fmt) {
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt))
	fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o){
	    if (new RegExp("(" + k + ")").test(fmt)) {
	fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	}
	    }
	    return fmt;
	}
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
	$('body').on('click','#update',function(event){
		layer_show('运维任务修改','mission_modifry.jsp?missionId='+this.name,'800','500');
	}); 
	$('body').on('click','#detail',function(event){	
		layer_show('运维任务详情','mission_detail.jsp?missionId='+this.name,'800','500');
	}); 
	$('body').on('click','#delete',function(event){
		var missionId = this.name;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"missionId":missionId,
			}
			$.ajax({
				type: 'POST',
				url: "/management/delMission.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
					layer.msg('删除失败!',{icon:1,time:15000});
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.href = 'mission_list.jsp';
				},
			});		
		});
	});

	var Request = new Object();
	Request = GetRequest();
	var stationid = Request['StationId'];
	
	$(document).ready(function (){
		$("#start").val("");
		$("#end").val("");
		search()
	})
		
		function search(){

		//加载页面数据
		
		var params = {
				"StationId" : stationid,
				"end":$("#end").val(),
				"start":$("#start").val(),
			}
		console.log(params)
		$.ajax({    
		    type: "post",    
		    async: false,    
		    url: "/management/loadStationMission.do",  
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
		    error: function(data){  
		    	alert("出错了！！:"+data.msg);
		    } , 
		    success: function(data) { 
		    	var str = "";  
				for(var i = 0; i < data.length; i++){     			
					str+="<tr class='text-c'>"+
					"<td>"+(i+1)+"</td>"+
					"<td>"+data[i].username+"</td>"+
					"<td>"+data[i].missionname+"</td>"+
					"<td>"+data[i].enddate+"</td>"+
					"<td>"+data[i].statusname+"</td>"+
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'detail' href='javascript:;' name='"+data[i].Missionid+"'>"+
						"<i class='Hui-iconfont'>&#xe720;</i>"+
					"</a>"+
						"<a style='text-decoration:none' id = 'update' href='javascript:;' name='"+data[i].Missionid+"'>"+
						"<i class='Hui-iconfont'>&#xe6df;</i>"+
					"</a>"+
						"<a style='text-decoration:none' id = 'delete' href='javascript:;' name='"+data[i].Missionid+"'>"+
							"<i class='Hui-iconfont'>&#xe6e2;</i>"+
						"</a>"+
						"</td>"
		
					+"</tr>"
				
				}
		    	$("#tbody-alldoc").html(str);  		    	 
		    }     
		});
		}
	
function add(title,url,w,h){
	layer_show(title,url,w,h);
	
}
	</script>
</body>
</html>