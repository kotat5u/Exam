<%@ page pageEncoding="UTF-8" %>

<%@include file="../header.jsp" %>
<div id="wrapper">
<%@include file="../sidebar.jsp" %>

	<div id="main">
	<h2>科目情報変更</h2>
	<form id="cu" action="SubjectUpdateExecute.action">
	<label>科目コード</label><br>
    <input type="text" value="${updatesubject.cd}" name="cd"readonly="readonly"><br>
    <label>科目名</label><br>
   	<input type="text"maxlength="20" required id="readnly" name="name" 
    sbcode="subject" value="${updatesubject.name}" required><br>
    <input class="submit-blue" type="submit" value="変更"><br>
    <a href="subject_list.jsp">戻る</a>
	</form>
	</div>
</div>
	
<%@include file="../footer.jsp"%>
	