<%@ page pageEncoding="UTF-8" %>

<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
	<heder>
	<h2>科目情報変更</h2>
	<label>科目コード</label>
    <input href="SubjectUpdateExecute.Action">${code}</input>
    <label>科目名</label>
   	<input href="SubjectUpdateExecute.Action">${name}</input>
    <input type="submit" value="変更">
    <a href="subject_list.jsp">戻る</a>
    <body>
	</heder>	
	