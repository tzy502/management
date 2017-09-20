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
	<form class="form form-horizontal" id="form-admin-add">

	<table class="table table-border table-bordered" id = 'checklist'>
		<tbody id = 'tbody-project'>
		废水在线监测系统运行维护记录      
		</tbody>
		<tbody id = 'tbody-budget'>
			<tr>
				<th width = '10%'>站点名称</th>
				<td width = '30%' colspan='2'><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'>
				<th width = '10%'>巡查时间</th>
				<td width = '30%' colspan='2'><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'>
				<th width = '20%'>运行说明</th>
			</tr>	
		</table>	
		<table class="table table-border table-bordered" id = ''>
			<tr>
				<th width = '20%'>采样单元</th>
				<td width = '60%' colspan='2'>
				  <div class="check-box">

			
					 <input type="checkbox" id="Samplingunit1">
				    <label for="Samplingunit-1">水泵运行正常 </label>
	
					      <input type="checkbox" id="Samplingunit2">
				    <label for="Samplingunit-2">止回阀清理</label>

					   <input type="checkbox" id="Samplingunit3">
				    <label for="Samplingunit-3">采水管路通畅</label> 


					 <br/>
				 <input type="checkbox" id="Samplingunit4">
				    <label for="Samplingunit-4">采水管路清洁 </label>
	
					       <input type="checkbox" id="Samplingunit5">
				    <label for="Samplingunit-5">采样杯清洗 </label>
			
					   <input type="checkbox" id="Samplingunit6">
				    <label for="Samplingunit-6">管路是否滴漏 </label> 
    
				  </div>


				</td>
				<td width = '20%' colspan='2'>
				 <textarea name="" id='SamplingunitDescription' cols="" rows="" class="textarea" ></textarea>
					</tr>
		</tbody>
		</table>
		<table class="table table-border table-bordered" id = ''>
			<tr>
				<th width = '20%' rowspan="6" >检测单元</th>
				<th width = '10%'>COD或TOC</th>
				<td width = '50%' colspan='3'>
				 <input type="checkbox" id="COD1">
				    <label for="COD1">运行是否正常   </label>
				     <input type="checkbox" id="COD2">
				    <label for="COD2">更换试剂 </label>
				     <input type="checkbox" id="COD3">
				    <label for="COD3">冷却（液封）水位充足  </label>
				    <br/>
				     <input type="checkbox" id="COD4">
				    <label for="COD4">仪器管路清理 </label>
				     <input type="checkbox" id="COD5">
				    <label for="COD5">氮气压力检查 </label>
				     <input type="checkbox" id="COD6">
				    <label for="COD6">更换氮气 </label>
				     <input type="checkbox" id="COD7">
				    <label for="COD7">仪器校准 </label>
				       <br/>
				     <input type="checkbox" id="COD8">
				    <label for="COD8">质控样校验  </label>
				     <input type="checkbox" id="COD9">
				    <label for="COD9">更换易耗品 </label>
				     <input type="checkbox" id="COD10">
				    <label for="COD10">采水样比对</label>
				     <input type="checkbox" id="COD11">
				    <label for="COD11">废液清理 </label>
				    <br/>
				    约<input type='text'  style='width:20%'   id = 'COD12' class='input-text radius size-S'>L
				 
				接收人：<input type='text' style='width:40%'  id = 'COD13' class='input-text radius size-S'>
				  <br/>
				TOC在用系数 ： <br/>
				a <input type='text' style='width:40%'  id = 'COD14' class='input-text radius size-S'>     
				 b<input type='text' style='width:40%'  id = 'COD15' class='input-text radius size-S'>          
				  <br/>	
					 <input type="checkbox" id="COD16">
				    <label for="COD16">系数是否修改   </label>
				</td>
				<td width = '20%' colspan='3'>
				<textarea name="" id='CODDescription' cols="" rows="" class="textarea" ></textarea>
			
				</td>
			</tr>
			<tr>
				
				<th width = '10%'>pH计</th>
				<td width = '50%' colspan='3'>
				
					  <input type="checkbox" id="pH1">
				    <label for="pH1">运行是否正常</label>
	
					      <input type="checkbox" id="pH2">
				    <label for="pH2">仪器校准</label>

					   <input type="checkbox" id="pH3">
				    <label for="pH3">电极清洗 </label> 
				<br/>
				
					  <input type="checkbox" id="pH4">
				    <label for="pH4">质控样校验 </label>
	
					      <input type="checkbox" id="pH5">
				    <label for="pH5">更换易耗品</label>

					   <input type="checkbox" id="pH6">
				    <label for="pH6">采水样比对</label> 
				
				
				
				</td>
				<td width = '20%' colspan='3'>
				      <textarea name="" id='pHDescription' cols="" rows="" class="textarea" ></textarea>

				
				</td>
			</tr>
			<tr>
				
				<th width = '10%'>NH3-N仪</th>
				<td width = '50%' colspan='3'>
					<input type="checkbox" id="NH3-N1">
				    <label for="NH3-N1">运行是否正常</label>
					<input type="checkbox" id="NH3-N2">
				    <label for="NH3-N2">更换试剂 </label>
					 <input type="checkbox" id="NH3-N3">
				    <label for="NH3-N3">仪器校准</label>

					 <input type="checkbox" id="NH3-N4">
				    <label for="NH3-N4">质控样校验</label> 
				<br/>
					 <input type="checkbox" id="NH3-N5">
				    <label for="NH3-N5">电极保养</label>
	
					      <input type="checkbox" id="NH3-N6">
				    <label for="NH3-N6">泵管移位（每月一次）</label>

					   <input type="checkbox" id="NH3-N7">
				    <label for="NH3-N7">仪器管路清理 </label> 
				<br/>
	
					      <input type="checkbox" id="NH3-N8">
				    <label for="NH3-N8">更换易耗品</label>

					   <input type="checkbox" id="NH3-N9">
				    <label for="NH3-N9">采水样比对</label> 
				<br/>
				</td>
				<td width = '20%' colspan='3'>
			
				    <textarea name="" id='NH3-NDescription' cols="" rows="" class="textarea" ></textarea>
				</td>
			</tr>
			<tr>
				
				<th width = '10%'>TNP分析仪</th>
				<td width = '50%' colspan='3'>
				<input type="checkbox" id="TNP1">
				    <label for="TNP1">运行是否正常</label>
					<input type="checkbox" id="TNP2">
				    <label for="TNP2">更换试剂 </label>
					 <input type="checkbox" id="TNP3">
				    <label for="TNP3">仪器校准</label>

					 <input type="checkbox" id="TNP4">
				    <label for="TNP4">质控样校验</label> 
				<br/>
					<input type="checkbox" id="TNP5">
				    <label for="TNP5">仪器管路清理</label>
	
					      <input type="checkbox" id="TNP6">
				    <label for="TNP6">更换易耗品</label>

					   <input type="checkbox" id="TNP7">
				    <label for="TNP7">采水样比对</label> 
				<br/>
				
				</td>
				<td width = '20%' colspan='3'>
				 <textarea name="" id='TNPDescription' cols="" rows="" class="textarea" ></textarea>
				</td>
			</tr>
			<tr>
				
				<th width = '10%'>流量计</th>
				<td width = '50%' colspan='3'>
				<input type="checkbox" id="Flow1">
					<label for="Flow1">运行是否正常</label>
					<input type="checkbox" id="Flow2">
				    <label for="Flow2">堰板是否漏水  </label>
					 <input type="checkbox" id="Flow3">
				    <label for="Flow3">探头清理</label>
					 <input type="checkbox" id="Flow4">
				    <label for="Flow4">液面模拟测试 </label> 
				<br/>
				
				</td>
				<td width = '20%' colspan='3'>
				 <textarea name="" id='FlowDescription' cols="" rows="" class="textarea" ></textarea>
				</tr>
			<tr>
				
				<th width = '10%'>采样仪</th>
				<td width = '50%' colspan='3'>
					<input type="checkbox" id="Sampler1">
					<label for="Sampler1">运行是否正常</label>
					<input type="checkbox" id="Sampler2">
				    <label for="Sampler2">制冷正常 </label>
					 <input type="checkbox" id="Sampler3">
				    <label for="Sampler3">清理储水壶</label>
				<br/>
					<input type="checkbox" id="Sampler4">
					<label for="Sampler4">采样头清洗</label>
					<input type="checkbox" id="Sampler5">
				    <label for="Sampler5">回归零位 </label>
					 <input type="checkbox" id="Sampler6">
				    <label for="Sampler6">数采仪控制采样</label>
				<br/>
				</td>
				<td width = '20%' colspan='3'>
				
				 <textarea name="" id='COD3' cols="" rows="" class="textarea" ></textarea>
				
				</td>
			</tr>
		</tbody>
	</table>
		<table class="table table-border table-bordered" id = ''>
			<tr>
				<th width = '20%' rowspan="2" >数据采集单元</th>
				<td width = '60%'>
			
					<input type="checkbox" id="DataAcquisitionUnit1">
				    <label for="DataAcquisitionUnit1">运行是否正常</label>
					 <input type="checkbox" id="DataAcquisitionUnit2">
				    <label for="DataAcquisitionUnit2">本次运维周期数据检查，异常数据记录</label>
				<br/>
					<input type="checkbox" id="DataAcquisitionUnit3">
					<label for="DataAcquisitionUnit3">数采仪重启</label>
					<input type="checkbox" id="DataAcquisitionUnit4">
				    <label for="DataAcquisitionUnit4">一次仪表与数采仪数据偏差检查 </label>
					<input type="checkbox" id="DataAcquisitionUnit5">
				    <label for="DataAcquisitionUnit5">上传情况检查</label>
				<br/>
				</td>
				<th width = '20%' rowspan="2" >
				 <textarea name="" id='DataAcquisitionUnitDescription' cols="" rows="" class="textarea" ></textarea>
				
				</th>
			</tr>
			<tr>
				<th>
				<table class="table table-border table-bordered" id = ''>
					<th width = '5%' rowspan="4" >实时数据记录</th>
						<tr>
							<td width = '8%' ></td>
							<td width = '15%' >COD</td>
							<td width = '15%' >PH</td>
							<td width = '15%' >NH3-N</td>
							<td width = '15%' >流量</td>
							<td width = '15%' >总磷</td>
							<td width = '15%' >总氮</td>
						</tr>
						<tr>
							<td width = '8%' >仪器值</td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-COD' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-pH' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-NH3-N' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-Flows' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-P' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-Instrument-N' class='input-text radius size-S'>      </td>
						</tr>
						<tr>
							<td width = '10%' >数采仪值 </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-COD' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-pH' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-NH3-N' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-Flows' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-P' class='input-text radius size-S'>      </td>
							<td width = '15%' ><input type='text'   id = 'RealtimeDataLogging-machine-N' class='input-text radius size-S'>      </td>
						</tr>
				</table>
				</th>	
			</tr>
			<tr>
				<th width = '20%' rowspan="3" >监测站房（辅助）单元</th>
				<td width = '60%' rowspan="3" >
					<input type="checkbox" id="Auxiliary1">
					<label for="Auxiliary1">输入电压检查  </label>
					<input type="checkbox" id="Auxiliary2">
				    <label for="Auxiliary2">机柜线路检查整理  </label>
					<input type="checkbox" id="Auxiliary3">
				    <label for="Auxiliary3">排水口检查清理</label>
				    <input type="checkbox" id="Auxiliary4">
				    <label for="Auxiliary4">稳压电源运行正常</label>
				<br/>
					<input type="checkbox" id="Auxiliary5">
					<label for="Auxiliary5">空调运行正常</label>
						<input type="checkbox" id="Auxiliary6">
				    <label for="Auxiliary6">灭火器在有效期内</label>
					<input type="checkbox" id="Auxiliary7">
				    <label for="Auxiliary7">检查制度牌、资料架整齐清洁</label>
				
				<br/>
					<input type="checkbox" id="Auxiliary8">
					<label for="Auxiliary8">站房清洁</label>
					<input type="checkbox" id="Auxiliary9">
				    <label for="Auxiliary9">仪器整体除尘、清洁 </label>
					<input type="checkbox" id="Auxiliary10">
				    <label for="Auxiliary10">有效性资料齐全，标签完整 </label>
				<br/>
				
				
				</td>
				<td width = '20%' rowspan="3" >
				<textarea name="" id='Auxiliary' cols="" rows="" class="textarea" ></textarea>
			
				
				</td>
			</tr>

		</table>
		<table class="table table-border table-bordered" id = ''>
					<tr>
				<th width = '20%' rowspan="3" >质量控制</th>
				<td width = '60%' rowspan="3" >
					<table class="table table-border table-bordered" id = ''>
					<tr>
						<td  colspan="2" ></td>
						<td  colspan="2" >COD</td>
						<td  colspan="2" >PH</td>
						<td  colspan="2" >NH3-N</td>
						<td  colspan="2" >总磷</td>
						<td  colspan="2" >总氮</td>						
					</tr>
					<tr>
						<td  colspan="2" >标准值</td>
						<td><input type='text'   id = 'controller-StandardValue-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-StandardValue-N2' class='input-text radius size-S'></td>
					</tr>
					<tr>
						<td colspan="2" >检测值</td>
						<td><input type='text'   id = 'controller-DetectionValue-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-DetectionValue-N2' class='input-text radius size-S'></td>
					</tr>
					<tr>
						<td  colspan="2" >误 差</td>
						<td><input type='text'   id = 'controller-ErrorValue-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'controller-ErrorValue-N2' class='input-text radius size-S'></td>
					</tr>
					</table>
				
				</td>
				<td width = '20%' rowspan="3" >
				
		
				  <textarea name="" id='controller-' cols="" rows="" class="textarea" ></textarea>
				</td>
			</tr>
		</table>
			<table class="table table-border table-bordered" id = ''>
					<tr>
				<th width = '20%' rowspan="3" >实样比对记录</th>
				<td width = '60%' rowspan="3" >
					<table class="table table-border table-bordered" id = ''>
					<tr>
						<td  colspan="2" ></td>
						<td  colspan="2" >COD</td>
						<td  colspan="2" >PH</td>
						<td  colspan="2" >NH3-N</td>
						<td  colspan="2" >总磷</td>
						<td  colspan="2" >总氮</td>						
					</tr>
					<tr>
						<td  colspan="2" >仪器值</td>
	
						<td><input type='text'   id = 'comparison-instrument-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-instrument-N2' class='input-text radius size-S'></td>
						</tr>
					<tr>
						<td colspan="2" >实验值</td>
		
						<td><input type='text'   id = 'comparison-experiment-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-experiment-N2' class='input-text radius size-S'></td>
					</tr>
					<tr>
						<td  colspan="2" >偏差</td>
				
						<td><input type='text'   id = 'comparison-ErrorValue-COD1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-COD2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-PH1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-PH2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-NH3-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-NH3-N2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-P1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-P2' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-N1' class='input-text radius size-S'></td>
						<td><input type='text'   id = 'comparison-ErrorValue-N2' class='input-text radius size-S'></td>
		</tr>
					</table>
				
				</td>
				<td width = '20%' rowspan="3" >
			
				
				  <textarea name="" id='comparison' cols="" rows="" class="textarea" ></textarea>
			</td>
			</tr>
		</table>	
		<table class="table table-border table-bordered" id = ''>
		<tr>
			<td width = '15%' >维 护 人</td>
			<td width = '35%' >		
		<input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'>
			</td>
			<td width = '15%' >远   程</td>
			<td width = '35%' >		
				<input type='text' value='' name='remotely' id = 'remotely' class='input-text radius size-S'>
			</td>
		</tr>
		<tr>
			<td width = '15%' >确认企业</td>
			<td width = '35%' >		
				<input type='text' value='' name='companyname' id = 'companyname' class='input-text radius size-S'>
			</td>
			<td width = '15%' >审   核</td>
			<td width = '35%' >		
			<input type='text'  value='' name='audit' id = 'audit' class='input-text radius size-S'>
			</td>
		</tr>
		</table>	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick = "addBudget()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
	
	<input type='hidden'  value='' name='StationId' id = 'StationId'>
	<input type='hidden'  value='' name='StationId' id = 'StationId'>
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
				      for(var i = 0; i < strs.length; i ++) {   
				         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
				      }   
				   }   
				   return theRequest;   
			}   
			var Request = new Object();
			Request = GetRequest();
			var checklistId = Request['checklistId'];
		
			var params = {
				"checklistId" : checklistId,
			}
			
			$(document).ready(function (){

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
			        success: function(data) { 
			
						var obj=JSON.parse(data.checklistcheckbox);		
						for(var i = 0; i < obj.checked.length; i++){ 
					
							var checked = document.getElementById(obj.checked[i])
							checked.checked = true;
						}
						
						var input=JSON.parse(data.checklistinput);	
					
					
						
						for(var i = 0; i < input.length; i++){ 
											
							$("#"+input[i].id).val(input[i].value);					
						}
						
						$("#StationId").val(data.StationId)
						console.log(data.StationId);
			        }
			    })
			})
			function addBudget(){
			var inputs = document.getElementsByTagName("input");//获取所有的input标签对象
			var checked = [];//初始化空数组，用来存放checkbox对象。
			for(var i=0;i<inputs.length;i++){
			  var obj = inputs[i];
			  if(obj.type=='checkbox'){
				  if($("#"+inputs[i].id).is(':checked'))				 
				  checked.push(inputs[i].id);
			  }
			}
			var input ={
					"id":"",
					"value":""
					
			}
			var inputtext = new Array();//初始化空数组，用来存放checkbox对象。
	
			for(var i=0;i<inputs.length;i++){
			  var obj = inputs[i];
			  if(obj.type=='text'||obj.type=='textarea'){				
				  inputtext.push({id:obj.id,value:obj.value});	
			  }
			}
			$("textarea").each(function(){			
				inputtext.push({id:$(this).attr("id"),value:$(this).val()});	
			});

			var input=JSON.stringify(inputtext);
			var params={
					"checked":checked,	
			}		
			
			var checklistcheckbox=JSON.stringify(params);
			var Request = new Object(); 
			Request = GetRequest(); 
	
				
		
			var userId = getCookie("userId");
		
			var form = new FormData();
			
			form.append("checklistId",checklistId)
			form.append("stationId",$("#StationId").val())
			form.append("userId",userId)
			form.append("checklisttype",1)
			var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
			form.append("checklisttime",now)
			form.append("checklistcheckbox",checklistcheckbox)
			form.append("checklistinput",input)
			
		    $.ajax({    
				type: 'POST',
				url: "/management/modifryChecklist.do", 
				data:form, 
		        async: false,
		        processData:false,
		        contentType:false,
				success: function(data){	
					if(data.msg!=null){
						alert(data.msg);					
					}
					else{layer.msg('已添加!',{icon:1,time:15000});}
			
				},
				error:function(data) {
					alert(data.msg);
					console.log(data.msg);
				},
			});
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index); 
		}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>