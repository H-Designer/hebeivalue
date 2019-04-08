<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/User/1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	function addInput(){
// 		alert($("div[id='adds']").length);
		if($("div[id='adds']").length<5){
// 		var fdiv=document.getElementById("addInput");
// 		fdiv.innerHTML+='<div style="float: float;"><input type="text" name="constructionUnit" value="${param.constructionUnit }"/><input type="button" onclick="del(this)" value="删除"/><div>';
		$("#addInput").append("<div id='adds' style='float: float;'><input type='text' name='constructionUnit'/><input type='button' onclick='del(this)' value='删除'/><div>");
		}
	}
	function del(obj){
		obj.parentNode.parentNode.removeChild(obj.parentNode);
	}
</script>
<script type="text/javascript">  
	function checkA() {
		var checks = document.getElementsByName("PingtaiShape");
		for (var i = 0; i < checks.length; i++) {
			if (checks[i].check == false) {
				check[i].value = " ";
			}
		}
	}
</script>
<script type="text/javascript">
	function checkAll(allC){
		//获取所有的选择框
		var checks = document.getElementsByName("PingtaiShape");
		if(allC.checked == true){
			for(var i= 0;i<checks.length;i++){
				checks[i].disabled=false;
			}
		}
		else {
			for(var i= 0;i<checks.length;i++){
				checks[i].checked=false;
				checks[i].disabled=true;
			}
		}
		
	}
	
	function check(chec){
		var checks = document.getElementsByName("PingtaiShape");
		if(chec.checked == true){
			checks[1].checked=false;
			checks[2].checked=false;
			checks[0].checked=false;
			checks[1].disabled=true;
			checks[0].disabled=true;
			checks[2].disabled=true;
		}
	}
</script>
<style type="text/css">
	td{
		text-align:center;
		valign-align:middle;
	}
	body table tr{
		height: 50px;
	}
	table {
		cellspacing:0;
		border-collapse:collapse;
		cellpading:0;
	}
	body{
		margin: 0;
	}
	/*
	body input{
		font-size: 20px;
	}
	*/
</style>
<title>填写基本资料</title>
</head>
<body  onload="setup();preselect('陕西省');promptinfo();">
	<center>
	<h3 class="text-center">河北省重大技术需求征集表</h3>
	</center>
	<hr>
	<form action="${pageContext.request.contextPath }/severLet/formSeverlet" method="post">
		<table border="1" width="80%" align="center">
			<tr>
				<td>平台名称：</td>
				<td colspan="2"><input type="text" name="platname" style="width: 100%;height: 100%" value="${sessionScope.user.platname}"/></td>
				<td>平台编号：</td>
				<td colspan="3"><input type="text" name="platnum" style="width: 100%;height: 100%" value="${sessionScope.user.platnum}"/></td>
			</tr>
			<tr>
				<td>批准年月：</td>
				<td colspan="2"><input type="text" name="pizhuntime" style="width: 100%;height: 100%" value="${sessionScope.user.pizhuntime}"/></td>
				<td>批准文号：</td>
				<td colspan="3"><input type="text" name="pizhunwenhao" style="width: 100%;height: 100%" value="${sessionScope.user.pizhunwenhao}"/></td>
			</tr>
			<tr>
				<td>技术领域：</td>
				<td colspan="7"><input type="text" name="jishulingyu" style="width: 100%;height: 100%" value="${sessionScope.user.jishulingyu}"/></td>
			</tr>
			<tr>
				<td>平台级别：</td>
				<td>
				<input type="checkbox" name="PingtaiLevel" value="国家级"/>国家级
				<input type="checkbox" name="PingtaiLevel" value="省级"/>省级
				</td>
				<td>所在市县（区）：</td>
				<td colspan="3">
					<select style="font-size: 20px" class="select" name="province" id="s1">
						<option></option>
					</select> <select style="font-size: 20px" class="select" name="city" id="s2">
						<option></option>
					</select> <select style="font-size: 20px" class="select" name="town" id="s3">
						<option></option>
					</select>
				</td>
			</tr>
			<tr>
				<td rowspan="3">平台组织形态：</td>
				<td rowspan="3"><input type="radio" name="PingtaiShape" onclick="check(this)"  value="内设机构相对独立"/>内设机构相对独立</td>
				<td rowspan="3" style="text-align: right"><input type="radio" onclick="checkAll(this)"  name="PingtaiShape" value="独立法人"/>独立法人</td>
				<td style="text-align: left"><input type="hidden" name="PingtaiShape" value=""/>
				<input type="checkbox" disabled="disabled" id="PingtaiShape" name="PingtaiShape" value="企业法人"/>企业法人</td>
				<td rowspan="2" style="text-align: left"><input type="radio" name="PingtaiShape" value="多单位联合共建"/>多单位联合共建法人<br><input type="radio" name="PingtaiShape" value="依托单位独自建设"/>依托单位独自建设</td>
			</tr>
			<tr>
				<td style="text-align: left"><input type="checkbox" disabled="disabled" id="PingtaiShape" name="PingtaiShape" value="事业法人"/>事业法人</td>
			</tr>
			<tr>
				<td style="text-align: left"><input type="checkbox" disabled="disabled" id="PingtaiShape" name="PingtaiShape" value="社团法人"/>社团法人</td>
				<td>京津冀共建:</td>
				<td style="text-align: left"><input type="radio" name="BTHconstruction" value="是"/>是<input type="radio" name="BTHconstruction" value="否"/>否</td>
			</tr>
			<tr>
				<td><input type="hidden" value=""  name="PingtaiShape"/>服务的主要国民经济行业：</td>
								<td colspan="7" style="text-align: left">
				
