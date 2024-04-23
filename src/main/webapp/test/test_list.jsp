<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	<h2>成績管理</h2>
	<%-- フォームを読み込み --%>
	<%@include file="test_list_form.jsp" %>
	</div>
</div>
<%@include file="../footer.jsp" %>