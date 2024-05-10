<%@page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="shortcut icon" href="../images/管.png">
		<title>エラーページ</title>
		
	</head>
	<body>
	<header>
	<h1>得点管理システム</h1>
	<span>${teacher.name }様
	<a href="../login_logout/Logout.action">ログアウト</a>
	</span>
	</header>	

<div id="wrapper">
	<%-- サイドバー読み込み --%>
	<%@include file="../sidebar.jsp" %>
	<div id="main">
	エラーが発生しました
	</div>
</div>
<%-- フッターを読み込み --%>
<%@include file="../footer.jsp" %>