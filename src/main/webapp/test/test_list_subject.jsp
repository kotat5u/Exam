<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>成績管理</h2>
	<%@include file="test_list_form.jsp" %>
	<div>
	科目:${choiceSubject.name }
	<table>
		<tr>
			<th>入学年度</th>
			<th>クラス</th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>1回</th>
			<th>2回</th>
		</tr>
		<c:forEach var="test" items="${testListSubject }">
		<tr>
			<td>${test.entYear }</td>
			<td>${test.classNum }</td>
			<td>${test.studentNo }</td>
			<td>${test.studentName }</td>
			<td>${empty test.getPoint(1) ? "-" : test.getPoint(1) }</td>
			<td>${empty test.getPoint(2) ? "-" : test.getPoint(2) }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</div>
<%@include file="../footer.jsp" %>