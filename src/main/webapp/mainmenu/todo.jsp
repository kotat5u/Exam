<%@page contentType="text/html; charset=UTF-8" %>

<%-- ヘッダー読み込み --%>
<%@include file="../header.jsp" %>
<div id="wrapper">
	<%-- サイドバー読み込み --%>
	<%@include file="../sidebar.jsp" %>
	<div id="mainmenu">
	<h2>今後の課題</h2>
	<ul>
	<li>AWS</li>
	<li>cssの作成およびjspの調整</li>
	<li>メインメニューに蛇足をつける</li>
	<li>テストを進める、バグを直す</li>
	</ul>
	</div>
	<div id="special">
	<section id="tounai">
	</section>
	<section id="katoh">
	<a href="https://godfield.net/">
	<img src="../images/godfield.png" alt="GODFIELD" width="200"><br>
	<p></p></a>
	</section>
	</div>
</div>
<%-- フッターを読み込み --%>
<%@include file="../footer.jsp" %>