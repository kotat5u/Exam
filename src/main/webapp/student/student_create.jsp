<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
		<h2>学生情報登録</h2>
		<form action="StudentCreateExecute.action">
			
		<label for="ent_year">入学年度</label>
		<select name="ent_year" id="ent_year">
			<option value="-1" selected>--------</option>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${year }>${year }</option>
			</c:forEach>
		</select>
		<br>
		<label for="no">学生番号</label>
		<input type="text" maxlength="10" name="no" value="${no }"
			placeholder="学生番号を入力してください。" required>
		<br>
		<c:if test="${PKerrorDAO == -1 }">
		学生番号が重複しています
		<br>
		</c:if>
		<label for="name">氏名</label>
		<input type="text" maxlength="10" name="name" value="${name }"
			placeholder="氏名を入力してください。" required>
		<br>
		<label for="classNum">クラス</label>
		<select name="class_num" id="class_num">
			<c:forEach var="num" items="${classlist }">
				<option value=${num }>${num }</option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" id="submit_botton" value="登録して終了">
		<br>
		</form>
	</div>
</div>

<%@include file="../footer.jsp" %>
