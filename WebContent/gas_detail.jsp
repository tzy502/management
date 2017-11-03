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
<title>角色列表</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 历史数据 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<div>
	选择时间:
	<input type="text" style='width:30%' class="input-text" value="" placeholder="开始时间" onclick="WdatePicker({maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
	id="start" name="start">
	到
		<input type="text" style='width:30%' class="input-text" value="" placeholder="结束时间" onclick="WdatePicker({maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
	id="end" name="end">
	<input class="btn btn-primary radius" type="button" onclick = "button()" value="&nbsp;&nbsp;查看&nbsp;&nbsp;">
	
</div>	
	<div class="mt-5 mb-5">
	<br/>
	</div>	
		<table class="table table-border table-bordered table-bg">
		<thead id=thead>
		
			<tr id="stationname" name="stationname">				
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

var Request = new Object();
Request = GetRequest();
var stationid = Request['stationid'];
var end=new Date().Format("yyyy-MM-dd hh:mm:ss");
var start =new Date(new Date()-24*60*60*1000).Format("yyyy-MM-dd hh:mm:ss");//取前一天的时间
	  //“今天”转换成可识别的格式输出

$(function(){ 
	$("#start").val(start);
	$("#end").val(end);
	generate()

})
function button(){
	generate()
}
function generate(){
	var params = {
			"StationId" : stationid,
			"end":$("#end").val(),
			"start":$("#start").val(),
		}
	$('body').on('click','#detail ',function(event){
		var Request = new Object();
		Request = GetRequest();
		var stationid = Request['stationid'];
		
		layer_show('数据趋势','data_detail.jsp?stationid='+stationid+'&InfectCode='+this.title,'650','450');
	}); 	

	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/loadoldgasdata.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 	        	
	        	if(data.length>0){
	        	var str = "";  
	        	str="<th scope='col' colspan='15'>"+data[0].stationname+"</th>";
	        	$("#stationname").html(str); 
	        	 str = ""; 
	        	 str="	<tr class='text-c'>"+
						"<th width='120'>时间"+
						
						"</th>"+
						"<th width='70'>实测SO2"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='02'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>实测烟尘"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='01'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>实测NOx"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='03'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>折算烟尘"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='01-Zs'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>折算NOx"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='02-Zs'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>折算NOx"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='03-Zs'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>氧气含量"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='S01'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>烟气流速"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='S02'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>烟气温度"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='S03'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>烟气压力"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='S08'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>标匡流量"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='B02'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"<th width='70'>烟气湿度"+
						 "<a style='text-decoration:none' id = 'detail' href='javascript:;' title='S05'>"+
							"<i class='Hui-iconfont'>&#xe61c;</i>"+
						"</a>"+
						"</th>"+
						"</tr>";
			        	$("#thead").html(str); 
			        	 str = ""; 		
	        	
	        		for(var i = 0; i < data.length; i++){     	
		    			str += "<tr class='text-c'>"+
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
						"</tr>";
						str+=""
						
		       			$("#tbody-allItem").html(str);  
	        		}	
	        	} 
	        		else{
	        			alert("并没有详细数据");
	        			
	        		}
	        		
	        			
	    		
	        }
		
	}
	)
}


	
	//加载页面数据
	
</script>
</body>
</html>