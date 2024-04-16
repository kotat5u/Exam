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
		
//		入力に不備があれば処理を戻す
		if (entYear == -1 || classNum == "notselect" || subject == "notselect") {
			request.setAttribute("testSubjectError", -1);
			return "test_list.jsp";
		}
		
		request.setAttribute("testSubjectError", 0);
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
//		ユーザー(先生)の情報を取得
		t = (Teacher)session.getAttribute("teacher");
		
		TestListSubjectDAO dao=new TestListSubjectDAO();
//		条件にあう成績一覧を取得
		List<TestListSubject> list=dao.filter(entYear, classNum, subject, t.getSchool());
		
//		成績一覧と科目を格納
		request.setAttribute("testListSubject", list);
		request.setAttribute("choiceSubject", subject);
		
		return "test_list_subject.jsp";
	}

}
