package subject;


import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class SubjectDeleteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		
		Teacher t = (Teacher)session.getAttribute("teacher");

		String cd=request.getParameter("cd");

		SubjectDAO dao=new SubjectDAO();
		Subject list=dao.get(cd, t.getSchool());

		session.setAttribute("deletesubject", list);
		
		return "../subject/subject_delete.jsp";
	}
}




