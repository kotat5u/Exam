package student;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		String no=request.getParameter("no");
		
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t=(Teacher)session.getAttribute("teacher");
		
		StudentDAO studao=new StudentDAO();
		Student stu=studao.get(no);
				
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(t.getSchool());
		
		request.setAttribute("classlist", classlist);
		session.setAttribute("studentinfo", stu);
				
		return "student_update.jsp";
	}
}