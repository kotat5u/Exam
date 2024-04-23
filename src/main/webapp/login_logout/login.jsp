<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../logoutheader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<div id="main">
	<h2>ログイン</h2>
	<c:if test="${loginError == -1 }">
	ログインに失敗しました。IDまたはパスワードが正しくありません。<%-- ログインエラーの値が-1の時のみ表示 --%>
	</c:if>
	<form id="login" action="LoginExecute.action">
	<input type="text" name="id" placeholder="ID" required><br><%-- required : 必須項目 --%>
	<input  type="password" name="password" placeholder="パスワード" required id="password"><br>
	<input type="checkbox" name="check_d_ps" id="showPassword" onchange="togglePasswordVisibility()"><label for="check_d_ps">パスワードを表示</label><br>
	<input type="submit" value="ログイン"><br>
	</form>
</div>
</div>
<script>
		function togglePasswordVisibility() {
			let passwordInput = document.getElementById("password");
			let showPasswordCheckbox = document.getElementById("showPassword");

			if (showPasswordCheckbox.checked) {
				passwordInput.type = "text";
			} else {
				passwordInput.type = "password";
			}
		}
</script>
<%@include file="../footer.jsp" %>