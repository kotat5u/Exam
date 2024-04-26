package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		HttpSession session=request.getSession();
		Subject s=(Subject)session.getAttribute("deletesubject");

		SubjectDAO dao=new SubjectDAO();
		dao.delete(s.getCd());

	
		return  "../subject/subject_delete_done.jsp";
	}
}