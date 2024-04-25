package student;

import java.util.List;

import bean.Teacher;
import dao.ClassNumDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t=(Teacher)session.getAttribute("teacher");
		
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(t.getSchool());
		
		session.setAttribute("classlist", classlist);

		return "student_create.jsp";
	}
}

