package subject;

import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String Subject=request.getParameter("School");
		if (Subject==null) Subject="";

		SubjectDAO dao=new SubjectDAO();
		List<Subject> list=dao.filter(Subject);

		session.setAttribute("list", list);

		return "subject_list.jsp";
	}
}
