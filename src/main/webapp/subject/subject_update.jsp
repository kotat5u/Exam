<%@ page pageEncoding="UTF-8" %>

<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
	<heder>
	<h2>科目情報変更</h2>
		<form action="SubjectUpdateExecute.action">
	<label>科目コード</label>
    <input type="text" ${updatesubject.name} readonly>${code}</input>
    <label>科目名</label>
   	<input type="text"maxlength="20" required id="readnly" name="name" 
    sbcode="subject" ${updatesubject.cd} required>${name}</input>
    <input type="submit" value="変更">
    <a href="subject_list.jsp">戻る</a>
    <body>
	</heder>	

	