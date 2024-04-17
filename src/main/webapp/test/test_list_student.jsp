
<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>成績管理</h2>
	<%@include file="test_list_form.jsp" %>
	<div>
	科目:${choiceStudnt.name }(${choiceStudent.no })
	<table>
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
	</div>
	</div>
</div>
<%@include file="../footer.jsp" %>