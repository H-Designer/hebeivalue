<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jQuery treeview</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/jquery.treeview.css" />


<script src="${pageContext.request.contextPath }/static/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery.treeview.async.js" type="text/javascript"></script>
<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
		
	</script>
<style type="text/css">
	a{
		text-decoration:none;
		color:#000;
	}
	body{

		margin:0px;
		border-top:3px solid #ccc;
		border-right:3px solid #ccc;
	}

</style>
</head>
<body>

<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">收起所有</a> | <a href="?#">展开所有</a></div>

<ul id="tree" style = "width:220px;height:430px;">
	<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=1" target="mainActionList"><strong>所有类型分类</strong></a>
	<ul>
		<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=2" target="mainActionList">京津冀共建</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=5" target="mainActionList">是</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=6" target="mainActionList">否</a></li>
		</ul>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=3" target="mainActionList">平台级别</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=7" target="mainActionList">国家级</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=8" target="mainActionList">省级</a></li>
		</ul>
		</li>
		<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=17" target="mainActionList">所属学科</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=18" target="mainActionList">外语</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=19" target="mainActionList">数学</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=20" target="mainActionList">物理</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=21" target="mainActionList">生物</a></li>
			
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=23" target="mainActionList">金融</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=24" target="mainActionList">文史</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=22" target="mainActionList">其他</a></li>
		</ul>
		</li>
		
		<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=4" target="mainActionList">依托类型</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=9" target="mainActionList">企业</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=10" target="mainActionList">科研机构</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=11" target="mainActionList">高等院校</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=12" target="mainActionList">检测机构</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=13" target="mainActionList">医疗机构</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=14" target="mainActionList">政府机构</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=15" target="mainActionList">社团</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=16" target="mainActionList">其他</a></li>
		</ul>
		</li>
		<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=25" target="mainActionList">服务经济行业</a>
		<ul>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=33" target="mainActionList">教育</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=26" target="mainActionList">金融</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=27" target="mainActionList">房地产</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=28" target="mainActionList">餐饮住宿</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=29" target="mainActionList">医疗</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=30" target="mainActionList">科学技术</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=31" target="mainActionList">环境经济</a></li>
			<li><a href="${pageContext.request.contextPath }/severLet/BrowseSeverlet?method=get&n=32" target="mainActionList">其他</a></li>
		</ul>
		</li>

	</ul>
	</li>
	<li><a href="${pageContext.request.contextPath }/select/action.jsp" target="_parent"><strong>返回主系统</strong></a></li>
</ul>
</div>

</body>

</html>