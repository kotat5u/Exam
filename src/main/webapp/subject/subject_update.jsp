<%@ page pageEncoding="UTF-8" %>

<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
	<heder>
	<h2>科目情報変更</h2>
	<label>科目コード</label>
    <input href="SubjectUpdateExecuteAction.jsp">${code}</input>
    <label>科目名</label>
   	<input href="SubjectUpdateExecuteAction.jsp">${name}</input>
    <input type="submit" value="変更">
    <a href="SubjectList.Action">戻る</a>
    <body>
	</heder>	
	