<%@page contentType="text/html; charset=UTF-8"%>


<%@include file="../header.jsp"%>
<%@include file="../sidebar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="SubjectCreateExecute.action">
	<input type="text" maxlength="3" required id="readnly" name="cd"
		sbcode="subject" placeholder="科目コードを入力して下さい" required>
	<c:if test="${isError == 100 }">
	科目コードが重複しています<%-- ログインエラーの値がyesの時のみ表示 --%>
	</c:if>
	<c:if test="${myError == 1 }">
	科目コードは3文字で入力してください<%-- ログインエラーの値が1の時のみ表示 --%>
	</c:if>
		
    <input type="text"maxlength="20" required id="readnly" name="name" 
    sbcode="subject" placeholder="科目名を入力して下さい" required></input> 
	<input type="submit" value="登録">
	
</form>

<a href="subject_list.jsp">戻る</a>
<body>
</heder>
	<%@include file="../footer.jsp"%>
