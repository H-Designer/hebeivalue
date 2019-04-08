<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			alert("系统友情提示",'最多只能有3个条件');
			return;
		}
		var strId = t.rows.length;

		var e = document.createElement("select");
		e.name = "logic" + strId;
		e.id = "logic" + strId;
		e.size = 1;
		e.options[0] = new Option("并且", "and");
		e.options[1] = new Option("或者", "or");
		e.options[2] = new Option("不含", "not");

		var e2 = document.createElement("select");
		e2.name = "sType" + strId;
		e2.id = "sType" + strId;
		e2.size = 1;
		e2.options[0] = new Option("需求名称", "nd_name");
		e2.options[1] = new Option("机构名称", "jgmc");
		e2.options[2] = new Option("关键字", "keyw");

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
<form name="thisform" action="${pageContext.request.contextPath }/servlet/needServlet?method=findZH" method="post"
						onsubmit="return check();">
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
										<td colspan="2" align="left" bgcolor="#FFFFFF"
											style="padding-left: 20px;">
											<table bgcolor="#FFFFFF" cellspacing="1" cellpadding="0"
												id="sTable">
												<tbody>
													<tr id="row1">
														<td style="width: 60px;" align="center"><img
															src="${pageContext.request.contextPath }/static/css/images/11.png" title="增加限制条件" onclick="addRow()"
															style="cursor: hand;"> <img src="../static/css/images/22.png"
															title="移除限制条件" onclick="removeRow()"
															style="cursor: hand;"></td>
														<td><select name="sType0" size="1">
																<option value="nd_name">需求名称</option>
																<option value="jgmc">机构名称</option>
																<option value="keyw">关键字</option>
														</select> <input type="text" size="50" maxlength="80" name="q0"
															id="q0"> <input type="submit" class="submit"
															value="&nbsp;查&nbsp;询&nbsp;" size="30"></td>
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
	<c:if test="${ param.status==1}">
	<div style = "height:50px;"></div>
		<table class = "table table-striped">
			<thead>
				<th>序号</th>
				<th>技术需求名称</th>
				<th>机构名称</th>
				<th>关键字</th>
				<th>需求状态</th>
			</thead>
			<tbody>
				<c:forEach items="${needBeans}" var="item">
					<tr>
						<td>${item.nd_id}</td>
						<td><a href = "${pageContext.request.contextPath }/servlet/needServlet?method=listDetail&nd_id=${item.nd_id}">${ item.nd_name}</a></td>
						<td>${item.jgmc}</td>
						<td>${item.key}</td>
						<c:if test="${item.nd_state==1 }">
							<td>未审核</td>
						</c:if>
						<c:if test="${item.nd_state==2 }">
							<td>已审核</td>
						</c:if>
						<c:if test="${item.nd_state==3 }">
							<td>被退回</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</c:if>
	<c:if test="${ param.status==2}">
		<div class = "col-md-12 alert alert-danger">
			尚未录入需求信息！
		</div>
	</c:if>
	</div>
</body>
</html>