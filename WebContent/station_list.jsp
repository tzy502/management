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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 检测站列表  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">	

	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		 <a href="javascript:;" onclick="add('添加检测站','station_add.jsp','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加检测站</a>
	 </span>  
	  </div>
	
	<table class="table table-border table-bordered table-bg" id="table">
		<thead>
			<tr>
				<th scope="col" colspan="9">站点列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="250">站点名</th>
				<th width="350">地区</th>		
				<th width="120">负责人</th>	
				<th width="120">监控数据</th>		
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-alldoc'>
		</tbody>
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
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
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

	$(document).ready(function (){
		$('body').on('click','#delete',function(event){
			var StationId = this.title;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"StationId":StationId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delStation.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
						layer.msg('删除失败!',{icon:1,time:15000});
						window.location.href = 'station_list.jsp';
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						window.location.href = 'station_list.jsp';
					},
				});		
			});
		});
		
		
		
	$('body').on('click','#update',function(event){
		layer_show('检测站编辑','station_modifry.jsp?stationId='+this.title,'800','500');
	}); 
	$('body').on('click','#datail',function(event){
		layer_show('检测站详情','station_detail.jsp?stationId='+this.title,'800','500');
	}); 
	//加载页面数据

	$.ajax({    
        type: "post",    
        async: true,    
        url: "/management/loadAllStation.do",  
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
				"<td>"+data[i].stationname+"</td>"+
				"<td>"+data[i].city+"市"+data[i].area+"区</td>"+
				"<td>"+data[i].name+"</td>"+
				"<td>"+data[i].data+"</td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'datail' href='javascript:;' title='"+data[i].stationId+"'>"+
				"<i class='Hui-iconfont'>&#xe720;</i>"+
				"</a>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].stationId+"'>"+
				"<i class='Hui-iconfont'>&#xe6df;</i>"+
			"</a>"+
				"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+data[i].stationId+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
				"</a>"+

				
				"</td>"
				"</tr>";
				str+=""
			
    			
    		}
 
    	
		
    		
    		
    		
        	$("#tbody-alldoc").html(str);  
        	$("#table").DataTable();
        }     
    });

})
function add(title,url,w,h){
	layer_show(title,url,w,h);
	
}
	</script>
</body>
</html>