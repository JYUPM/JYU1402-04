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
			<div class="main-top">
					<span class="title">修改课程信息</span>
				</div>
				<form name="courseForm" method="POST" action="editCourse.do">
					<input type="hidden" name="flag" value="update" />
					<input type="hidden" name="course.keyId" value=<c:out value="${course.keyId}"/> />
					<table class="main-table" cellpadding="0" cellspacing="0" align="center">
						<tr >
							<td class="first">
								<span class="tip">*</span>课程号：
							</td>
							<td >
								<input type="text" name="course.courseId" maxlength="20"
									size="30" value="<c:out value="${course.courseId}"/>">
							</td>
						</tr>
						<tr >
							<td class="first">
								<span class="tip">*</span>课程名称：
							</td>
							<td>
								<input type="text" name="course.courseName" maxlength="26" size="30"
									value="<c:out value="${course.courseName}"/>">
							</td>
						</tr>
						<tr >
							<td class="first">
								<span class="tip">*</span>课时：
							</td>
							<td>
								<input type="number" name="course.courseTime" value="<c:out value="${course.courseTime}"/>">
							</td>
						</tr>
						<tr >
							<td class="first">
								<span class="tip">*</span>学分：
							</td>
							<td>
								<input type="text" name="course.courseCredit" value="<c:out value="${course.courseCredit}"/>">
							</td>
						</tr>
						<tr class="light">
							<td  class="first">
								<span class="tip">*</span>授课老师：
							</td>
							<td>
								<select name="course.teacherId">
									<c:forEach items="${userlist}" var="user" varStatus="status">
										<option value="${user.id }" <c:if test="${user.id == course.teacherId}">selected</c:if>>
											${ user.userName}
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr >
							<td colspan="2" class="ctrl-button">
									<input type="submit" value="保存">
									&nbsp;&nbsp;
									<input type="reset" value="清 除">
									&nbsp;&nbsp;
									<input type="reset" value="返 回" onclick="history.back(-1);">
							</td>
						</tr>
						<tr >
							<td colspan="2" class="note">							
								<span class="title">注 意 事 项 ：</span><br/>
								1. 请仔细核对课程的信息，确认所输入的信息是正确的，如果本次输入错了，添加成功后，还可以继续修改；<br/>
								2.<span class="tip">*</span> 为必填项，如果全部正确输入后,按“新 建”按钮进行创建。
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<t:foot />
	</body>
</html>