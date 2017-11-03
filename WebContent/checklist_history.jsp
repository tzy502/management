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
<title>文档</title>
</head>
<body>
<div class="page-container">	
	
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9" id="name">档案列表</th>
			</tr>
				<tr class='text-c'>
				<th width='40%'>文档名(最新创建)</th>
				<th width='40%'>最后编写时间</th>		
				<th width='10%'>编辑人</th>			
				<th width='10%'>操作</th>
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
var Request = new Object();
Request = GetRequest();
var stationId = Request["stationId"];
var type = Request["checklisttype"];
var params={
		"stationId":stationId,
		"type":type,
}

	$(document).ready(function (){
		var url;
		switch (type)
		{
		case "1":
			url="water_daily_checklist_";
			 break;
		case "2":
			 url="water_check_checklist_";
		 break;
		case "3":
			 url="gas_total_pollution_";
		 break;
		case "4":
			 url="pollution_maintain_";
		 break;
		case "5":
			 url="gas_daily_checklist_";
		 break;
		case "6":
			 url="gas_calibration_checklist_";
		 break;
		case "7":
			 url="water_monitor_comparison_";
		 break;
		case "8":
			 url="gas_monitor_comparison_";
		 break;	 
		}	
		
		
		
	
	$('body').on('click','#update',function(event){
		layer_show('档案编辑',url+'modifry.jsp?checklistId='+this.name,'800','500');
	}); 
	$('body').on('click','#detail',function(event){
		layer_show('档案详情',url+'detail.jsp?checklistId='+this.name,'800','500');
	}); 
	//加载页面数据

	$.ajax({
		type: 'POST',
		url: "/management/loadChecklisthistory.do", 
		data: JSON.stringify(params),
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		error:function(data) {
			
			window.location.reload()
		},
        success: function(data) { 
        	console.log(data)
        	var str="";
        		$("#name").html(data[0].name);
        		
        		for(var i=1;i<data.length;i++){
        			str+="<tr class='text-c'>"+
        			"<td>"+data[i].Checklisttypename+"</td>"+
        			"<td>"+data[i].Checklisttime+"</td>"+
        			"<td>"+data[i].userId+"</td>"+
        			"<td class='td-manage'>"+
        			"<a style='text-decoration:none' id = 'detail' href='javascript:;' name='"+data[i].checklistId+"'>"+
        			"<i class='Hui-iconfont'>&#xe720;</i>"+
        			"</a>"+
        			"<a style='text-decoration:none' id = 'update' href='javascript:;' name='"+data[i].checklistId+"'>"+
        			"<i class='Hui-iconfont'>&#xe6df;</i>"+
        			"</a>"+
        			"</td>"
        			+"</tr>"
        			
        		}
    		
        	$("#tbody-alldoc").html(str);  
        	 
        }     
    });

})
function add(title,url,w,h){
	layer_show(title,url,w,h);
	
}
	</script>
</body>
</html>