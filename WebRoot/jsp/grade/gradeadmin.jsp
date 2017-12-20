<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script language="javascript" src="html/js/manageGrade.js"></script>
		<link rel="stylesheet" href="html/css/grade.css" type="text/css"></link>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">学生成绩管理</span>
		</div>

		<div class="main-body">
			<form name="gradeForm" method="POST">
				<table class="main-table" cellspacing="0" width="100%" border="1"
					align="center">
					<tr class="title">
						<td>
							&nbsp;
						</td>
						<td>
							学号
						</td>
						<td class="name">
							姓名
						</td>
						<td>
							各科成绩
						</td>
						<td>
							总 分
						</td>
					</tr>
					<c:forEach items="${studentlist}" var="student" varStatus="status">
						<c:set var="student" value="${student}"></c:set>
						<c:set var="stuIndex" value="${status.index }"></c:set>
						<c:set var="total" value="0"></c:set>
						<tr>
							<td>
								<input type=checkbox id="${student.stuNumber}"
									value="${student.stuNumber}">
							</td>
							<td>
								${student.stuNumber}
							</td>
							<td>
								<c:out value="${student.username}"></c:out>
							</td>
							<td>
								<c:forEach items="${electiveMap}" var="elective" varStatus="electiveStatus">
									<c:if test="${elective.key == stuIndex }">
										<c:choose>
											<c:when test="${not empty elective.value}">
												<c:forEach items="${elective.value }" var="ele">
													<c:choose>
														<c:when test="${ele.close == 1}">
															<span>
																<c:forEach items="${courselist }" var="course">
																	<c:if test="${course.courseId == ele.courseId}">
																		<c:set var="total" value="${total+ele.grade }"></c:set>
																		${course.courseName} : ${ele.grade}
																	</c:if>
																</c:forEach>
															</span>
															<br/>
														</c:when>
														<c:otherwise>
															<span>
																${course.courseName} : 暂未录入数据
															</span>
															<br/>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<span>
													该学生暂未有选课记录
												</span>
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>
								
							</td>
							<td class="num">
								<c:out value="${total}" default="0"></c:out>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="12" class="ctrl-button">
							<input type=hidden name="studentids" value="">
							<input type="hidden" name="from" value="gradeadmin">
							<input type=button name="allcheck" value="全选"
								onclick=javascript:checkall(gradeForm); />
							<input type=button name="allnotcheck" value="全不选"
								onclick=javascript:uncheckall(gradeForm); />
							<input type=button name="delete" value="删除"
								onclick=javascript:deletegrade(gradeForm); />
							<input type=button name="addgrade" value="维护学生成绩"
								onclick=javascript:modifygrade(gradeForm); />
						</td>
					</tr>

				</table>
			</form>
		</div>

		<t:foot />
	</body>
</html>