<%@page pageEncoding="UTF-8" %>

	<div>
		<h2>学生管理</h2>
		<a href="#">新規登録</a>
		<form action="StudentExecute.action">

		<label for="f1">入学年度</label>
		<select name="f1" id="f1">
			<option value="-1" selected hidden>--------</option>
			<c:forEach var="year" begin="2020" end="2030">
				<option value=${year }>${year }</option>
			</c:forEach>
		</select>
		<label for="f2">クラス</label>
		<select name="f2" id="f2">
			<option value="notselect" selected hidden>--------</option>
			<c:forEach var="num" items="${classlist }">
				<option value=${num }>${num }</option>
			</c:forEach>
		</select>
		<label><input type="checkbox" name="f3" value="true">在学中</label>
		<td>
			<input type="submit" value="絞込み">
		</td>
		</form>
	</div>
	
	