<%-- 成績登録のフォーム部分 --%>

<%@ page pageEncoding="UTF-8" %>

	<div>
		科目情報
		<form action="TestListSubjectExecute.action">
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
			<c:when test="${empty  }"<option value="-1" selected hidden>--------</option>
			</c:choose>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${year }>${year }</option>
			</c:forEach>
		</select></td>
		<td><select name="f2">
			<option value="notselect" selected hidden>--------</option>
			<c:forEach var="num" items="${classlist }">
				<option value=${num }>${num }</option>
			</c:forEach>
		</select></td>
		<td><select name="f3">
			<option value="notselect" selected hidden>--------</option>
			<c:forEach var="s" items="${subjectlist }">
				<option value=${s.cd }>${s.name }</option>
			</c:forEach>
		</select></td>
		<td><select name="f4">
			<option value="notselect" selected hidden>--------</option>
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
		入学年度とクラスと科目を入力してください。
		</c:if>
	</div>