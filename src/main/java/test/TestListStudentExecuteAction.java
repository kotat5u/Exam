package test;

import java.util.List;

import bean.Student;
import bean.TestListStudent;
import dao.StudentDAO;
import dao.TestListStudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TestListStudentExecuteAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no=request.getParameter("f4");
		
		StudentDAO sdao=new StudentDAO();
		Student student=new Student();
		student = sdao.get(no);
		
		TestListStudentDAO dao=new TestListStudentDAO();
//		条件にあう成績一覧を取得
		List<TestListStudent> list=dao.filter(student);
		
//		成績一覧と科目を格納
		request.setAttribute("testListStudent", list);
		request.setAttribute("choiceStudent", student);
		
	
		
		return "test_list_student.jsp";
	}

}