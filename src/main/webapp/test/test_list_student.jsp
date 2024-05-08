
<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>成績管理</h2>
	<%@include file="test_list_form.jsp" %>
	<div>
	<c:choose>
	<c:when test="${empty choiceStudent.name }">
	学生情報が存在しませんでした
	</c:when>
	<c:when test="${empty testListStudent }">
	氏名:${choiceStudent.name }(${choiceStudent.no })
	成績情報が存在しませんでした
	</c:when>
	<c:otherwise>
	氏名:${choiceStudent.name }(${choiceStudent.no })
	<table class="sql">
		<tr>
			<th>科目名</th>
			<th>科目コード</th>
			<th>回数</th>
			<th>点数</th>
		</tr>
		<c:forEach var="test" items="${testListStudent }">
		<tr>
			<td>${test.subjectName }</td>
			<td>${test.subjectCd }</td>
			<td>${test.num }</td>
			<td>${test.point }</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
	</div>
	</div>
</div>
<%@include file="../footer.jsp" %>