<input type="radio" id="Enterprise" name="EconoyServing" value="教育"/>教育
					<input type="radio" id="ScientificResearchInstitutions" value="金融" name="EconoyServing"/>金融
					<input type="radio" id=" higheLearning" value="房地产" name="EconoyServing"/>房地产
					<input type="radio" id="Detection"value="餐饮住宿" name="EconoyServing"/>餐饮住宿
					<input type="radio" id="Medical" value="医疗" name="EconoyServing"/>医疗
					<input type="radio" id="Government" value="科学技术" name="EconoyServing"/>科学技术
					<input type="radio" id="college"  value="环境经济" name="EconoyServing"/>环境经济
					<input type="radio" id="Other" value="其他" name="EconoyServing"/>其他			</tr>
			<tr>
				<td>所属的主要学科:</td>
<td colspan="7" style="text-align: left">
					<input type="radio" id="Enterprise" name="xueke" value="外语"/>外语
					<input type="radio" id="ScientificResearchInstitutions" value="金融" name="数学"/>数学
					<input type="radio" id=" higheLearning" value="英语" name="xueke"/>英语
					<input type="radio" id="Detection"value="物理" name="xueke"/>物理
					<input type="radio" id="Medical" value="生物" name="xueke"/>生物
					<input type="radio" id="Government" value="金融" name="xueke"/>金融
					<input type="radio" id="college"  value="文史" name="xueke"/>文史
					<input type="radio" id="Other" value="其他" name="xueke"/>其他
				</td>			</tr>
			<tr>
				<td>依托单位名称:</td>
				<td><input type="text" style="width: 100%;height: 100%" name="YituoCompany"/></td>
				<td colspan="3">依托单位组织机构代码(社会信用代码):</td>
				<td><input type="text" style="width: 100%;height: 100%" name="DanweiDaima"/></td>
			</tr>
			<tr>
				<td>依托单位法人代表姓名:</td>
				<td><input type="text" style="width: 100%;height: 100%" name="YituorenName"/></td>
				<td>办公电话:</td>
				<td colspan="3"><input style="width: 100%;height: 100%" type="text" name="BangongPhone"/></td>
			</tr>
			<tr>
				<td>依托单位类型:</td>
				<td colspan="7" style="text-align: left">
					<input type="radio" id="Enterprise" name="YituoType" value="企业"/>企业
					<input type="radio" id="ScientificResearchInstitutions" value="科研机构" name="YituoType"/>科研机构
					<input type="radio" id=" higheLearning" value="高等院校" name="YituoType"/>高等院校
					<input type="radio" id="Detection"value="检测机构" name="YituoType"/>检测机构
					<input type="radio" id="Medical" value="医疗机构" name="YituoType"/>医疗机构
					<input type="radio" id="Government" value="政府机构" name="YituoType"/>政府机构
					<input type="radio" id="college"  value="社团组织" name="YituoType"/>社团组织
					<input type="radio" id="Other" value="其他" name="YituoType"/>其他
				</td>
			</tr>
			<tr>
				<td>共建单位:</td>
				<td colspan="7" style="text-align: left">
				<div id="addInput" style="float: float;">
								<input type="text" name="GongjianCompany" value="${param.constructionUnit }"/>
				
<!-- 					<div style="float: float;"> -->
<!-- 					</div> -->
				</div>
					<input style="height: 35px;width: 90px;font-size: 20px;cursor: pointer;" type="button" onclick="addInput()" value="添加一个"/>
				</td>
			</tr>
			</table>
			
			<table border="1" width="80%" align="center">
			<tr>
				<td style="width: 78px" rowspan="3">平台主任(院长)：</td>
				<td style="width: 200px">姓名</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangName"/></td>
				<td>性别</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangSex"/></td>
				<td>出生年月</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangBrith"/></td>
				<td>职称</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangZhicheng"/></td>
			</tr>
			<tr>
				<td style="width: 200px">所学专业</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangZhuanye"/></td>
				<td>学历</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangXueli"/></td>
				<td>学位</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangXuewei"/></td>
			</tr>
			<tr>
				<td style="width: 200px">办公电话</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangBangong"/></td>
				<td>手机</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangShouji"/></td>
				<td>E-mail</td>
				<td><input style="width: 100%;height: 100%" type="text" name="TaizhangEmail"/></td>
			</tr>
			<tr>
				<td>平台网站名称</td>
				<td colspan="3"><input style="width: 100%;height: 100%" type="text" name="PingtaiWebName"/></td>
				<td>网址</td>
				<td colspan="4"><input style="width: 100%;height: 100%" type="text" name="PingtaiWebaddress"/></td>
			</tr>
			<tr>
				<td>平台通讯地址</td>
				<td colspan="3"><input style="width: 100%;height: 100%" type="text" name="PingtaiTongxunDizhi"/></td>
				<td>邮编</td>
				<td colspan="4"><input style="width: 100%;height: 100%" type="text" name="mail"/></td>
			</tr>
			<tr>
				<td colspan="9">
					<input style="height: 35px;width: 65px;font-size: 20px;cursor: pointer;" type="submit" value="保存"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input style="height: 35px;width: 65px;font-size: 20px;cursor: pointer;" type="submit" value="提交" onclick="checkA()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>