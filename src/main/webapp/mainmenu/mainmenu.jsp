<%@page contentType="text/html; charset=UTF-8" %>

<%-- ヘッダー読み込み --%>
<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:choose>
			<c:when test="${now == 1 }">
				<p>おはようございます！<br>
				今日も一日かましましょう！</p>
			</c:when>
			<c:when test="${now == 2 }">
				<p>こんにちは！<br>
				お昼ご飯を用意してあるので<br>
				そろそろ休憩しましょう！</p>
			</c:when>
			<c:when test="${now == 3 }">
				<p>もうそろそろ終業時間ですね！<br>
				本日もお疲れ様でした。</p>
			</c:when>
			<c:otherwise>
				<p>こんばんは！<br>
				もうそろそろ終業していいんじゃないの？<br>
				Used to be 諦めるのは easy</p>
			</c:otherwise>
		</c:choose>
	</section>
	<br>
	<section id="katoh">
	<a href="https://godfield.net/">
	<img src="../images/godfield.png" alt="GODFIELD" width="232">
	<p></p></a>
	</section>
	</div>
</div>
<%-- フッターを読み込み --%>
<%@include file="../footer.jsp" %>