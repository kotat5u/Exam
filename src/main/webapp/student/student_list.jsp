<%@page contentType="text/html charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
		<h2>学生管理</h2>
		<%@include file="student_list_form.jsp" %>
		<c:choose>
			<c:when test="${SELECTerror == -1 }">
				<p>クラスを指定する場合は入学年度も指定してください。</p>
			</c:when>
			<c:when test="${studentlist.size()==0 }">
				<p>学生情報が存在しませんでした。</p>
			</c:when>
			<c:otherwise>
				<div>
					検索結果:${studentlist.size() }件
					<table class="sql">
						<tr>
							<th>入学年度</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>クラス</th>
							<th>在学中</th>
							<th></th>
						</tr>
						
						<c:forEach var="student" items="${studentlist }">
						<tr>
							<td>${student.entYear }</td>
							<td>${student.no }</td>
							<td>${student.name }</td>
							<td>${student.classNum }</td>
							<td class="center">${student.isAttend == "True" ? "○" : "×"}</td>
							<td><a class="a" href="StudentUpdate.action?no=${student.no }">変更</a></td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@include file="../footer.jsp" %>
