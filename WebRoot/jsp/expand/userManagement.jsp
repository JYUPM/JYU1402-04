<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageUser.js"></script>
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
				<form name="userForm" method="POST">
					<table  class="main-table" cellpadding="0" cellspacing="0" align="center">
						<tr class="title">
							<td></td>
							<td>账号</td>
							<td>角色</td>
						</tr>
						<c:forEach items="${userlist}" var="user">
							<tr>							
								<td>
									<c:choose>
										<c:when test="${user.role eq '1'}">
											<input type=checkbox id="${user.id}"
												value="${user.id}" disabled="disabled">
										</c:when>
										<c:otherwise>
											<input type=checkbox id="${user.id}"
												value="${user.id}">
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:out value="${user.userName}" />
								</td>
								<td>
									<c:if test="${user.role eq '1'}">系统管理员</c:if>
									<c:if test="${user.role eq '0'}">普通管理员</c:if>
									<c:if test="${user.role eq '2'}">教师</c:if>
								</td>
							</tr>
						</c:forEach>
	
						<c:if test="${empty userlist}">
							<tr>
								<td colspan=9>
									没有任何用户信息，请先添加!
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan=9 class="ctrl-button">
								<input type=button name="allcheck" value="全选"
									onclick="checkall(userForm);" />
								<input type=button name="allnotcheck" value="全不选"
									onclick="uncheckall(userForm);" />
								<input type=button name="delete" value="删除"
									onclick="deleteUser(userForm);" />
								<input type=button name="add" value="新增用户"
									onclick="addUser();" />
								<input type=button name="edit" value="修改用户信息"
									onclick="editUser(userForm);" />
							</td>
						</tr>
					</table>
					<input type=hidden name="userids" value="">
				</form>
			</div>
		</div>
		<t:foot />
	</body>
</html>