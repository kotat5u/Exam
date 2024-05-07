<%@page contentType="text/html; charset=UTF-8"%>


<%@include file="../header.jsp"%>
<%@include file="../sidebar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="SubjectDeleteExecute.action">


    <p><label>「${deletesubject.name}(${deletesubject.cd })」を削除してもよろしいですか</label></p>
	<input type="submit" value="削除">
	
	
</form>
<a href="subject_list.jsp">戻る</a>
<body>
</heder>
	<%@include file="../footer.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

