<%@page contentType="text/html; charset=UTF-8" %>

<%-- ヘッダー読み込み --%>
<%@include file="../header.jsp" %>
<div id="wrapper">
	<%-- サイドバー読み込み --%>
	<%@include file="../sidebar.jsp" %>
	<div id="mainmenu">
	<h2>メニュー</h2>
	<section>
	<div class="red menu">
		<a href="../student/StudentList.action">学生管理</a>
	</div>
	<div class="green menu">
		<div>
		成績管理<br>
		<a href="../test/TestRegist.action">成績登録</a><br>
		<a href="../test/TestList.action">成績参照</a>
		</div>
	</div>
	<div class="blue menu">
		<a href="../subject/SubjectList.action">科目管理</a>
	</div>
	</section>
	</div>
	
	<div id="special">
	<section id="tounai">
	</section>
	<section id="katoh">
	<a href="https://godfield.net/"><img src="../images/godfield1.png" alt="GODFIELD"></a>
	</section>
	</div>
</div>
<%-- フッターを読み込み --%>
<%@include file="../footer.jsp" %>