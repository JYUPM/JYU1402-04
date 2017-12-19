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
			<div class="main-top">
					<span class="title">请勾选表格中的课程进行选修</span>
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
						</tr>
						<c:forEach items="${courselist}" var="course">
							<tr>							
								<td>
									<input type=checkbox id="${course.courseId}"
										value="${course.courseId}">
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
							</tr>
						</c:forEach>
	
						<c:if test="${empty courselist}">
							<tr>
								<td colspan=9>
									没有任何课程信息，等待管理员添加新课程</a>!
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan=9 class="ctrl-button">
								<input type=button name="allcheck" value="全选"
									onclick="checkall(courseForm);" />
								<input type=button name="allnotcheck" value="全不选"
									onclick="uncheckall(courseForm);" />
								<input type=button name="add" value="确定选修"
									onclick="defineElectiveCourse(courseForm);" />
							</td>
						</tr> 
					</table>
					<input type=hidden name="courseids" value="">
				</form>
			</div>
		</div>
		<t:foot />
	</body>
</html>