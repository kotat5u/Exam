package subject;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		
		Teacher t=new Teacher(); t = (Teacher)session.getAttribute("teacher");

		String cd=request.getParameter("cd");

		SubjectDAO dao=new SubjectDAO();
		Subject list=dao.get(cd, t.getSchool());
					

		session.setAttribute("updatesubject", list);
		
		return "../subject/subject_update.jsp";
	}
}