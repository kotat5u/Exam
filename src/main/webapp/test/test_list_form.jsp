<%-- 成績一覧のフォーム部分 --%>

<%@ page pageEncoding="UTF-8" %>

<div>
		科目情報
		<form action="TestListSubjectExecute.action">
		<table>
		<tr>
			<th>入学年度</th>
			<th>クラス</th>
			<th>科目</th>
		</tr>
		<tr>
		<td><select name="f1">
			<option value="-1" selected hidden>--------</option>
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
		<td>
			<input type="submit" value="検索">
		</td>
		</tr>
		</table>
		</form>
		<c:if test="${tstSubjectError == -1 }">
		入学年度とクラスと科目を入力してください。
		</c:if>
	</div>
	<div>
		学生情報
		<form action="TestListStudentExecute.action">
			<input type="text" name="f4" placeholder="学生番号を入力してください" required>
			<input type="submit" value="検索">
		</form>
	</div>