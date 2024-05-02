package login_logout;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginExecuteAction extends Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		TeacherDAO dao=new TeacherDAO();
//		入力されたID,PWでログインを試みる。ログインに成功したらそのユーザー(先生)の情報が返ってくる
		Teacher t=dao.login(id, password);
		
		HttpSession session=request.getSession();
		
//		tがnull(=ログインに失敗した)ならlogin.jspに処理を戻す
		if (t.getSchool() == null) {
			request.setAttribute("loginError", -1);
			request.setAttribute("teacherID", id);
			return "login.jsp";
		}
		

//		ユーザー(先生)の情報をセッションに格納
		session.setAttribute("teacher", t);
		
		return "../mainmenu/mainmenu.jsp";
	}

}
