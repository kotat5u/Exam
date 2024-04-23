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

public class StudentListAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t=(Teacher)session.getAttribute("teacher");
		
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(t.getSchool());
		
		StudentDAO studentdao=new StudentDAO();
		List<Student> studentlist=studentdao.filter(t.getSchool());
		
		session.setAttribute("classlist", classlist);
		request.setAttribute("studentlist",studentlist);
		
		return "student_list.jsp";
		
	}

}

