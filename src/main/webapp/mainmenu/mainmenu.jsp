<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>メニュー</h2>
	<div>
		<a href="StudentList.action">学生管理</a>
	</div>
	<div>
		<div>成績管理</div>
		<a href="TestRegist.action">成績登録</a>
		<a href="../test/TestList.action">成績参照</a>
	</div>
	<div>
		<a href="SubjectList.action">科目管理</a>
	</div>
	</div>
</div>
<%@include file="../footer.jsp" %>