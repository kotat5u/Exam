<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<%@include file="../sidebar.jsp" %>
	<h2>科目管理</h2>
	<a href="subject_create.jsp">新規登録</a>
	<table>
	<tr>
    <th>科目コード</th>
    <th>科目名</th>
    </tr>
    <c:forEach var="subject" items="${list }">
    <tr>
    	<td>${subject.cd }</td>
    	<td>${subject.name }</td>
    	<td><a href="SubjectDelete.action?cd=${subject.cd }"></a></td>
    </tr>
    </c:forEach>
    </table>
</div>	

	<%@include file="../footer.jsp" %>
		
	
<%---
ヘッダー―
タグリブ

<div id="wrapper">
再いどばー
<div id"main">
混ってんつ
</div>
</div>

 --%>	

