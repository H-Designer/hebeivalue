<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listDetail</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container">
		<div style = "height:50px;width:100%;"></div>
	<h3 class = "text-center">技术需求详细信息</h3>
		<table class = "table table-striped">
			<tr>
				<td>序号</td>
				<td>${needBean.nd_id}</td>
				
			</tr>
			<tr>
				<td>技术需求名称</td>
				<td>${needBean.nd_name}</td>
			</tr>
			<tr>
				<td>机构名称</td>
				<td>${needBean.jgmc}</td>
			</tr>
			<tr>
				<td>通讯地址</td>
				<td>${needBean.txdz }</td>
			</tr>
			<tr>
				<td>单位网址</td>
				<td>${needBean.dwwz }</td>
			</tr>
			<tr>
				<td>联系人</td>
				<td>${needBean.lxr }</td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td>${needBean.email }</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>${needBean.phone }</td>
			</tr>
			<tr>
				<td>传真</td>
				<td>${needBean.cz }</td>
			</tr>
			<tr>
				<td>机构属性</td>
				<td>${needBean.jgsx }</td>
			</tr>
			<tr>
				<td>机构简介</td>
				<td>${needBean.jgjj }</td>
			</tr>
			<tr>
				<td>研究类型</td>
				<td>${needBean.yjlx }</td>
			</tr>
			<tr>
				<td>学科分类</td>
				<td>${needBean.xkfl }</td>
			</tr>
			<tr>
				<td>需求所属领域</td>
				<td>${needBean.ssly }</td>
			</tr>
			<tr>
				<td>需求应用行业</td>
				<td>${needBean.yyhy }</td>
			</tr>
			<tr>
				<td>合作模式</td>
				<td>${needBean.hzms }</td>
			</tr>
			<tr>
				<td>重大科技需求概述</td>
				<td>${needBean.nd_gs}</td>
			</tr>
			<tr>
				<td>研究类型</td>
				<td>${needBean.yjlx}</td>
			</tr>
			<tr>
				<td>技术需求合作模式</td>
				
				<td>${needBean.hzms}</td>
			</tr>
			<tr>
				<td>计划总投资</td>
				<td>${needBean.ztz}万元</td>
			</tr>
		</table>
	</div>
</body>
</html>