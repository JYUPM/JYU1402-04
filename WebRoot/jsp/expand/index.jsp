<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<link rel="stylesheet" href="html/css/expand.css" type="text/css" />
		<link rel="stylesheet" href="html/css/grade.css" type="text/css" />
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">扩展功能</span>
		</div>

		<div class="main-body">
			<div class="main-body-left">
				<c:if  test="${not empty isAdmin && isAdmin}">
					<a class="menu-link" href="userManagement.do">用户管理</a>|
					<a class="menu-link" href="courseManagement.do">课程管理</a>|
				</c:if>
				<a class="menu-link" href="electiveManagement.do">学生选课管理</a>
			</div>
			<div class="main-body-content">
				<IMG src="html/pic/welcome.gif">
			</div>
		</div>

		<t:foot />
	</body>
</html>