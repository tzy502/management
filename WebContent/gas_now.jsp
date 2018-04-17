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
<title>角色列表</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 实时数据<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
		<table class="table table-border table-bordered table-bg" id="table">
		<thead>
			<tr>
				<th scope="col" colspan="15">实时数据</th>
			</tr>
			<tr class="text-c">
				<th width="120">站点名</th>
				<th width="120">时间</th>
				<th width="70">实测SO2</th>
				<th width="70">实测烟尘</th>
				<th width="70">实测NOx</th>
				<th width="70">折算烟尘</th>
				<th width="70">折算SO2</th>
				<th width="70">折算NOx</th>
				
				<th width="70">氧气含量</th>
				<th width="70">烟气流速</th>
				<th width="70">烟气温度</th>
				<th width="70">烟气压力</th>
				<th width="70">标匡流量</th>
				<th width="70">烟气湿度</th>
				
				
				<th width="40">以往详情</th>
				
			</tr>
		</thead>
		<tbody id = 'tbody-allItem'>
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
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/



$(function(){ 
	$('body').on('click','#update',function(event){
		layer_show('历史数据','gas_detail.jsp?stationid='+this.title,'800','500');
	}); 

	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/loadnewgasdata.do",  
	        //data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 	        	
	        	
	        	var str = "";  
	    		for(var i = 0; i < data.length; i++){     	
	    			str += "<tr class='text-c'>"+
	    			"<td>"+data[i].stationname+"</td>"+
					"<td>"+data[i].time+"</td>"+
					
					"<td>"+data[i].g02+"</td>"+
					"<td>"+data[i].g01+"</td>"+
					"<td>"+data[i].g03+"</td>"+
					"<td>"+data[i].g01Zs+"</td>"+
					"<td>"+data[i].g02Zs+"</td>"+
					"<td>"+data[i].g03Zs+"</td>"+
					"<td>"+data[i].gS01+"</td>"+
					"<td>"+data[i].gS02+"</td>"+
					"<td>"+data[i].gS03+"</td>"+
					"<td>"+data[i].gS08+"</td>"+
					"<td>"+data[i].gB02+"</td>"+
					"<td>"+data[i].Sg05+"</td>"+		
					
					
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].stationId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
				"</a>"+"</td>"
					"</tr>";
					str+=""
					
	       			$("#tbody-allItem").html(str);  
					$("#table").DataTable();
	    		}
	        }
		
	}
	)
}
)
	
	//加载页面数据
	
</script>
</body>
</html>