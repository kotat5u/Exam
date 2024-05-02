<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
		<h2>学生情報変更</h2>
		<form action="StudentUpdateExecute.action">
		
		<c:if test="${ErrorYAO == -1 }">
		再入力してクレメンス～
		<br>
		</c:if>
		<label for="ent_year">入学年度</label>
		<input type="text" name="ent_year" value="${studentinfo.entYear }" readonly="readonly">
		<br>
		<label for="no">学生番号</label>
		<input type="text" name="no" value="${studentinfo.no }" readonly="readonly">
		<br>
		<label for="name">氏名</label>
		<input type="text" maxlength="10" name="name" value="${studentinfo.name }" required>
		<br>
		<label for="classNum">クラス</label>
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
				<label><input type="checkbox" name="is_attend" value="true" checked>在学中</label>
			</c:when>
			<c:otherwise>
				<input type="checkbox" name="is_attend" value="true">在学中</label>
			</c:otherwise>
		</c:choose>
		<br>
		<input type="submit" id="submit_botton" value="変更">
		<br>
		<a href="../student/StudentList.action">戻る</a>
		</form>
	</div>
</div>