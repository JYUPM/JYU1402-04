<%@tag pageEncoding="utf-8" body-content="empty"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="top">
	<div class="logo"></div>
	<div class="welcome">
		<span style="color: green">欢迎 <span
			style="color: red; font-weight: bold">
			<c:if test="${not empty user}">
				${user.userName}
			</c:if>
			<c:if test="${not empty students}">
				${student.username}
			</c:if>
			</span>使用大学学籍管理系统
		</span>
	</div>
	<div class="menu">
		<c:if test="${empty user && empty students}">
			<a class="menu-link" href="#">学籍管理首页</a>|
			<a class="menu-link" href="#">扩展功能</a>
		</c:if>
		<c:if test="${not empty user}">
			<a class="menu-link" href="login.do">学籍管理首页</a>|
			<c:if test="${not empty isAdmin && isAdmin}">
				<a class="menu-link" href="addStudent.do">新建学生</a>|
				<a class="menu-link" href="studentAdmin.do">学生基本信息管理</a>|
				<a class="menu-link" href="studentList.do">学生一览表</a>|
				<a class="menu-link" href="studentSearchall.do">学生基本信息查询</a>|
				<a class="menu-link" href="gradeAdmin.do">学生成绩管理</a>|
				<!--  <a class="menu-link" href="gradeList.do">学生成绩一览表</a>|
				<a class="menu-link" href="gradeSearch.do">学生成绩查询</a>|-->
				<a class="menu-link" href="expandList.do">扩展功能</a>|
			</c:if> 
			<c:if test="${not empty isTeacher && isTeacher}">
				<a class="menu-link" href="expandList.do">扩展功能</a>|
			</c:if>
			<a class="menu-link" href="javascript:exit();">退出系统</a>
		</c:if>
		<c:if test="${not empty students}">
			<c:if test="${not empty isStudent && isStudent}">
				<a class="menu-link" href="studentElective.do">学生选课</a>|
			</c:if>
			<a class="menu-link" href="javascript:exit();">退出系统</a>
		</c:if>
		<c:if test="${empty user && empty students}">
			|<a class="menu-link" href="login.do">登录系统</a>
		</c:if>
	</div>
</div>


<script language="javascript">
	function exit() {
		alert("欢迎你下次继续登录本网站！");
		location.href = "logout.do?rnd=" + new Date().getTime();
	}
</script>