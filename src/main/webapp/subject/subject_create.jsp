<%@page contentType="text/html; charset=UTF-8"%>


<%@include file="../header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<%@include file="../sidebar.jsp"%>

<div id="main">
<h2>科目情報登録</h2>
<form action="SubjectCreateExecute.action" id="cu">
	<label>科目コード<br><input type="text" maxlength="3" required id="readnly" name="cd"
		sbcode="subject" placeholder="科目コードを入力して下さい" required></label>
	<br>
	<c:if test="${isError == 100 }">
	<p class="error">科目コードが重複しています</p><%-- ログインエラーの値がyesの時のみ表示 --%>
	</c:if>
	<c:if test="${myError == 1 }">
	<p class="error">科目コードは3文字で入力してください</p><%-- ログインエラーの値が1の時のみ表示 --%>
	</c:if>
		
    <label>科目名<br><input type="text"maxlength="20" required id="readnly" name="name" 
    sbcode="subject" placeholder="科目名を入力して下さい" required></input></label> 
    <br>
	<input class="submit-blue" type="submit" value="登録">
	
</form>

<a href="subject_list.jsp">戻る</a>
</div></div>
<%@include file="../footer.jsp"%>
