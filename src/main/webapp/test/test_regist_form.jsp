<%-- 成績登録のフォーム部分 --%>

<%@ page pageEncoding="UTF-8" %>

	<div>
		科目情報
		<form action="TestRegist.action">
		<table>
		<tr>
			<th>入学年度</th>
			<th>クラス</th>
			<th>科目</th>
			<th>回数</th>
		</tr>
		<tr>
		<td><select name="f1">
			<c:choose>
				<c:when test="${empty choiceYear }"><option value="-1" selected hidden>--------</option></c:when>
				<c:otherwise><option value="${choiceYear }" selected hidden>${choiceYear }</option></c:otherwise>
			</c:choose>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${year }>${year }</option>
			</c:forEach>
		</select></td>
		<td><select name="f2">
			<c:choose>
				<c:when test="${empty choiceClass }"><option value="notselect" selected hidden>--------</option></c:when>
				<c:otherwise><option value="${choiceClass }" selected hidden>${choiceClass }</option></c:otherwise>
			</c:choose>
			<c:forEach var="num" items="${classlist }">
				<option value=${num }>${num }</option>
			</c:forEach>
		</select></td>
		<td><select name="f3">
			<c:choose>
				<c:when test="${empty choiceSubject }"><option value="notselect" selected hidden>--------</option></c:when>
				<c:otherwise><option value="${choiceSubject.cd }" selected hidden>${choiceSubject.name }</option></c:otherwise>
			</c:choose>
			<c:forEach var="s" items="${subjectlist }">
				<option value=${s.cd }>${s.name }</option>
			</c:forEach>
		</select></td>
		<td><select name="f4">
			<c:choose>
				<c:when test="${empty choiceNum }"><option value="-1" selected hidden>--------</option></c:when>
				<c:otherwise><option value="${choiceNum }" selected hidden>${choiceNum }</option></c:otherwise>
			</c:choose>
			<option value="1">1</option>
			<option value="2">2</option>
		</select></td>
		<td>
			<input type="submit" value="検索">
		</td>
		</tr>
		</table>
		</form>
		<c:if test="${testRegistError == -1 }">
		入学年度とクラスと科目と回数を入力してください。
		</c:if>
	</div>