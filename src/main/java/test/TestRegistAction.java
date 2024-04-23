package test;

import java.util.List;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		セッションからユーザー(先生)の情報を取得
		HttpSession session=request.getSession();
		Teacher t=new Teacher();
		t = (Teacher) session.getAttribute("teacher");
		School school=t.getSchool();
		SubjectDAO subjectdao=new SubjectDAO();
		
		if (request.getParameter("f1") == null) {
			
//			ユーザー(先生)の所属する学校をもとにクラス一覧と科目一覧を取得
			ClassNumDAO classdao=new ClassNumDAO();
			List<String> classlist=classdao.filter(school);
			
			List<Subject> subjectlist=subjectdao.filter(school);
			
//			クラス一覧と科目一覧を保存
			session.setAttribute("classlist", classlist);
			session.setAttribute("subjectlist", subjectlist);
//			test_list.jspにエラーメッセージが残っている可能性をつぶす
			request.setAttribute("first", "first");
		} else {
		
			int entYear=Integer.parseInt(request.getParameter("f1"));
			String classNum=request.getParameter("f2");
			String subjectCd=request.getParameter("f3");
			int num=Integer.parseInt(request.getParameter("f4"));
		
//			入力に不備があれば処理を戻す
			if (entYear == -1 || classNum == "notselect" || subjectCd == "notselect" || num == -1) {
				request.setAttribute("testRegistError", -1);
				request.setAttribute("first", "first");
				return "test_regist.jsp";
			}
		
			Subject subject=subjectdao.get(subjectCd, school);
			TestDAO testdao=new TestDAO();
			List<Test> list=testdao.filter(entYear, classNum, subject, num, school);
			
			request.setAttribute("testRegistList", list);
			request.setAttribute("choiceYear", entYear);
			request.setAttribute("choiceClass", classNum);
			request.setAttribute("choiceSubject", subject);
			request.setAttribute("choiceNum", num);
			session.setAttribute("size", list.size());
		}
		return "test_regist.jsp";
	}

}