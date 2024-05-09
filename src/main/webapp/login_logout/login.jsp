<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../logoutheader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
<div id="login">
	<h2>ログイン</h2>
	<c:choose>
	<c:when test="${loginError == -1 }">
	ログインに失敗しました。IDまたはパスワードが正しくありません。<%-- ログインエラーの値が-1の時のみ表示 --%>
	<form action="LoginExecute.action">
	<input type="text" name="id" value="${teacherID }" placeholder="半角でご入力ください" maxlength="20" pattern="^[a-zA-Z0-9]+$" required><br><%-- required : 必須項目 --%>
	</c:when>
	<c:otherwise>
	<form action="LoginExecute.action">
	<input type="text" name="id" placeholder="半角でご入力ください" maxlength="20" pattern="^[a-zA-Z0-9]+$" required><br><%-- required : 必須項目 --%>
	</c:otherwise>
	</c:choose>
	<input type="password" name="password" placeholder="20文字以内の半角英数字でご入力ください" maxlength="20" pattern="^[a-zA-Z0-9]+$" required id="password"><br>
	<input type="checkbox" name="check_d_ps" id="showPassword" onchange="togglePasswordVisibility()"><label for="check_d_ps">パスワードを表示</label><br>
	<input class="submit-blue" type="submit" value="ログイン"><br>
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