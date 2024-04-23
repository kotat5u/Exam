<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>成績管理</h2>
	<%-- フォームを読み込み --%>
	<%@include file="test_regist_form.jsp" %>
	<c:if test="${empty first }">
	<div>
		<h2>科目:${choiceSubject.name }(${choiceNum }回)</h2>
		<form action="TestRegistExecute.action">
		<table>
		<tr>
			<th>入学年度</th>
			<th>クラス</th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>点数</th>
		</tr>
		<c:forEach var="test" items="${testRegistList }">
		<tr>
			<td>${test.student.entYear }</td>
			<td>${test.classNum }</td>
			<td>${test.student.no }</td>
			<td>${test.student.name }</td>
			<td>
			<c:choose>
				<c:when test="${empty test.point }"><input type="number" name="${test.student.no }" min="0" max="100"></c:when>
				<c:otherwise><input type="number" name="${test.student.no }" value="${test.point}" min="0" max="100"></c:otherwise>
			</c:choose>
			</td>
		</tr>
		</c:forEach>
		</table>
		<input type="submit" value="登録して終了">
		</form>
	</div>
	</c:if>
	</div>
</div>
<%@include file="../footer.jsp" %>