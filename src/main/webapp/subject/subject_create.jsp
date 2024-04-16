<%@ page pageEncoding="UTF-8" %>

<%@include file="../header.jsp" %>
<%@include file="../sidebar.jsp" %>
<!DOCTYPE html>

<html>
	<heder>
	<h2>科目情報登録</h2>
	<label>科目コード</label>
	<form name="div" onSubmit="return false">
	<input type="text" maxlength="3" required id="readnly" name="cd" sbcode="subject"
    value ="科目名を入力して下さい"  href="SubjectUpdateExecuteAction.jsp" >${cd}</input>
  
    <label>科目名</label>
   	<input type="text" maxlength="20" required id="readnly" name="name" sbcode="subject" 
   	value ="科目名を入力して下さい" href="SubjectUpdateExecuteAction.jsp">${name}</input>
    <input type="submit"  onclick="return validateInput()"  value="変更">
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
    <a href="SubjectList.Action">戻る</a>
    <body>
<%@include file="../footer.jsp" %>
	</heder>