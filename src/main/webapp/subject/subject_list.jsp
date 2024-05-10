<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>科目管理</h2>
	<a href="subject_create.jsp" class="right">新規登録</a>
	<div>
	<table class="sql">
	<tr>
    <th>科目コード</th>
    <th>科目名</th>
    <th></th><th></th>
    </tr>
    <c:forEach var="subject" items="${list }">
    <tr>
    	<td>${subject.cd }</td>
    	<td>${subject.name }</td>
    	<td><a class="a" href="SubjectUpdate.action?cd=${subject.cd }">変更</a></td>
    	<td><a class="a" href="SubjectDelete.action?cd=${subject.cd }">削除</a></td>
    	
    </tr>
    </c:forEach>
    </table>
</div></div>
</div>	

	<%@include file="../footer.jsp" %>
		
