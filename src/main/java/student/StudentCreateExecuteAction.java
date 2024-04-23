package student;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentCreateExecuteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		Integer entYear=Integer.parseInt(request.getParameter("entYear"));
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String classNum=request.getParameter("classNum");
		
		Student stu=new Student();
		stu.setEntYear(entYear);
		stu.setNo(no);
		stu.setName(name);
		stu.setClassNum(classNum);
		StudentDAO dao=new StudentDAO();
		dao.save(stu);
		
		return "list.jsp";
	}	
}
