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
<title></title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
<table class="table table-border table-bordered" id = 'checklist'>
  <tr>
    <td width="122">站点名称</td>
    <td width="285" colspan="3"><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'></td>
    <td width="83">巡检时间</td>
    <td width="207"><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="122">设备运行状态</td>
    <td width="575" colspan="5">
		<input type="checkbox" id="input1">
		<label for="input1">总量控制设施运行 </label>
		<input type="checkbox" id="input2">
		<label for="input2">流量计运行 </label>
		<input type="checkbox" id="input3">
		<label for="input3">触摸屏操作 </label>
		<input type="checkbox" id="input4">
		<label for="input4">窨井防水排水检测 </label>
        <br />
    	<input type="checkbox" id="input5">
		<label for="input5">输入电压检查</label>
		<input type="checkbox" id="input6">
		<label for="input6">机柜线路检查整理</label>
		<input type="checkbox" id="input7">
		<label for="input7">空调运行正常 </label>
		<input type="checkbox" id="input8">
		<label for="input8">灭火器在有效期内</label>
     	<br />
     	<input type="checkbox" id="input9">
		<label for="input9">检查制度牌、资料架整齐清洁</label>
		<input type="checkbox" id="input10">
		<label for="input10">站房清洁</label>
		<input type="checkbox" id="input11">
		<label for="input11">仪器整体除尘、清洁 </label>
		</td>
  </tr>
  <tr>
    <td width="122">设备在线情况</td>
    <td width="575" colspan="5">
    		<input type="checkbox" id="input12">
		<label for="input12">总量控制平台互联网是否正常 </label>
				<input type="checkbox" id="input13">
		<label for="input13">在线监控平台互联网是否正常 </label>
</td>
  </tr>
  <tr>
    <td width="122" rowspan="5">总量及现场 <br />
      数据记录</td>
    <td width="110">COD</td>
    <td width="465" colspan="4">
    		实时排放量 <input type='text' style='width:30%'  id = 'input14' class='input-text radius size-S'>
            月排放比例<input type='text' style='width:30%'  id = 'input15' class='input-text radius size-S'><br/>
			年排放比例<input type='text' style='width:30%'  id = 'input16' class='input-text radius size-S'>
            </td>
  </tr>
  <tr>
    <td width="110">NH3-N</td>
    <td width="465" colspan="4">
   		实时排放量 <input type='text' style='width:30%'  id = 'input17' class='input-text radius size-S'>
            月排放比例<input type='text' style='width:30%'  id = 'input18' class='input-text radius size-S'><br/>
			年排放比例<input type='text' style='width:30%'  id = 'input19' class='input-text radius size-S'>

 </td>
  </tr>
  <tr>
    <td width="110">SO2</td>
    <td width="465" colspan="4">
   		实时排放量 <input type='text' style='width:30%'  id = 'input20' class='input-text radius size-S'>
            月排放比例<input type='text' style='width:30%'  id = 'input21' class='input-text radius size-S'><br/>
			年排放比例<input type='text' style='width:30%'  id = 'input22' class='input-text radius size-S'>

 </td>
  </tr>
  <tr>
    <td width="110">NOX</td>
    <td width="465" colspan="4">
   		实时排放量 <input type='text' style='width:30%'  id = 'input23' class='input-text radius size-S'>
            月排放比例<input type='text' style='width:30%'  id = 'input24' class='input-text radius size-S'><br/>
			年排放比例<input type='text' style='width:30%'  id = 'input25' class='input-text radius size-S'>

 </td>
  </tr>
  <tr>
    <td width="110">粉尘</td>
    <td width="465" colspan="4">
   		实时排放量 <input type='text' style='width:30%'  id = 'input26' class='input-text radius size-S'>
            月排放比例<input type='text' style='width:30%'  id = 'input27' class='input-text radius size-S'><br/>
			年排放比例<input type='text' style='width:30%'  id = 'input28' class='input-text radius size-S'>

 </td>
  </tr>
  <tr>
    <td width="122">阀门控制状态</td>
    <td width="575" colspan="5">
    				<input type="checkbox" id="input29">
		<label for="input29">现场控制运行 </label>
    				<input type="checkbox" id="input30">
		<label for="input30">通过平台控制运行 </label>
</td>
  </tr>
  <tr>
    <td width="122">总量控制器 <br />
					      设备中的 <br />
					      刷卡余额</td>
    <td width="575" colspan="5">    
        				<input type="checkbox" id="input31">
		<label for="input31">余额检查 </label>
    				<input type="checkbox" id="input32">
		<label for="input32">现场充值 </label></td>
  </tr>
  <tr>
    <td width="122">异常情况记录</td>
    <td width="575" colspan="5">
     <textarea name="" id='input33' cols="" rows="" class="textarea" ></textarea>

  </tr>
  
  <tr>
    <td width="122">维修人员</td>
    <td width="271" colspan="2">
    	<input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'>
</td>
    <td width="97" colspan="2">确认企业</td>
    <td width="207"><input type='text'   value='' name='companyname' id = 'companyname' class='input-text radius size-S'>
</td>
  </tr>
</table>


</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/icheck/icheck.css"></script>

	<script type="text/javascript">
		var j = 0;
		function getCookie(Name) {
			var search = Name + "="//查询检索的值
			var returnvalue = "";//返回值
			if (document.cookie.length > 0) {
				sd = document.cookie.indexOf(search);
				if (sd != -1) {
					sd += search.length;
					end = document.cookie.indexOf(";", sd);
					if (end == -1)
						end = document.cookie.length;
					//unescape() 函数可对通过 escape() 编码的字符串进行解码。
					returnvalue = unescape(document.cookie.substring(sd, end))
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
		var Request = new Object();
		Request = GetRequest();
		var checklistId = Request['checklistId'];
	
		var params = {
			"checklistId" : checklistId,
		}

		$(document).ready(function() {
			$.ajax({
				type : "post",
				async : true,
				url : "/management/searchChecklist.do",
				data : JSON.stringify(params),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				error : function(data) {
					alert("出错了！！ :" + data.msg);
				},
				success : function(data) {

					var obj = JSON.parse(data.checklistcheckbox);
					for (var i = 0; i < obj.checked.length; i++) {
						console.log(obj.checked[i]);
						var checked = document.getElementById(obj.checked[i])
						checked.checked = true;
					}

					var input = JSON.parse(data.checklistinput);

					for (var i = 0; i < input.length; i++) {
						console.log(input[i].id);
						$("#" + input[i].id).val(input[i].value);
					}

				}
			})
		})
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>