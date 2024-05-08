package login_logout;

import java.time.LocalTime;

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
//		時間判定
		String now=LocalTime.now().toString();
		now = (now.substring(0, now.indexOf(":")));
		int time;
		switch (now) {
			case "4", "5",  "6", "7", "8", "9", "10":
				time=1;
				break;
			case "11", "12", "13":
				time=2;
				break;
			case "14", "15", "16", "17", "18":
				time=3;
				break;
			default:
				time=4;
		}
        request.setAttribute("now", time);

//		ユーザー(先生)の情報をセッションに格納
		session.setAttribute("teacher", t);
		
		return "../mainmenu/mainmenu.jsp";
	}

}