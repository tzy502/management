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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>文档</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 超标数据列表  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container">	
		<div class="text-c">
			选择时间: <input type="text" style='width: 30%' class="input-text"
				value="" placeholder="开始时间"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
				id="start" name="start"> 到 <input type="text"
				style='width: 30%' class="input-text" value="" placeholder="结束时间"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
				id="end" name="end"> <input class="btn btn-primary radius"
				type="button" onclick="generate()" value="&nbsp;&nbsp;查看&nbsp;&nbsp;">
		</div>
		<div class="mt-5 mb-5">
			<br />
		</div>
	<table class="table table-border table-bordered table-bg" id="table">
		<thead>
			<tr>
				<th scope="col" colspan="9">超标数据列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="200">站点名</th>
				<th width="400">问题数据</th>		
				<th width="120">类型</th>	
				<th width="40">发生时间</th>
			</tr>
		</thead>
		<tbody id = 'tbody-alldoc'>
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
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
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
var end=new Date().Format("yyyy-MM-dd hh:mm:ss");
var start =new Date(new Date()-24*60*60*1000).Format("yyyy-MM-dd hh:mm:ss");//取前一天的时间
	$(document).ready(function (){
		$("#start").val(start);
		$("#end").val(end);
		$('#table').DataTable();
		generate()
		

})
function generate(){
		//加载页面数据
		var table=$('#table').DataTable();
		var params = {
		"end":$("#end").val(),
		"start":$("#start").val(),
			}
		var str = "";  
		$.ajax({    
	        type: "post",    
	        async: false,    
	        url: "/management/loadwarning.do",  
			data: JSON.stringify(params),
			dataType : "json",
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！");
	        } , 
	        success: function(data) { 
	        	for(var i = 0; i < data.length; i++){  
	        		
	        		table.row.add( [
	        			(i+1),
	        			data[i].stationname,
	        			data[i].InfectCode,
	        			data[i].type,
	        			data[i].warningtime,
	                ] ).draw();

		        	
//		        	str += "<tr class='text-c'>"+
	//				"<td>"+(i+1)+"</td>"+
		//			"<td>"+data[i].stationname+"</td>"+
			//		"<td>"+data[i].InfectCode+"</td>"+
				//	"<td>"+data[i].type+"</td>"+
				//	"<td>"+data[i].warningtime+"</td>"+
				//	"</tr>";
				//	str+="";
		
	        	}
	//        	$("#tbody-alldoc").html(str);  

	        	
	        }     
	    });
	}
function add(title,url,w,h){
	layer_show(title,url,w,h);
	
}
	</script>
</body>
</html>