package subject;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t = (Teacher)session.getAttribute("teacher");

		Subject subject=new Subject();
		subject.setCd(request.getParameter("cd"));
		subject.setName(request.getParameter("name"));
		subject.setSchool(t.getSchool());
		
		SubjectDAO dao=new SubjectDAO();
		
		if (dao.get(subject.getCd(), subject.getSchool()).getCd() != null) {
			request.setAttribute("isError", "100");
			return "subject_create.jsp";
		}
		
		if (subject.getCd().length() <3) {
			request.setAttribute("myError", "1");
			return "subject_create.jsp";
		
		}
		dao.save(subject);
		

		
		return  "../subject/subject_create_done.jsp";
	}
}

