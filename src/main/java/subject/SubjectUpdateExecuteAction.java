package subject;

import bean.Subject;
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

		
		
		return  "../subject/subject_update_done.jsp";
	}
}
