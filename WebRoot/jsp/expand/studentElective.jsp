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
					<span class="title">当前您选课情况</span>
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
							<td>是否已经结课</td>
							<td>成绩</td>
						</tr>
						<c:forEach items="${electivelist}" var="elective">
							<c:forEach items="${courselist}" var="course">
								<c:if test="${course.courseId == elective.courseId}">
								<tr>							
									<td>
										<input type=checkbox id="${elective.keyId}"
											value="${elective.keyId}">
									</td>
									
										<td>
											<c:out value="${elective.courseId}" />
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
											<c:if test="${elective.close eq 0 }">否</c:if>
											<c:if test="${elective.close eq 1 }">是</c:if>
										</td>
										<td>
											<c:if test="${elective.close eq 0 }">未结课</c:if>
											<c:if test="${elective.close eq 1 }">
												<c:out value="${elective.grade}" />
											</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
	
						<c:if test="${empty electivelist}">
							<tr>
								<td colspan=9>
									没有任何已选课程信息，请先<a href="addElective.do">选择新课程</a>!
								</td>
							</tr>
						</c:if>
						<tr>
							<td colspan=9 class="ctrl-button">
								<input type=button name="allcheck" value="全选"
									onclick="checkall(courseForm);" />
								<input type=button name="allnotcheck" value="全不选"
									onclick="uncheckall(courseForm);" />
								<input type=button name="add" value="新增选课"
									onclick="addElectiveCourse(courseForm);" />
								<input type=button name="delete" value="退选课程"
									onclick="deleteElectiveCourse(courseForm);" />
							</td>
						</tr> 
					</table>
					<input type=hidden name="electiveids" value="">
				</form>
			</div>
		</div>
		<t:foot />
	</body>
</html>