package test;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t = (Teacher) session.getAttribute("teacher");
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(t.getSchool());
		
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subjectlist=subjectdao.filter(t.getSchool());
		
		request.setAttribute("classlist", classlist);
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("testSubjectError", 0);
		
		return "test_list.jsp";
	}

}