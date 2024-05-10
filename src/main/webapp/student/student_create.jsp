<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
		<h2>学生情報登録</h2>
		<form id="cu" action="StudentCreateExecute.action">
			
		<label for="ent_year">入学年度</label><br>
		<select name="ent_year" id="ent_year">
			<option value="-1" selected>--------</option>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${year }>${year }</option>
			</c:forEach>
		</select>
		<br>
			<c:if test="${EDOKKOerror == -1 }">
				<p class="error">入学年度を入力してください</p>
			</c:if>
		<label for="no">学生番号</label><br>
			<c:choose>
				<c:when test="${EDOKKOerror == -1 }">
					<input type="text" maxlength="10" name="no" value="${studentinfo.no }"
						placeholder="学生番号を入力してください。" required>
				</c:when>
				<c:otherwise>
					<input type="text" maxlength="10" name="no" value="${no }"
						placeholder="学生番号を入力してください。" required>
			<c:if test="${PKerrorDAO == -1 }">
				<p class="error">学生番号が重複しています</p>
			</c:if>
				</c:otherwise>
			</c:choose>
			<br>
		<label for="name">氏名</label><br>
			<c:choose>
				<c:when test="${EDOKKOerror == -1 }">
					<input type="text" maxlength="10" name="name" value="${studentinfo.name }"
						placeholder="氏名を入力してください。" required>
				</c:when>
				<c:otherwise>
					<input type="text" maxlength="10" name="name" value="${name }"
						placeholder="氏名を入力してください。" required>
				</c:otherwise>
			</c:choose>
		<br>
		<label for="classNum">クラス</label><br>
			<c:choose>
				<c:when test="${EDOKKOerror == -1 }">
					<select name="class_num" id="class_num">
					<c:forEach var="num" items="${classlist }">
						<option value=${studentinfo.classNum }>${num }</option>
					</c:forEach>
				</select>
				</c:when>
				<c:otherwise>
					<select name="class_num" id="class_num">
						<c:forEach var="num" items="${classlist }">
							<option value=${num }>${num }</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		<br>
		<input class="submit-grey" type="submit" id="submit_botton" value="登録して終了">
		<br>
		</form>
		<a href="StudentList.action">戻る</a>
	</div>
</div>

<%@include file="../footer.jsp" %>