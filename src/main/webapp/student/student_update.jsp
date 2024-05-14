<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
		<h2>学生情報変更</h2>
		<form id="cu" action="StudentUpdateExecute.action">
		
		<c:if test="${ErrorYAO == -1 }">
		<p class="error">再入力してクレメンス～</p>
		<br>
		</c:if>
		<label for="ent_year">入学年度</label><br>
		<input type="text" name="ent_year" value="${studentinfo.entYear }" readonly="readonly">
		<br>
		<label for="no">学生番号</label><br>
		<input type="text" name="no" value="${studentinfo.no }" readonly="readonly">
		<br>
		<label for="name">氏名</label><br>
		<input type="text" maxlength="10" name="name" value="${studentinfo.name }" required>
		<br>
		<label for="classNum">クラス</label><br>
		<select name="class_num" id="class_num">
			<c:forEach var="num" items="${classlist }">
				<c:choose>
					<c:when test="${studentinfo.classNum == num }"><option value= ${num } selected>${num }</option></c:when>
					<c:otherwise><option value= ${num }>${num }</option></c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br>
		<c:choose>
			<c:when test="${studentinfo.isAttend == true }">
				<label>在学中<input type="checkbox" name="is_attend" value="true" checked></label>
			</c:when>
			<c:otherwise>
				<label>在学中<input type="checkbox" name="is_attend" value="true"></label>
			</c:otherwise>
		</c:choose>
		<br>
		<input class="submit-blue" type="submit" id="submit_botton" value="変更">
		<br>
		<a href="../student/StudentList.action">戻る</a>
		</form>
	</div>
</div>

<%@include file="../footer.jsp" %>