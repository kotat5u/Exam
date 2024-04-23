<%@page contentType="text/html; charset=UTF-8" %>

<%-- ヘッダー読み込み --%>
<%@include file="../header.jsp" %>
<div id="wrapper">
	<%-- サイドバー読み込み --%>
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>メニュー</h2>
	<div>
		<a href="../student/StudentList.action">学生管理</a>
	</div>
	<div>
		<div>成績管理</div>
		<a href="../test/TestRegist.action">成績登録</a>
		<a href="../test/TestList.action">成績参照</a>
	</div>
	<div>
		<a href="../subject/SubjectList.action">科目管理</a>
	</div>
	</div>
</div>
<%-- フッターを読み込み --%>
<%@include file="../footer.jsp" %>