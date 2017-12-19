<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageCourse.js"></script>
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
				<form name="courseForm" method="POST">
					<table  class="main-table" cellpadding="0" cellspacing="0" align="center">
						<tr class="title">
							<td></td>
							<td>课程号</td>
							<td>课程名称</td>
							<td>课时</td>
							<td>学分</td>
							<td>授课老师</td>
							<td>选修学生人数</td>
						</tr>
						<c:forEach items="${courselist}" var="course">
							<c:set var="total" value="0"></c:set>
							<tr>							
								<td>
									<input type=checkbox id="${course.keyId}"
										value="${course.keyId}">
								</td>
								<td>
									<c:out value="${course.courseId}" />
								</td>
								<td>
									<c:out value="${course.courseName}" />
								</td>
								<td>
									<c:out value="${course.courseTime}" />
								</td>
								<td>
									<c:out value="${course.courseCredit}" />
								</td>
								<td>
									<c:forEach items="${userlist}" var="user">
										<c:if test="${course.teacherId == user.id }">
											<c:out value="${user.userName}" />
										</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach items="${electiveList}" var="elective">
										<c:if test="${elective.courseId == course.courseId}">
											<c:set var="total" value="${total +1 }"></c:set>
										</c:if>
									</c:forEach>
									${total }
								</td>
							</tr>
						</c:forEach>
						<c:if test="${empty courselist}">
							<tr>
								<td colspan=9>
									没有任何课程信息，请先<a href="addCourse.do">添加新课程</a>!
								</td>
							</tr>
						</c:if>
					</table>
					<input type=hidden name="courseids" value="">
				</form>
			</div>
		</div>
		<t:foot />
	</body>
</html>