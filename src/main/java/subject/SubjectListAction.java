package subject;

import java.util.List;

import bean.Subject;
import bean.Teacher;
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
		Teacher t=new Teacher();
		t = (Teacher)session.getAttribute("teacher");
		


		SubjectDAO dao=new SubjectDAO();
		List<Subject> list=dao.filter(t.getSchool());

		session.setAttribute("list", list);

		return "../subject/subject_list.jsp";
	}
}
