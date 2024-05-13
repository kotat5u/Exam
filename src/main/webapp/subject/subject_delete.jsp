<%@page contentType="text/html; charset=UTF-8"%>


<%@include file="../header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<%@include file="../sidebar.jsp"%>
<div id="main">
<h2>科目情報削除</h2>
<form action="SubjectDeleteExecute.action">


    <p><label>「${deletesubject.name}(${deletesubject.cd })」を削除してもよろしいですか</label></p>
	<input class="submit-red" type="submit" value="削除">
	
	
</form>
<a href="subject_list.jsp">戻る</a>
</div></div>
	<%@include file="../footer.jsp"%>


