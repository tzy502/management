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
	<form class="form form-horizontal" id="add">

		<table class="table table-border table-bordered">
			
			<tr>
				<th scope="col" colspan="9">检测站详情</th>
			</tr>
				<th width='13%'>所属公司名称</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="companyname"
					name="companyname"> </option>

				</select></td>
				<th width='13%'>负责人</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="name"
					name="name"> </td>
				<th width='13%'></th>
				<td width='20%'></td>

			</tr>
			<tr>
				<th width='13%'>站点名称</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value=""   disabled="disabled" id="stationname"
					name="stationname"></td>
				<th width='13%'>站点类型</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="type" name="type"></td>

				<th width='13%'>所在地区</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="city" name="city">市
					<input type="text" class="input-text formControls" value="" disabled="disabled"
					id="area" name="area">区</td>

			</tr>
			<tr>
				<th width='13%'>行政区代码</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="areaid" name="areaid"></td>
				<th width='13%'>站位编码A</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="codeA" name="codeA"></td>

				<th width='13%'>站位编码B</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="codeB" name="codeB"></td>
			</tr>

			<tr>
				<th width='13%'>控制级别</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="level" name="level"></td>
				<th width='13%'>行业</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="industry"
					name="industry"></td>
				<th width='13%'>排放去向</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="togo" name="togo"></td>
			</tr>
			<tr>
				<th width='13%'>纳污区域</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="pollution"
					name="pollution"></td>
				<th width='13%'>排放模式</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="model" name="model"></td>

				<th width='13%'>运维单位</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="unit" name="unit"></td>
			</tr>
			<tr>
				<th width='13%'>站点现状</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="status" name="status"></td>
				<th width='13%'>监管部门</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="regulatoryauthorities"
					name="regulatoryauthorities"></td>

				<th width='13%'>经度</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="longitude"
					name="longitude"></td>
			</tr>
			<tr>
				<th width='13%'>纬度</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="latitude"
					name="latitude"></td>
				<th width='13%'>详细地址</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="address"
					name="address"></td>

				<th width='13%'>设计处理能力</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="ability"
					name="ability"></td>
			</tr>
			<tr>
				<th width='13%'>验收验收时间</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="acceptance"
					name="acceptance"></td>
				<th width='13%'>是否监督考核</th>
				<td width='20%'><input type="text"
					class="input-text formControls" value="" disabled="disabled" id="assessment"
					name="assessment"></td>
