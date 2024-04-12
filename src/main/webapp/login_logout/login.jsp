<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../logoutheader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<div id="main">
	<h2>ログイン</h2>
	<c:if test="${loginerror == -1 }">
	ログインに失敗しました。IDまたはパスワードが正しくありません。
	</c:if>
	<form action="LoginExecute.action">
	<input type="text" name="id" placeholder="ID" required><br>
	<input type="password" name="password" placeholder="PASSWORD" required><br>
	<input type="checkbox" name="check_d_ps"><label for="check_d_ps">パスワードを表示</label><br>
	<input type="submit" value="ログイン"><br>
	</form>
</div>
</div>
<%@include file="../footer.jsp" %>