package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		


		Subject subject=(Subject) request.getSession();

		SubjectDAO dao=new SubjectDAO();
		boolean list=dao.save(subject);
		
		

		session.setAttribute("list", list);
		
		return "../subject/subject_create.jsp";
	}
}

