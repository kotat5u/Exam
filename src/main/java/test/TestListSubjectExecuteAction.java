package test;

import java.util.List;

import bean.Teacher;
import bean.TestListSubject;
import dao.TestListSubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectExecuteAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int entYear=Integer.parseInt(request.getParameter("f1"));
		String classNum=request.getParameter("f2");
		String subject=request.getParameter("f3");
		
		if (entYear == -1 || classNum == "notselect" || subject == "notselect") {
			request.setAttribute("testSubjectError", -1);
			return "test_list.jsp";
		}
		
		request.setAttribute("testSubjectError", 0);
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t = (Teacher)session.getAttribute("teacher");
		
		TestListSubjectDAO dao=new TestListSubjectDAO();
		List<TestListSubject> list=dao.filter(entYear, classNum, subject, t.getSchool());
		
		request.setAttribute("testListSubject", list);
		request.setAttribute("choiceSubject", subject);
		
		return "test_list_subject.jsp";
	}

}
