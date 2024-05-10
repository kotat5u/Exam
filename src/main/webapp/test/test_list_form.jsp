<%-- 成績一覧のフォーム部分 --%>

<%@ page pageEncoding="UTF-8" %>
<div class="form">
	<div id="tlsbj">
		<div>科目情報</div>
		<div>
		<table>
		<tr>
			<th>入学年度</th>
			<th>クラス</th>
			<th>科目</th>
		</tr>
		
		<form action="TestListSubjectExecute.action">
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
		<td>
			<input class="submit-grey" type="submit" value="検索">
		</td>
		</tr>
		</form>
		</table>
		</div>
		<c:if test="${testSubjectError == -1 }">
		入学年度とクラスと科目を入力してください。
		</c:if>
	</div>
	<div id="tlstu">
		<div>学生情報</div>
		<div>
		<form action="TestListStudentExecute.action">
			<c:choose>
				<c:when test="${empty choiceStudent }"><input type="text" name="f4" placeholder="学生番号を入力してください" required></c:when>
				<c:otherwise><input type="text" name="f4" value="${choiceStudent.no }" placeholder="学生番号を入力してください" required></c:otherwise>
			</c:choose>
			<input class="submit-grey" type="submit" value="検索">
		</form>
		</div>
	</div>
</div>