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
<title>角色列表</title>
</head>
<body>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="main" style="width: 600px; height: 400px;"></div>
</body>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/echarts.min.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
	src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
	src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
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
			var InfectCode = Request['InfectCode'];
			var end=new Date().Format("yyyy-MM-dd hh:mm:ss");
			var start =new Date(new Date()-(24*60*60*1000*3)).Format("yyyy-MM-dd hh:mm:ss");//取前一天的时间
				  //“今天”转换成可识别的格式输出
				  
			$(function() {
	
			var params = {
				"StationId" : stationid,
				"end":end,
				"start":start,
				"InfectCode":InfectCode,
			}
			  var myChart = echarts.init(document.getElementById('main'));

  
			         
			
			     
			   var vaule=[];
			   var time=[];
			$.ajax({
				type : "post",
				async : true,
				url : "/management/loaddata.do",
				data: JSON.stringify(params),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				error : function(data) {
					alert("出错了！！:" + data.msg);
				},
				success : function(data) {
					if( data.length>0){	
						for(var i = 0; i < data.length; i++){ 
				 		time.push(data[i].mTime);
				 		
				 		vaule.push(data[i].InfectValue);
				 	}
	
					    
					 var option = {
					            title: {    //图表标题
					                text: '过去三天数值趋势'
					            },
					            tooltip: {
					                trigger: 'axis', 
					            },
			
					            dataZoom: [
					                 {
					                     type: 'inside',    //支持单独的滑动条缩放
					                     start: 0,            //默认数据初始缩放范围为10%到90%
					                     end: 100
					                 }
					            ],
					            toolbox: {    //工具栏显示             
					                show: true,
					                feature: {                
					                    saveAsImage: {}        //显示“另存为图片”工具
					                }
					            },
					            xAxis:  { 
					            
					            	 data: time
					            },
					            yAxis : [   
			                        {
			      
	
			                             type : 'value',
			                             name : '',
			                         }
					            
					            ],
					            series : [  
					            	{
					                    name: '数值',
					                    type: 'line',
					                    data: vaule
		                       
					            	}
					       ]
					};
					    
	
					 myChart.setOption(option); 
				 }
					    // 为echarts对象加载数据
				
			 	else{
	        			alert("近三天没有新数据更新");
	        			
	        		}
				}

		})
			
			
		})


	
	</script>
</body>
</html>