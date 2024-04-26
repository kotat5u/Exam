package student;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t=(Teacher)session.getAttribute("teacher");
		
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String classNum=request.getParameter("class_num");
		boolean isAttend=request.getParameter("is_attend") != null;
		
		Student stu=new Student();
		stu.setNo(no);
		stu.setName(name);
		stu.setClassNum(classNum);
		stu.setIsAttend(isAttend);
		stu.setSchool(t.getSchool());

		StudentDAO dao=new StudentDAO();
		
		dao.save(stu);
		
		return "student_update_done.jsp";
		
		
//		if (dao.get(no) != null) {
//			dao.save(stu);
//			return "student_update_done.jsp";
//		}else {
//			request.setAttribute("ErrorYAO", -1);
//			return "student_update.jsp";
//		}
	}
}
