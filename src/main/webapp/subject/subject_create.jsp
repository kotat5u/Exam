<%@page contentType="text/html; charset=UTF-8"%>


<%@include file="../header.jsp"%>
<%@include file="../sidebar.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="SubjectCreateExecute.action">
	<input type="text" maxlength="3" required id="readnly" name="cd"
		sbcode="subject" value="科目コードを入力して下さい">
    <input type="text"maxlength="20" required id="readnly" name="name" 
    sbcode="subject" value="科目名を入力して下さい"></input> 
	<input type="submit" value="登録">
</form>
<a href="subject_list.jsp">戻る</a>
<body>
	<%@include file="../footer.jsp"%>
</heder>


<%-- <!DOCTYPE html>
<html>
<heder>
<h2>科目情報登録</h2>
<label>科目コード</label>
<form name="div" onSubmit="return false">
	<input type="text" maxlength="3" required id="readnly" name="cd"
		sbcode="subject" value="科目名を入力して下さい"
		href="SubjectListAction.java">${cd}</input> <label>科目名</label>
	<input type="text" maxlength="20" required id="readnly" name="name"
		sbcode="subject" value="科目名を入力して下さい"
		href="SubjectListAction.java">${name}</input> <input
		type="submit"
		onclick="http://localhost:8080/tokutenkanri/subject/create.jsp"
		value="登録">
	<p id="error_msg" style="color: orange;"></p>

	<!-- エラー処理 -->
	<script>
    var readnlyList = []; 

    function checkDuplicate() {
        var readnly = document.getElementById("readnly").value;
        if (readnlyList.includes(readnly)) {
            var errorMsg = "科目コードが重複しています";
            document.getElementById("error_msg").innerHTML = errorMsg;
            return false;
        } else {
        	readnlyList.push(readnly); 
            return true;
        }
    }
    function validateInput() {
        var input = document.getElementById("readnly").value;
        if (input.length !== 3) {
            var errorMsg = "科目コードは3文字で入力してください";
            document.getElementById("error_msg").innerHTML = errorMsg;
            return false;
        }
        return true;
    }
</script>

</form>
<a href="subject_list.jsp">戻る</a>
<body>
	<%@include file="../footer.jsp"%>
</heder> --%>