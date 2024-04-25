package student;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateExecuteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t=(Teacher)session.getAttribute("teacher");

		
		int entYear=Integer.parseInt(request.getParameter("ent_year"));
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String classNum=request.getParameter("class_num");
		
		Student stu=new Student();
		stu.setEntYear(entYear);
		stu.setNo(no);
		stu.setName(name);
		stu.setClassNum(classNum);
		stu.setSchool(t.getSchool());
		
		StudentDAO dao=new StudentDAO();
		
		
		if (dao.get(no).getNo() == null) {
			boolean isSaved=dao.save(stu);
			return "student_create_done.jsp";
		}else {
			request.setAttribute("PKerrorDAO", -1);
			return "student_create.jsp";
		}
		
	}	
}

