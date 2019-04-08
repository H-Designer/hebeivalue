<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="Dao.XuqiuDao"%>
   <%@page import="Message.Mes"%>
   <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>综合查询</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/messages_zh.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<script type="text/javascript">
	/* 加减条件的js代码（1）开始  */
	function check() {
		var num = document.getElementById("num");
		if (num.value == "1") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示","首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
		}
		if (num.value == "2") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示","首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			} else {
				if (document.getElementById('q1').value == "") {
					alert("系统友情提示","第二项查询条件不能为空");
					thisform.q1.focus();
					return false;
				}
			}
		}
		if (num.value == "3") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示","首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
			if (document.getElementById('q1').value == "") {
				alert("系统友情提示","第二项查询条件不能为空");
				thisform.q1.focus();
				return false;
			}
			if (document.getElementById('q2').value == "") {
				alert("系统友情提示","第三项查询条件不能为空");
				thisform.q2.focus();
				return false;
			}
		}
		if (num.value == "4") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示","首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
			if (document.getElementById('q1').value == "") {
				alert("系统友情提示","第二项查询条件不能为空");
				thisform.q1.focus();
				return false;
			}
			if (document.getElementById('q2').value == "") {
				alert("系统友情提示","第三项查询条件不能为空");
				thisform.q2.focus();
				return false;
			}
			if (document.getElementById('q3').value == "") {
				alert("系统友情提示","第四项查询条件不能为空");
				thisform.q3.focus();
				return false;
			}
		}
		if (num.value == "5") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示","首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
			if (document.getElementById('q1').value == "") {
				alert("系统友情提示","第二项查询条件不能为空");
				thisform.q1.focus();
				return false;
			}
			if (document.getElementById('q2').value == "") {
				alert("系统友情提示","第三项查询条件不能为空");
				thisform.q2.focus();
				return false;
			}
			if (document.getElementById('q3').value == "") {
				alert("系统友情提示","第四项查询条件不能为空");
				thisform.q3.focus();
				return false;
			}
			if (document.getElementById('q4').value == "") {
				alert("系统友情提示","第五项查询条件不能为空");
				thisform.q4.focus();
				return false;
			}
		}
	}

	function addRow() {
		var obj = document.getElementById("num");
		var t = document.getElementById("sTable");
		if (t.rows.length >= 3) {
			alert("最多只能有3个条件",'');
			return;
		}
		var strId = t.rows.length;

		var e = document.createElement("select");
		e.name = "logic" + strId;
		e.id = "logic" + strId;
		e.size = 1;
		e.options[0] = new Option("并且", "and");
		e.options[1] = new Option("或者", "or");

		var e2 = document.createElement("select");
		e2.name = "sType" + strId;
		e2.id = "sType" + strId;
		e2.size = 1;
		e2.options[0] = new Option("平台名称", "platname");
		e2.options[1] = new Option("平台级别", "PingtaiLevel");
		e2.options[2] = new Option("依托类型", "YituoType");

		var q1 = document.createElement("input");
		q1.type = "text";
		q1.size = 50;
		q1.maxlength = 60;
		q1.name = "q" + strId;
		q1.id = "q" + strId;

		var row = t.insertRow(t.rows.length);
		var c0 = row.insertCell(0);
		c0.appendChild(e);

		var c1 = row.insertCell(1);
		c1.appendChild(e2);
		c1.appendChild(q1);
		obj.value = parseInt(obj.value) + 1; //查询框的数量

	}

	function removeRow() {
		var obj = document.getElementById("num");
		tr = document.getElementById("sTable").rows;
		if (tr.length > 1) {
			var row = tr[tr.length - 1];
			if (row.parentNode)
				row.parentNode.removeChild(row);
			obj.value = parseInt(obj.value) - 1;
		}
	}
	/* 加减条件的js代码（1）结束  */
</script>

</head>
<body>
<form action="${pageContext.request.contextPath }/severLet/MulQSeverlet" method="post">
	<input type="hidden" id="num" name="num" value="1" />
	<input type="hidden" id="Type11" name="Type11" >
	<input type="hidden" id="Scope11" name="Scope11" >
	<div class="search"
		style="border-style: groove; border-width: 0px; width: 90%; border-color: #000; margin-left: 5%;margin-bottom:14px">
		<table width="95%" cellpadding="3" border="0" cellspacing="1"
			bgcolor="#FFFFFF">
			<caption style="color: red;"></caption>
			<tbody>
				<tr>
					<td colspan="2" align="left" bgcolor="#FFFFFF"style="padding-left: 20px;">
						<table bgcolor="#FFFFFF" cellspacing="1" cellpadding="0"id="sTable">
							<tbody>
								<tr id="row1">
									<td style="width: 60px;" align="center">
										<img src="${pageContext.request.contextPath }/static/css/images/11.png" title="增加限制条件" onclick="addRow()"style="cursor: hand;"> 
										<img src="${pageContext.request.contextPath }/static/css/images/22.png"title="移除限制条件" onclick="removeRow()"style="cursor: hand;">
									</td>
									<td><select name="sType0" size="1">
											<option value="platname">平台名称</option>
											<option value="PingtaiLevel">平台级别</option>
											<option value="YituoType">依托类型</option>
										</select> <input type="text" size="50" maxlength="80" name="q0"id="q0">
										 <input type="submit" class="submit"value="&nbsp;查&nbsp;询&nbsp;" size="30">
									 </td>
								</tr>													
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</form> <!--页面查询条件控件代码 结束部分（2）  -->
	<div class = "container">
	
	
	<div style = "height:50px;"></div>
		<table class = "table table-striped">
			<thead>
				<th>平台名称</th>
				<th>平台级别</th>
				<th>依托类型</th>
				<th>依托单位</th>
				<th>所在市县</th>
			</thead>
			<tbody> 
	<tr>
	<%
				List<Mes> needBeans =(List<Mes>)request.getAttribute("needBeans");
					if(needBeans!=null)
				//XuqiuDao needDao = new XuqiuDao();
				//List<Mes> needbean=needDao.listNeed();
					for(Mes needbean1:needBeans )
					{		
			%>
			<tr>
		<td><%=needbean1.getPlatname()%></td>
		<td><%=needbean1.getPingtaiLevel()%></td>
		<td><%=needbean1.getYituoType()%></td>
		<td><%=needbean1.getYituoCompany()%></td>
		<td><%=needbean1.getLocation()%></td>
		  <%} %>
		  
	</tr>
	
	</div>
</body>
</html>