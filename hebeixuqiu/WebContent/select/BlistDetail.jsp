<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="Dao.XuqiuDao"%>
   <%@page import="Message.Mes"%>
   <%@page import="java.util.List"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->

<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<title>BList</title>
</head>
<body>
<table class = "table table-striped">
			<tr>
				<th>平台名称</th>
				<th>平台级别</th>
				<th>所属学科</th>
				<th>服务经济行业</th>
				<th>京津冀共建</th>
				<th>依托类型</th>
				
			</tr>
			<%
			List<Mes> needBeans =(List<Mes>)request.getAttribute("needBeans");
				//XuqiuDao needDao = new XuqiuDao();
				//List<Mes> needbean=needDao.listNeed();
					for(Mes needbean1:needBeans )
					{		
			%>
			<tr>
		<td><%=needbean1.getPlatname()%></td>
		<td><%=needbean1.getPingtaiLevel()%></td>
		<td><%=needbean1.getXueke()%></td>
		<td><%=needbean1.getEconoyServing()%></td>
		<td><%=needbean1.getBTHconstruction()%></td>
				<td><%=needbean1.getYituoType()%></td>
		
		  <%} %>
		  
			</tr>
			
		</table>	
</body>
</html>