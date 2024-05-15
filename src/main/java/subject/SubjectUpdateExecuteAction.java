package subject;

import bean.Subject;
import bean.Teacher;
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
			Teacher t=new Teacher();
			t = (Teacher)session.getAttribute("teacher");
		
			
			String cd=request.getParameter("cd");
			String name=request.getParameter("name");
			
			Subject subject=new Subject();
			subject.setCd(cd);
			subject.setName(name);
			subject.setSchool(t.getSchool());

			SubjectDAO dao=new SubjectDAO();
			
			if (dao.get(cd, t.getSchool()).getCd() == null) {
				request.setAttribute("fuckingError", -1);
				return "subject_update.jsp";
			}
			dao.save(subject);
		
		return  "subject_update_done.jsp";
	}
}