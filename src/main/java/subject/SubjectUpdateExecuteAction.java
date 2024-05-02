package subject;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
			HttpSession session=request.getSession();
			Subject s=(Subject)session.getAttribute("updatesubject");

			SubjectDAO dao=new SubjectDAO();
			dao.save(s.getCd());
		
		return  "../subject/subject_update_done.jsp";
	}
}