<th width='13%'></th>
				<td width='20%'></td>
			</tr>
		</table>


	</form>
		<div class="mt-10">         </div>
	<div class="line"></div>
	
	<div class="mb-10">      </div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		 <a href="javascript:;" onclick="Standard_add()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加监控对象</a>
	 </span>  
	  </div>
		<table class="table table-border table-bordered table-bg" id='infect'>
		<thead>
			<tr>
				<th scope="col" colspan="9">报警数据设置</th>
			</tr>
			<tr class="text-c">
				<th width="5%">序号</th>
				<th width="15%">名称</th>
				<th width="15%">预警下限</th>	
				<th width="15%">预警上限</th>	
				<th width="15%">报警下限</th>	
				<th width="15%">报警上限</th>		
				<th width="20%">操作</th>
			</tr>
		</thead>
		<tbody id = 'Standard'>
		</tbody>
	
	</table>
	
	<div class="mt-10">         </div>
	<div class="line"></div>
	
	<div class="mb-10">      </div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		 <a href="javascript:;" onclick="add()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加设备</a>
	 </span>  
	  </div>
		<table class="table table-border table-bordered table-bg" id='equipmengt'>
		<thead>
			<tr>
				<th scope="col" colspan="9">设备列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="100">型号</th>
				<th width="100">编号</th>	
				<th width="300">作用</th>		
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'equipment'>
		</tbody>
	
	</table>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css"
		rel="stylesheet" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
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
		$(document)	.ready(function() {
		
				$.ajax({
							type : "post",
							async : true,
							url : "/management/loadAllCompany.do",
							//data: JSON.stringify(params),
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							error : function(data) {
								alert("出错了！！:" + data.msg);
							},
							success : function(data) {
								var str = "<option value='1' selected>请选择</option>";
								for (var i = 0; i < data.length; i++) {
									str += "<option value='"+data[i].companyId+"' >"
											+ data[i].companyname
											+ "</option>"
								}
			
								$("#companyid").html(str);
							}
						})
			
				$.ajax({
							type : "post",
							async : true,
							url : "/management/loadAllUser.do",
							//data: JSON.stringify(params),
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							error : function(data) {
								alert("出错了！！:" + data.msg);
							},
							success : function(data) {
								var str = "<option value='1' selected>请选择</option>";
								for (var i = 0; i < data.length; i++) {
									str += "<option value='"+data[i].userId+"' >"
											+ data[i].userName
											+ "</option>"
								}
			
								$("#principal").html(str);
							}
						})
				$('companyid').select2();
				$('select').select2();
				//
				var Request = new Object();
				Request = GetRequest();
				var stationid = Request['stationid'];
				var params = {
					"stationId" : stationid,
				}
				
				$.ajax({
							type : "post",
							async : true,
							url : "/management/SearchStation.do",
							data : JSON.stringify(params),
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							error : function(data) {
								alert("出错了！！:" + data.msg);
							},
							success : function(data) {
								$("#stationname").val(data.stationname);
								$("#companyname").val(data.companyname);
								$("#type").val(data.type);
								$("#city").val(data.city);
								$("#area").val(data.area);
								$("#areaid").val(data.areaid);
								$("#codeA").val(data.codeA);
								$("#codeB").val(data.codeB);
								$("#level").val(data.level);
								$("#industry").val(data.industry);
								$("#togo").val(data.togo);
								$("#pollution").val(data.pollution);
								$("#model").val(data.model);
								$("#unit").val(data.unit);
								$("#status").val(data.status);
								$("#regulatoryauthorities").val(
										data.regulatoryauthorities);
								$("#pollution").val(data.pollution);
								$("#model").val(data.model);
								$("#unit").val(data.unit);
								$("#status").val(data.status);
								$("#regulatoryauthorities").val(
										data.regulatoryauthorities);
								$("#longitude").val(data.longitude);
								$("#latitude").val(data.latitude);
								$("#address").val(data.address);
								$("#ability").val(data.ability);
			
								$("#acceptance").val(
										data.acceptance);
								$("#assessment").val(
										data.assessment);
								$("#principal").val(data.principal);
								$("#name").val(data.name);
							}
						})
					$.ajax({
							type : "post",
							async : true,
							url : "/management/loadStandard.do",
							data : JSON.stringify(params),
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							error : function(data) {
								alert("出错了！！ :" + data.msg);
							},
					        success: function(data) { 
					        	var str = "";  
					    		
					        	for(var i = 0; i < data.length; i++){ 

					       			str += "<tr class='text-c'>"+
									"<td>"+(i+1)+"</td>"+
									"<td>"+data[i].name+"</td>"+
									"<td>"+data[i].minvaule+"</td>"+
									"<td>"+data[i].maxvaule+"</td>"+
									"<td>"+data[i].minalarm+"</td>"+
									"<td>"+data[i].maxalarm+"</td>"+
									"<td class='td-manage'>"+
									"<a style='text-decoration:none' id = 'updateStandard' href='javascript:;' title='"+data[i].standardid+"'>"+
									"<i class='Hui-iconfont'>&#xe6df;</i>"+
								"</a>"+
									"<a style='text-decoration:none' id = 'deleteStandard' href='javascript:;' title='"+data[i].standardid+"'>"+
										"<i class='Hui-iconfont'>&#xe6e2;</i>"+
									"</a>"+
			
									
									"</td>"
									"</tr>";
									str+=""					    			
					    		}
					        	$("#Standard").html(str);  
					        }
					})
			$.ajax({
							type : "post",
							async : true,
							url : "/management/loadAllequipment.do",
							data : JSON.stringify(params),
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							error : function(data) {
								alert("出错了！！:" + data.msg);
							},
					        success: function(data) { 
					        	var str = "";  
					    		
					        	for(var i = 0; i < data.length; i++){ 
					    		
					       			str += "<tr class='text-c'>"+
									"<td>"+(i+1)+"</td>"+
									"<td>"+data[i].model+"</td>"+
									"<td>"+data[i].number+"</td>"+
									"<td>"+data[i].effect+"</td>"+
									"<td class='td-manage'>"+
									"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].equipmentid+"'>"+
									"<i class='Hui-iconfont'>&#xe6df;</i>"+
								"</a>"+
									"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+data[i].equipmentid+"'>"+
										"<i class='Hui-iconfont'>&#xe6e2;</i>"+
									"</a>"+
			
									
									"</td>"
									"</tr>";
									str+=""					    			
					    		}
					        	$("#equipment").html(str);  
					        }
					})
			})
		$('body').on('click','#updateStandard',function(event){
		layer_show('数据编辑','standard_modifry.jsp?standardid='+this.title,'400','300');
	}); 	
						
		$('body').on('click','#update',function(event){
		layer_show('检测站编辑','equipment_modifry.jsp?equipmentid='+this.title,'400','300');
	}); 					
						
		$('body').on('click','#delete',function(event){
			var equipmentid = this.title;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"equipmentid":equipmentid,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delequipment.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
						
						location=location 
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						location=location 
					},
				});		
			});
		});			
		$('body').on('click','#deleteStandard',function(event){
			var standardid = this.title;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"standardid":standardid,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delStandard.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
						
						location=location 
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						location=location 
					},
				});		
			});
		});			
		function add() {
			
			var Request = new Object();
			Request = GetRequest();
			var stationid = Request['stationid'];
	
			layer_show('添加设备',"equipment_add.jsp?stationid="+stationid ,400,300);

		}
		
		function Standard_add() {
			
			var Request = new Object();
			Request = GetRequest();
			var stationid = Request['stationid'];
	
			layer_show('添加上限',"standard_add.jsp?stationid="+stationid ,400,300);

		}
	</script>

</body>
</html>