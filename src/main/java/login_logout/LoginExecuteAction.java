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
		Teacher t=dao.login(id, password);
		
		HttpSession session=request.getSession();
		
		if (t.getSchool() == null) {
			request.setAttribute("loginerror", -1);
			return "login.jsp";
		}
		
		request.setAttribute("loginerror", 0);
		session.setAttribute("teacher", t);
		
		return "../mainmenu/mainmenu.jsp";
	}

}
